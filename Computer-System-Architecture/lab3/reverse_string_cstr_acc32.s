    .data
    ; здесь находится буффер, куда мы пишем символы (+3 чтобы потом случайно не затереть следующие данные)
.org             0x23
start_input_ptr: .word  0x1F               ; указатель при чтении, двигаем влево, чтобы сразу реверсировать строку в буффере
buffer_ptr:      .word  0x0                ; указатель для смещения всей строки в начало буффера
start_ptr:       .word  0x1F               ; дублирует значение стартового указателя, чтобы потом с ним сравнивать
input_addr:      .word  0x80
output_addr:     .word  0x84
const_1:         .word  0x1
const_4:         .word  0x4
stop_letter:     .word  0xA
maskFF:          .word  0x000000FF
mask00:          .word  0xFFFFFF00
temp:            .word  0x0
was_zero_letter: .word  0x0


    .text
    .org         0x90
_start:

read_cycle:
    load_ind     input_addr                  ; acc <- input

    beqz         zero_elem                   ; если символ 0 - то дальше не надо реверсировать строку
    sub          stop_letter
    beqz         out_and_symbol_offset
    add          stop_letter                 ; проверка что символ - не конец строки

    store        temp                        ; загружаем символ во временную переменную
    load_ind     start_input_ptr
    or           temp                        ; объединяем уже записанные данные с новым прочитанным символом, чтобы их не затереть
    store_ind    start_input_ptr             ; пишем в память

    load         start_input_ptr
    beqz         over
    sub          const_1
    store        start_input_ptr             ; двигаем указатель влево, если же он мог стать меньше 0 - переполнение

    jmp          read_cycle                  ; повторяем

zero_elem:
    load         const_1
    store        was_zero_letter             ; устанавливаем флаг, который показывает, что был 0-символ (после него не надо реверсировать)

out_and_symbol_offset:
    load         start_input_ptr
    sub          start_ptr
    beqz         add00                       ; если первоначальный указатель вернулся к правому краю буффера - больше нечего читать, надо заполнять буффер дальше 005f5f...

    load         start_input_ptr
    add          const_1
    store        start_input_ptr             ; двигаем первоначальный указатель вправо, чтобы читать считанную строку в обратном порядке

    load_ind     start_input_ptr
    and          maskFF                      ; получаем именно текущий символ (очищаем остальные байты)

    store        temp                        ; сохраняем во временную переменную
    store_ind    output_addr                 ; выводим символ

    ; поскольку буффер 32 байта, а в строке может быть 10 символов, то надо всю строку сместить вначало буффера.
    ; именно эта логика дальше реализована
    ; ============================
    load_ind     buffer_ptr
    and          mask00
    or           temp                        ; совмещаем наш символ с местом, куда его надо загрузить, чтобы мы не затёрли ячейки памяти buffer_ptr+1, ..., buffer_ptr+3 при store
    store_ind    buffer_ptr
    ; ============================

    load         buffer_ptr
    add          const_1
    store        buffer_ptr                  ; увеличиваем указатель на нужный адрес в буфере

    jmp          out_and_symbol_offset


add00:
    load_imm     0x0
    store_ind    buffer_ptr                  ; грузим 00 в буффер

    load         buffer_ptr
    add          const_1
    store        buffer_ptr                  ; увеличиваем указатель на нужный адрес в буфере

    load         was_zero_letter
    sub          const_1
    store        was_zero_letter             ; убираем флаг о том что был 0-символ, он больше не нужен
    beqz         read_last_sym               ; если когда-то был 0-символ, то нам надо в правильном порядке дочитать остальные символы в буффер


add__:
    load_imm     0x5f5f5f5f
    store_ind    buffer_ptr                  ; сохраняем в буффер 5f5f5f5f

    load         buffer_ptr
    add          const_4
    sub          start_ptr                   ; увеличиваем буфферный указатель сразу на 4, поскольку мы загружаем по 4 байта
    bgt          end                         ; если он стал больше буффера, то конец проги

    add          start_ptr
    store        buffer_ptr                  ; обновляем значение буффера

    jmp          add__

read_last_sym:
    load_ind     input_addr                  ;  acc <- input

    sub          stop_letter
    beqz         add00
    add          stop_letter                 ; проверка, что символ - не конец строки, иначе дописываем в оставшийся буффер 005f5f5f...

    store_ind    buffer_ptr                  ; сохраняем символ в буффер
    load         buffer_ptr
    add          const_1
    store        buffer_ptr                  ; увеличиваем буфферный указатель
    jmp          read_last_sym

over:
    load_imm     0xCCCCCCCC                  ; acc <- 0xCCCCCCCC
    store_ind    output_addr

end:
    halt
