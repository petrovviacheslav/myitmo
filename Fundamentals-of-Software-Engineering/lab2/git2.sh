#!/bin/bash
#-Xtheirs - в пользу ветки, с которой выполняется слияние, в случае конфликта
#-Xours - в пользу ветки, из которой выполняется слияние, в случае конфликта

rm -rf .git
rm -f .gitignore
echo "--- Создан бэкап .git"

rm -rf src


# Создание репозитория
git init
echo "--- git init"

git config --local merge.tool vscode
git config --local mergetool.vscode.cmd "code --new-window --wait \$MERGED"
git config --local mergetool.prompt false

# Настройка пользователей
git config user.name "red"
git config user.email "red@example.com"
echo "--- Пользователь red создан"


git checkout -b branch1 # commits: 0-5-12-25-30

# Новый .gitignore {
echo "commits" > .gitignore
echo "git2.sh" >> .gitignore
echo "svn.sh" >> .gitignore
git add .gitignore
echo "--- Новый .gitignore создан"
# }

# Ревизия r0 (пользователь 1) {
unzip -o commits/commit0.zip -d src
git add .
git commit -m "Initial commit (r0)"
echo "--- Коммит 0 (red)"
# }

git checkout -b branch2 # commits: 1-23-24-28

# Ревизия r1 (red user) {
unzip -o commits/commit1.zip -d src
git add .
git commit -m "Revision 1 (r1)"
echo "--- Коммит 1 (red)"
# }

git checkout -b branch3 # commits: 2-6

# Ревизия r2 (blue user) {
unzip -o commits/commit2.zip -d src
git add .
git commit --author="blue <blue@example.com>" -m "Revision 2 (r2)"
echo "--- Коммит 2 (blue)"
# }

git checkout -b branch4 # commits: 3-8-9-19-21

# Ревизия r3 (red user) {
unzip -o commits/commit3.zip -d src
git add .
git commit -m "Revision 3 (r3)"
echo "--- Коммит 3 (red)"
# }


git checkout -b branch5 # commits: 4-7-17-22-27

# Ревизия r4 (blue user) {
unzip -o commits/commit4.zip -d src
git add .
git commit --author="blue <blue@example.com>" -m "Revision 4 (r4)"
echo "--- Коммит 4 (blue)"
# }

git checkout branch1 # commits: 0-5-12-25-30

# Ревизия r5 (red user) {
unzip -o commits/commit5.zip -d src
git add .
git commit -m "Revision 5 (r5)"
echo "--- Коммит 5 (red)"
# }


git checkout branch3 # commits: 2-6

# Ревизия r6 (blue user) {
unzip -o commits/commit6.zip -d src
git add .
git commit --author="blue <blue@example.com>" -m "Revision 6 (r6)"
echo "--- Коммит 6 (blue)"
# }

git checkout branch5 # commits: 4-7-17-22-27

git merge --no-commit branch3
git mergetool --tool=vscode
##
## ИСПРАВЛЕНИЕ КОНФЛИКТА ВРУЧНУЮ
##
git add .
echo "--- Слияние r4 и r6"

# Ревизия r7 (blue user) {
unzip -o commits/commit7.zip -d src
git add .
git commit --author="blue <blue@example.com>" -m "Revision 7 (r7)"
echo "--- Коммит 7 (blue)"
# }

git checkout branch4 # commits: 3-8-9-19-21

# Ревизии r8-9 (red user) {
unzip -o commits/commit8.zip -d src
git add .
git commit -m "Revision 8 (r8)"
echo "--- Коммит 8 (red)"

unzip -o commits/commit9.zip -d src
git add .
git commit -m "Revision 9 (r9)"
echo "--- Коммит 9 (red)"
# }

git checkout -b branch6 # commits: 10-13-16-29

# Ревизия r10 (blue user) {
unzip -o commits/commit10.zip -d src
git add .
git commit --author="blue <blue@example.com>" -m "Revision 10 (r10)"
echo "--- Коммит 10 (blue)"
# }

git checkout -b branch7 # commits: 11-20

# Ревизия r11 (blue user) {
unzip -o commits/commit11.zip -d src
git add .
git commit --author="blue <blue@example.com>" -m "Revision 11 (r11)"
echo "--- Коммит 11 (blue)"
# }

git checkout branch1 # commits: 0-5-12-25-30

# Ревизия r12 (red user) {
unzip -o commits/commit12.zip -d src
git add .
git commit -m "Revision 12 (r12)"
echo "--- Коммит 12 (red)"
# }


git checkout branch6 # commits: 10-13-16-29

# Ревизия r13 (blue user) {
unzip -o commits/commit13.zip -d src
git add .
git commit --author="blue <blue@example.com>" -m "Revision 13 (r13)"
echo "--- Коммит 13 (blue)"
# }

git checkout -b branch8 # commits: 14-15-18-26

# Ревизии r14-15 (red user) {
unzip -o commits/commit14.zip -d src
git add .
git commit -m "Revision 14 (r14)"
echo "--- Коммит 14 (red)"

unzip -o commits/commit15.zip -d src
git add .
git commit -m "Revision 15 (r15)"
echo "--- Коммит 15 (red)"
# }

git checkout branch6 # commits: 10-13-16-29

# Ревизия r16 (blue user) {
unzip -o commits/commit16.zip -d src
git add .
git commit --author="blue <blue@example.com>" -m "Revision 16 (r16)"
echo "--- Коммит 16 (blue)"
# }

git checkout branch5 # commits: 4-7-17-22-27

