import re

regexp = r'.* ([\w])\.\1\. P0000\s'


def testReg(value):
    print('Новый тест...')

    print(re.sub(regexp, '', value))

    print()


testReg('Пе-тр ов П.П. P0000\nАнищенко А.А. P33113\nИванов И.И. P0000\nПримеров Е.В. P0000\n')
