import re

def parse_json_to_xml(json_string):
    xml_string = ""
    json_dict = eval(json_string)  # Преобразуем JSON-строку в Python словарь через eval()

    for key, value in json_dict.items():
        key = key.replace(" ", "_").replace("(", "").replace(")", "")
        xml_string += f"<{key}>"

        if isinstance(value, dict):  # Если значение является словарем
            xml_string += parse_dict_to_xml(value)
        elif isinstance(value, list):  # Если значение является списком
            xml_string += parse_list_to_xml(value)
        else:
            xml_string += str(value)

        xml_string += f"</{key}>"

    return xml_string

def parse_dict_to_xml(json_dict):
    xml_string = ""
  
    for key, value in json_dict.items():
        key = key.replace(" ", "_").replace("(", "").replace(")", "")
        xml_string += f"<{key}>"

        if isinstance(value, dict):
            xml_string += parse_dict_to_xml(value)
        elif isinstance(value, list):
            xml_string += parse_list_to_xml(value)
        else:
            xml_string += str(value)

        xml_string += f"</{key}>"

    return xml_string

def parse_list_to_xml(json_list):
    xml_string = ""
  
    for item in json_list:
        if isinstance(item, dict):
            xml_string += parse_dict_to_xml(item)
        elif isinstance(item, list):
            xml_string += parse_list_to_xml(item)
        else:
            xml_string += str(item)

    return xml_string

# Пример использования
json_string = ''.join(open("schedulle.json").readlines())
xml_string = parse_json_to_xml(json_string)

print("<?xml version=\"1.0\" encoding=\"UTF-8\"?><root>" + xml_string + "</root>" )
