import re
def testReg(value):
    print("Новый тест...")

    ans = []
    arr = re.findall(r"\b\w+\b", value)
    for elem in arr:
        for letter in "аоуыэяёюие":
            pattern = re.compile(rf"{letter}", re.IGNORECASE)
            new_word = re.sub(pattern, "", elem)

            pattern2 = re.compile(r"[аоуыэяёюие]", re.IGNORECASE)
            if not (re.search(pattern2, new_word)):
                ans.append(elem)
    new_ans = sorted(set(ans), key=lambda e: (len(e), e))
    for elem in new_ans:
        print(elem)
    print()
testReg("Классное слово – обороноспособность, которое должно идти после слов: трава и молоко")
# и
# идти
# слов
# слово
# трава
# должно
# молоко
# обороноспособность
testReg("Аааааааааа Юаааааааа ЮюююЮюююЮююю ЮЮЮЮюююЮЮЮюююА")
# Аааааааааа
# ЮюююЮюююЮююю
testReg("")
#
testReg("Прошу отчислить по собственному желанию. Возможно меня отчислят прямо на лабе, но я надеюсь, что нет")
# я
# на
# но
# по
# нет
# что
# Возможно
testReg("Уточка, когда ее сжимаешь, она попискивает.\n©Клименков Сергей Викторович")
# ее
# Сергей

