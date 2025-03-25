import cliche
import half_division
import newton_method
import iteration_method
from prettytable import PrettyTable
import functions
import math
import parameters
import os


def custom_print(data, result_in_file_keyboard, output_path):
    if result_in_file_keyboard == "f":
        try:
            with open(output_path, "a") as f:
                print(data, file=f)
        except IOError:
            print("Ошибка ввода/вывода при записи в файл.")
    else:
        print(data)


def equation_logic():
    first_equation = functions.OneVarFunction(lambda var_x: 3 * var_x ** 3 + 1.7 * var_x ** 2 - 15.42 * var_x + 6.89,
                                              "3x^3 + 1.7x^2 - 15.42x + 6.89")
    second_equation = functions.OneVarFunction(lambda var_x: var_x ** 3 - 5 * var_x ** 2 + 3,
                                               "x^3 - 5x^2 + 3")
    third_equation = functions.OneVarFunction(lambda var_x: var_x ** 3 - 3.78 * var_x ** 2 + 1.25 * var_x + 3.49,
                                              "x^3 - 3.78x^2 + 1.25x + 3.49")
    equations = [first_equation, second_equation, third_equation]

    file_or_keyboard = ""
    while file_or_keyboard != "f" and file_or_keyboard != "k":
        file_or_keyboard = input(cliche.choice_msg("уравнение"))

    input_data = {'num_def': 0, 'method': 0, 'a': 0, 'b': 0, 'x_0': 0, 'epsilon': 0}
    if file_or_keyboard == "f":
        file_path = input("Введите путь до файла: ")
        while not os.path.isfile(file_path):
            file_path = input("К сожалению, файла по этому пути не существует, введите путь снова: ")

        with open(file_path, "r") as file:
            lines = file.readlines()
        try:
            input_data['num_def'] = int(lines[0].strip())
            input_data['method'] = int(lines[1].strip())

            if input_data['method'] == 1:
                input_data['a'], input_data['b'] = parameters.get_borders(False, lines[2].strip())
            else:
                input_data['x_0'] = parameters.get_start_approach(1, False, lines[2].strip())

            input_data['epsilon'] = parameters.get_epsilon(False, lines[3].strip())
        except ValueError:
            return None
    elif file_or_keyboard == "k":
        while input_data['num_def'] != 1 and input_data['num_def'] != 2 and input_data['num_def'] != 3:
            input_data['num_def'] = int(
                input(
                    f"Выберите функцию: \n 1. {equations[0].string_function} \n 2. {equations[1].string_function} \n 3. {equations[2].string_function}\n"))

        while input_data['method'] != 1 and input_data['method'] != 2 and input_data['method'] != 3:
            input_data['method'] = int(input(
                f"Выберите метод решения: \n 1. {cliche.methods_eq[0]} \n 2. {cliche.methods_eq[1]} \n 3. {cliche.methods_eq[2]}\n"))

        if input_data['method'] == 1:
            input_data['a'], input_data['b'] = parameters.get_borders(True)
        else:
            input_data['x_0'] = parameters.get_start_approach(1, True)

        input_data['epsilon'] = parameters.get_epsilon(True)

    result = None
    if input_data["method"] == 1:
        result = half_division.solve(equations[input_data["num_def"] - 1], input_data["a"],
                                     input_data["b"], input_data["epsilon"])
    elif input_data["method"] == 2:
        result = newton_method.solve(equations[input_data["num_def"] - 1], input_data["x_0"], input_data["epsilon"])
    else:
        result = iteration_method.solve(equations[input_data["num_def"] - 1],
                                        input_data["x_0"], input_data["epsilon"])

    return result, equations, input_data


def system_logic():
    file_or_keyboard = ""
    while file_or_keyboard != "f" and file_or_keyboard != "k":
        file_or_keyboard = input(cliche.choice_msg("систему"))

    first_system = functions.TwoVarFunction(lambda var_y: 3 + math.cos(var_y), lambda var_x: 0.5 - math.cos(var_x - 1),
                                            "x - cos(y) = 3", "cos(x-1) + y = 0.5")
    second_system = functions.TwoVarFunction(lambda var_y: 1 - math.sin(var_y) / 2,
                                             lambda var_x: 0.7 - math.cos(var_x - 1),
                                             "sin(y) + 2x = 2", "cos(x-1) + y = 0.7")
    systems = [first_system, second_system]

    num_system = 0
    if file_or_keyboard == "k":
        while num_system != 1 and num_system != 2:
            num_system = int(
                input(
                    f"Выберите систему: \n1. {systems[0].string_func1} \n   {systems[0].string_func2} \n2. {systems[1].string_func1} \n   {systems[1].string_func2}\n"))
        x, y = parameters.get_start_approach(2, True)
        result = iteration_method.solve_system(systems[num_system - 1], x, y,
                                               parameters.get_epsilon(True))
        return result, systems, num_system, x, y
    else:
        file_path = input("Введите путь до файла: ")
        while not os.path.isfile(file_path):
            file_path = input("К сожалению, файла по этому пути не существует, введите путь снова: ")

        with open(file_path, "r") as file:
            lines = file.readlines()

        try:
            num_system = int(lines[0].strip())
            x, y = parameters.get_start_approach(2, False, lines[1].strip())
            result = iteration_method.solve_system(systems[num_system - 1], x, y,
                                                   parameters.get_epsilon(False, lines[2].strip()))
            return result, systems, num_system, x, y
        except ValueError:
            return None


