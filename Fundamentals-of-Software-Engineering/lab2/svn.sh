#!/bin/bash

# Создание локального репозитория
svnadmin create repo
REPO_URL="file://$(pwd)/repo"


# Создаём структуру проекта
cd repo
svn mkdir -m "project structure" $REPO_URL/trunk $REPO_URL/branches
cd ..

# Создание рабочей копии
svn checkout $REPO_URL/trunk/ wc  # commits: 0-5-12-25-30
cd wc

# Ревизия r0 (red user) {
unzip -o commits/commit0.zip -d src
svn add *
svn commit -m "Initial commit (r0)" --username=red
echo "--- Коммит 0 (red)"
# }

svn copy $REPO_URL/trunk $REPO_URL/branches/branch2 -m "Creating branch2" # commits: 1-23-24-28
svn switch $REPO_URL/branches/branch2

# Ревизия r1 (red user) {
unzip -o commits/commit1.zip -d src
svn add *
svn commit -m "Revision 1 (r1)" --username=red
echo "--- Коммит 1 (red)"
# }

svn copy $REPO_URL/branches/branch2 $REPO_URL/branches/branch3 -m "Creating branch3" # commits: 2-6
svn switch $REPO_URL/branches/branch3

# Ревизия r2 (blue user) {
unzip -o commits/commit3.zip -d src
svn add *
svn commit -m "Revision 2 (r2)" --username=blue
echo "--- Коммит 2 (blue)"
# }

svn copy $REPO_URL/branches/branch3 $REPO_URL/branches/branch4 -m "Creating branch4" # commits: 3-8-9-19-21
svn switch $REPO_URL/branches/branch4

# Ревизия r3 (red user) {
unzip -o commits/commit3.zip -d src
svn add *
svn commit -m "Revision 3 (r3)" --username=red
echo "--- Коммит 3 (red)"
# }

svn copy $REPO_URL/branches/branch4 $REPO_URL/branches/branch5 -m "Creating branch5" # commits: 4-7-17-22-27
svn switch $REPO_URL/branches/branch5

# Ревизия r4 (blue user) {
unzip -o commits/commit4.zip -d src
svn add *
svn commit -m "Revision 4 (r4)" --username=blue
echo "--- Коммит 4 (blue)"
# }

svn switch $REPO_URL/trunk # commits: 0-5-12-25-30

# Ревизия r5 (red user) {
unzip -o commits/commit5.zip -d src
svn add *
svn commit -m "Revision 5 (r5)" --username=red
echo "--- Коммит 5 (red)"
# }

svn switch $REPO_URL/branches/branch3 # commits: 2-6

# Ревизия r6 (blue user) {
unzip -o commits/commit6.zip -d src
svn add *
svn commit -m "Revision 6 (r6)" --username=blue
echo "--- Коммит 6 (blue)"
# }

svn update

svn switch $REPO_URL/branches/branch5 # commits: 4-7-17-22-27

svn merge $REPO_URL/branches/branch3
##
## ИСПРАВЛЕНИЕ КОНФЛИКТА ВРУЧНУЮ
##
svn add *
echo "--- Слияние r4 и r6"

# Ревизия r7 (blue user) {
unzip -o commits/commit7.zip -d src
svn add *
svn commit -m "Revision 7 (r7)" --username=blue
echo "--- Коммит 7 (blue)"
# }

svn switch $REPO_URL/branches/branch4 # commits: 3-8-9-19-21

# Ревизии r8-9 (red user) {
unzip -o commits/commit8.zip -d src
svn add *
svn commit -m "Revision 8 (r8)" --username=red
echo "--- Коммит 8 (red)"

unzip -o commits/commit9.zip -d src
svn add *
svn commit -m "Revision 9 (r9)" --username=red
echo "--- Коммит 9 (red)"
# }

svn copy $REPO_URL/branches/branch4 $REPO_URL/branches/branch6 -m "Creating branch6" # commits: 10-13-16-29
svn switch $REPO_URL/branches/branch6

# Ревизия r10 (blue user) {
unzip -o commits/commit10.zip -d src
svn add *
svn commit -m "Revision 10 (r10)" --username=blue
echo "--- Коммит 10 (blue)"
# }

svn copy $REPO_URL/branches/branch6 $REPO_URL/branches/branch7 -m "Creating branch7" # commits: 11-20
svn switch $REPO_URL/branches/branch7

# Ревизия r11 (blue user) {
unzip -o commits/commit11.zip -d src
svn add *
svn commit -m "Revision 11 (r11)" --username=blue
echo "--- Коммит 11 (blue)"
# }

svn switch $REPO_URL/trunk # commits: 0-5-12-25-30

# Ревизия r12 (red user) {
unzip -o commits/commit12.zip -d src
svn add *
svn commit -m "Revision 12 (r12)" --username=red
echo "--- Коммит 12 (red)"
# }

svn switch $REPO_URL/branches/branch6 # commits: 10-13-16-29

# Ревизия r13 (blue user) {
unzip -o commits/commit13.zip -d src
svn add *
svn commit -m "Revision 13 (r13)" --username=blue
echo "--- Коммит 13 (blue)"
# }

svn copy $REPO_URL/branches/branch6 $REPO_URL/branches/branch8 -m "Creating branch8" # commits: 14-15-18-26
svn switch $REPO_URL/branches/branch8

# Ревизии r14-15 (red user) {
unzip -o commits/commit14.zip -d src
svn add *
svn commit -m "Revision 14 (r14)" --username=red
echo "--- Коммит 14 (red)"

unzip -o commits/commit15.zip -d src
svn add *
svn commit -m "Revision 15 (r15)" --username=red
echo "--- Коммит 15 (red)"
# }

