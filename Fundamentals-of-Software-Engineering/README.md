# О предмете

## Оглавление

1. [Общая информация](#info)
2. [Микрокр](#microkr)
3. [Рубежка](#rubez)
4. [Лабы](#labs)
5. [Экзамен](#exam)

## Общая информация <a name="info"></a>

Дисциплина: ОПИ (основы программной инженерии)

Лектор: Клименков Сергей Викторович, практик: Воронина Дарья Сергеевна (_aka добри Дора_)

[Журнал успеваемости потока 2024-25 учебного года 4 семестра](https://docs.google.com/spreadsheets/d/1J4CJTEE185eR_LpWSQquGP7Rd6oErDuMxsUXKgmSGgI/edit?gid=1973567039#gid=1973567039)

## Микрокр <a name="microkr"></a>

1. [просто тест системы](docs/mk0.pdf), за который не ставили баллы))
2. первая нормальная микрокр была пивом:
   - Какая команда svn выполняет следующие действия (написать без svn): Обновление рабочей копии продукта - update
   - К какому типу относится данное требование? Введите в поле ответа название группы требований на английском языке. Модуль генерации отчетов должен предусматривать возможность расширения доступных форматов для экспорта
   - Какая подкоманда git выполняет следующие действия (в ответ введите подкоманду без базового "git"): Обновить обьекты и ссылки с удаленного репозитория - fetch
   - В вашем проекте разработка идёт по модели gitflow. В какую ветку вы бы добавили коммит при возникновении следующей ситуаци: Вася ошибся в коде и теперь все пользователи имеют права администратора и могут читать чужую переписку - hotfix
   - Определите три самых важных риска по их экспозиции. Ответ введите перечислением номеров рисков через запятую(','), начиная с самого важного. 1. Риск закрытия программы полётов на Марс на государственном уровне prob=4% sum=800000 руб. 2. Риск возникновения пылевой бури в атмосфере Марса в период посадки prob=3% sum=8800000 руб. 3. Риск использования в конструкции корабля неэффективных двигателей prob=80% sum=840000 руб. 4. Риск нехватки запасов продовольствия на время полёта prob=80% sum=800000 руб. 5. Риск выбора неудачного стартового окна для полёта prob=5% sum=8700000 руб. - 3, 4, 5
   - И другие вопросы, которые можно быстро загнать в гпт
3. вторая микрокр была примерно [такая](docs/mk2.md) (тоже писали на листочках) [взято у eliteSufferer](https://github.com/eliteSufferer/ITMO_Studies/blob/main/OPI/mk1.md).

## Рубежка <a name="rubez"></a>

Материалы:
- рубежки 20/21 года - https://github.com/alex-grandson/edu/blob/main/MISPI/rubej.md
- [миро в которой хорошо разобраны варианты прошлых лет](https://miro.com/app/board/uXjVK-r8iVI=/)
- [другой разбор рубежки](docs/razbor.pdf)

В моём году было 2 дня для написания рубежки - 9 и 10 июня. В первый день всем потокам он давал варианты с 3 заданиями (первому потоку вообще дал задание точь-точь, как в файле), при этом мог поменять только концепцию ИС, например "Золушка" (уборка) / "Санта клаус" (доставка подарков) / "Колобок" (доставка булок). Во второй день были новые варианты по 10-12 вопросов. 

Что дал нового: 
- в первый день:
  - одному потоку добавил вопрос "Мониторинг и профилирование программ. Основные подходы. Пример программы, организующий мониторинг внутренних параметров или состояний при помощи Mbeans". Тут тупо налить воды про мониторинг + описать концепцию Mbean.
  - также были варианты [с немного другими тестовыми сценариями](docs/other-tests.jpg)
- в новых вариантах во второй день:
  - был вопрос про соотношение печки и кухни по отрывку из сказки (определить связь: агрегация, композиция, ...) - в ответах ниже это вопрос 8
  - был очень спорный вопрос про политические риски (влияние менеджеров - это политика!!) - в ответах вопрос 9
  - был вопрос, какие требования определены верно в соответствии со свойствами (просто на чуечке по факту выбрать) - в ответах вопрос 10
  - "Написать makefile с исполнение hello.c и word.c, один должен зависеть от другого"
  - первый вопрос - ИС, в которой надо прописать аттрибуты требований + Use-case вместо доменной модели + Use case
  - определить по 5 тестам (assert'ы с тремя параметрами - входное значение, выходное значение, возможная разница между ними), из которых 1, 2, 4 - выдали ошибку, а 3, 5 - верные, какая функция тестируется. Дано 5 вариантов на выбор, типо x^2 - 4, 2x - 4, 2 - cos(x), ... - в ответах вопрос 4
  - [ответы на один из потоков второго дня](docs/answers-rubez.jpg)

## Лабы <a name="labs"></a>

### 1 лаба

Надо написать SRS. Здесь система похожа с первой лабой по опд: практик всегда найдёт до чего доебаться в вашей лабе, поэтому просто исправляем косяки и ждём пока примут.

Из интересного, чекните данные варианты: 555, 558

### 2 лаба

Не делаем свои коммиты, а жмём на кружочки, появляющиеся при генерации варианта - это ваши ревизии как раз! Зачастую недостаточно в коде написать принудительный мердж, практики просят решить конфликт вручную. Можно использовать средства Visual Studio Code, как в моей лабе (для git)

### 3 лаба

Не обязательно, чтобы ваш скрипт работал, главное, чтобы практику показалось, что скрипт работает! ауф. Например, очень тяжело реализовать history для svn

### 4 лаба

С учётом того, что за эту лабу 20 баллов - то это одна из самых лёгких лаб. 4 задание абсолютно одинаковое для всех, поэтому его решение кочует из отчёта в отчёт, 2 и 3 задания - тоже несложные, просто потыкаться в утилитах. Придётся немного помудохаться только с 1 заданием, но оно тоже не супер сложное.

## Экзамен <a name="exam"></a>

Хорошие материалы:
- [от kyoto](https://docs.google.com/document/d/1mOeRs6-WKrAcwsTqyehsJl-ZT1zrzSXlnEm61GQfQBA/edit?tab=t.0)
- [от шаромышь](https://grove-spandex-678.notion.site/20a5159178a98015b8c2ee54a23defa4)
- [от zerumi](https://zerumi.notion.site/1bbf9e6a6b3944e8a54af4a90142be38)
- https://miro.com/app/board/uXjVK-r8iVI=/ (здесь лучше смотреть про диаграмму последовательностей)
- [файл 20/21 года](docs/2021-voprosy-k-ekzamenu.pdf), а также можно посмотреть вопросы на сайте https://se.ifmo.ru/courses/software-engineering-basics
