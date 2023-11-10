arr = []
arr_tag = [[], [], [], [], []]
counter_tag = [0, 0, 0, 0]

prev_tag = ''


def create_str_yaml(arr):
    for elem in arr:
        find_tags(elem)
    with open("finish.yaml", "w", encoding="utf-8") as out:
        minus_flag = 0
        for i in range(len(arr)):
            gaps, tag, text, = separation(arr[i])

            if '/' in tag:
                pass
            else:
                ind = counter_tag[gaps // 4]
                if ind > 0 and arr_tag[gaps // 4][ind] == arr_tag[gaps // 4][ind - 1]:
                    print(gaps * ' ' + '  - ', file=out, end='')
                    if len(text) > 0:
                        print(text, file=out)
                    minus_flag = 1
                elif len(arr_tag[gaps // 4]) > (ind + 1) and arr_tag[gaps // 4][ind] == arr_tag[gaps // 4][ind + 1]:
                    print(gaps * ' ' + tag + ': ', file=out)
                    print(gaps * ' ' + '  - ', file=out, end='')
                    if len(text) > 0:
                        print(text, file=out)
                    minus_flag = 1
                else:
                    if minus_flag:
                        print(tag + ': ' + text, file=out)
                    else:
                        print(gaps * ' ' + tag + ': ' + text, file=out)
                    minus_flag = 0

                counter_tag[gaps // 4] += 1


def separation(line):
    gaps = line.find('<')
    tag = line[line.find('<') + 1: line.find('>')]
    text = line[line.find('>') + 1: line.find('</')]
    return gaps, tag, text


def find_tags(line):
    if '/' in line[line.find('<') + 1: line.find('>')]:
        pass
    else:
        arr_tag[line.find('<') // 4].append(line[line.find('<') + 1: line.find('>')])


with open("start.xml", "r", encoding="utf-8") as f:
    for elem in f.readlines():
        if elem == '<?xml version="1.0" encoding="UTF-8" ?>\n':
            continue
        else:
            arr.append(elem)
    create_str_yaml(arr)
