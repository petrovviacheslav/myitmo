import functions


def solve(function, x_0, epsilon):
    """ Метод простой итерации для уравнения """
    result = {'error': None, 'history': [], 'iterations': 0, 'x_0': None, 'f_x': None}
    x = create_phi(function.func_calc, x_0)

    iterations = 0
    result['history'].append([iterations, x_0, x, function.func_calc(x), x - x_0])
    while result['iterations'] < 100 and abs(x - x_0) >= epsilon:
        if functions.derivative(function.func_calc, 1, x) >= 1:
            result['error'] = "Не выполнено достаточное условие сходимости"
            return result

        x_0, x = x, create_phi(function.func_calc, x)
        result['iterations'] += 1
        result['history'].append([result['iterations'], x_0, x, function.func_calc(x), abs(x - x_0)])

    result['x_0'] = x
    result['f_x'] = function.func_calc(x)
    return result


def solve_system(system, x_0, y_0, epsilon):
    """ Метод простой итерации для системы """
    result = {'error': None, 'history': [], 'iterations': 0, 'x': None, 'y': None}
    x, y = x_0, y_0

    while (abs(x - system.func1_calc(y)) > epsilon or abs(y - system.func2_calc(x)) > epsilon) and result["iterations"] < 100:
        prev_x, prev_y = x, y
        x = system.func1_calc(y)
        y = system.func2_calc(x)
        result["history"].append([result["iterations"], prev_x, prev_y, x, y, abs(x-prev_x), abs(y-prev_y)])
        result["iterations"] += 1

    if result["iterations"] == 100:
        result["error"] = "Метод простой итерации не сошелся за 100 итераций"
        return result

    result["history"].append([result["iterations"], x, y, system.func1_calc(y), system.func2_calc(x), abs(x - system.func1_calc(y)), abs(y - system.func2_calc(x))])
    result["x"] = x
    result["y"] = y
    return result


def create_phi(function, x):
    return x + (-1 / functions.derivative(function, 1, x)) * function(x)
