print('Программа по переводу чисел из СС Цекендорфа в десятичную СС')

s = input('Введите число в СС Цекендорфа: ')

if s.isdigit() and len(s) == s.count('1') + s.count('0') and not('11' in s):
	k = len(str(int(s)))
	s = str(int(s))
	fib_ss = [1,2]
	for i in range(2, k+1):
		fib_ss.append(fib_ss[i-2]+fib_ss[i-1])
	ans = 0 
	for i in range(len(s)):
		ans += int(s[-i-1]) * fib_ss[i]
	print(f'Результат: {ans}')
else:
	print('Вы ввели число не в СС Цекендорфа. Ошибка!')
