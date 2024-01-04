from json2xml import json2xml
from json2xml.utils import readfromstring


def json_to_xml(json_string):
    xml_data = json2xml.Json2xml(readfromstring(json_string)).to_xml()
    return xml_data


# Пример использования
json_data = ''.join(open("schedulle.json").readlines())

xml_data = json_to_xml(json_data)
print(xml_data)
