import time
import xml_to_yaml
import xml_to_yaml_libs

if __name__ == "__main__":
    st = time.time()
    for _ in range(1000000):
        xml_to_yaml
    fin = time.time()
    print(f"Без всего: {fin-st}")

    st2 = time.time()
    for _ in range(1000000):
        xml_to_yaml_libs
    fin2 = time.time()
    print(f"С библиотекой: {fin2 - st2}")