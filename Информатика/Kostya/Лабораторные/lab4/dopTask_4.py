import timeit

with open('main_2.0.py', 'r',encoding='utf-8') as f0:
    prog0 = f0.read()
with open('dopTask_1.py', 'r',encoding='utf-8') as f1:
    prog1 = f1.read()
with open('dopTask_2.py', 'r',encoding='utf-8') as f2:
    prog2 = f2.read()
with open('dopTask_3.py', 'r',encoding='utf-8') as f3:
    prog3 = f3.read()

time0 = timeit.timeit(prog0, number=100)
time1 = timeit.timeit(prog1, number=100)
time2 = timeit.timeit(prog2, number=100)
time3 = timeit.timeit(prog3, number=100)

times = [time1,time2,time3]

for i in range(len(times)):
    if time0 < times[i]:
        print(f'Программа из обязательного задания быстрее программы из дополнительного задания {i + 1}.')
    else:
        print(f'Программа из дополнительного задания {i + 1} быстрее программы из обязательного задания.')

print(time0,times)