import re

f2 = open("finish_reg.yaml", "w", encoding="utf-8")


def create_yaml(file):
    clear_data = re.compile(r"\n *")
    to_one_str_file = re.sub(clear_data, '', file)
    convert_to_yaml(to_one_str_file)


def convert_to_yaml(line, gaps=0, minus=False):
    tag, text_in, text_out = divide(line)
    in_check_tag, out_check_tag = check_tag(text_in), check_tag(text_out)

    if minus:
        print(" " * (gaps - 2) + "- ", end="", file=f2)
    else:
        print(" " * gaps, end="", file=f2)

    if not in_check_tag:
        if not out_check_tag or is_this_tag_next(text_out) != tag:
            print(tag + ": " + text_in, file=f2)
            if is_this_tag_next(text_out) != tag and len(text_out) > 0:
                convert_to_yaml(text_out, gaps)
        elif out_check_tag:
            print(tag + ": ", file=f2)
            for elem in find_info_in_tag(tag, line):
                print(" " * gaps + "  - " + elem, file=f2)
    else:
        print(tag + ": ", file=f2)
        if not out_check_tag or is_this_tag_next(text_out) != tag:
            convert_to_yaml(text_in, gaps + 4)
            if is_this_tag_next(text_out) != tag and len(text_out) > 0:
                convert_to_yaml(text_out, gaps)
        else:
            for elem in find_info_in_tag(tag, line):
                convert_to_yaml(elem, gaps + 4, True)


def divide(line):
    find_tag = re.compile(r'<(\w+)>')
    tag = re.search(find_tag, line).group(1)

    find_text_in = re.compile(rf"<{tag}>(.*)</{tag}>")
    text_in = re.search(find_text_in, line).group(1)

    find_text_out = re.compile(rf"</{tag}>(.*)")
    text_out = re.search(find_text_out, line).group(1)

    return tag, text_in, text_out


def check_tag(line):
    return re.search(re.compile(r'<(\w+)>'), line)


def is_this_tag_next(line):
    find_tag = re.compile(r'<(\w+)>')
    if re.search(find_tag, line):
        return re.search(find_tag, line).group(1)
    return ''


def find_info_in_tag(tag, line):
    regexp = re.compile(rf"(.*)</{tag}>")
    return [re.search(regexp, elem).group(1) for elem in line.split(f'<{tag}>')[1:]]

def start():
    with open("start.xml", "r", encoding="utf-8") as f:
        create_yaml(f.read())
start()
