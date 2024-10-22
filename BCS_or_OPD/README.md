# О предмете

## Оглавление

1. [Общая информация](#info)
2. [Микрокр](#microkr)
3. [Рубежки](#rubez)
4. [Лабы](#labs)
5. [Экзамен](#exam)

## Общая информация <a name="info"></a>

Дисциплина: ОПД - Основы Профессиональной Деятельности

Лектор: Клименков Сергей Викторович, практики: Остапенко Ольга Денисовна, Вербовой Александр Александрович

- [Журнал успеваемости потока 2023-24 учебного года 1 семестра](https://docs.google.com/spreadsheets/d/13S-2iAf4nN32t-FHNJ_jX8qY8gaT1N2PcAmV19g3OMo/edit#gid=1376124505)
- [Журнал успеваемости потока 2023-24 учебного года 2 семестра](https://docs.google.com/spreadsheets/d/1r8d1n3sGhOtqBdFpx-kMUNpaGigBS6X_fC8O7VNI1Jc/edit#gid=881512036)

[Кастомная бэвм](custom.jar)

[Команды бэвм](interpreter.txt)

[Исовская бэвм, просто для интереса](https://github.com/AppLoidx/bcomp-extended) + [дока к ней](books.ifmo.ru/file/pdf/761.pdf)

Знаете почему символ вт - уточка? ...

Уточка, как студенты, когда ее сжимаешь, она попискивает.
© Клименков С.В.

## Микрокр <a name="microkr"></a>

На самом деле микрокр придуманы для того, чтобы повысить посещаемость лекций (также как и год назад). В первом семестре их никогда не проверяют

<b>Микрокр в 1 семе</b> была 22 ноября (вроде Клименков всегда её проводит в середине ноября), лучше прийти и посмотреть, как
она проходит.
Задания [2023 года](https://github.com/petrovviacheslav/myitmo/blob/main/%D0%9E%D0%9F%D0%94/%D0%BC%D0%B8%D0%BA%D1%80%D0%BE%D0%BA%D1%80/1.pdf).
Задания [2022 года](https://github.com/maxbarsukov/itmo/blob/master/1-2%20%D0%BE%D0%BF%D0%B4/%D0%BC%D0%B8%D0%BA%D1%80%D0%BE%D0%BA%D1%80/3/full.pdf)

<b>Первая микрокр во 2 семе</b>
![](https://i.imgur.com/PE16Yzz.png)
![](https://i.imgur.com/vNyTaJc.png)
У каждого ученика был свой вариант, который генерировался на сайте se.ifmo через ваш isu. То есть задания были
одинаковыми, а числа для них - разными

<b>Вторая микрокр по 2 семе</b>

Была без вариантов, но скринов нету (((

## Рубежки <a name="rubez"></a>


### Рубеж 1 семестра
[Тренажер](https://se.ifmo.ru/~s263975/program-tracing/)

[Гайд на трассировку](https://www.youtube.com/watch?v=u2-U5QQYgZw)

### Рубеж 2 семестра

<b>1 вариант - Программа ассемблере БЭВМ</b>
1. Программа должна быть реентерабельной и содержать отдельный блок исходных данных, констант и вспомогательных переменных (крч, программу можно несколько раз перезапустить и результат не будет меняться, то есть устанавливать значения временных переменных перед запуском)
2. Задания по образу и подобию лабораторных 3,4,5.
3. Везде есть массив, упаковка и размещение элементов массива в 16-ти и 32-х разрядные слова, действия, которые нужно сделать с каждым элементом (+ возможно вывод на ву)
4. Пролистайте третью часть презентации, особенно в части до подпрограмм, там есть подходы, которые могут пригодится.
5. Вспомните про тупоконечников и остроконечников. Подумайте как делать в БЭВМ операции с 32-х разрядными числами -> low endian big endian

<details>
<summary>Примеры</summary>

````
ORG 0x100

ARR_START: WORD $ARR
ARR_END: WORD 0
ARR_LENGTH: WORD 18
SMASK: WORD 0x0020
RES_H: WORD 0x0
RES_L: WORD 0x0

CUR_H: WORD 0x0
CUR_L: WORD 0x0

CUR_ADR: WORD 0x0

START:
CLA
ST RES_H
ST RES_L

LD ARR_START
ST CUR_ADR

ADD ARR_LENGTH
ADD ARR_LENGTH
ST ARR_END

MAIN_LOOP:
LD (CUR_ADR)+
ST CUR_H
LD (CUR_ADR)
ST CUR_L

LD CUR_ADR
DEC
ADD #6
ST CUR_ADR

LD CUR_H
AND SMASK
BZS POS
NEG
OR CUR_H
POS:
ST CUR_H

LD CUR_L
ADD RES_L
ST RES_L
CALL SIGN_CHECK
LD RES_H
ADD CUR_H
LD CUR_ADR
CMP ARR_END
BGE STOP
JUMP MAIN_LOOP
STOP:
HLT

SIGN_CHECK:
LD CUR_L
BMI NEGATIVE
POSITIVE:
LD RES_H
ADC #0
ST RES_H
RET
NEGATIVE:
LD RES_H
ADC #-1
ST RES_H
RET


ORG 0x6D2
ARR:
````
![](https://i.imgur.com/G3ktdDe.jpg)


У меня был очень похожий вариант, я сделал по другому, вот код:
````
я увидел это только спустя 6 месяцев и вообще не помню, что я писал((( кидайте свои программы на гит сразу!
````

Другие коды, которые разбирались до рубежки, то есть ребята сами придумывали задание, а потом реализовывали его (мне это очень помогло подготовиться):

Сначала будет код, потом задание (каждый блок отделил горизонтальной линией)

```
    ORG 0x100
max: WORD 0x0000
firstElementAddress: WORD 0x500
currentElementAddress: WORD 0x0000          ; Переменная, равная firstElementAddress (чтобы сделать программу реентерабельной)
arrayLength: WORD 0x0005
elementsLeft: WORD 0x0000                   ; Переменная, равная elementsLeft (чтобы сделать программу реентерабельной)

    ORG 0x110
Start: CLA
    ST max                                  ; Сброс всех элементов (чтобы сделать программу реентерабельной)
    LD firstElementAddress
    ST currentElementAddress
    LD arrayLength
    ST elementsLeft
    MainLoop: LD (currentElementAddress)+   ; Загружен элемент массива
        CMP max                             ; Сравниваем с максимумом
        BLT Next                            ; Если элеменет < максимума, то переход на следующую итерацию цикла
        ST max                              ; Если оказалось, что элемент >= максимуму, то записать его в максимум
        Next: LOOP elementsLeft
        JUMP MainLoop
HLT


    ORG 0x500
WORD 0x1000
WORD 0x2141
WORD 0xFFFF
WORD 0x9241
WORD 0x5555

```
Эта программа ищет максимальный элемент массива, состоящего из 16-битовых знаковых чисел. Ответ лежит в ячейке 100.

----------

```
sum1: WORD 0
sum2: WORD 0

thingWeSum: WORD 0

summing:
LD thingWeSum
BLT if_neg

ADD sum1
ST sum1
CLA
ADC sum2
ST sum2
JUMP return

if_neg:
ADD sum1
ST sum1
LD #0xFF
ADC sum2
ST sum2
JUMP return

return:
```
32-разрядная сумма

----------

```
ORG 0x10
ArrAddr: WORD 0x300
CurElemAddr: WORD 0
step: WORD 0
arrayIndex: WORD 0
ArrLength: WORD 29
sum1: WORD 0
sum2: WORD 0
TMP: WORD ?

Start:
LD #0
ST sum1
ST sum2
Spin0:
IN 5
AND #0x40
BEQ Spin0
IN 4
ST step

DEC
ST arrayIndex
JUMP Skip

OlegSheyko:
LD arrayIndex
ADD step
ST arrayIndex
Checking:
CMP ArrLength
BMI Skip
HLT
Skip:
LD ArrAddr
ADD arrayIndex
ST CurElemAddr

summing:
LD (CurElemAddr)

ExtendingSign:
ASR
ASR
SXTB
ASL
ASL
ST TMP
LD (CurElemAddr)
AND #0x03
ADD TMP

BLT if_neg

ADD sum1
ST sum1
CLA
ADC sum2
ST sum2
JUMP OlegSheyko

if_neg:
ADD sum1
ST sum1
LD #0xFF
ADC sum2
ST sum2
JUMP OlegSheyko


ORG 0x300
Array:
WORD 0;
WORD 0;
...
WORD 0; 30й элемент

```
Обход массива 10 битных значений с суммированием каждого k-го элемента (ввод k с ВУ2) в 32 битную сумму

----------
```
ORG 0x10
ArrAddr: WORD 0x300
CurElemAddr: WORD 0
step: WORD 0
arrayIndex: WORD 0
ArrLength: WORD 29
sum1: WORD 0
sum2: WORD 0

Start:
LD #0
ST sum1
ST sum2
LD ArrLength ; увеличение границы для проверки индекса
ASL
INC
ST ArrLength
Spin0:
IN 5
AND #0x40
BEQ Spin0
IN 4
ASL ; умножаю шаг на 2
ST step

SUB #2 ; вычитаю 2, чтобы верно обработать первый по порядку k-ый элемент
ST arrayIndex
JUMP Skip

OlegSheyko:
LD arrayIndex
ADD step
ST arrayIndex
Checking:
CMP ArrLength
BMI Skip
HLT
Skip:
LD ArrAddr
ADD arrayIndex
ST CurElemAddr

summing:
LD (CurElemAddr)+

ADD sum1 ; складывание младшего байта
ST sum1

summing2:
LD (CurElemAddr)
ADC #0 ; сложение с битом С, потому что он будет потерян при расширении знака старшего байта
ExtendingSign:
ASL
ASL
ASL
ASL
ASL
ASL
SXTB
ASR
ASR
ASR
ASR
ASR
ASR
ADD sum2
LD CurElemAddr ; возвращение указателя к младшему байту
DEC
ST CurElemAddr
JUMP OlegSheyko


ORG 0x300
Array:
WORD 0;
WORD 0; 1 элемент
WORD 0;
WORD 0; 2 элемент
...
WORD 0;
WORD 0; 30й элемент

```
Обход массива 18 битных значений с суммированием каждого k-го элемента (ввод k с ВУ2) в 32 битную сумму

формат хранения мл_байт_0, ст_байт_0, мл_байт_1, ст_байт_1, ...

----------

````
ORG 0x10
ArrAddr: WORD 0x300
CurElemAddr: WORD 0
flat_dimension: WORD 7 ; размер
linearIndexMaxBorder: WORD 0 ; макс граница линейного индекса
count: WORD ? ; счётчик 
indexI: WORD 0
indexJ: WORD 0
indexJMaxBorder: WORD ? ; фактическая граница для индекса J (т.к храним мл_байт, ст_байт в элементе)
step_i: WORD 3
step_j: WORD 2
step_i_f: WORD ? ; шаг для первого случая
step_j_f: WORD ?
step_j_actual: WORD ? ; шаг для корректного прохода по элементам в строке
indexLinear: WORD 0
sum1: WORD 0
sum2: WORD 0

Start:
CLA
ST sum1
ST sum2
LD step_i
DEC
ST step_i_f
LD step_j
ASL
ST step_j_actual ; фактический шаг это step * 2
SUB #2
ST step_j_f ; но для первого случая step * 2 - 2
LD flat_dimension ; count = 7 = flat_dimension
ST count
ASL
ST indexJMaxBorder; граница у j = 7*2 = 14
LD #0

square: ; расчёт для дальнейшей проверки границ лин.индекса (2*7*7)
ADD flat_dimension ; (=7)
LOOP count ; (count = 7)
JUMP square
ASL
ST linearIndexMaxBorder

calcIndexes_f: ; индексы для первого прохода
LD step_i_f 
ST indexI
LD step_j_f
ST indexJ
JUMP calcLinearIndex

; //////////////////////

OlegSheyko:

calcIndexes: ; добавление шага к индексам (смещение)
LD indexJ
CMP indexJMaxBorder ; сначала проверяем, что мы обошли все элементы в строке (j)
BPL inc_i
ADD step_j_actual ; если нет, то добавляем шаг
ST indexJ
JUMP calcLinearIndex

inc_i: ; иначе ставим в позицию для первого случая !!!
LD step_j_f 
ST indexJ

LD indexI ; увеличиваем i
ADD step_i
ST indexI

checking: ; проверка что i не вышел за границы 
LD indexI
CMP flat_dimension
BMI calcLinearIndex
HLT


; //////////////////////

calcLinearIndex: ; короче тут типа линейный индекс вычисляется как 7*i + j
CLA
ST linearIndex
LD indexI
BEQ add_j

add_i:
LD linearIndex
ADD flat_dimension
ST linearIndex

LD indexI
DEC
ST indexI
BNE add_i

ASL
ST linearIndex

add_j:
LD linearIndex
ADD indexJ
ST linearIndex
CMP linearIndexMaxBorder ; проверка чтобы он не вышел за границы
BMI elemFinder
HLT

; //////////////////////

elemFinder: ; представляем двумерный массив как единую строку и смещаемся по ней
LD ArrAddr
ADD linearIndex
ST CurElemAddr

; //////////////////////

summing:
LD (CurElemAddr)+

checkingMultiplicity: 
ROR
BCS return
ROR
BCS return
ROL
ROL

ADD sum1 ; складывание младшего байта
ST sum1

summing2:
LD (CurElemAddr)
ADC #0 ; сложение с битом С, потому что он будет потерян при расширении знака старшего байта
ExtendingSign:
ASL
ASL
ASL
ASL
SXTB
ASR
ASR
ASR
ASR
ADD sum2
return:
LD CurElemAddr ; возвращение указателя к младшему байту
DEC
ST CurElemAddr
JUMP OlegSheyko

; //////////////////////

ORG 0x300
Array:
WORD 0;   i = 0, j = 0
WORD 0;
...
WORD 0;   i = 0, j = 13
WORD 0;

WORD 0;   i = 1, j = 0
WORD 0;
...
WORD 0;   i = 1, j = 13
WORD 0;
````
Суммирование каждого элемента двумерного массива размерностью [7][7] с индексом i с шагом 3, индексом j с шагом 2 и при условии, что элемент кратен 4, состоящего из 20-разрядных элементов, с формированием 32-разрядного результата

Формат хранения элементов в массиве: мл_байты_0; ст_байты_0; мл_байты_1; ст_байты_1; ...

----------
```
    ORG 0x20
ARR_LENGTH:    WORD ?  ; Длина вводимого массива
CURR_ELEM:    WORD 0  ; Текущий элемент
ELEMS_LEFT:    WORD ?  ; Сколько элементов осталось (счетчик цикла)
SUM_0_15:    WORD 0  ; Результат/сумма (младшие 2 байта)
SUM_16_31:    WORD 0  ; Результат/сумма (старшие 2 байта)
INDEX_CHECK:    WORD 0  ; Счетчик, который обнуляется каждый k-ый индекс (для суммы k-ых элементов)
INDEX_INDENT:  WORD ?  ; k - число, которому кратны индексы суммируемых элементов
COMPARISON_MASK:  WORD 0x2000 ; Маска для проверки знака 14-ти разрядного числа
NEGATIVE_MASK:  WORD 0xC000 ; Маска для очищения "мусора" в старших разрядах и получения отрицательного числа
POSITIVE_MASK:  WORD 0x1FFF  ; Маска для очищения "мусора" в старших разрядах и получения положительного числа

START:  CLA    ; Загружаем исходные данные в обновляемые ячейки и обнуляем ячейки результата
  ST $SUM_0_15
  ST $SUM_16_31
  LD $ARR_LENGTH
  ST $ELEMS_LEFT

MAIN_LOOP:  CLA    ; Основной цикл программы
  ST $CURR_ELEM  ; Обнуляем ячейку с предыдущим считанным элементом
  CALL WORD_INPUT  ; Вызов подпрограммы ввода числа
  LD $INDEX_CHECK  ; Проверка на равенство счетчика числу k
  INC
  CMP $INDEX_INDENT
  BEQ FUNCTION  ; Если счетчик равен k - переходим к функции суммирования
  ST $INDEX_CHECK  ; Иначе - сохраняем новое значение счетчика и продолжаем цикл
LOOP_END:  LOOP ELEMS_LEFT
  JUMP MAIN_LOOP
  HLT

WORD_INPUT:      ; Подпрограмма для ввода числа с ВУ-2 (сначала старший байт, затем младший)
SPIN_LOOP_1:  IN 5    ; Спин-луп
  AND #0x40
  BEQ SPIN_LOOP_1
  IN 4    ; Ввод старшего байта
  SWAB
  ST $CURR_ELEM
SPIN_LOOP_2:  IN 5    ; Спин-луп
  AND #0x40
  BEQ SPIN_LOOP_2
  IN 4    ; Ввод младшего байта
  ADD $CURR_ELEM
  ST $CURR_ELEM
  RET

FUNCTION:  CLA
  ST $INDEX_CHECK  ; Обнуляем счетчик элементов
  LD $CURR_ELEM  ; Загружаем только что считанный элемент
  AND $COMPARISON_MASK  ; Проверяем знак числа с помощью маски и переходим к нужной подфункции суммирования
  BEQ POS_ELEM
  JUMP NEG_ELEM

POS_ELEM:  LD $CURR_ELEM  ; Подфункция для суммирования с положительным числом
  AND $POSITIVE_MASK
  ADD $SUM_0_15
  ST $SUM_0_15
  CLA
  ADC $SUM_16_31
  ST $SUM_16_31
  JUMP LOOP_END

NEG_ELEM:  LD $CURR_ELEM  ; Подфункция для суммирования с отрицательным числом
  OR $NEGATIVE_MASK
  ADD $SUM_0_15
  ST $SUM_0_15
  LD #0xFF
  ADC $SUM_16_31
  ST $SUM_16_31
  JUMP LOOP_END

```
Суммирование каждого k-ого элемента массива в 32-ух разрядную сумму, вводимого с ВУ-2. Элементы — 14-ти разрядные числа

</details>


<b>2 вариант - трассировка микрокода</b>

На всякий случай, тренажёр немного поломанный, поэтому иногда неверно выдаёт результат - https://205826.github.io/MicroProgramTracingBasicComputer/

Хороший гайд от Zerumi - https://www.youtube.com/watch?v=vuW08kTodJM


## Лабы <a name="labs"></a>


<details>
<summary><h2>1 лаба</h2></summary>

Первая лаба по ОПД - можно сказать самая первая крупная проблема, с которой вы столкнётесь, как только поступите на ВТ.
Остальные лабы (в 1 семестре) по другим предметам значительно легче.
Скорее всего вы сдадите эту лабу только тогда, когда практик решит, что достаточно помучал вас (обычно это происходит в
конце октября - начале ноября).
В принципе можно установить Linux, как вторую ОС или подсистему, ну или пользуйтесь виртуалкой (VirtualBox / VMware),
так как вы замучаетесь отрабатывать команды на helios'е.

Годные курсы на степике, которые помогут изучить команды (их очень много) + опции, - [первый](https://stepik.org/course/548/syllabus) и [второй](https://stepik.org/course/762/syllabus). Если у вас
мало времени, то проходите только второй.

Небольшие мануалы для сдачи:

- [Неплохая теория для сдачи от знакомого](https://docs.google.com/document/d/19otD1kkqn4YImn4nDXEeJ2ycgZoWlZ9C/edit)
- [Ещё один гугл док (прям с нуля)](https://docs.google.com/document/d/1XZ7bkOy13lZGQ0-5w4AaAFLb610I_oCZKR_OsyIkvao/)
- [Дополнение к предыдущему](https://docs.google.com/document/d/1Bc6oI4yNCBIUSL9HYmv4jfmCJZzMQJRaJLEnP4KGhTY/)

</details>
<details>
<summary><h2>2 лаба</h2></summary>
[Лучший видос для кристального понимания](https://www.youtube.com/watch?v=5DXYGx7RtZY)

### Пояснение про ОДЗ:

Когда ты складываешь знаковые числа в БЭВМ, если ты решишь сложить 2 числа одного знака (давай для удобства возьмем положительные числа), то ты ограничен тем, что сумма будет в промежутке от 0 (!!) до 2^15 - 1 (только 15 разрядов). Ты обязан гарантировать для корректности суммы, что X + Y < 2^15 - 1, при условии, что X > 0; Y > 0.
Это самое точное ОДЗ, которое ты можешь получить для случая, когда X и Y положительные, но тут есть проблема -- в неравенстве 2 неизвестных. Но! Если ты сложишь 2 числа с разными знаками, то какими бы они не были (буквально), переполнения никогда в этом случае не возникнет, поскольку результат точно попадает в ограничение 16-разрядной сетки (у тебя считай будет вычитание, а результат вычитания всегда меньше уменьшаемого, которое само по себе ограничено 15 разрядами)

Поэтому самое точное ОДЗ здесь будет следующее: X > 0; Y < 0 || X < 0; Y > 0. Еще раз: переполнение невозможно при сложении разнознаковых чисел

С этим знанием в презентации поделили на 3 разных случая. Чтобы точно не возникало переполнения (X + Y &le; 2^15 - 1), ограничили X и Y вплоть до 2^14 - 1. И действительно, максимальная сумма X + Y, если ограничить сверху до 2^14 - 1 будет 2*(2^14 - 1) = 2^15 - 2 < 2^15 - 1 (мы гарантируем, что переполнения не возникнет)
Таким образом, мы перешли от сложно задаваемого ОДЗ в X + Y &le; 2^15 - 1 ко вполне себе приемлимой системе: X &le; 2^14 - 1, Y &le; 2^14 - 1

Дальше, понимая, что если складывать числа разных знаков, переполнения не возникает, дополним это очень сильно ограниченное ОДЗ следующими 2мя случаями:
Мы не покрываем X первым случаем в промежутке от 2^14 до 2^15 - 1. В этом случае Y может быть любым отрицательным числом -> Y < 0

И аналогично для Y. Аналогично для отрицательных чисел

Самое главное, что отсюда стоит усвоить, это точное ОДЗ, которое покрывает все случаи: X + Y &le; 2^15 - 1
Для отрицательных чисел я не писал, но оно будет X + Y &ge; -2^15. Разнознаковые числа складываются без ограничений 

Но написанное выше не является адекватно написанным ОДЗ, поэтому мы изворачиваемся, возможно упуская некоторые случаи, при которых программа тоже работала бы корректно, но это сделано в целях того, чтобы пользователь мог пользоваться программой, мог заранее для себя понять, корректно ли она отработает при его значениях.

Не всегда X и Y придумываются совместно друг с другом. Часто приходится иметь дело с тем, что на данном этапе времени нам дано только X, и мы должны понимать, оно валидно, или нет. Поэтому одз X + Y &le; 2^15 - 1 это плохое одз


Мануал:

- [Про основное расписано](https://docs.google.com/document/d/1uIEith7IyBjr1Ml_8ONNz5hXl6lLQfBaHNtGxB_ksww/edit)

</details>
<details>
<summary><h2>3 лаба</h2></summary>

Ничего особо сложного нет, можно сделать свою лабу ~~по аналогии с каким-то другим отчётом с чьего-то гита~~. Также
почитайте в методичке про адресацию и потактовое исполнение команд loop и jump

Мануал:

- [Лучше читать здесь](https://docs.google.com/document/d/1ibxWGHrGqzumBXy3c-ye6oFcl5KJKDzT_ZZbq8nSPpU/edit)

</details>

<details>
<summary><h2>4 лаба</h2></summary>

У вас отдельно есть функция (идёт после -----), команды в которой вы должны раскодировать, и основная прога, которая применяет эту функцию на некоторый набор чисел, типо f(x) + f(y) - f(z-1)

блять потом допишу

</details>

<details>
<summary><h2>5 лаба</h2></summary>

блять потом допишу

</details>

<details>
<summary><h2>6 лаба</h2></summary>

блять потом допишу

</details>

<details>
<summary><h2>7 лаба</h2></summary>

блять потом допишу

</details>

## Экзамен <a name="exam"></a>

https://github.com/Imtjl/1st-year-guide/blob/main/OPD/%D0%91%D0%B8%D0%BB%D0%B5%D1%82%D1%8B_%D1%8D%D0%BA%D0%B7%D0%B0%D0%BC%D0%B5%D0%BD_2.docx

https://github.com/maxbarsukov/itmo/blob/master/1-2%20%D0%BE%D0%BF%D0%B4/%D1%8D%D0%BA%D0%B7%D0%B0%D0%BC%D0%B5%D0%BD/%D0%91%D0%B8%D0%BB%D0%B5%D1%82%D1%8B%D0%AD%D0%BA%D0%B7%D0%B0%D0%BC%D0%B5%D0%BD%D0%9E%D0%9F%D0%94.pdf


![](https://i.imgur.com/nvfO5L3.jpg)

