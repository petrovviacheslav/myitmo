import re

r = re.compile(r"[0-9]+")

def cum(n):
    return str(4*(int(n.group())**2) - 7)

string = "22c + 23 = 45"
new_string = r.sub(cum, string)

print(new_string)

