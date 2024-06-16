import sys

code = input()
d = {
        'r1': code[0],
        'r2': code[1],
        'i1': code[2],
        'r3': code[3],
        'i2': code[4],
        'i3': code[5],
        'i4': code[6],
     }


ans = [code[2], code[4], code[5], code[6]]
s1 = (int(d['r1']) + int(d['i1']) + int(d['i2']) + int(d['i4'])) % 2
s2 = (int(d['r2']) + int(d['i1']) + int(d['i3']) + int(d['i4'])) % 2
s3 = (int(d['r3']) + int(d['i2']) + int(d['i3']) + int(d['i4'])) % 2

s = str(s3) + str(s2) + str(s1)
n = int(s, 2)
if n in range(1, 8):
    match n:
        case 1:
            print("Ошибка в символе r1")
        case 2:
            print("Ошибка в символе r2")
        case 3:
            print("Ошибка в символе i1")
            ans[0] = str(1 - int(ans[0]))
        case 4:
            print("Ошибка в символе r3")
        case 5:
            print("Ошибка в символе i2")
            ans[1] = str(1 - int(ans[1]))
        case 6:
            print('Ошибка в символе i3')
            ans[2] = str(1 - int(ans[2]))
        case 7:
            print('Ошибка в символе i4')
            ans[3] = str(1 - int(ans[3]))
    sys.exit(0)

print(f"Декодированное сообщение: {''.join(ans)}")



