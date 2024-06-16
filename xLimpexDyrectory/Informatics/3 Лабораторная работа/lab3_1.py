import re

# 422
# =-{O
r = r'\=-{O'


def testReg(value):
    print(len(re.findall(r, value)))


testReg("=-{O=-{]O=-[{O")  # 1 
testReg("")  # 0
testReg("]<{P[<{P]")  # 0
testReg("=======----------{{{{{{{OOOOOOOO")  # 0
testReg("=-{O")  # 1
testReg("=-{O=-{O=-{O)")  # 3
