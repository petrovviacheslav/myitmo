# О предмете
Лектор и практик: Письмак Алексей Евгеньевич

[Журнал успеваемости потока 2023-24 учебного года 1 семестра](https://docs.google.com/spreadsheets/d/1dMRvYwRp3Lhy6IT5mbjdaplId9xB99b_9NijSpF7iJI/edit#gid=2120352098)

> [!IMPORTANT]
> Обязательно делайте скрины вашего варианта задания, так как он может неожиданно поменяться в тот момент, когда вы станете писать отчёт (так было в моём году). При этом вы уже не сможете подтвердить, что сделали нужный варик.

![](https://github.com/petrovviacheslav/myitmo/blob/main/gifs/monitors-typing.gif)

<details>
<summary><h3>1 лаба</h3></summary>


Данная лаба ориентирована на изучение ситаксиса. Если вы до этого немного прогали, то будет легко.
Для сдачи/выполнения:
- [Другие утилиты + байт-код](http://ivanbabanin.blogspot.com/2013/10/jdk.html)
- В строке ```String str = String.format("%7.4f ", c[i][j]);``` 7 - количество символов, выделенных на данное число при выводе, 4 - число цифр после запятой в каждом числе. 
- Если попросят представить в экспоненциальной форме или просто будут получаться огромные числа, то замените f на e. Надо уметь объяснить, откуда появляются None и Infinity (приколы с математическими операциями).
</details>


<details>
<summary><h3>2 лаба</h3></summary>

Полезное [видео](https://www.youtube.com/watch?v=9SQm6IsKJuo), в котором многое поясняется.

Следует пользоваться второй ссылкой с сайта se.ifmo.ru -  http://pokemondb.net.
Там подробно расписано про все атаки (их тип и что они делают) и характеристики покемонов.
После того, как вы разберётесь с типами и характеристиками идите в [документацию](https://se.ifmo.ru/~tony/doc/) и пытайтесь понять, как реализовать каждую атаку.
Вся информация, которая вам нужна отмечена на скринах.

<div>
<img src="https://github.com/petrovviacheslav/myitmo/blob/main/materials/pokemons/pok_att.png" width=57% align="middle">
<img src="https://github.com/petrovviacheslav/myitmo/blob/main/materials/pokemons/pok.png" width=40% align="middle">
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
- Для чего может быть полезна конструкция X y = new Y(), если у переменной y нельзя выpывать методы класса Y?
- Какие компоненты класса не наследуются?
- Для чего нужен конструктор (даже автогенерируемый в пустом классе)?
- Блок инициализации
- Для чего нужен @Override (детально рассказать)?

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
<summary><h3>3 лаба</h3></summary>

В данной лабе перед написанием кода вам надо продумать его структуру.

Uml лучше всего писать в IntelliJ IDEA Ultimate (получить можно по студенческой подписке).
Другой вариант - скачать jar-ник plantuml с [сайта](https://plantuml.com/ru/download) и запускать его с txt-файлом, как аргументом.

Для сдачи/выполнения:
- [про equals](https://www.techiedelight.com/override-equals-hashcode-method-java/)
- [про hashCode](https://translated.turbopages.org/proxy_u/en-ru.ru.d44f927c-65666aea-254b8a62-74722d776562/https/www.baeldung.com/java-hashcode) и [методы его реализации](https://habr.com/ru/companies/vk/articles/321306/)
- [SOLID](https://allineed.ru/development/java-development/82-java-solid-principles)
- [STUPID](https://it.badykov.com/blog/2020/03/08/stupid-principles/)
- [интерфейсы по умолчанию](https://metanit.com/java/tutorial/3.7.php)
- [ковариантность](https://pr0java.blogspot.com/2015/07/blog-post_47.html)

</details>



<details>
<summary><h3>4 лаба</h3></summary>

Для сдачи/выполнения:
- [вложенные, анонимные, локальные классы](https://javarush.com/groups/posts/vidy-vlozhennyh-klassov)

</details>