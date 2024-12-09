%include "lib.inc"
%define STEP 8

section .text
global find_word

; Указатель на нуль-терминированную строку.
; Указатель на начало словаря.

; find_word пройдёт по всему словарю в поисках подходящего 
; ключа. Если подходящее вхождение найдено, вернёт адрес 
; начала вхождения в словарь (не значения), иначе вернёт 0.

; rdi - pointer to dictionary, rsi - pointer to string to search
;
; rax - pointer to the found word in the dictionary, else 0
find_word:

  push rsi            ; rsi, r12 -> stack
  push r12
  mov r12, rsi

  .loop:
    lea  rsi, [r12 + STEP] ; rsi <- addr value

    push rdi               ; save rdi
    call string_equals
    pop rdi

    test rax, rax    
    jnz .success      ; lines are equal -> .found

    mov r12, [r12]  ; r12 <- next elem addr
    test r12, r12    
    jz .fail 

    jmp .loop

  .fail:
    xor rax, rax 
    pop r12  
    pop rsi 
    ret
  .success:
    mov rax, rsi 
    pop r12
    pop rsi 
    ret