# Ревизия r17 (blue user) {
unzip -o commits/commit17.zip -d src
git add .
git commit --author="blue <blue@example.com>" -m "Revision 17 (r17)"
echo "--- Коммит 17 (blue)"
# }

git checkout branch8 # commits: 14-15-18-26

# Ревизия r18 (red user) {
unzip -o commits/commit18.zip -d src
git add .
git commit -m "Revision 18 (r18)"
echo "--- Коммит 18 (red)"
# }

git checkout branch4 # commits: 3-8-9-19-21

# Ревизия r19 (red user) {
unzip -o commits/commit19.zip -d src
git add .
git commit -m "Revision 19 (r19)"
echo "--- Коммит 19 (red)"
# }


git checkout branch7 # commits: 11-20

# Ревизия r20 (blue user) {
unzip -o commits/commit20.zip -d src
git add .
git commit --author="blue <blue@example.com>" -m "Revision 20 (r20)"
echo "--- Коммит 20 (blue)"
# }

git checkout branch4 # commits: 3-8-9-19-21

git merge --no-commit branch7
git mergetool --tool=vscode
##
## ИСПРАВЛЕНИЕ КОНФЛИКТА ВРУЧНУЮ ТУТ КОНФЛИКТ!!!!!!!!!!!!!!!
##
git add .
echo "--- Слияние r19 и r20"

# Ревизия r21 (red user) {
unzip -o commits/commit21.zip -d src
git add .
git commit -m "Revision 21 (r21)"
echo "--- Коммит 21 (red)"
# }

git checkout branch5 # commits: 4-7-17-22-27

git merge --no-commit branch4
git mergetool --tool=vscode
##
## ИСПРАВЛЕНИЕ КОНФЛИКТА ВРУЧНУЮ ТУТ КОНФЛИКТ!!!!!!!!!!!!!!!
##
git add .
echo "--- Слияние r17 и r21"

# Ревизия r22 (blue user) {
unzip -o commits/commit22.zip -d src
git add .
git commit --author="blue <blue@example.com>" -m "Revision 22 (r22)"
echo "--- Коммит 22 (blue)"
# }

git checkout branch2 # commits: 1-23-24-28

# Ревизии r23-24 (red user) {
unzip -o commits/commit23.zip -d src
git add .
git commit -m "Revision 23 (r23)"
echo "--- Коммит 23 (red)"

unzip -o commits/commit24.zip -d src
git add .
git commit -m "Revision 24 (r24)"
echo "--- Коммит 24 (red)"
# }

git checkout branch1 # commits: 0-5-12-25-30

# Ревизия r25 (red user) {
unzip -o commits/commit25.zip -d src
git add .
git commit -m "Revision 25 (r25)"
echo "--- Коммит 25 (red)"
# }

git checkout branch8 # commits: 14-15-18-26

# Ревизия r26 (red user) {
unzip -o commits/commit26.zip -d src
git add .
git commit -m "Revision 26 (r26)"
echo "--- Коммит 26 (red)"
# }

git checkout branch5 # commits: 4-7-17-22-27

git merge --no-commit branch8
git mergetool --tool=vscode
##
## ИСПРАВЛЕНИЕ КОНФЛИКТА ВРУЧНУЮ ТУТ КОНФЛИКТ!!!!!!!!!!!!!!!
##
git add .
echo "--- Слияние r22 и r26"

# Ревизия r27 (blue user) {
unzip -o commits/commit27.zip -d src
git add .
git commit --author="blue <blue@example.com>" -m "Revision 27 (r27)"
echo "--- Коммит 27 (blue)"
# }

git checkout branch2 # commits: 1-23-24-28

git merge --no-commit branch5
git mergetool --tool=vscode
##
## ИСПРАВЛЕНИЕ КОНФЛИКТА ВРУЧНУЮ ТУТ КОНФЛИКТ!!!!!!!!!!!!!!!
##
git add .
echo "--- Слияние r24 и r27"

# Ревизия r28 (red user) {
unzip -o commits/commit28.zip -d src
git add .
git commit -m "Revision 28 (r28)"
echo "--- Коммит 28 (red)"
# }

git checkout branch6 # commits: 10-13-16-29

git merge --no-commit branch2
git mergetool --tool=vscode
##
## ИСПРАВЛЕНИЕ КОНФЛИКТА ВРУЧНУЮ ТУТ КОНФЛИКТ!!!!!!!!!!!!!!!
##
git add .
echo "--- Слияние r16 и r28"

# Ревизия r29 (blue user) {
unzip -o commits/commit29.zip -d src
git add .
git commit --author="blue <blue@example.com>" -m "Revision 29 (r29)"
echo "--- Коммит 29 (blue)"
# }

git checkout branch1 # commits: 0-5-12-25-30

git merge --no-commit branch6
git mergetool --tool=vscode
##
## ИСПРАВЛЕНИЕ КОНФЛИКТА ВРУЧНУЮ ТУТ КОНФЛИКТ!!!!!!!!!!!!!!!
##
git add .
echo "--- Слияние r25 и r29"

# Ревизия r30 (red user) {
unzip -o commits/commit30.zip -d src
git add .
git commit -m "Revision 30 (r30)"
echo "--- Коммит 30 (red)"
# }


# Вывод графа
git log --graph --abbrev-commit --decorate --format=format:'%C(bold blue)%h%C(reset) - %C(bold green)(%ar)%C(reset) %C(white)%s%C(reset) %C(dim white)- %an%C(reset)%C(auto)%d%C(reset)' --all
