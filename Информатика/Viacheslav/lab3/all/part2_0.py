import re

regexp13 = re.compile(r'^([^еыаоэиюуя]*[еыаоэиюуя]){5}[^еыаоэиюуя]*$', re.IGNORECASE)
regexp2 = re.compile(r'^([^еыаоэиюуя]*[еыаоэиюуя]){7}[^еыаоэиюуя]*$', re.IGNORECASE)

def testReg(value):
    print('Новый тест...')
    arr = re.split(r'\/', value)
    if len(arr) != 3:
        print('Не хайку. Должно быть 3 строки.')
    else:
        if re.search(regexp13, arr[0]) and re.search(regexp2, arr[1]) and re.search(regexp13, arr[2]):
            print('Хайку!')
        else:
            print('Не хайку.')
    print()


testReg("Вечер за окном. / Еще один день прожит./ Жизнь скоротечна...")
testReg("Просто текст ")
testReg("Как вишня расцвела! / Она с коня согнала / И князя-гордеца.")
