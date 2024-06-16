ORG 0x0027
TEMP:	WORD ?

ORG 0x0 	; Инициализация векторов прерывания
V0:	WORD 	$DEFAULT,0x180 ; Вектор прерывания #0
V1: 	WORD 	$INT8,0x180 	; Вектор прерывания #1
V2: 	WORD 	$DEFAULT,0x180	; Вектор прерывания #2
V3: 	WORD 	$DEFAULT,0x180 ; Вектор прерывания #3
V4: 	WORD 	$DEFAULT,0x180 ; Вектор прерывания #4
V5: 	WORD 	$DEFAULT,0x180 ; Вектор прерывания #5
V6: 	WORD 	$DEFAULT,0x180 ; Вектор прерывания #6
V7: 	WORD 	$DEFAULT,0x180 ; Вектор прерывания #7


DEFAULT: IRET 	; просто возврат

ORG 0x30 	; загрузка начальных векторов прерывания
START: DI	; запрет прерываний
CLA
OUT 0x1 	; MR КВУ-0 на вектор 0
OUT 0x3 	; MR КВУ-1 на вектор 0
OUT 0x5 	; MR КВУ-2 на вектор 0
OUT 0x7 	; MR КВУ-3 на вектор 0
OUT 0xB 	; MR КВУ-4 на вектор 0
OUT 0xD 	; MR КВУ-5 на вектор 0
OUT 0x11	; MR КВУ-6 на вектор 0
OUT 0x15 	; MR КВУ-7 на вектор 0
OUT 0x1E  	; MR КВУ-9 на вектор 0
 	
LD #0x9 	; Разрешить прерывания на вектор 1
OUT 0x1A ; (1000 | 0001 = 1001) в MR КВУ-8


EI	; разрешили прерывания

PROG: IN 0x19
AND #0x40
BEQ PROG
JUMP INT8


INT8: IN 0x18
ST TEMP
CYCLE: IN 0x0D  ; выводим букву   
AND #0x40
BEQ CYCLE
LD TEMP
OUT 0x0C
JUMP PROG





с прерываниями

ORG 0x0027
TEMP:	WORD ?

ORG 0x0 	; Инициализация векторов прерывания
V0:	WORD 	$DEFAULT,0x180 ; Вектор прерывания #0
V1: 	WORD 	$INT8,0x180 	; Вектор прерывания #1
V2: 	WORD 	$DEFAULT,0x180	; Вектор прерывания #2
V3: 	WORD 	$DEFAULT,0x180 ; Вектор прерывания #3
V4: 	WORD 	$DEFAULT,0x180 ; Вектор прерывания #4
V5: 	WORD 	$DEFAULT,0x180 ; Вектор прерывания #5
V6: 	WORD 	$DEFAULT,0x180 ; Вектор прерывания #6
V7: 	WORD 	$DEFAULT,0x180 ; Вектор прерывания #7


DEFAULT: IRET 	; просто возврат

ORG 0x30 	; загрузка начальных векторов прерывания
START: DI	; запрет прерываний
CLA
OUT 0x1 	; MR КВУ-0 на вектор 0
OUT 0x3 	; MR КВУ-1 на вектор 0
OUT 0x5 	; MR КВУ-2 на вектор 0
OUT 0x7 	; MR КВУ-3 на вектор 0
OUT 0xB 	; MR КВУ-4 на вектор 0
OUT 0xD 	; MR КВУ-5 на вектор 0
OUT 0x11	; MR КВУ-6 на вектор 0
OUT 0x15 	; MR КВУ-7 на вектор 0
OUT 0x1E  	; MR КВУ-9 на вектор 0
 	
LD #0x9 	; Разрешить прерывания на вектор 1
OUT 0x1A ; (1000 | 0001 = 1001) в MR КВУ-8
EI	; разрешили прерывания

PROG: JUMP PROG


INT8: IN 0x18
ST TEMP
CYCLE: IN 0x0D  ; выводим букву   
AND #0x40
BEQ CYCLE
LD TEMP
OUT 0x0C
IRET;возврат из обработки прерывания

