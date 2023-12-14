#!/bash/bin 

#lab 1630
chmod 777 lab0
rm -r lab0

mkdir lab0
cd lab0
mkdir chandelure4
cd chandelure4
mkdir numel
mkdir sunkern
mkdir ducklett
mkdir walrein
cd ..
mkdir parasect1
cd parasect1
mkdir machop
mkdir ledian
mkdir cacnea
cd ..
mkdir tranquill3
cd tranquill3
mkdir ledian
mkdir larvesta
cd ..
cd chandelure4
echo "satk=6 sdef=7 spd=5" > marshtomp
echo -e "Живет Forest Grassland\nRainforest" > bulbasaur
cd ../parasect1
echo -e "Возможности Overland=6 Surface=6 Underwater=6\nBurrow6=0 Jump=1 Power=2 Intelligence=3 Fountain=0\nGilled=0" > marshtomp
echo -e "Возможности Sky=9 Power=2 Intelligence=3\nInvisibility=0 Phasing=0" > haunter
echo -e "Способности Hypnosis Imprison\nConfuse Ray Psywave Iron Defense Faint Attack Safeguard Future Sight\nMetal Sound Block Gyro Ball Extrasensory Payback Heal Block Heavy\nSlam" > bronzong
cd ..
echo -e "Возможности Overland=8 Surface=6 Jump=3 Power=2\nIntelligence=4 Tracker=0" > purugly2
echo -e "Возможности Overland=8 Surface=2\nSky=8 Jump=5 Power3=0 Intelligence=4" > scyther9
cd tranquill3
echo -e "Тип покемона WATER\nNONE" > golduck
echo -e "Возможности Overland=7 Surface=4 Jump=2 Poweor=1\nIntelligence=4 Sprouter=0" > sunflora
echo -e "Живет Cave Mountain\nTaiga" > teddiursa
cd ..
echo -e "Способности Foresight Tackle Quick Attack Double Team\nSonicboom Detect Supersonic Uproar Pursuit Ancientpower Hypnosis Wing\nAttack Screech U-Turn Air Slash Bug Buzz" > yanma9
chmod u-r,g+w,g-r chandelure4
cd chandelure4
chmod o-r,o+w numel
chmod u-r,g+w,g-r,o-r,o+w sunkern
chmod u-wx,g-x,o-rx marshtomp
chmod 440 bulbasaur
chmod o-r,o+w ducklett
chmod 317 walrein
cd ..
chmod 555 parasect1
cd parasect1
chmod u-rwx,g-x,g+w,o-rx marshtomp
chmod u-r,g+w machop
chmod u-w,g+w,o-r,o+w ledian
chmod 640 haunter
chmod 066 bronzong
chmod g+w,g-x,o-x cacnea
cd ..
chmod u-wx,g-rx,o-rx purugly2
chmod u-rwx,g-x,o-x scyther9
chmod u-w,g+w,o-r,o+w tranquill3
cd tranquill3
chmod u-wx,g-x,o-rx golduck
chmod 770 ledian
chmod g-r,g+w,o+w larvesta
chmod u-x,g-rx,o-x sunflora
chmod u-wx,g-x,o-x teddiursa
cd ..
chmod 640 yanma9
cd parasect1
cd ..
cat purugly2 > parasect1/haunterpurugly
ln yanma9 parasect1/bronzongyanma
ln -s purugly2 parasect1/marshtomppurugly
ln -s parasect1 Copy_5
cat parasect1/bronzong parasect1/bronzong > purugly2_75
cp purugly2 parasect1/cacnea
cp -r parasect1 tranquill3/ledian

//Подсчитать количество строк содержимого файлов: haunter, bronzong, результат записать в файл в директории /tmp, добавить вывод ошибок доступа в стандартный поток вывода
wc -l parasect1/haunter parasect1/bronzong > /tmp/tmp1 2>&1 ; echo -e "\n"
//Вывести два последних элемента рекурсивного списка имен и атрибутов файлов в директории lab0, содержащих строку "di", список отсортировать по возрастанию даты модификации файла, ошибки доступа не подавлять и не перенаправлять
ls -Rt |grep -v "/"| grep -Ev "^(total|$)" | grep "di" | head -n2 ; echo -e "\n"
//Вывести содержимое файлов: marshtomp, bulbasaur, marshtomp, haunter, bronzong, golduck, sunflora, оставить только строки, заканчивающиеся на 't', ошибки доступа перенаправить в файл в директории /tmp
cat chandelure4/marshtomp chandelure4/bulbasaur parasect1/marshtomp parasect1/haunter parasect1/bronzong tranquill3/golduck tranquill3/sunflora 2>/tmp/tmp2| grep "t$" ; echo -e "\n"
//Вывести рекурсивно список имен файлов в директории parasect1, список отсортировать по имени a->z, подавить вывод ошибок доступа
ls -Rp1 parasect1 2>/dev/null |grep -v '/' |grep -v "^$" | sort ; echo -e "\n"
//Вывести три последних элемента рекурсивного списка имен и атрибутов файлов в директории lab0, список отсортировать по имени z->a, добавить вывод ошибок доступа в стандартный поток вывода
ls -R1 2>&1| sort -r | grep -Ev '^(total|$|try)' | head -n3 ; echo -e "\n"
Вывести три первых элемента рекурсивного списка имен и атрибутов файлов в директории lab0, начинающихся на символ 'l', список отсортировать по возрастанию количества жестких ссылок, ошибки доступа не подавлять и не перенаправлять
ls -R | grep "^l" | sort -k 2,2n | head -n3

rm yanma9
rm parasect1/marshtomp
rm Copy_5
rm parasect1/bronzongyan*
rm -rf chandelure4/walrein
rm -rf chandelure4
