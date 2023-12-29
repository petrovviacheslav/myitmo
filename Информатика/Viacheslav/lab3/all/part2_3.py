import re

regexp = r'([А-Я][а-я]*) [А-Я]\.[А-Я]\.'


def testReg(value):
    print('Новый тест...')

    for elem in re.findall(regexp, value):
        print(elem)

    print()


testReg("Студент Вася вспомнил, что на своей лекции Балакшин П.В. упоминал про старшекурсников, которые будут ему помогать: Анищенко А.А. и Машина Е.А.")
