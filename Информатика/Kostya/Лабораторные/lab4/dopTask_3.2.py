from lark import Lark, Transformer, v_args

xml_grammar = '''
    start: element
    element: "<" NAME ">" (element | TEXT)* "</" NAME ">"
    %import common.CNAME -> NAME
    %import common.WS
    %ignore WS
    %ignore COMMENT 
    COMMENT: /<!--[\s\S]*?-->/
    TEXT: /[^<]+/
'''


#@v_args(inline=True)
class XMLTransformer(Transformer):
    # def start(self, items):
    #     return items[0]
    def element(self, items):
        print(self)
        tag, *content = items
        return {tag: content}

with open('schedule.xml', 'r', encoding='utf-8') as fileXML:
    declarationXML = fileXML.readline()
    XML = fileXML.read()

# Парсер XML
xml_parser = Lark(xml_grammar, start='start')

# Парсинг XML и преобразование в JSON
tree = xml_parser.parse(XML)
json_data = XMLTransformer().transform(tree)
print(str(json_data))

with open('schedule3_2.json', 'w', encoding='utf-8') as fileJSON:
    fileJSON.write(str(json_data).replace("'", "\""))