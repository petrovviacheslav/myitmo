xml_string = '<?xml version="1.0" encoding="UTF-8"?>\n'  # Мета-теги XML


def json_to_xml(json_string):
    global xml_string
    xml_string += '<root>\n'
    indentation = 1

    # Функция для форматирования ключей и значений JSON в XML-теги
    def format_tag(key, value):
        formatted_key = key.replace(" ", "_")  # Заменяем пробелы на нижнее подчеркивание
        formatted_key = formatted_key.replace("(", "")  # Заменяем скобку на пустую строку
        formatted_key = formatted_key.replace(")", "")  # Заменяем скобку на пустую строку
        return f"{'    ' * indentation}<{formatted_key}>{value}</{formatted_key}>\n"

    # Функция для проверки, является ли значение JSON объектом
    def is_json_object(value):
        return isinstance(value, dict) or isinstance(value, list)

    # Функция для обработки объектов JSON
    def process_json_object(obj, indent):
        global xml_string
        indent += 1
        for key, value in obj.items():
            formatted_key = key.replace(" ", "_")  # Заменяем пробелы на нижнее подчеркивание
            formatted_key = formatted_key.replace("(", "")  # Заменяем скобку на пустую строку
            formatted_key = formatted_key.replace(")", "")  # Заменяем скобку на пустую строку
            if is_json_object(value):
                xml_string += f"{'    ' * indent}<{formatted_key}>\n"
                process_json(value, indent)
                xml_string += f"{'    ' * indent}</{formatted_key}>\n"
            else:
                xml_string += format_tag(formatted_key, value)
        indent -= 1

    # Функция для обработки массивов JSON
    def process_json_array(array, indent):
        global xml_string
        indent += 1
        for item in array:
            if is_json_object(item):
                process_json_object(item, indent)
            else:
                xml_string += format_tag("item", item)
        indent -= 1

    # Функция для обработки JSON-данных
    def process_json(json_data, indent):
        if isinstance(json_data, dict):
            process_json_object(json_data, indent)
        elif isinstance(json_data, list):
            process_json_array(json_data, indent)

    # Преобразование JSON-строки в словарь
    json_data = eval(json_string)

    process_json(json_data, indentation)
    xml_string += '</root>'

    return xml_string


json_data = ''.join(open("schedulle.json").readlines())

xml_data = json_to_xml(json_data)
print(xml_data)
