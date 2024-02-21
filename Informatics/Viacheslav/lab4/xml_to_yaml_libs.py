import xmlplain


def start():
    with open("start.xml", "r", encoding="utf-8") as inf:
        root = xmlplain.xml_to_obj(inf, strip_space=True, fold_dict=True)

    with open("finish.yaml", "w", encoding="utf-8") as outf:
        xmlplain.obj_to_yaml(root, outf)


start()

