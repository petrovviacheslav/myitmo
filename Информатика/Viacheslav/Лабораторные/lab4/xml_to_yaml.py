
def create_str_yaml(line):
    gaps, tag, text, = separation(line)

    if '/' in tag:
        print('')
    else:
        print(gaps * ' ' + tag + ': ' + text)


def separation(line):
    gaps = line.find('<')

    tag = line[line.find('<') + 1: line.find('>')]

    text = line[line.find('>') + 1: line.find('</')]

    return gaps, tag, text


with open("start.xml", "r", encoding="utf-8") as f:
    for elem in f.readlines():
        if elem == '<?xml version="1.0" encoding="UTF-8" ?>\n':
            continue
        else:
            create_str_yaml(elem)
