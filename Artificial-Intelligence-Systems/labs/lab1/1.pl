% Факты о людях (ID, Фамилия, Имя, Пол)
person(1, 'Петрова', 'Карина', female).
person(2, 'Петров', 'Вячеслав', male).
person(3, 'Петров', 'Валентин', male).
person(4, 'Петрова', 'Анна', female).
person(5, 'Петров', 'Марк', male).
person(6, 'Петрова', 'Наталия', female).
person(7, 'Копасов', 'Сергей', male).
person(8, 'Старикова', 'Анастасия', female).
person(9, 'Петрова', 'Лора', female).
person(10, 'Петров', 'Алексей', male).
person(11, 'Петров', 'Егор', male).
person(12, 'Копасова', 'Татьяна', female).
person(13, 'Копасов', 'Евгений', male).
person(14, 'Копасова', 'Валентина', female).
person(15, 'Елисеев', 'Андрей', male).
person(16, 'Елисеев', 'Сергей', male).
person(17, 'Стариков', 'Иван', male).
person(18, 'Старикова', 'Мария', female).
person(19, 'Петров', 'Кирилл', male).
person(20, 'Петрова', 'Людмила', female).
person(21, 'Копасова', 'Екатерина', female).
person(22, 'Копасов', 'Дмитрий', male).
person(23, 'Елисеева', 'Варвара', female).
person(24, 'Елисеев', 'Константин', male).
person(25, 'Петров', 'Трофим', male).
person(26, 'Петрова', 'Нина', female).
person(27, 'Копасов', 'Даниил', male).
person(28, 'Копасова', 'Прасковья', female).
person(29, 'Елисеев', 'Алексей', male).
person(30, 'Елисеева', 'Любовь', female).

% События рождения (ID, Год)
birth(1, 2003).
birth(2, 2005).
birth(3, 1975).
birth(4, 1984).
birth(5, 1981).
birth(6, 1980).
birth(7, 1977).
birth(8, 1941).
birth(9, 1947).
birth(10, 1943).
birth(11, 1945).
birth(12, 1950).
birth(13, 1948).
birth(14, 1950).
birth(15, 1955).
birth(16, 1952).
birth(17, 1912).
birth(18, 1914).
birth(19, 1915).
birth(20, 1910).
birth(21, 1923).
birth(22, 1921).
birth(23, 1919).
birth(24, 1919).
birth(25, 1880).
birth(26, 1882).
birth(27, 1894).
birth(28, 1897).
birth(29, 1888).
birth(30, 1889).

% События смерти (ID, Год)
death(8, 2002).
death(10, 2011).
death(11, 2013).
death(12, 2022).
death(15, 2020).
death(16, 2015).
death(17, 1950).
death(18, 1954).
death(19, 1945).
death(20, 1964).
death(21, 1960).
death(22, 1970).
death(23, 1991).
death(24, 1978).
death(25, 1941).
death(26, 1942).
death(27, 1941).
death(28, 1942).
death(29, 1941).
death(30, 1941).

% Браки (ID1, ID2, Год)
marriage(5, 6, 2002).
marriage(9, 10, 1970).
marriage(13, 14, 1977).
marriage(17, 18, 1937).
marriage(19, 20, 1935).
marriage(21, 22, 1946).
marriage(23, 24, 1950).
marriage(25, 26, 1910).
marriage(27, 28, 1917).
marriage(29, 30, 1919).

% Разводы (ID1, ID2, Год)
divorce(5, 6, 2011).

% Родительские связи (родитель, ребенок)
parent(5, 1).
parent(6, 1).
parent(5, 2).
parent(6, 2).

parent(9, 3).
parent(10, 3).
parent(9, 4).
parent(10, 4).
parent(9, 5).
parent(10, 5).

parent(13, 6).
parent(14, 6).
parent(13, 7).
parent(14, 7).

parent(17, 8).
parent(18, 8).
parent(17, 9).
parent(18, 9).

parent(19, 10).
parent(20, 10).
parent(19, 11).
parent(20, 11).

parent(21, 12).
parent(22, 12).
parent(21, 13).
parent(22, 13).

parent(23, 14).
parent(24, 14).
parent(23, 15).
parent(24, 15).
parent(23, 16).
parent(24, 16).

parent(25, 19).
parent(26, 19).
parent(27, 22).
parent(28, 22).
parent(29, 24).
parent(30, 24).

