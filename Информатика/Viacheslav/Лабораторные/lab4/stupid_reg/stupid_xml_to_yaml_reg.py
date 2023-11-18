import re


def start():
    with open("start.xml", "r", encoding="utf-8") as f:
        with open("finish_stupid_pars.yaml", "w", encoding="utf-8") as f2:
            for line in f.readlines():
                if line == '<?xml version="1.0" encoding="UTF-8" ?>\n':
                    pass
                else:
                    line = re.sub(f'<(\w+)>', '\\1' + ': ', line)
                    line = re.sub(f'<(/\w+)>', '', line)

                    gaps = len(re.search(f'^( *)', line).group(0)) // 2
                    line = re.sub(f'^( *)', ' ' * gaps, line)

                    if len(line) - 1 != line.count(" "):
                        print(line, end="", file=f2)


start()

