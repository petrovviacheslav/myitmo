    .data

num:             .word  0
input_addr:      .word  0x80
output_addr:     .word  0x84
const_1:         .word  1

    .text

_start:
    load_ind     input_addr
    store        num                  ; num <- input

    beqz         err
    ble          err                  ; num <= 0 --> err

    and          const_1              ; remainder 2
    beqz         input_multiple_two

    load         num                  ; acc <- num
    add          const_1              ; acc += 1
    shiftr       const_1              ; shift on 1 bit (division)
    mul          num

    jmp end

input_multiple_two:
    load         num                  ; acc <- num1
    add          const_1              ; acc += 1
    store        num                  ; num <- acc
    sub          const_1              ; acc -= 1
    shiftr       const_1              ; shift on 1 bit (division)
    mul          num
    jmp end

err:
    load_imm     -1                   ; acc <- -1
    jmp end

over:
    load_imm     0xCCCCCCCC          ; acc <- 0xCCCCCCCC

end:
    store_ind    output_addr
    halt