def choice():
    result_in_file_keyboard = ""
    while result_in_file_keyboard != "f" and result_in_file_keyboard != "c":
        result_in_file_keyboard = input(
            "Вывести результаты в файл или консоль? Введите f, если в файл, c - в консоль: ")
    output_path = ""
    if result_in_file_keyboard == "f":
        output_path = input("Введите путь до файла: ")

    system_or_equation = ""
    while system_or_equation != "s" and system_or_equation != "e":
        system_or_equation = input("Что вы хотите решать? Введите s, если систему уравнений, e - 1 уравнение: ")

    if system_or_equation == "e":
        return_value = equation_logic()
        if return_value is None:
            custom_print('', result_in_file_keyboard, output_path)
            custom_print("Ошибка при считывании данных из файла!", result_in_file_keyboard, output_path)
        else:
            result, equations, input_data = return_value

            if not (result['error'] is None):
                custom_print('', result_in_file_keyboard, output_path)
                custom_print(result['error'], result_in_file_keyboard, output_path)
                if input_data["method"] == 1:
                    equations[input_data["num_def"] - 1].paint(input_data["a"], input_data["b"])
                elif input_data["method"] == 2:
                    equations[input_data["num_def"] - 1].paint(input_data["x_0"], input_data["x_0"])
                else:
                    equations[input_data["num_def"] - 1].paint(input_data["x_0"], input_data["x_0"])

            else:
                if result['iterations'] == 100 or abs(result['f_x']) >= input_data["epsilon"]:
                    custom_print("На промежутке нет корней", result_in_file_keyboard, output_path)
                    equations[input_data["num_def"] - 1].paint(input_data["a"], input_data["b"])
                else:
                    if input_data["method"] == 1:
                        equations[input_data["num_def"] - 1].paint2(input_data["a"], input_data["b"],
                                                                    round(result["x_0"], 4),
                                                                    round(result["f_x"], 4))
                    else:
                        equations[input_data["num_def"] - 1].paint2(input_data["x_0"], input_data["x_0"],
                                                                    round(result["x_0"], 4),
                                                                    round(result["f_x"], 4))

                table = PrettyTable()
                if input_data["method"] == 1:
                    table.field_names = ["№", "a", "b", "x", "f(a)", "f(b)", "f(x)", "|a-b|"]
                elif input_data["method"] == 2:
                    table.field_names = ["№", "x_k", "f(x_k)", "f'(x_k)", "x_k+1", "|x_k+1 - x_k|"]
                elif input_data["method"] == 3:
                    table.field_names = ["№", "x_k", "x_k+1", "f(x_k+1)", "|x_k+1 - x_k|"]

                for row in result['history']:
                    table.add_row(row)

                custom_print('', result_in_file_keyboard, output_path)
                custom_print(f'x = {result["x_0"]}\n' + f'f(x) = {result["f_x"]}', result_in_file_keyboard,
                             output_path)
                custom_print(table, result_in_file_keyboard, output_path)

    else:
        return_value = system_logic()
        if return_value is None:
            custom_print('', result_in_file_keyboard, output_path)
            custom_print(
                "Неверные данные в файле, вероятно проблема с приближением, выбором уравнения или погрешностью",
                result_in_file_keyboard, output_path)
        else:
            result, systems, num_system, x, y = return_value
            if not (result['error'] is None):
                custom_print('', result_in_file_keyboard, output_path)
                custom_print(result['error'], result_in_file_keyboard, output_path)
            else:
                table = PrettyTable()
                table.field_names = ["№", "x_0", "y_0", "x", "y", "|x_0 - x|", "|y_0 - y|"]
                for row in result["history"]:
                    table.add_row(row)

                custom_print('', result_in_file_keyboard, output_path)
                custom_print(f'Вектор неизвестных: {result["x"]}, {result["y"]}', result_in_file_keyboard, output_path)
                custom_print(table, result_in_file_keyboard, output_path)
                systems[num_system - 1].paint(x, y, round(result["x"], 3), round(result["y"], 3))


if __name__ == '__main__':
    print("Лабораторная работа №2")
    choice()
