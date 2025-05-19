import numpy as np

from utils import calc_det, coefficient_det


def lin_approximation(data):
    x = data['x']
    y = data['y']

    SX = sum([_ for _ in x])
    SXX = sum([_ ** 2 for _ in x])
    SY = sum([_ for _ in y])
    SXY = sum([x[_] * y[_] for _ in range(len(x))])

    delta = calc_det([[SXX, SX], [SX, len(x)]])
    delta1 = calc_det([[SXY, SX], [SY, len(x)]])
    delta2 = calc_det([[SXX, SXY], [SX, SY]])

    try:
        a = delta1 / delta
        b = delta2 / delta
    except ZeroDivisionError:
        return None

    return {'a': a, 'b': b, 'c': '-', 'd': '-', 'function': lambda t: a * t + b, 'str_function': "fi = a*x + b", 'title': "Линейная аппроксимация",
            'coef': coefficient_det(x, y, lambda t: a * t + b)}


def pol2_approximation(data):
    x = data['x']
    y = data['y']

    SX = sum([_ for _ in x])
    SX2 = sum([_ ** 2 for _ in x])
    SX3 = sum([_ ** 3 for _ in x])
    SX4 = sum([_ ** 4 for _ in x])
    SY = sum([_ for _ in y])
    SXY = sum([x[_] * y[_] for _ in range(len(x))])
    SX2Y = sum([x[_] * x[_] * y[_] for _ in range(len(x))])

    delta = calc_det([[len(x), SX, SX2], [SX, SX2, SX3], [SX2, SX3, SX4]])
    delta1 = calc_det([[SY, SX, SX2], [SXY, SX2, SX3], [SX2Y, SX3, SX4]])
    delta2 = calc_det([[len(x), SY, SX2], [SX, SXY, SX3], [SX2, SX2Y, SX4]])
    delta3 = calc_det([[len(x), SX, SY], [SX, SX2, SXY], [SX2, SX3, SX2Y]])

    try:
        c = delta1 / delta
        b = delta2 / delta
        a = delta3 / delta
    except ZeroDivisionError:
        return None
    return {'a': a, 'b': b, 'c': c, 'd': '-', 'function': lambda t: a * (t ** 2) + b * t + c,
            'str_function': "fi = a*x^2 + b*x + c", 'title': "Квадратичная аппроксимация",
            'coef': coefficient_det(x, y, lambda t: a * (t ** 2) + b * t + c)}


def pol3_approximation(data):
    x = data['x']
    y = data['y']

    SX = sum([_ for _ in x])
    SX2 = sum([_ ** 2 for _ in x])
    SX3 = sum([_ ** 3 for _ in x])
    SX4 = sum([_ ** 4 for _ in x])
    SX5 = sum([_ ** 5 for _ in x])
    SX6 = sum([_ ** 6 for _ in x])
    SY = sum([_ for _ in y])
    SXY = sum([x[i] * y[i] for i in range(len(x))])
    SX2Y = sum([x[i] * x[i] * y[i] for i in range(len(x))])
    SX3Y = sum([x[i] * x[i] * x[i] * y[i] for i in range(len(x))])

    x_res = np.array([[len(x), SX, SX2, SX3], [SX, SX2, SX3, SX4], [SX2, SX3, SX4, SX5], [SX3, SX4, SX5, SX6]])
    y_res = np.array([SY, SXY, SX2Y, SX3Y])
    a = np.linalg.solve(x_res, y_res)

    return {'a': a[3], 'b': a[2], 'c': a[1], 'd': a[0], 'function': lambda t: a[3] * t ** 3 + a[2] * t ** 2 + a[1] * t + a[0],
            'str_function': "fi = a*x^3 + b*x^2 + cx + d", 'title': "Трехкратичная аппроксимация",
            'coef': coefficient_det(x, y, lambda t: a[3] * t ** 3 + a[2] * t ** 2 + a[1] * t + a[0])}


def exp_approximation(data):
    x = data['x']
    y = data['y']

    lin_y = [np.log(y[i]) for i in range(len(x))]
    lin_result = lin_approximation({'x': x, 'y': lin_y})

    a = np.exp(lin_result['b'])
    b = lin_result['a']
    data['a'] = a
    data['b'] = b

    return {'a': a, 'b': b, 'c': '-', 'd': '-', 'function': lambda t: a * np.exp(b * t),
            'str_function': "fi = a*e^(b*x)", 'title': "Экспоненциальная аппроксимация",
            'coef': coefficient_det(x, y, lambda t: a * np.exp(b * t))}


def log_approximation(data):
    x = data['x']
    y = data['y']

    for elem in x:
        if elem <= 0:
            return None

    lin_x = [np.log(x[_]) for _ in range(len(x))]
    lin_result = lin_approximation({'x': lin_x, 'y': y})

    a = lin_result['a']
    b = lin_result['b']
    data['a'] = a
    data['b'] = b

    return {'a': a, 'b': b, 'c': '-', 'd': '-', 'function': lambda t: a * np.log(t) + b,
            'str_function': "fi = a*ln(x) + b", 'title': "Логарифмическая аппроксимация",
            'coef': coefficient_det(x, y, lambda t: a * np.log(t) + b)}


def pow_approximation(data):
    x = data['x']
    y = data['y']

    for i in range(len(x)):
        if x[i] <= 0 or y[i] <= 0:
            return None

    lin_x = [np.log(x[_]) for _ in range(len(x))]
    lin_y = [np.log(y[_]) for _ in range(len(x))]
    lin_result = lin_approximation({'x': lin_x, 'y': lin_y})

    a = np.exp(lin_result['b'])
    b = lin_result['a']
    data['a'] = a
    data['b'] = b

    return {'a': a, 'b': b, 'c': '-', 'd': '-', 'function': lambda t: a * t ** b,
            'str_function': "fi = a * x ** b", 'title': "Степенная аппроксимация",
            'coef': coefficient_det(x, y, lambda t: a * t ** b)}
