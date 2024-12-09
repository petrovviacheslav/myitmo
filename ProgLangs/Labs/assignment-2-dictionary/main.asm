section .text
%include "dict.inc"
%include "lib.inc"
%include "words.inc"
%include "colon.inc"

%define MAX_BUF_SIZE 255
%define ST_DICTIONARY first_word

%define ENOENT 2
%define E2BIG 7

section .bss
  buffer: resb MAX_BUF_SIZE+1

section .rodata
	overflow: db "Err: string is too long!", 0
	not_found: db "Err: string is not found!", 0

section .text
global _start
_start:
	mov rdi, buffer
	mov rsi, MAX_BUF_SIZE
	call read_string      ; getting the input string

	test rax, rax
	mov rdi, overflow
	jz .error_over             ; >= 256 -> overflow.error

	mov rdi, rax
	mov rsi, ST_DICTIONARY   ; start addr
	call find_word
	test rax, rax
	mov rdi, not_found
	jz .error_found             ; no match -> not_found.error

	mov rdi, rax          ; rdi <- addr key
	push rdi
	call string_length
	pop rdi
	add rdi, rax          ; skip key in pair key = value -> next value
	inc rdi               ; skip 0x0

	call print_string		; match -> output

	xor rdi, rdi
	jmp exit

	.error_over:
		call print_error

		mov rdi, E2BIG
		jmp exit
	
	.error_found:
		call print_error

		mov rdi, ENOENT
		jmp exit
