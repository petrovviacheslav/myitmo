import re

def nesting_level(string):
    return len(string) - len(string.strip())

with open('schedule.xml', 'r', encoding='utf-8') as fileXML:
    declarationXML = fileXML.readline()
    XML = fileXML.read()

stringsXML = re.split(r'\n',XML)
stringsJSON = []

for i in range(len(stringsXML)-1):
    string = stringsXML[i]
    block = re.search(r'(<[\w/]+>)',string).group(1)
    if '/' not in block:
        opening = block
        closing = re.sub(opening,opening[0] + '/' + opening[1:],opening)
        if (opening and closing) in string:
            newOpening = f'"{opening[1:-1]}"'
            if nesting_level(string) == nesting_level(stringsXML[i+1]):
                string = re.sub(opening,f'{newOpening}: "',string)
                newString = re.sub(closing,'",',string)
            else:
                string = re.sub(opening,f'{newOpening}: "',string)
                newString = re.sub(closing,'"',string)
        elif opening in string:
            newOpening = f'"{opening[1:-1]}"'
            newString = re.sub(opening,f'{newOpening}: {{',string)
    else:
        closing = block
        if (nesting_level(string) == nesting_level(stringsXML[i+1])) and nesting_level(string) != 0:
                newClosing = '},'
                newString = re.sub(closing,newClosing, string)
        else:
            newClosing = '}'
            newString = re.sub(closing,newClosing, string)
    stringsJSON.append(newString)
    if i == len(stringsXML)-2:
        string = stringsXML[i+1]
        closing = block
        newClosing = '}'
        newString = re.sub(closing,newClosing,string)
        stringsJSON.append(newString)

JSON = '{\n'
for string in stringsJSON:
    JSON += f'\t{string}\n'
JSON = JSON + '}'

with open('schedule2.json', 'w', encoding='utf-8') as fileJSON:
    fileJSON.write(JSON)