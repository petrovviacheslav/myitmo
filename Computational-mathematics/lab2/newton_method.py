import functions


def solve(function, start_x, epsilon):
    """ Метод Ньютона для уравнения """
    result = {'error': None, 'history': [], 'iterations': 0, 'x_0': None, 'f_x': None}
    x_0 = 0
    # проверка начального приближения
    if function.func_calc(start_x) * functions.derivative(function.func_calc, 2, start_x) > 0:
        x_0 = start_x
    else:
        result['error'] = "Данным методом невозможно найти корень"
        return result

    res = function.func_calc(x_0)
    while abs(res) >= epsilon and result['iterations'] < 100:
        deriv = functions.derivative(function.func_calc, 1, x_0)
        result['history'].append([result['iterations'], x_0, res, deriv, x_0 - function.func_calc(x_0) / deriv,
                                  abs(function.func_calc(x_0) / deriv)])
        # if abs(function.func_calc(x_0) / functions.derivative(function.func_calc, 1, x_0)) < epsilon:
        #     break
        x_0 = x_0 - function.func_calc(x_0) / deriv

        result['iterations'] += 1
        res = function.func_calc(x_0)

    result['x_0'] = x_0
    result['f_x'] = res
    result['history'].append([result['iterations'], x_0, res, "-", "-", "-"])
    return result
