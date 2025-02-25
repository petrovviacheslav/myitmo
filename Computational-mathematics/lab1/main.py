import os
import random
from prettytable import PrettyTable
import numpy as np


def print_matrix_in_table(matrix, n):
    table = PrettyTable()
    table.field_names = ["k" + str(i + 1) if i < n else "b" for i in range(n + 1)]
    for row in matrix:
        table.add_row(row)
    print(table)


def get_file():
    """ Получение порядка матрицы и самой матрицы из файла по введённому пути """
    # 1 - ошибка при считывании, 2 - стартовое значение, 0 - успешно
    code_error = 2
    matrix = []
    while code_error != 0:
        if code_error != 2:
            print("Ошибка при чтении данных из файла, в строке должен быть n+1 элемент, а строк всего n (n - определитель матрицы)")
        file_path = input("Введите путь до файла: ")
        while not os.path.isfile(file_path):
            file_path = input("К сожалению, файла по этому пути не существует, введите путь снова: ")

        code_error = 0
        with open(file_path, 'r') as input_file:
            n = int(input_file.readline())
            if n <= 0:
                code_error = 1
            for string in input_file.readlines():
                line_matrix = list(map(int, string.strip().split()))
                if len(line_matrix) != n + 1:
                    code_error = 1
                    break
                matrix.append(line_matrix)
            if len(matrix) != n:
                code_error = 1

    return matrix


def get_keyboard():
    """ Получение порядка матрицы и самой матрицы с клавиатуры """
    n = int(input("Введите порядок матрицы: n = "))
    while n <= 0:
        n = int(input("Порядок матрицы должен быть > 0. Введите порядок матрицы: n = "))

    matrix = []
    for i in range(n):
        line_matrix = list(map(int, input("коэффициенты уравнения №" + str(i + 1) + ": ").strip().split()))
        while len(line_matrix) != n + 1:
            print("В строке должен быть n+1 элемент, где n - определитель матрицы. Введите строку повторно")
            line_matrix = list(map(int, input("коэффициенты уравнения №" + str(i + 1) + ": ").strip().split()))

        matrix.append(line_matrix)

    return matrix


def get_random():
    """ Создание матрицы заданной размерности со случайными значениями """
    n = int(input("Введите порядок матрицы: n = "))
    while n <= 0:
        n = int(input("Порядок матрицы должен быть > 0. Введите порядок матрицы: n = "))
    return [[random.randint(-20, 20) for _ in range(n + 1)] for _ in range(n)]


def get_determinant(matrix, n):
    """ Вычисление определителя матрицы """
    determinant = 1
    # для матриц с n > 5 невыгодно считать определитель заранее через миноры, ведь сложность n! > n^3 (преобразование матрицы)
    for i in range(n):
        determinant *= matrix[i][i]
    return determinant


def matrix_transformation(matrix, n):
    """ Преобразование начальной матрицы методом Гаусса с выбором главного элемента по столбцам """
    for col in range(n - 1):
        index_max_num = col
        for row in range(col + 1, n):
            if abs(matrix[row][col]) > abs(matrix[index_max_num][col]):
                index_max_num = row
        matrix[col], matrix[index_max_num] = matrix[index_max_num], matrix[col]

        for row in range(col + 1, n):
            multiplier = matrix[row][col] / matrix[col][col]
            for k in range(n + 1):
                matrix[row][k] -= multiplier * matrix[col][k]

    print("Полученная треугольная матрица:")
    print_matrix_in_table(matrix, n)
    return matrix


def gauss_method(matrix, n):
    new_matrix = matrix_transformation(matrix, n)
    determinant = get_determinant(matrix, n)
    if determinant == 0:
        print("Матрица является несовместной: det = 0")
        return
    else:
        print("Определитель: det = " + str(determinant))

    variables = [0] * n
    residuals = [0] * n
    for i in range(n - 1, -1, -1):
        sum_vars = 0
        for k in range(i + 1, n):
            sum_vars += new_matrix[i][k] * variables[k]
        variables[i] = (new_matrix[i][n] - sum_vars) / new_matrix[i][i]
        residuals[i] = sum_vars + new_matrix[i][i] * variables[i] - new_matrix[i][n]

    print("Полученный вектор неизвестных:")
    print(*variables)
    print("Полученный вектор невязок:")
    print(*residuals)


def start():
    print("Решение системы линейных алгебраических уравнений методом Гаусса с выбором главного элемента по столбцам")
    file_or_keyboard_or_random = ""
    while file_or_keyboard_or_random != "f" and file_or_keyboard_or_random != "k" and file_or_keyboard_or_random != "r":
        file_or_keyboard_or_random = input(
            "Как вы хотите ввести матрицу? Введите f, если из файла, k - с клавиатуры, r - создать рандомную матрицу: ")

    matrix = []
    if file_or_keyboard_or_random == "f":
        matrix = get_file()
        print("Считанная из файла матрица:")
        print_matrix_in_table(matrix, len(matrix))
    elif file_or_keyboard_or_random == "k":
        matrix = get_keyboard()
    elif file_or_keyboard_or_random == "r":
        matrix = get_random()
        print("Созданная случайная матрица:")
        print_matrix_in_table(matrix, len(matrix))
    gauss_method(matrix, len(matrix))

    print()
    matrix_k = [[matrix[row][col] for col in range(len(matrix))] for row in range(len(matrix))]
    coef_b = [matrix[row][-1] for row in range(len(matrix))]
    print("Сравним результаты с вычислениями через библиотеку numpy:")
    try:
        print("Решение системы:", *np.linalg.solve(matrix_k, coef_b))
        print("Определитель матрицы: det = ", np.linalg.det(matrix_k))
    except np.linalg.LinAlgError:
        print("det = 0")


if __name__ == '__main__':
    start()
