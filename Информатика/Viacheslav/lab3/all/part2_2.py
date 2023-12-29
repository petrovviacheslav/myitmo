import re

regexp = r'ВТ[^\w]*\w*[^\w]*\w*[^\w]*\w*[^\w]*\w*[^\w]*ИТМО'


def testReg(value):
    print('Новый тест...')

    print(re.findall(regexp, value)[0])

    print()


testReg("А ты знал, что ВТ - лучшая кафедра ИТМО?")
