def get_epsilon(is_keyboard=True, line_file=None):
    epsilon = 0.01
    if is_keyboard:
        while True:
            try:
                epsilon = float(input("Введите погрешность вычисления (> 0 and < 1): "))
                if 1 > epsilon > 0:
                    break
            except ValueError:
                print("Погрешность должна быть числом")
    else:
        try:
            epsilon = float(line_file)
            if 1 < epsilon or epsilon < 0:
                raise ValueError
        except ValueError:
            print("Погрешность должна быть числом в пределах от 0 до 1")
    return epsilon


def get_borders(is_keyboard=True, line_file=None):
    left, right = 0, 0
    if is_keyboard:
        while True:
            try:
                left, right = map(float, input(
                    "Введите границы интервала (первое число < второе число): ").split())
                if left < right:
                    break
            except ValueError:
                print("Границы интервала должны быть числами")
    else:
        try:
            left, right = map(float, line_file.split())
            if left >= right:
                raise ValueError
        except ValueError:
            print("Границы интервала должны быть числами и первое число < второе число")
    return left, right


def get_start_approach(count_vars=1, is_keyboard=True, line_file=None):
    arr_vars = []
    if is_keyboard:
        if count_vars == 1:
            while True:
                try:
                    arr_vars = float(input("Введите начальное приближение (1 число - x0): "))
                    break
                except ValueError:
                    print("Начальное приближение должно быть числом.")
        else:
            while True:
                try:
                    arr_vars = map(float, input(
                        "Введите начальное приближение (x0, y0): ").split())
                    break
                except ValueError:
                    print("Начальное приближение должно состоять из двух чисел")
    else:
        if count_vars == 1:
            try:
                arr_vars = float(line_file)
            except ValueError:
                print("Начальное приближение должно быть числом.")
        else:
            try:
                arr_vars = map(float, line_file.split())
            except ValueError:
                print("Начальное приближение должно состоять из двух чисел")

    return arr_vars
