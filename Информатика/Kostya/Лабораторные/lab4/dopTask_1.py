import xmltodict
import json

def parsing(line):
    xml = xmltodict.parse(line)
    return json.dumps(xml, ensure_ascii=False, indent=2)

with open('schedule.xml', 'r', encoding='utf-8') as fileXML:
    XML = fileXML.read()

with open('schedule1.json', 'w', encoding='utf-8') as fileJSON:
    fileJSON.write(parsing(XML))