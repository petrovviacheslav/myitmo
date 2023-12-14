import csv
import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt

def nothing_point(num):
    return int(num[:num.find('.')])

f = open('Table.csv','r',encoding='utf-8')
tabl = f.read().split('\n')

while '' in tabl:
    tabl.pop(tabl.index(''))

tabl2 = [x.split(',') for x in tabl]

arr = [[]] * 4
column = ['Open', 'Max', 'Min', 'Close']
dates = ['13/09/18', '15/10/18', '13/11/18', '13/12/18']

k = 0
for t in tabl2:
    if k == 0:
        pass
    elif t[2] == dates[0]:
        a = [nothing_point(t[4]), nothing_point(t[5]), nothing_point(t[6]), nothing_point(t[7])]
        arr[0].append(a)
    elif t[2] == dates[1]:
        a = [nothing_point(t[4]), nothing_point(t[5]), nothing_point(t[6]), nothing_point(t[7])]
        arr[1].append(a)
    elif t[2] == dates[2]:
        a = [nothing_point(t[4]), nothing_point(t[5]), nothing_point(t[6]), nothing_point(t[7])]
        arr[2].append(a)
    elif t[2] == dates[3]:
        a = [nothing_point(t[4]), nothing_point(t[5]), nothing_point(t[6]), nothing_point(t[7])]
        arr[3].append(a)
    k += 1

plt.figure(figsize=(12, 6))
for i in range(4):
    data = pd.DataFrame(arr[i], columns=column)
    plt.subplot(2, 2, i+1)
    sns.boxplot(data=data, palette='husl')
    plt.title(f"Данные на {dates[i]}")
    plt.legend(column, loc='best')
plt.subplots_adjust(wspace=0.4, hspace=0.4)
plt.show()
