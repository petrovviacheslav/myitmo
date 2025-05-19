import math


def calc_minor(matrix, i, j):
    n = len(matrix)
    return [[matrix[row][col] for col in range(n) if col != j] for row in range(n) if row != i]


def calc_det(matrix):
    n = len(matrix)
    if n == 1:
        return matrix[0][0]

    det = 0
    sgn = 1
    for j in range(n):
        det += sgn * matrix[0][j] * calc_det(calc_minor(matrix, 0, j))
        sgn *= -1
    return det


def coefficient_det(x, y, func):
    phi = sum([_ for _ in x]) / len(x)
    return 1 - (sum([(y[i] - func(x[i])) ** 2 for i in range(len(x))]) / sum([(p - phi) ** 2 for p in y]))


def calc_deviation(data, function):
    return sum([(function(data['x'][i]) - data['y'][i]) ** 2 for i in range(len(data['x']))])


def calc_smd(data, function):
    return math.sqrt(calc_deviation(data, function) / len(data['x']))


def coef_pirson(data):
    x = data['x']
    y = data['y']
    x_sr = sum([_ for _ in x]) / len(x)
    y_sr = sum([_ for _ in y]) / len(y)
    sum_chisl = 0
    sum_left_zn = 0
    sum_right_zn = 0

    for i in range(len(x)):
        cur_x = x[i]
        cur_y = y[i]
        sum_chisl += (cur_x - x_sr)*(cur_y - y_sr)
        sum_left_zn += (cur_x - x_sr) ** 2
        sum_right_zn += (cur_y - y_sr) ** 2
    return sum_chisl / math.sqrt(sum_left_zn * sum_right_zn)
