import timeit
import time
from genious_pars_xml_to_yaml import xml_to_yaml
from stupid_pars_xml_to_yaml import stupid_xml_to_yaml
from how_is_it_work_v1 import how_is_it_work
import xml_to_yaml_reg
import xml_to_yaml_libs

if __name__ == "__main__":

    st = time.time()
    for _ in range(100):
        stupid_xml_to_yaml.start()
    fin = time.time()
    print(f"Тупой: {fin - st}")

    st = time.time()
    for _ in range(100):
        how_is_it_work.start()
    fin = time.time()
    print(f"how_is_it_work: {fin - st}")

    st = time.time()
    for _ in range(100):
        xml_to_yaml.start()
    fin = time.time()
    print(f"Без всего (с грамматиками): {fin - st}")

    st = time.time()
    for _ in range(100):
        xml_to_yaml_reg.start()
    fin = time.time()
    print(f"С регулярками: {fin - st}")

    st2 = time.time()
    for _ in range(100):
        xml_to_yaml_libs.start()
    fin2 = time.time()
    print(f"С библиотекой: {fin2 - st2}")