% ПРАВИЛО 1: Найти ID по фамилии и имени
find(ID, LastName, FirstName) :- person(ID, LastName, FirstName, _).

% Правило 2: Проверка, жив ли человек в заданный год
alive(ID, Year) :- alive_status(ID, Year, alive).

% Правило 3-4: Проверка, что когда то был брак/развод
married(ID1, ID2) :- marriage(ID1, ID2, _).
married(ID1, ID2) :- marriage(ID2, ID1, _).
divorced(ID1, ID2) :- divorce(ID1, ID2, _).
divorced(ID1, ID2) :- divorce(ID2, ID1, _).

married_year(ID1,ID2,Y) :-
    marriage(ID1,ID2,MY), MY =< Y,
    \+ (divorce(ID1,ID2,DY), DY =< Y).

married_year(ID1,ID2,Y) :-
    marriage(ID2,ID1,MY), MY =< Y,
    \+ (divorce(ID2,ID1,DY), DY =< Y).

% Правило 5-6: все женщины/мужчины
male(Person)   :- person(Person, _, _, male).
female(Person) :- person(Person, _, _, female).


% Правило 7-22: семейные отношения

father(Parent, Child) :- parent(Parent, Child), person(Parent, _, _, male).
mother(Parent, Child) :- parent(Parent, Child), person(Parent, _, _, female).
son(Child, Parent) :- parent(Parent, Child), person(Child, _, _, male).
daughter(Child, Parent) :- parent(Parent, Child), person(Child, _, _, female).

grandparent(GP, GC) :- parent(GP, P), parent(P, GC).
grandparent_alive(GP, GC, Y) :- grandparent(GP, GC), alive(GP, Y).
grandfather(GF, GC) :- grandparent(GF, GC), person(GF, _, _, male).
grandmother(GM, GC) :- grandparent(GM, GC), person(GM, _, _, female).
grandchild(GC,GP)   :- grandparent(GP, GC).

sibling(S1, S2) :-
    setof((S1, S2), P^(
        parent(P, S1), 
        parent(P, S2), 
        S1 \= S2
    ), SibPairs),
    member((S1, S2), SibPairs).
sibling_alive(S1, S2, Y) :- sibling(S1, S2), alive(S1, Y), alive(S2, Y).
brother(S, P) :- sibling(S, P), person(S, _, _, male).
sister(S, P) :- sibling(S, P), person(S, _, _, female).

uncle(Uncle, Person) :- brother(Uncle, Parent), parent(Parent, Person).
uncle_alive(Uncle, Person, Y) :- uncle(Uncle, Person), alive(Uncle, Y).
aunt(Aunt, Person) :- sister(Aunt, Parent), parent(Parent, Person).
aunt_alive(Aunt, Person, Y) :- aunt(Aunt, Person), alive(Aunt, Y).
cousin(C1, C2) :-
    setof((C1, C2), P1^P2^(
        parent(P1, C1), 
        parent(P2, C2), 
        sibling(P1, P2), 
        C1 \= C2
    ), CousinPairs),
    member((C1, C2), CousinPairs).
cousin_alive(C1, C2, Y) :- cousin(C1, C2), alive(C1, Y), alive(C2, Y).

nephew(Nephew, Person) :- son(Nephew, Sibling), sibling(Sibling, Person).
niece(Niece, Person) :- daughter(Niece, Sibling), sibling(Sibling, Person).

% Правило 23-24: кто старше/младше?
older(P1, P2) :- birth(P1, Y1), birth(P2, Y2), Y1 < Y2.
younger(P1, P2) :- birth(P1, Y1), birth(P2, Y2), Y1 > Y2.

% Правило 25: найти самого молодого человека
youngest_person(ID) :-
    findall(BirthYear, birth(_, BirthYear), Years),
    max_list(Years, MaxYear),
    birth(ID, MaxYear).

% Правило 26-30: совершеннолетие/старше какого-то возраста?
age(ID,Y,Age) :- birth(ID,BY), death(ID,DY), Y =< DY, Age is Y - BY, Age >= 0.
adult(X,Y)   :- age(X,Y,A), A >= 18.
minor(X,Y)   :- age(X,Y,A), A <  18.

% Жизненный статус на год Y: alive/dead
alive_status(ID, Y, dead) :- death(ID, DY), DY =< Y.
alive_status(ID, Y, alive) :- death(ID, DY), DY > Y.
status(ID,Y,S) :- alive_status(ID,Y,S).
