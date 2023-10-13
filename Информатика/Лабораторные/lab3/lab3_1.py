import re

regexp = r'\[<{P'


def testReg(value):
    print(len(re.findall(regexp, value)))


testReg("[<{P[<{P]<{P")  # 2
testReg("")  # 0
testReg("]<{P[<{P]")  # 1
testReg("[[[[[[[[<<<<<<{{{{PPPP")  # 0
testReg("[<{P")  # 1
testReg("[<{P]<{P[<}P[<{P[<{P")  # 3

