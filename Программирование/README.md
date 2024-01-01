# О предмете

## Оглавление
1. [Общая информация](#info)
2. [Рубежки](#rubez)
3. [Лабы](#labs)

## Общая информация <a name="info"></a>
Лектор и практик: Письмак Алексей Евгеньевич

[Журнал успеваемости потока 2023-24 учебного года 1 семестра](https://docs.google.com/spreadsheets/d/1dMRvYwRp3Lhy6IT5mbjdaplId9xB99b_9NijSpF7iJI/edit#gid=2120352098)

> [!IMPORTANT]
> Обязательно делайте скрины вашего варианта задания, так как он может неожиданно поменяться в тот момент, когда вы станете писать отчёт (так было в моём году). При этом вы уже не сможете подтвердить, что сделали нужный варик.

![](https://i.imgur.com/1S6nxuu.gif)

## Рубежки <a name="rubez"></a>

![](https://i.imgur.com/WtM3fSA.jpg)

Вопросы из года в год повторяются, поэтому советую посмотреть [самые популярные](./Рубежки/)

## Лабы <a name="labs"></a>
[Здесь очень хорошо расписана теория для сдачи 2-4 лабы](https://github.com/exception-s/course1) 

<details>
<summary><h2>1 лаба</h2></summary>

Данная лаба ориентирована на изучение синтаксиса. Если вы до этого немного прогали, то будет легко.

Для сдачи/выполнения:
- [Другие утилиты + байт-код](http://ivanbabanin.blogspot.com/2013/10/jdk.html)
- В строке ```String str = String.format("%7.4f ", c[i][j]);``` 7 - количество символов, выделенных на данное число при выводе, 4 - число цифр после запятой в каждом числе. 
- Если попросят представить в экспоненциальной форме или просто будут получаться огромные числа, то замените f на e. 
- Надо уметь объяснить, откуда появляются None и Infinity (приколы с математическими операциями).
</details>


<details>
<summary><h2>2 лаба</h2></summary>

[Полезное видео](https://www.youtube.com/watch?v=9SQm6IsKJuo), в котором многое поясняется.

Следует пользоваться второй ссылкой с сайта se.ifmo.ru -  http://pokemondb.net.
Там подробно расписано про все атаки (их тип и что они делают) и характеристики покемонов.
После того, как вы разберётесь с типами и характеристиками идите в [документацию](https://se.ifmo.ru/~tony/doc/) и пытайтесь понять, как реализовать каждую атаку.
Вся информация, которая вам нужна отмечена на скринах.

<div>
<img src="https://i.imgur.com/gU8EqdB.png" width=57% align="middle">
<img src="https://i.imgur.com/ui7nqbD.png" width=40% align="middle">
</div>

> 1 скрин - любая атака, 2 скрин - любой покемон

Сборку можно провести на helios следующим образом (в cmd windows не получится). Соответственно пути надо подставить свои.
```
export CLASSPATH=./lib/Pokemon.jar:./src:./src/info/Moves/PhysicalMoves:./src/info/Moves/StatusMoves./src/info/Moves/SpecialMoves./src/info/Pokemons:./src/info/Main
javac -d out src/info/Main.java
jar cfm Main.jar src/META-INF/MANIFEST.MF -C out . -C lib Pokemon.jar
java -jar Main.jar
```

Скорее всего вопросы будут заданы, основываясь на вашем коде, поэтому когда вас попросят открыть какую-нибудь атаку, лучше не открывать что-то очень сложное. 

Популярные вопросы:
- [Какие компоненты класса не наследуются?](https://translated.turbopages.org/proxy_u/en-ru.ru.a8bde27f-6570d643-f0b00af1-74722d776562/https/stackoverflow.com/questions/23103498/which-members-are-not-inherited-in-a-child-class)
- [конструктор, автогенерируемый конструктор](https://javarush.com/groups/posts/1391-konstruktorih-klassov-java-jdk-15)
- [блок инициализации](https://vertex-academy.com/tutorials/ru/bloki-inicializacii-v-java-chast-1/)
- [теория по всему остальному](https://github.com/exception-s/course1?tab=readme-ov-file#%D0%BB%D0%B0%D0%B1%D0%BE%D1%80%D0%B0%D1%82%D0%BE%D1%80%D0%BD%D0%B0%D1%8F-%D1%80%D0%B0%D0%B1%D0%BE%D1%82%D0%B0-2)

Возможные доп. задания:
- При перемещении jar-файла он перестаёт запускаться (т.к. в нём находятся зависимости), решить эту проблему. При сборке jar-ника в него надо класть не Pokemon.jar, а разархивированные данные.
```
jar xf lib/Pokemon.jar
jar cfm Main.jar src/META-INF/MANIFEST.MF -C out . -C . ru (вместо 3-ей строки при сборке)
```
- При нажатии Ctrl+C бой прекращается (так и должно быть), при этом надо вывести фразу "Покемон умер". Надо дописать такую строку перед созданием всех покемонов в Main.java:
```
Runtime.getRuntime().addShutdownHook(new Thread(() -> {
    System.out.println("Я УМИРАААААААЮ!!!!");
}));
```
</details>

<details>
<summary><h2>3 лаба</h2></summary>

[Рофлогайд на эту лабу](https://www.youtube.com/watch?v=uZqMHOLqBsA&t=144s)

Uml лучше всего писать в IntelliJ IDEA Ultimate ([получить можно по студенческой подписке](https://github.com/Imtjl/1st-year-guide/blob/main/PROG/Jet_brains.pdf)).
Другой вариант - скачать jar-ник plantuml с [сайта](https://plantuml.com/ru/download) и запускать его через командную строку с txt-файлом, как аргументом.

Для сдачи/выполнения:
- [про equals](https://www.techiedelight.com/override-equals-hashcode-method-java/)
- [про hashCode](https://www.baeldung.com/java-hashcode) и [методы его реализации](https://habr.com/ru/companies/vk/articles/321306/)
- [SOLID](https://allineed.ru/development/java-development/82-java-solid-principles)
- [интерфейсы по умолчанию](https://metanit.com/java/tutorial/3.7.php)
- [теория по всему остальному](https://github.com/exception-s/course1?tab=readme-ov-file#%D0%BB%D0%B0%D0%B1%D0%BE%D1%80%D0%B0%D1%82%D0%BE%D1%80%D0%BD%D0%B0%D1%8F-%D1%80%D0%B0%D0%B1%D0%BE%D1%82%D0%B0-3)

</details>

<details>
<summary><h2>4 лаба</h2></summary>

Для сдачи/выполнения:
- [теория](https://github.com/exception-s/course1?tab=readme-ov-file#%D0%BB%D0%B0%D0%B1%D0%BE%D1%80%D0%B0%D1%82%D0%BE%D1%80%D0%BD%D0%B0%D1%8F-%D1%80%D0%B0%D0%B1%D0%BE%D1%82%D0%B0-4)

</details>