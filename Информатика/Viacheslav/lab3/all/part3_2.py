import re


regexp = r'\d+'

def testReg(value):
    print('Новый тест...')

    ans = value
    for num in re.findall(regexp, value):
        ans = re.sub(num, str(4*int(num)**2 - 7), ans)
    print(ans)

    print()


testReg('20 + 22 = 42')
testReg('11 + 2 = 2')
