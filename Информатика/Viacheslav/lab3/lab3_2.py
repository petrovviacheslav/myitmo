import re


regexp = re.compile(
    r"([а-я]*[еыаоэиюуя]{2}[а-я]*)[:,.]?\s[-]?\s?[аоуыэяёюие']*[йцкнгшщзхъфвпрлджчсмтьб]?(?:[аоуыэяёюие]*[йцкнгшщзхъфвпрлджчсмтьб]?){2}[аоуыэяёюие,-;:']*(\s|$)",
    re.IGNORECASE,
)


def testReg(value):
    print("Новый тест...")
    res = re.findall(regexp, value)
    for elem in res:
        print(elem[0])
    print()


testReg("Гуляет по парку")
# Гуляет
testReg("гуляет - по")
# гуляет
testReg("гуляет, по")
# Гуляет
testReg("ПСЖ - известное среди студентов ИТМО слово, которое мотивирует их учиться")
# известное
# мотивирует
testReg(
    "ИТМО - институт тёплых мужских отношений, в котором каждый найдёт себе паяльник, чтобы прочувствовать все прелести \
    жизни. Самые слабые пишут так называемое ПСЖ, думая что освободят себя от этих мук навсегда, но как же они ошибаются. \
    Они уже присели на иглу, под названием 'любовь к унижению себя', поэтому прибегут в ИТМО снова"
)
# паяльник
# Самые
# называемое
# думая
# ошибаются
# унижению


