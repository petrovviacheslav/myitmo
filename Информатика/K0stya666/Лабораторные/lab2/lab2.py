def xor(a,b,c,d):
    st = a + b + c + d
    if st.count('1') % 2 == 0: return '0'
    else: return '1'

print ("Введите подряд 7 цифр (0 или 1)")
num = input()
while (num.count("0") + num.count("1")) != 7:
    print("Вы ввели неправильно! Попробуйте ещё раз.")
    num = input()

array = [x for x in num]
bits = ['r1', 'r2', 'i1', 'r3', 'i2', 'i3', 'i4']

step2 = []
step = 0
while 2 ** step < len(array) + 1:
    step2.append(2 ** step)
    step += 1

i = [array[x] for x in range(len(array)) if x + 1 not in step2]
r = [array[x] for x in range(len(array)) if x + 1 in step2]

s1 = xor(r[0], i[0], i[1], i[3])
s2 = xor(r[1], i[0], i[2], i[3])
s3 = xor(r[2], i[1], i[2], i[3])
s = s1 + s2 + s3

tabl = [((3 - len(bin(x)[2:]))*'0'+bin(x)[2:])[-1::-1] for x in range(1,8)]
tabl_r = [tabl[0],tabl[1],tabl[3]]
tabl_i = [tabl[2], tabl[4], tabl[5], tabl[6]]

num_arr = [x for x in num]

if s in tabl_r:
    ind = tabl.index(s)
else:
    ind = tabl.index(s)
    if num_arr[ind] == '0':
        num_arr[ind] = '1'
    elif num_arr[ind] == '1':
        num_arr[ind] = '0'
    res = ''
    for i in num_arr:
        res += i

res = num_arr[2] + num_arr[4] + num_arr[5] + num_arr[6]
print('ошибка в бите: ', bits[ind])
print(res)
