import json
from lark import Lark, Transformer, v_args, Tree

with open('schedule.xml', 'r', encoding='utf-8') as fileXML:
    declarationXML = fileXML.readline()
    XML = fileXML.read()

grammar = r'''start: element
    element: "<" NAME ">" (element | TEXT)* "</" NAME ">"
    %import common.CNAME -> NAME
    %import common.WS
    %ignore WS
    %ignore COMMENT 
    COMMENT: /<!--[\s\S]*?-->/
    TEXT: /[^<]+/
'''

parser = Lark(grammar, start='start') # lalr
# xml_parser = Lark(xml_grammar, start='start')

# Парсинг XML и преобразование в JSON
# tree = xml_parser.parse(XML)
tree = parser.parse(XML)

class TreeTransformer(Transformer):
    out = []

    def start(self, content):
        #out = []
        for token in content:
            if isinstance(token, str):
                print('string')

    def filters_function(self, content):
        for token in content:
            print(token)
        return content

    def property_insensitive(self, content):
        return 'property_insensitive'

    def FILTER(self,content):
        return content

    def property(self, args):
        return 'property'

transformer = TreeTransformer()
print(transformer)
print(transformer.transform(tree))