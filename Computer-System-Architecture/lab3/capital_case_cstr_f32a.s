    .data

buffer:                 .word  0x0
buffer2:                 .word  0x0
buffer3:                 .word  0x0
buffer4:                 .word  0x0
buffer5:                 .word  0x0
buffer6:                 .word  0x0
buffer7:                 .word  0x0
buffer8:                 .word  0x0
\output_addr:           .word  132               \ Output address where the result should be stored

input_addr:             .word  0x80   

    .text

_start:

    @p input_addr b!        \ пушит в стек значение input_addr и забирает его в регистр b

    @p buffer a!          \ пушит в стек значение buffer и забирает его в регистр а


    lit 32                \ базовый счётчик
    lit -32               \ изначальное уменьшение 
cycle:
    over \ счетчик из stack[1] дублируем вниз
    if end

    @b \ читаем букву в стек из input_addr

    dup
    lit -97 +  \ 97 - а в нимжнем регистре
    -if go_lol \ если буква и так в верхнем регистре или пробел, то lol

go:
    + \ увеличиваем если надо
    dup
    lit -10 +
    if next

    dup
    lit -32 +   \ пробел
    if spec

    dup
    !+   \ получем значение из стека и увеличиваем счётчик буфера
    !p 0x84

    lit -1 +
    lit 0
    cycle ;

go_lol:
    over   \ тут будет или -32 или 0
    if go   \ если 0 можно спокойно складывать

    lit 32 +
    go ;

spec:
    dup
    !+   \ получем значение из стека и увеличиваем счётчик буфера
    !p 0x84

    lit -1 +
    lit -32
    cycle ;

next:
    lit -10 + 
    !+ \ читаем ноль и двигаем буффер
    lit -1 +
    
while:
    dup
    if end
    
    lit 0x5f
    !+     \ пишет в нужную ячейку памяти и увеличивает счётчик

    lit -1 +
    while ;

end:
    halt
