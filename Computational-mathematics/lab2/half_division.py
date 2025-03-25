def solve(function, a, b, epsilon):
    """ Метод половинного деления для уравнения """
    result = {'error': None, 'history': [], 'iterations': 0, 'x_0': None, 'f_x': None}
    if function.func_calc(a)*function.func_calc(b) > 0:
        result['error'] = "Этим методом невозможно найти корни на промежутке"
        return result

    left, right = a, b

    res = function.func_calc((left + right) / 2)

    result['history'].append(
        [result['iterations'], left, right, (left + right) / 2, function.func_calc(left), function.func_calc(right), res, right - left])
    while abs(res) >= epsilon and result['iterations'] < 100:

        if function.func_calc(left) > 0:
            if res > 0:
                left = (left + right) / 2
            else:
                right = (left + right) / 2
        else:
            if res > 0:
                right = (left + right) / 2
            else:
                left = (left + right) / 2

        result['iterations'] += 1
        res = function.func_calc((left + right) / 2)
        result['history'].append(
            [result['iterations'], left, right, (left + right) / 2, function.func_calc(left), function.func_calc(right), res,
             right - left])

    result['x_0'] = (left + right) / 2
    result['f_x'] = res
    return result
