# О предмете
Лектор и практик: Письмак Алексей Евгеньевич

[Журнал успеваемости потока 2023-24 учебного года 1 семестра](https://docs.google.com/spreadsheets/d/1dMRvYwRp3Lhy6IT5mbjdaplId9xB99b_9NijSpF7iJI/edit#gid=2120352098)

> [!IMPORTANT]
> Обязательно делайте скрины вашего варианта задания, так как он может неожиданно поменяться в тот момент, когда вы станите писать отчёт (так было в моём году). При этом вы уже не сможете подтвердить, что сделали нужный варик.

![](https://github.com/petrovviacheslav/myitmo/blob/main/gifs/monitors-typing.gif)

## 1 лаба
Примерный пул вопросов:
- Что такое switch-case, в чём отличие этой конструкции в Java от других языков? Надо рассказать про break, return, yield, лямбда-функции (->).
- Какое существует ограничение на принимаемый параметр в switch-case? В свитч может идти только строка или целое число, так как нельзя сравнивать массивы данных и т.п., а также дробные числа неккоректно сравниваются
- Надо будет вывести javadoc через index.html в браузере
- Надо покопаться с jdb и поставить/убрать breakpoint
- Рассказать про то, как создавать прямоугольный массив с разными длинами строк
- Какие есть утилиты кроме самых известных (java, javac, jar, jdb, javadoc)? Самая интересная - javap (декомпиляция class-файла, или если применить параметр -c, можно посмотреть байткод), и [ещё несколько по большей части связанных с JVM](http://ivanbabanin.blogspot.com/2013/10/jdk.html)
- [Ну и множество других вопросов, которые вас поставят в тупик](https://www.youtube.com/watch?v=dQw4w9WgXcQ)

Возможно надо будет переписать код:
- заменить конструкцию if-else на switch-case
- заменить какой-то цикл на foreach

## 2 лаба
[Полезное видео, в котором многое поясняется](https://www.youtube.com/watch?v=9SQm6IsKJuo)

Сборку можно провести на helios следующим образом (в cmd windows не получится). Соответственно пути надо подставить свои.
```
export CLASSPATH=./lib/Pokemon.jar:./src:./src/info/Moves/PhysicalMoves:./src/info/Moves/StatusMoves./src/info/Moves/SpecialMoves./src/info/Pokemons:./src/info/Main
javac -d out src/info/Main.java
jar cfm Main.jar src/META-INF/MANIFEST.MF -C out . -C lib Pokemon.jar
java -jar Main.jar
```
