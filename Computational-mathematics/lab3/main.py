import math

func_array = [lambda x: x ** 2 - 3, lambda x: 5 / x - 2 * x, lambda x: math.e ** (2 * x) - 2,
              lambda x: 3 * x ** 3 - 2 * x ** 2 - 7 * x - 8]


def asker():
    func_lambda = 0
    num_method = 0
    a = 0
    b = 0
    epsilon = 0
    parameter = 0
    while True:
        try:
            print("Выберите функцию: (введите номер)")
            print("1: x^2 - 3 \n2: 5/x - 2x \n3: e^(2x) - 2\n4: 3x^3 - 2x^2 - 7x - 8")
            num_func = int(input("Выранный номер: "))
            if num_func != 1 and num_func != 2 and num_func != 3 and num_func != 4:
                raise ValueError
            func_lambda = func_array[num_func - 1]
            break
        except TypeError:
            print("Неправильный ввод!")
            continue
        except ValueError:
            print("Неправильный ввод!")
            continue
        except KeyboardInterrupt:
            print("Неправильный ввод!")
            continue

    while True:
        try:
            print("Выберите метод решения: (введите номер)")
            print(
                "1.1: Метод прямоугольников (левый) \n1.2: Метод прямоугольников (средний) \n1.3: Метод прямоугольников (правый) \n2: Метод трапеций \n3: Метод Симпсона")
            num_method = float(input("Выранный номер: "))
            if num_method != 1.1 and num_method != 1.2 and num_method != 1.3 and num_method != 2 and num_method != 3:
                raise ValueError
            parameter = int(num_method * 10 % 10)
            num_method = num_method // 1
            break
        except TypeError:
            print("Неправильный ввод!")
            continue
        except ValueError:
            print("Неправильный ввод!")
            continue
        except KeyboardInterrupt:
            print("Неправильный ввод!")
            continue

    while True:
        try:
            a, b = map(float, input("Введите пределы интегрирования (a, b): ").split())
            if a > b:
                raise ValueError
            break
        except TypeError:
            print("Неправильный ввод!")
            continue
        except ValueError:
            print("Неправильный ввод!")
            continue
        except KeyboardInterrupt:
            print("Неправильный ввод!")
            continue

    while True:
        try:
            epsilon = float(input("Введите погрешность вычислений (> 0 и < 1): "))
            if epsilon <= 0 or epsilon >= 1:
                raise ValueError
            break
        except TypeError:
            print("Неправильный ввод!")
            continue
        except ValueError:
            print("Неправильный ввод!")
            continue
        except KeyboardInterrupt:
            print("Неправильный ввод!")
            continue
    return {"num_method": num_method, "func_lambda": func_lambda, "a": a, "b": b, "epsilon": epsilon,
            "parameter": parameter}


def distributor(input_data):
    if input_data["num_method"] == 1:
        return rectangle_method(input_data)
    elif input_data["num_method"] == 2:
        return trapezoid_method(input_data)
    elif input_data["num_method"] == 3:
        return simpson_method(input_data)


def rectangle_method(data_set):
    n = 4
    integral = 0
    while True:
        left = data_set["a"]
        right = data_set["b"]
        used_func = data_set["func_lambda"]
        h = (right - left) / n
        cur_integral = 0
        if data_set["parameter"] == 1:
            pass
        elif data_set["parameter"] == 2:
            left = left + h / 2
        elif data_set["parameter"] == 3:
            left = left + h

        while left < right or (data_set["parameter"] == 0.3 and left <= right):
            cur_integral += used_func(left) * h
            left += h

        if abs(cur_integral - integral) <= data_set["epsilon"] or n == 4 * (2**7):
            integral = cur_integral
            break
        integral = cur_integral
        n *= 2
    return {"answer": integral, "parts": n}


def simpson_method(data_set):
    n = 4
    integral = 0
    while True:
        left = data_set["a"]
        right = data_set["b"]
        used_func = data_set["func_lambda"]
        h = (right - left) / n
        cur_integral = used_func(left) + used_func(right)
        left += h
        flag = True

        while left < right:
            if flag:
                cur_integral += 4 * used_func(left)
            else:
                cur_integral += 2 * used_func(left)
            flag = not flag
            left += h
        cur_integral *= h / 3

        if abs(cur_integral - integral) <= data_set["epsilon"] or n == 4 * (2**7):
            integral = cur_integral
            break
        integral = cur_integral
        n *= 2
    return {"answer": integral, "parts": n}


def trapezoid_method(data_set):
    n = 4
    integral = 0
    while True:
        left = data_set["a"]
        right = data_set["b"]
        used_func = data_set["func_lambda"]
        h = (right - left) / n
        cur_integral = (used_func(left) + used_func(right)) / 2
        left += h
        while left < right:
            cur_integral += used_func(left)
            left += h
        cur_integral *= h
        if abs(cur_integral - integral) <= data_set["epsilon"] or n == 4 * (2**7):
            integral = cur_integral
            break
        integral = cur_integral
        n *= 2
    return {"answer": integral, "parts": n}


if __name__ == '__main__':
    print("Лабораторная работа #3 (вариант 8)")
    print("Численное интегрирование")
    data = asker()
    result = distributor(data)

    print("\n\nРезультаты:")
    print(f"Значение интеграла: {result['answer']}")
    print(f"Количество разбиений: {result['parts']}")
