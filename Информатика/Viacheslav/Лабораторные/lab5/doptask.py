import csv
import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt


def convert(arg):
    return int(arg[:arg.find('.')])


with open("start.csv", encoding='utf-8') as r_file:
    file_reader = csv.reader(r_file, delimiter=",")
    arr = [[], [], [], []]
    col = ["Открытие", "Мин", "Макс", "Закрытие"]
    dates = ['05/09/18', '05/10/18', '07/11/18', '05/12/18']
    count = 0
    for row in file_reader:
        if count == 0:
            pass
            # col = [row[4], row[5], row[6], row[7]]
        elif row[2] == '05/09/18':
            arr[0].append([convert(row[4]), convert(row[5]), convert(row[6]), convert(row[7])])
        elif row[2] == '05/10/18':
            arr[1].append([convert(row[4]), convert(row[5]), convert(row[6]), convert(row[7])])
        elif row[2] == '07/11/18':
            arr[2].append([convert(row[4]), convert(row[5]), convert(row[6]), convert(row[7])])
        elif row[2] == '05/12/18':
            arr[3].append([convert(row[4]), convert(row[5]), convert(row[6]), convert(row[7])])
        count += 1

    plt.figure(figsize=(14, 7))
    for i in range(4):
        data = pd.DataFrame(arr[i], columns=col)
        plt.subplot(2, 2, i + 1)
        sns.boxplot(data=data, palette='husl')
        plt.title(f"Данные на {dates[i]}")
        plt.legend(col, loc='best')
    plt.subplots_adjust(wspace=0.4, hspace=0.4)
    plt.show()
