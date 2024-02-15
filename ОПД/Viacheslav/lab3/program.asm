ORG 0x4C2
first_elem: WORD 0x04D6
current_elem: WORD 0x0200
arr_length: WORD 0xE000
result: WORD 0x0200
START: LD #0x80
DEC
SWAB
ST result
LD #0x04
ST arr_length
LD first_elem
ST current_elem
loop_start: LD (current_elem)+
BMI loop_addr
CMP result
BGE loop_addr
ST result
loop_addr: LOOP 0x4C4
JUMP loop_start
HLT
WORD 0xF300
WORD 0xF000
WORD 0xF500
WORD 0xFA00