f2 = open("finish_xml_to_yaml.yaml", "w", encoding="utf-8")
def create_yaml(file):
    file = file.replace('<?xml version="1.0" encoding="UTF-8" ?>', "")
    to_one_str_file = "".join(line.strip() for line in file.split("\n"))
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
            convert_to_yaml(text_in, gaps + 2)
            if is_this_tag_next(text_out) != tag and len(text_out) > 0:
                convert_to_yaml(text_out, gaps)
        else:
            for elem in find_info_in_tag(tag, line):
                convert_to_yaml(elem, gaps + 2, True)
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

