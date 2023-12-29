def start():
    with open("start.xml", "r", encoding="utf-8") as f:
        with open("finish_stupid_pars.yaml", "w", encoding="utf-8") as f2:
            for line in f.readlines():
                if line == '<?xml version="1.0" encoding="UTF-8" ?>\n':
                    pass
                else:
                    tag = line[line.find("<") + 1:line.find(">")]
                    if not ('/' in tag):
                        line = line.replace("<" + tag + ">", tag + ": ")

                    tag = line[line.find("<") + 1:line.find(">")]
                    if '/' in tag:
                        line = line.replace("<" + tag + ">", "")
                    k_gaps = 0
                    while k_gaps<len(line) and line[k_gaps] == " ":
                        k_gaps += 1

                    if len(line) - 1 != line.count(" "):
                        print(" " * (k_gaps // 2) + line[k_gaps:], end="", file=f2)


start()

