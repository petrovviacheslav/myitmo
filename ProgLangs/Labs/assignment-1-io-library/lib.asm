; repeat symbols

%define READ_SYSCALL 0
%define STD_IN 0

%define WRITE_SYSCALL 1
%define STD_OUT 1

%define SYS_EXIT 60
%define NEW_LINE 0xA

section .text

; Принимает код возврата и завершает текущий процесс
exit: 
    mov rax, SYS_EXIT
    syscall

; Принимает указатель на нуль-терминированную строку, возвращает её длину
string_length:
    xor rax, rax               ; 0 -> rax
    .counter:
        cmp byte [rax+rdi], 0  ; check on 0
        je .end                ; if true -> end, else -> counter
        inc rax                ; rax += 1
        jmp .counter           ; jump .counter

    .end:
        ret                    ; return

; Принимает указатель на нуль-терминированную строку, выводит её в stdout
print_string:
    xor rax, rax               ; 0 -> rax
    push rdi                   ; rdi -> stack
    call string_length         ; now in rax length of string

    mov rdx, rax               ; rax (length of string) -> rdx
    pop rsi                    ; stack (address of first element) -> rsi

    mov rax, WRITE_SYSCALL     ; write
    mov rdi, STD_OUT           ; std out
    syscall
    ret

; Переводит строку (выводит символ с кодом 0xA)
print_newline:
    mov rdi, NEW_LINE

; Принимает код символа и выводит его в stdout
print_char:
    xor rax, rax               ; 0 -> rax
    push rdi                   ; rdi (char) -> stack

    mov rsi, rsp               ; our symbol for out -> rsi

    mov rdx, 1                 ; one symbol -> 1 in rdx
    mov rax, WRITE_SYSCALL     ; write
    mov rdi, STD_OUT           ; std out
    syscall

    pop rdi                    ; move stack
    ret

; Выводит знаковое 8-байтовое число в десятичном формате 
print_int:
    xor rax, rax

    cmp rdi, 0      ; or 'test rdi, rdi'
    jge print_uint  ; if >= 0 -> print_uint
    neg rdi         ; -1 * rdi => rdi > 0

    push rdi        ; num -> stack
    mov rdi, '-'
    call print_char ; output '-'
    pop rdi         ; num -> rdi

; Выводит беззнаковое 8-байтовое число в десятичном формате 
; Совет: выделите место в стеке и храните там результаты деления
; Не забудьте перевести цифры в их ASCII коды.
print_uint:
    xor rax, rax
    
    mov rax, rdi          ; our num -> rax
    mov rsi, 10           ; divider (10) -> rbx
    mov rcx, 23           ; it is counter
    sub rsp, 24           ; allocate space on the stack
    mov byte [rsp+23], 0

    .convert_loop:
        xor rdx, rdx      ; clear remainder 
        div rsi           ; rax / rsi (10): // -> rax, % -> rdx

        add dl, '0'       ; transfer remainder to ASCII
        dec rcx           ; rcx -= 1
        mov [rsp+rcx], dl ; dl -> symbol with address rsi

        test rax, rax     ; check rax on 0
        jnz .convert_loop
    
    lea rdi, [rsp+rcx]    ; addr of num for out -> rdi
    call print_string
    add rsp, 24           ; return address
    ret

; Принимает два указателя на нуль-терминированные строки, возвращает 1 если они равны, 0 иначе
string_equals:
    ; rdi, rsi - pointers
    xor rax, rax

    .looop:
        mov dl, byte[rsi]     ; n-symbol from rsi -> dl
        cmp dl, byte[rdi]     ; compare n-symbol from rdi with dl
        jne .finish           ; if != -> finish
        ; check on n-symbol has been passed

        cmp dl, 0             ; check dl on 0
        jz .equal             ; ZF == 0 -> .equal
        ; if the element is empty, then the string is closed -> .equal

        inc rsi               ; rsi += 1 (next symbol)
        inc rdi               ; rdi += 1 (next symbol)
        jmp .looop            ; -> .looop

    .equal:
        mov rax, 1            ; answer - 1 (rax)

    .finish:    
        ret                  ; answer doesn't change

