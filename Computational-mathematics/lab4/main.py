from approximations import lin_approximation, pol2_approximation, exp_approximation, log_approximation, \
    pow_approximation, pol3_approximation
from prettytable import PrettyTable

from utils import calc_deviation, calc_smd, coef_pirson
import matplotlib.pyplot as plt
import numpy as np


def get_file(file_name):
    with open(file_name, 'r') as file:
        lines = [line.split() for line in file.readlines()]
    return {'x': [float(elem[0]) for elem in lines], 'y': [float(elem[1]) for elem in lines]}


def get_keyboard():
    n = 8
    data = {'x': [], 'y': []}
    while True:
        try:
            n = int(input("Количество точек (от 8 до 12): "))
            if 8 <= n <= 12:
                break
        except ValueError:
            continue

    point = []
    for i in range(n):
        while True:
            try:
                point = list(map(float, input(f"Введите координаты точки {i + 1}: ").split()))
                if point[0] in data['x']:
                    print('Точка с такой координатой x уже есть!')
                    raise ValueError
                break
            except ValueError:
                continue
        data['x'].append(point[0])
        data['y'].append(point[1])
    return data


def print_apprs_in_table(approximations_data, data):
    table = PrettyTable()
    table.field_names = ['title', 'a', 'b', 'c', 'd', 'str_function', 'coef', 'deviation', 'smd']
    for row in approximations_data:
        if row is not None:
            new_row = []
            for i in range(len(table.field_names)):
                new_row.append(row[table.field_names[i]])
            table.add_row(new_row)
    print(table)
    print()

    table = PrettyTable()
    table.field_names = ['x', 'y', 'Линейная', 'Квадратичная', 'Трёхкратичная', 'Экспоненциальная', 'Логарифмическая',
                         'Степенная']
    for i in range(len(data['x'])):
        new_row = [data['x'][i], data['y'][i]]
        for j in range(len(approximations_data)):
            if approximations_data[j] is None:
                new_row.append('-')
            else:
                new_row.append(approximations_data[j]['function'](data['x'][i]))
        table.add_row(new_row)
    print(table)


def paint(data, apps_data):
    x = data['x']
    y = data['y']

    base_x = np.linspace(min(x), max(x), 50)
    plt.plot(x, y, 'o', color='blue', markersize=5)

    colors = ['red', 'green', 'black', 'orange', 'purple', 'grey']
    for i in range(len(apps_data)):
        if apps_data[i] is not None:
            plt.plot(base_x, apps_data[i]['function'](base_x), '-', color=colors[i], label=apps_data[i]['title'])
    plt.legend()
    plt.title('График')
    plt.xlabel('X')
    plt.ylabel('Y')
    plt.grid(True)
    plt.show()


def main():
    file_or_keyboard = ""
    while file_or_keyboard != "f" and file_or_keyboard != "k":
        file_or_keyboard = input(
            "Как вы хотите ввести функцию? Введите f, если из файла, k - с клавиатуры: ")

    if file_or_keyboard == "f":
        file_name = input("Имя файла: ")
        data = get_file(file_name)
    else:
        data = get_keyboard()


    approximations_data = [lin_approximation(data), pol2_approximation(data), pol3_approximation(data),
                           exp_approximation(data), log_approximation(data), pow_approximation(data)]

    print("Коэффициент корреляции Пирсона: ")
    print(coef_pirson(data))
    answer = ''
    answer_res = 0
    for cur_data in approximations_data:
        if cur_data is None:
            continue
        cur_data['deviation'] = calc_deviation(data, cur_data['function'])
        if answer_res < cur_data['coef']:
            answer_res = cur_data['coef']
            answer = cur_data['title']
        cur_data['smd'] = calc_smd(data, cur_data['function'])

    print_apprs_in_table(approximations_data, data)
    print("Лучшая аппроксимация - " + answer)
    paint(data, approximations_data)


if __name__ == '__main__':
    main()
