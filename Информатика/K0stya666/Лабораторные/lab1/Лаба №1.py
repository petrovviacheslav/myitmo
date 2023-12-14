alf = {chr(x):str(x-87) for x in range (97, 97 + 26)}

def fact(x):
    y = 1
    for i in range(x,0,-1):
        y *= i
    return y

def fact_sys(A):
    k = len(str(A)) # кол-во чисел
    res = 0
    for i in range(1,len(str(A))+1):
        res = A%10 + fact(i)
    return res
            
def f(A,B,C):
    A10 = int(str(A),B)
    newA = ''
    while A10 > 0:
        newA = str(A10 % C) + newA
        A10//=C
    return int(newA)

def notation (A, B, C):
    #if B == 'fact':
        #return fact_sys(A)
    
    if '.' not in str(A):
        return f(A,B,C)
    else:
        arr = str(A).split('.') # массив с целой и дробной частью числа
        newA = str(f(arr[0],B,C)) + '.'
        drob = int(arr[1]) / int('1' + str(len(str(arr[1]))*'0'))
        print(drob)
        for i in range(6):
            #print(drob)
            drob *= C
            newA += str(int(drob))
            #print(int(drob))
            drob -= int(drob)
        
        return round(float(newA),5)

arr_A = [38985, 'cad9b', '628ed', 36.63, '58.3c', 66.36, 0.110111, 0.001001, 'a6.Cf', 543210, 144, 101010100, 1894]
arr_B = [10, 15, 15, 10, 16, 8, 2, 2, 16, 'fact', 10, 'fib', -10]
arr_C = [7, 10, 5, 2, 2, 2, 16, 10, 10, 10, 'fib', 10, 10]

for i in range(0,len(arr_A)):
    print(notation(arr_A[i], arr_B[i], arr_C[i]))

print( int ('58.3c',15))

