import re

regexp = r'[\w\._]+@([a-z]+\.(com|ru))'


def testReg(value):
    print('Новый тест...')

    if re.findall(regexp, value):
        if len(re.findall(regexp, value)[0]) == 2:
            print(re.findall(regexp, value)[0][0])
        else:
            print('Fail!')
    else:
        print('Fail!')

    print()


testReg("shshsh@eeee.com")
testReg("shshsh@eeee.cm")
testReg("shshsh@eeee.")
testReg("shshsh@.com")
testReg("shshsh@eeeecom")
