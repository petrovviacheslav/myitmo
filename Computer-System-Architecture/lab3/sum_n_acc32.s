    .data


num:             .word  0
input_addr:      .word  0x80
output_addr:     .word  0x84
const_1:         .word  1
const_v:         .word  0x80000000

    .text

_start:

    load_ind     input_addr
    store        num                           ; num <- input
    
    beqz         err
    ble          err

    add          const_1
    
    mul          num
    bvs          over

    shiftr       const_1

    store_ind    output_addr
    halt

err:
    load_imm     -1
    store_ind    output_addr                 ; mem[mem[output_addr]] = -1
    halt

over:
    load_imm     0xCCCCCCCC
    store_ind    output_addr                 ; mem[mem[output_addr]] = 0xCCCCCCCC
    halt

