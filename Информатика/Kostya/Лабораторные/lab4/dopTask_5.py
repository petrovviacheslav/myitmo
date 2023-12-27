#XML --> TSV
import re

def nesting_level(string):
    return len(string)-len(string.strip())

with open('schedule.xml','r', encoding='utf-8') as f:
    XML = f.read()

stringsXML = XML.split('\n')[1:]
stringsTSV = []
keys = []

for string in stringsXML:
    arr = re.findall(r'<(\w+)>',string)
    if arr != []:
        opening = '<' + arr[0] + '>'
        closing = '</' + arr[0] + '>'
        if (opening and closing) in string:
            if arr[0] not in keys:
                keys.append(arr[0])

slov = {k:[] for k in keys}

for string in stringsXML:
    arr = re.findall(r'<(\w+)>',string)
    if arr != []:
        opening = '<' + arr[0] + '>'
        closing = '</' + arr[0] + '>'
        if (opening and closing) in string:
            line = string.replace(opening,'')
            line = line.replace(closing,'')
            line = line.strip()
            slov[arr[0]].append(line)

Lmax = 0
for k in keys:
    Lmax = max(Lmax,len(slov[k]))

stringsTSV = ['']
for k in keys:
    stringsTSV[0] += k + '\t'
stringsTSV[0] += '\n'

for i in range(Lmax):
    string = ''
    for k in keys:
        if len(slov[k])-1 >= i:
            string += slov[k][i] + '\t'
        else:
            string += slov[k][-1] + '\t'
    string += '\n'
    stringsTSV.append(string)

TSV = ''
for string in stringsTSV:
    TSV += string

with open('schedule5.tsv','w',encoding='utf-8') as fileTSV:
    fileTSV.write(TSV)