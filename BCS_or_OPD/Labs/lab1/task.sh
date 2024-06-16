
mkdir lab0
cd lab0


# Step 1

touch bulbasaur4
echo "weight=15.2 height=28.0 atk=5 def=5" > bulbasaur4

mkdir gastly0
cd gastly0

mkdir rhyperior
mkdir cleffa
touch alakazam
echo -e "satk=14\nsdef=9 spd=12" > alakazam
mkdir sceptile
mkdir galvantula
touch chandelure
echo -e "Способности This is dummy text when pokemon\ndoes not contain something. It is better then NPE!" > alakazam

cd ..

mkdir lileep9
cd lileep9

touch azumarill
echo -e "Тип\nдиеты Herbivore" > azumarill
touch bidoof
echo "Развитые способности Moody" > bidoof
touch combee
echo -e "Развитые\nспособности Hustle" > combee
touch beldum
echo -e "Ходы Iron Defense Iron Head Zen\nHeadbutt" > beldum

cd ..

mkdir rapidash3
cd rapidash3

mkdir totodile
mkdir diglett
touch banette
echo "Тип диеты Nullivore" > banette

cd ..

touch silcoon3
echo -e "Развитые способности\nBattle Armor" > silcoon3
touch vigoroth1
echo -e "Тип покемона NORMAL NONE" > vigoroth1



# Step 2

chmod 404 bulbasaur4
chmod 524 gastly0

cd gastly0
chmod 312 rhyperior
chmod 307 cleffa
chmod 604 alakazam
chmod 361 sceptile
chmod 537 galvantula
chmod 660 chandelure
cd ..

chmod 753 lileep9

cd lileep9
chmod 046 azumarill
chmod 620 bidoof
chmod 440 combee
chmod 600 beldum
cd ..

chmod 777 rapidash3

cd rapidash3
chmod 550 totodile
chmod 305 diglett
chmod 062 banette
cd ..

chmod 444 silcoon3
chmod 640 vigoroth1



# Step 3


# hard link
ln bulbasaur4 lileep9/beldumbulbasaur
chmod u+r lileep9/azumarill
cp -r lileep9 gastly0/rhyperior
chmod u-r lileep9/azumarill
cat lileep9/beldum gastly0/alakazam > bulbasaur4_43
ln -s vigoroth1 rapidash3/banettevigoroth 
chmod u+w gastly0
cp vigoroth1 gastly0/chandelurevigoroth

chmod u+w gastly0/galvantula
cp vigoroth1 gastly0/galvantula
chmod u-w gastly0/galvantula
chmod u-w gastly0
# soft link
ln -s rapidash3 Copy_45


# Step 4

echo '---- 4.1 ---- (Подсчитать количество строк содержимого файлов: alakazam, chandelure, azumarill, bidoof, combee, beldum, результат записать в файл в директории /tmp, подавить вывод ошибок доступа)'
wc -l gastly0/alakazam gastly0/chandelure lileep9/azumarill lileep9/bidoof lileep9/combee lileep9/beldum >/tmp/total 2>/dev/null
echo '---- 4.2 ---- (Вывести три первых элемента рекурсивного списка имен и атрибутов файлов в директории lab0, заканчивающихся на символ "a", список отсортировать по убыванию размера, подавить вывод ошибок доступа)'
ls -lRS 2>/dev/null | grep 'a$' | head -n3
echo '---- 4.3 ---- (Рекурсивно вывести содержимое файлов из директории lab0, имя которых заканчивается на 'a', строки отсортировать по имени a->z, добавить вывод ошибок доступа в стандартный поток вывода)'
cat $(ls -R | grep "a$") | sort
echo '---- 4.4 ---- (Подсчитать количество символов содержимого файлов: azumarill, bidoof, отсортировать вывод по уменьшению количества, ошибки доступа перенаправить в файл в директории /tmp)'
wc -m lileep9/azumarill lileep9/bidoof 2>/tmp/error | sort -r
echo '---- 4.5 ---- (Вывести два последних элемента рекурсивного списка имен и атрибутов файлов в директории lab0, список отсортировать по возрастанию количества жестких ссылок, ошибки доступа не подавлять и не перенаправлять)'
ls -l | tail -n3 | head -n2 | sort -nk2
echo '---- 4.6 ---- (Вывести рекурсивно список имен и атрибутов файлов в директории rapidash3, список отсортировать по возрастанию даты изменения записи о файле, добавить вывод ошибок доступа в стандартный поток вывода)'
ls -ltr rapidash3/ 2>&1



# Step 5

rm vigoroth1

chmod +w gastly0
rm gastly0/chandelure
rm Copy_*
rm lileep9/beldumbulbasa*
chmod +w gastly0/galvantula
chmod +r gastly0/rhyperior
# rm -rf gastly0
rm -rf rapidash3/diglett
