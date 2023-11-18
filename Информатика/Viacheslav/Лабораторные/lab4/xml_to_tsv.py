import re

f2 = open("finish.tsv", "w", encoding="utf-8")


def create_yaml(file):
    to_one_str_file = "".join(line.strip() for line in file.split("\n"))

    main_tag, text_in, text_out = divide(to_one_str_file)
    to_one_str_file = text_in

    dividing_tag, text_in, text_out = divide(to_one_str_file)
    waiting_tags = to_arr_tags(to_one_str_file, dividing_tag)
    for elem in re.findall(re.compile(rf"<{dividing_tag}>(.*?)</{dividing_tag}>"), to_one_str_file):
        convert_to_yaml(elem, waiting_tags)


def to_arr_tags(line, dividing_tag):
    divide_str = re.compile(rf"<{dividing_tag}>(.*?)</{dividing_tag}>")
    find_all_tags = re.compile(rf"<(.*?)>")
    last_tag = ""
    waiting_tags = []
    first_str = ""
    for elem in re.findall(find_all_tags, re.findall(divide_str, line)[0]):
        if last_tag == "":
            last_tag = elem
            first_str += f"{elem}\t"
            waiting_tags.append(elem)
        elif "/" + last_tag == elem:
            last_tag = ""
    print(first_str[:-1], file=f2)
    return waiting_tags


def convert_to_yaml(line, waiting_tags):
    tag, text_in, text_out = divide(line)
    in_check_tag, out_check_tag = check_tag(text_in), check_tag(text_out)

    if not in_check_tag:
        if not out_check_tag:
            print(text_in, file=f2)
        elif out_check_tag:
            print(text_in + "\t", end="", file=f2)
            convert_to_yaml(text_out, waiting_tags)
    else:
        info_in = re.findall(r"<\w*>(.*?)</\w*>", text_in)
        for i in range(len(info_in)):
            if i == len(info_in) - 1:
                if out_check_tag:
                    print(info_in[i] + "\t", end="", file=f2)
                else:
                    print(info_in[i], file=f2)
            else:
                print(info_in[i] + "|", end="", file=f2)
        if out_check_tag:
            convert_to_yaml(text_out, waiting_tags)


def divide(line):
    tag = line[line.find('<') + 1:line.find('>')]
    text_in = line[len(tag) + 2:line.find(f'</{tag}>')]
    text_out = line[line.find(f'</{tag}>') + len(tag) + 3:]
    return tag, text_in, text_out


def check_tag(line):
    return '<' in line and '>' in line


def is_this_tag_next(line):
    return line[line.find('<') + 1:line.find('>')]


def find_info_in_tag(tag, line):
    return [elem[:elem.find(f"</{tag}>")] for elem in line.split(f'<{tag}>')[1:]]


def start():
    with open("start.xml", "r", encoding="utf-8") as f:
        create_yaml(f.read())


start()
