import re

regexp = [r':', r';', r'X', r'8', r'=', r'\[', r'-', r'<', r'-{', r'<{', r'\(', r'\)', r'/']

# элементы, которые надо экранировать: [, (, ), |, \, /
def testReg(value):
    # брать итый элемент из массива сверху
    print(len(re.findall(regexp[12], value)))


testReg("//////") # for example