; Читает один символ из stdin и возвращает его. Возвращает 0 если достигнут конец потока
read_char:
    xor rax, rax
    push rax              ; rax (0) -> stack

    mov rsi, rsp          ; address top of stack -> rsi, char (stdin) is written in rsp

    mov rdx, 1            ; one symbol -> 1 in rdx
    mov rax, READ_SYSCALL ; read
    mov rdi, STD_IN       ; std in
    syscall

    pop rax
    ret

; Принимает: адрес начала буфера, размер буфера
; Читает в буфер слово из stdin, пропуская пробельные символы в начале, .
; Пробельные символы это пробел 0x20, табуляция 0x9 и перевод строки 0xA.
; Останавливается и возвращает 0 если слово слишком большое для буфера
; При успехе возвращает адрес буфера в rax, длину слова в rdx.
; При неудаче возвращает 0 в rax
; Эта функция должна дописывать к слову нуль-терминатор

read_word:
    ; rdi = buf-pointer, rsi = length_of_buf
    push r12
    push r13
    push r14

    xor r12, r12                 ; counter
    mov r13, rsi                 ; length_of_buf -> r13
    mov r14, rdi                 ; buf-pointer ->  r14

    .skip_whitespace_char:
        call read_char
        cmp rax, 0x20
        je .skip_whitespace_char
        cmp rax, 0x9
        je .skip_whitespace_char
        cmp rax, 0xA
        je .skip_whitespace_char
        test al, al
        jz .end_fail 

    .loop:
        mov byte[r14+r12], al
        inc r12
        dec r13
        jz .end_fail

        call read_char

        cmp rax, 0x20
        je .end_success
        cmp rax, 0x9
        je .end_success
        cmp rax, 0xA
        je .end_success
        test al,al
        jz .end_success

        jmp .loop
    
    .end_success:
        mov rdx,r12
        mov rax,r14
        mov byte[r12+r14], 0

        pop r14
        pop r13
        pop r12
        ret

    .end_fail:
        pop r14
        pop r13 
        pop r12

        xor rax, rax
        xor rdx, rdx
        ret
 

; Принимает указатель на строку, пытается
; прочитать из её начала беззнаковое число.
; Возвращает в rax: число, rdx : его длину в символах
; rdx = 0 если число прочитать не удалось
parse_uint:
    xor rax, rax
    xor rdx, rdx             ; counter
    xor rcx, rcx

    cmp byte[rdi+rdx], 0
    jz .end                  ; check on 0

    .loop:
        mov cl, byte [rdi+rdx]

        cmp cl, 0
        jz .end
        sub cl, '0'
        cmp cl, 9
        ja .end              ; check on num + -> ASCII

        imul rax, rax, 10    ; rax * 10 -> rax
        add rax, rcx         ; rax += rcx
        inc rdx
        jmp .loop
    .end:
        ret

; Принимает указатель на строку, пытается
; прочитать из её начала знаковое число.
; Если есть знак, пробелы между ним и числом не разрешены.
; Возвращает в rax: число, rdx : его длину в символах (включая знак, если он был) 
; rdx = 0 если число прочитать не удалось
parse_int:
    xor rax, rax
    cmp byte [rdi], '-'
    je .there_is_sign
    cmp byte [rdi], '+'
    jne parse_uint        ; no signs -> parse_uint, signs -> .there_is_sign

    .there_is_sign:
        push rdi          ; pointer -> stack
        inc rdi           ; getting rid of sign
        call parse_uint
        inc rdx           ; +1, because there is sign

        pop rdi           ; pointer -> rdi
        cmp byte [rdi], '+'
        je .end
        neg rax           ; if '-' -> change rax (-1*rax)

    .end:
        ret 

; Принимает указатель на строку, указатель на буфер и длину буфера
; Копирует строку в буфер
; Возвращает длину строки если она умещается в буфер, иначе 0
string_copy:
    ; rdi = str-pointer, rsi = buf-pointer, rdx = length_of_buf
    xor rax, rax                   ; counter
    xor r8, r8

    .loop:
        cmp rdx, rax              
        jl .else_end               ; rdx < rax -> .else_end

        mov r8b, byte [rdi + rax]
        mov byte [rsi + rax], r8b  ; transfer str-symbol to buf

        cmp r8b, 0
        jz .end                    ; check on 0

        inc rax
        jnz .loop
    .else_end:
        xor rax, rax
    .end:
        ret
