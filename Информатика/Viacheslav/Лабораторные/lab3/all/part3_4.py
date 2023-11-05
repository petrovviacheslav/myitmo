# Данное задание мне любезно согласился предостваить Елисеев Константин
import re

def string(a):
    s = ''
    for i in range(len(a)):
        s += a[i] + ' '
    return s.rstrip()
def f(b, s, st):
    if st == '' or b =='':
        return ''
    else:
        pattern = rf'{b[0]}'
        for i in range(1, len(b)):
            pattern += rf'.{{{s}}}{b[i]}'
        arr = re.findall(re.compile(rf'\b{pattern}\b', re.IGNORECASE), st)
        arr2 = []
        for i in range(len(arr)):
            if all(len(re.findall(re.compile(rf'{a}', re.IGNORECASE), arr[i])) == 1 for a in b):
                arr2.append(arr[i])
        return string(arr2)

# 412939 % 5 = 4

inp = 'КоРмА КоРкА КоРчмА'
b = 'КРА'
s = 1
res = 'КоРмА'

test1 = 'ХптЛанО ХоЛоднО ХЛопОк'
b1 = 'ХЛО'
s1 = 2
r1 = 'ХптЛанО'

test2 = 'ГрапМтфыН ГаМагНит ГориМоввНт ГлопМыаыН'
b2 = 'ГМН'
s2 = 3
r2 = 'ГрапМтфыН ГлопМыаыН'

test3 = 'Собака Мяч Зонт'
b3 = ''
s3 = 1
r3 = ''

test4 = 'ЯВОр ЯфВнО ЯыВоО ЯкВвО'
b4 = 'ЯВО'
s4 = 1
r4 = 'ЯфВнО'

test5 = 'Кот КРоА РуКА'
b5 = 'КРА'
s5 = 1
r5 = ''

tests = [test1,test2,test3,test4,test5]
buk = [b1,b2,b3,b4,b5]
S = [s1,s2,s3,s4,s5]
results = [r1,r2,r3,r4,r5]

for i in range(len(tests)):
    res = f(buk[i],S[i],tests[i])
    print(f'Тест №{i + 1}')
    print('Программа выводит:', res)
    print('Программа должна выводить:', results[i])
    if res == results[i]:
        print(f'Тест №{i + 1} успешно пройден\n')
    else:
        print(f'Тест №{i + 1} провален\n')