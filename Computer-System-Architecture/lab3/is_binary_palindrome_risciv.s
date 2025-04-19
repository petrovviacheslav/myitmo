    .data

input_addr:      .word  0x80               ; input address
output_addr:     .word  0x84               ; output address
low_mask:        .word  0x0000FFFF
high_mask:       .word  0xFFFF0000
main_mask:       .word  0x80000001
const_1:         .word  0x1

.org             0x90
    .text

_start:
    jal      ra, read_number

    ; now a0 = number

    jal      ra, divide_num_on_parts

    mv       a2, a1          ; now a2 - high bytes of number
    mv       a1, a0          ; now a1 - low bytes of number

    jal      ra, check_number

    ; now a0 - result (1 or 0)

    jal      ra, print_res

    halt

    ; =======================================

read_number:
    lui      t0, %hi(input_addr)
    addi     t0, t0, %lo(input_addr)         ; t0 = 0x0

    lw       t0, 0(t0)                       ; t0 = 0x80

    lw       a0, 0(t0)                       ; a0 = MEM[t0]

    jr       ra

    ; =======================================

divide_num_on_parts:
    lui      t0, %hi(low_mask)
    addi     t0, t0, %lo(low_mask)
    lw       t0, 0(t0)                       ; t0 = 0x0000FFFF

    lui      t1, %hi(high_mask)
    addi     t1, t1, %lo(high_mask)
    lw       t1, 0(t1)                       ; t1 = 0xFFFF0000

    mv       a1, a0                          ; a1 <- a0

    and      a0, a0, t0                      ; a0 <- a0 and t0 (low bytes)
    and      a1, a1, t1                      ; a1 <- a1 and t1 (high bytes)

    jr       ra

    ; =======================================

check_number:
    lui      t0, %hi(main_mask)
    addi     t0, t0, %lo(main_mask)
    lw       t0, 0(t0)                       ; t0 = 0x80000001

    lui      t1, %hi(const_1)
    addi     t1, t1, %lo(const_1)
    lw       t1, 0(t1)                       ; t1 = 0x1

    mv       a0, t1                          ; a0 = 1 (result)
    addi     t2, t1, 15                      ; счётчик = 16

while:
    beqz     t2, while_ret                   ; проверка счётчика на 0
    addi     t2, t2, -1                      ; изменение счётчика

    add      t3, a1, a2                      ; объединяем левую и правую части в одном регистре
    and      t3, t3, t0                      ; убираем лишние биты (оставляем крайний правый и левый)

    srl      a1, a1, t1
    sll      a2, a2, t1                      ; сдвиги частей влево и вправо на 1 бит

    beqz     t3, while                       ; тут проверка на 0x0000

    sub      t3, t3, t0
    beqz     t3, while                       ; тут проверка на 0x8001

    addi     a0, a0, -1                      ; a0 = 0
while_ret:
    jr       ra

    ; =======================================

print_res:
    lui      t0, %hi(output_addr)
    addi     t0, t0, %lo(output_addr)        ; t0 = 0x04;

    lw       t0, 0(t0)                       ; t0 = 0x84

    sw       a0, 0(t0)                       ; *output_addr_const = a0;

    jr       ra
