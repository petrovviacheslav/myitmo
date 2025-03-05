    .data

buffer1:                 .word  0x5f5f5f5f
buffer2:                 .word  0x5f5f5f5f
buffer3:                 .word  0x5f5f5f5f
buffer4:                 .word  0x5f5f5f5f
buffer5:                 .word  0x5f5f5f5f
buffer6:                 .word  0x5f5f5f5f
buffer7:                 .word  0x5f5f5f5f
buffer8:                 .word  0x5f5f5f5f
buffer_ptr:              .word  0x0
input_addr:              .word  0x80

    .text

_start:
    @p input_addr b!       \ stack <- input_addr and stack -> b
    @p buffer_ptr a!       \ stack <- buffer_ptr and stack -> a

    lit 32                 \ stack <- counter
    lit -32                \ stack <- start bias
read_input:
    !                      \ bias -> buffer
    dup                    \ counter duplication
    if over_may            \ if counter == 0 --> overflow

    @b                     \ stack <- mem[input_addr]

    dup                    \ input symbol duplication
    lit -10 +
    if end_str             \ if symbol == '\n' --> end of string

    dup                    \ input symbol duplication
    lit -32 +
    if space               \ if symbol == ' ' --> instructions for space

    dup                     \ input symbol duplication
    lit -97 +
    -if low_level           \ if letter - lowercase --> instructions for lowercase

    dup                     \ input symbol duplication
    lit -65 +
    -if up_level            \ if letter - uppercase --> instructions for uppercase

    dup                     \ input symbol duplication
    lit 0 +
    -if just_read           \ other symbols

    up_level:
        lit 32 +            \ add 32 to make the letter smaller
    low_level:
        @                   \ stack <- bias
        +                   \ letter += bias
    just_read:
        !+                  \ symbol -> a and a += 1

        lit -1 +            \ counter decrement
        lit 0               \ stack <- new bias
        read_input ;

    space:
        !+                  \ symbol -> a and a += 1

        lit -1 +            \ counter decrement
        lit -32             \ stack <- new bias
        read_input ;

end_str:
    lit -10 +               \ decrease '\n'
null_elem:
    lit 0x5f5f5f00 +        \ eq stack[0] or 0x5f5f5f00
    !+                      \ symbol -> a and a += 1
    drop                    \ drop counter
    print

over_may:
    lit 0xCCCCCCCC
    !p 0x84                 \ 0xCCCCCCCC -> mem[output_addr]
    halt

print:
    @p buffer_ptr           \ stack <- buffer_ptr
    lit 0xFF000000 and      \ clear other bytes
    a!                      \ buffer_ptr -> a

    output_while:
        @+
        lit 0xFF and        \ need only the last byte
        dup
        if end              \ if symbol == 0 --> end

        !p 0x84             \ symbol -> mem[output_addr]
        output_while ;

end:
    halt
