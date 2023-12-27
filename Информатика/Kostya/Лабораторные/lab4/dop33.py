import json
from lark import Lark, Transformer, v_args, Tree


grammar = r'''start: instruction

?instruction: filters_function

property: "property-insensitive"        -> property_insensitive
        | "property"                    -> property
property_date: "age"                    -> age_filter
             | "date"                   -> date_filter

// To run over special characters
TEXT: (LETTER+) (LETTER+|DIGIT+|"-"|"_")*
FILTER: TEXT
SPECIAL_VALUE: "${" (LETTER+) (LETTER+|DIGIT+|"-"|"_") "}" *
WILD_CARD: "%" TEXT | TEXT | NUMBER
VALUE: WILD_CARD|SPECIAL_VALUE|TEXT

ARGSEP: ":" // argument separator

STAR: "*"
filters_function: FILTER (property | property_date) VALUE *

// find the whitespace so we can ignore
WHITESPACE: (" " | "\n")+

%ignore WHITESPACE
%import common.LETTER
%import common.WORD
%import common.DIGIT
%import common.INT -> NUMBER
%ignore ARGSEP
%ignore " "
'''

parser = Lark(grammar, parser='earley') # lalr
# print(parser.parse("filter:property-insensitive:Surname:%Name"))
# print(parser.parse("filter:property-insensitive:Sex:M:F:U"))
# print(parser.parse("filter:age:on:${today}:Equal:26:years"))
# print(parser.parse("filter:date:Equal:${today}"))
# print(parser.parse("filter:property:Type:regular:temp"))
# print(parser.parse("filter:property:Status:active:deducted:deceased"))
# print(parser.parse("filter:date:LessThanOrEqual:YMD-2020-04-15:plus:1:days"))
# print(parser.parse("filter:date:LessThanOrEqual:YMD-2020-04-15:plus:1:months"))

final = parser.parse("filter:property-insensitive:Sex:M:F:U")

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
print(transformer.transform(final))