svn switch $REPO_URL/branches/branch6 # commits: 10-13-16-29

# Ревизия r16 (blue user) {
unzip -o commits/commit16.zip -d src
svn add *
svn commit -m "Revision 16 (r16)" --username=blue
echo "--- Коммит 16 (blue)"
# }

svn switch $REPO_URL/branches/branch5 # commits: 4-7-17-22-27

# Ревизия r17 (blue user) {
unzip -o commits/commit17.zip -d src
svn add *
svn commit -m "Revision 17 (r17)" --username=blue
echo "--- Коммит 17 (blue)"
# }

svn switch $REPO_URL/branches/branch8 # commits: 14-15-18-26

# Ревизия r18 (red user) {
unzip -o commits/commit18.zip -d src
svn add *
svn commit -m "Revision 18 (r18)" --username=red
echo "--- Коммит 18 (red)"
# }

svn switch $REPO_URL/branches/branch4 # commits: 3-8-9-19-21

# Ревизия r19 (red user) {
unzip -o commits/commit19.zip -d src
svn add *
svn commit -m "Revision 19 (r19)" --username=red
echo "--- Коммит 19 (red)"
# }

svn switch $REPO_URL/branches/branch7 # commits: 11-20

# Ревизия r20 (blue user) {
unzip -o commits/commit20.zip -d src
svn add *
svn commit -m "Revision 20 (r20)" --username=blue
echo "--- Коммит 20 (blue)"
# }

svn update

svn switch $REPO_URL/branches/branch4 # commits: 3-8-9-19-21

svn merge $REPO_URL/branches/branch7
##
## ИСПРАВЛЕНИЕ КОНФЛИКТА ВРУЧНУЮ
##
svn add *
echo "--- Слияние r19 и r20"

# Ревизия r21 (red user) {
unzip -o commits/commit21.zip -d src
svn add *
svn commit -m "Revision 21 (r21)" --username=red
echo "--- Коммит 21 (red)"
# }

svn update

svn switch $REPO_URL/branches/branch5 # commits: 4-7-17-22-27

svn merge $REPO_URL/branches/branch4
##
## ИСПРАВЛЕНИЕ КОНФЛИКТА ВРУЧНУЮ
##
svn add *
echo "--- Слияние r17 и r21"

# Ревизия r22 (blue user) {
unzip -o commits/commit22.zip -d src
svn add *
svn commit -m "Revision 22 (r22)" --username=blue
echo "--- Коммит 22 (blue)"
# }

svn switch $REPO_URL/branches/branch2 # commits: 1-23-24-28

# Ревизии r23-24 (red user) {
unzip -o commits/commit23.zip -d src
svn add *
svn commit -m "Revision 23 (r23)" --username=red
echo "--- Коммит 23 (red)"

unzip -o commits/commit24.zip -d src
svn add *
svn commit -m "Revision 24 (r24)" --username=red
echo "--- Коммит 24 (red)"
# }

svn switch $REPO_URL/trunk # commits: 0-5-12-25-30

# Ревизия r25 (red user) {
unzip -o commits/commit25.zip -d srcgit checkout -b branch1 # commits: 0-5-12-25-30
svn add *
svn commit -m "Revision 25 (r25)" --username=red
echo "--- Коммит 25 (red)"
# }

svn switch $REPO_URL/branches/branch8 # commits: 14-15-18-26

# Ревизия r26 (red user) {
unzip -o commits/commit26.zip -d src
svn add *
svn commit -m "Revision 26 (r26)" --username=red
echo "--- Коммит 26 (red)"
# }

svn update

svn switch $REPO_URL/branches/branch5 # commits: 4-7-17-22-27

svn merge $REPO_URL/branches/branch8
##
## ИСПРАВЛЕНИЕ КОНФЛИКТА ВРУЧНУЮ
##
svn add *
echo "--- Слияние r22 и r26"

# Ревизия r27 (blue user) {
unzip -o commits/commit27.zip -d src
svn add *
svn commit -m "Revision 27 (r27)" --username=blue
echo "--- Коммит 27 (blue)"
# }

svn update

svn switch $REPO_URL/branches/branch2 # commits: 1-23-24-28

svn merge $REPO_URL/branches/branch5
##
## ИСПРАВЛЕНИЕ КОНФЛИКТА ВРУЧНУЮ
##
svn add *
echo "--- Слияние r24 и r27"

# Ревизия r28 (red user) {
unzip -o commits/commit28.zip -d src
svn add *
svn commit -m "Revision 28 (r28)" --username=red
echo "--- Коммит 28 (red)"
# }

svn update

svn switch $REPO_URL/branches/branch6 # commits: 10-13-16-29

svn merge $REPO_URL/branches/branch2
##
## ИСПРАВЛЕНИЕ КОНФЛИКТА ВРУЧНУЮ
##
svn add *
echo "--- Слияние r16 и r28"

# Ревизия r29 (blue user) {
unzip -o commits/commit29.zip -d src
svn add *
svn commit -m "Revision 29 (r29)" --username=blue
echo "--- Коммит 29 (blue)"
# }

svn update

svn switch $REPO_URL/trunk # commits: 0-5-12-25-30

svn merge $REPO_URL/branches/branch6
##
## ИСПРАВЛЕНИЕ КОНФЛИКТА ВРУЧНУЮ
##
svn add *
echo "--- Слияние r25 и r29"

# Ревизия r30 (red user) {
unzip -o commits/commit30.zip -d src
svn add *
svn commit -m "Revision 30 (r30)" --username=red
echo "--- Коммит 30 (red)"
# }

svn update

