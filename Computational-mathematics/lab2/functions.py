import numpy as np
import matplotlib.pyplot as plt


class TwoVarFunction:
    def __init__(self, func1, func2, string_func1, string_func2):
        self.func1 = func1
        self.func2 = func2
        self.string_func1 = string_func1
        self.string_func2 = string_func2

    # x = ....
    def func1_calc(self, y):
        return self.func1(y)

    # y = ....
    def func2_calc(self, x):
        return self.func2(x)

    def paint(self, x, y, add_x, add_y):
        dif = max(5, abs(add_x - x) + 2, abs(add_y - y) + 2)
        x1 = np.linspace(x - dif, x + dif, 100)
        y1 = []
        for element in x1:
            y1.append(self.func2_calc(element))
        plt.plot(x1, y1)

        y2 = np.linspace(y - dif, y + dif, 100)
        x2 = []
        for element in y2:
            x2.append(self.func1_calc(element))
        plt.plot(x2, y2)

        plt.scatter(add_x, add_y, marker='o', color='red', s=30)
        plt.annotate(f"({add_x}, {add_y})",  # Текст подписи
                     xy=(add_x, add_y),  # Координаты точки
                     xytext=(add_x + 0.3, add_y + 0.3))

        plt.xlabel("x")
        plt.ylabel("y")
        plt.title(f'Система {self.string_func1} and {self.string_func2}')
        plt.grid(True)
        plt.show()


class OneVarFunction:
    def __init__(self, function, string_function):
        self.function = function
        self.string_function = string_function

    # y = ....
    def func_calc(self, x):
        return self.function(x)

    def paint(self, a, b):
        x = np.linspace(a - 5, b + 5, 60)
        y = []
        for element in x:
            y.append(self.func_calc(element))
        plt.plot(x, y)

        plt.xlabel("x")
        plt.ylabel("y")
        plt.title(f'График функции y = {self.string_function}')
        plt.grid(True)
        plt.show()

    def paint2(self, a, b, add_x, add_y):
        dif = max(5, abs(add_x - a) + 2, abs(add_x - a) + 2)
        x = np.linspace(a - dif, b + dif, 60)
        y = []
        for element in x:
            y.append(self.func_calc(element))
        plt.plot(x, y)

        plt.scatter(add_x, add_y, marker='o', color='red', s=30)
        plt.annotate(f"({add_x}, {add_y})",  # Текст подписи
                     xy=(add_x, add_y),  # Координаты точки
                     xytext=(add_x + 0.3, add_y + 0.3))

        plt.xlabel("x")
        plt.ylabel("y")
        plt.title(f'График функции y = {self.string_function}')
        plt.grid(True)
        plt.show()


def derivative(function, count, x, h=0.00001):
    if count == 1:
        return (function(x + h) - function(x)) / h
    return (derivative(function, count - 1, x + h) - derivative(function, count - 1, x)) / h
