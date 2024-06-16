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

## Микрокр <a name="microkr"></a>

На самом деле микрокр придуманы для того, чтобы повысить посещаемость лекций и по итогу у нас микрокр так и не
проверили (также как и год назад)

Микрокр в 1 семе была 22 ноября (вроде Клименков всегда её проводит в середине ноября), лучше прийти и посмотреть, как
она проходит.
Задания [2023 года](https://github.com/petrovviacheslav/myitmo/blob/main/%D0%9E%D0%9F%D0%94/%D0%BC%D0%B8%D0%BA%D1%80%D0%BE%D0%BA%D1%80/1.pdf).
Задания [2022 года](https://github.com/maxbarsukov/itmo/blob/master/1-2%20%D0%BE%D0%BF%D0%B4/%D0%BC%D0%B8%D0%BA%D1%80%D0%BE%D0%BA%D1%80/3/full.pdf)

Микрокр во 2 семе
![](https://i.imgur.com/PE16Yzz.png)
![](https://i.imgur.com/vNyTaJc.png)
У каждого ученика был свой вариант, который геренирировался на сайте se.ifmo через ваш isu. То есть задания были
одинаковыми, а числа для них - разными

## Рубежки <a name="rubez"></a>


### Рубеж 1 семестра
[Тренажер](https://se.ifmo.ru/~s263975/program-tracing/)

[Гайд на трассировку](https://www.youtube.com/watch?v=u2-U5QQYgZw)

### Рубеж 2 семестра

1 вариант - Программа ассемблере БЭВМ
1. Текст программы на ассемблере БЭВМ с комментариями (аналогично требованиям лаб 5, 6)
2. Программа должна быть реентерабельной и содержать отдельный блок исходных данных, констант и вспомогательных переменных
3. Задания по образу и подобию лабораторных 3,4,5.
4. Везде есть массив, упаковка и размещение элементов массива в 16-ти и 32-х разрядные слова, действия, которые нужно сделать с каждым элементом.
5. Пролистайте третью часть презентации, особенно в части до подпрограмм, там есть подходы, которые могут пригодится.
6. Вспомните про тупоконечников и остроконечников. Подумайте как делать в БЭВМ операции с 32-х разрядными числами -> low endian big endian

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
````

Другие коды, которые разбирались до рубежки, то есть ребята сами придумывали задание, а потом реализовывали его (мне это очень помогло подготовиться):
````
````
</details>
2 вариант - трассировка микрокода

## Лабы <a name="labs"></a>

Большая часть теории переписана из методички более понятным языком (от https://github.com/arseeenyyy)
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

## Экзамен <a name="exam"></a>

![](https://i.imgur.com/nvfO5L3.jpg)

