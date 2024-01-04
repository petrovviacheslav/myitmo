import ply.lex as lex
import ply.yacc as yacc

# Определение лексера
tokens = (
    'STRING',
    'NUMBER',
    'LBRACE',
    'RBRACE',
    'LBRACKET',
    'RBRACKET',
    'COMMA',
    'COLON',
    'TRUE',
    'FALSE',
    'NULL'
)

t_STRING = r'\".*?\"'
t_NUMBER = r'-?(0|[1-9]\d*)(\.\d+)?([eE][-+]? \d+)?'
t_LBRACE = r'\{'
t_RBRACE = r'\}'
t_LBRACKET = r'\['
t_RBRACKET = r'\]'
t_COMMA = r','
t_COLON = r':'
t_TRUE = r'true'
t_FALSE = r'false'
t_NULL = r'null'

t_ignore = ' \t\n'

def t_error(t):
    raise Exception(f"Недопустимый символ '{t.value[0]}'")

lexer = lex.lex()

# Определение грамматики
def p_dataset(p):
    '''dataset : object
               | array'''
    p[0] = '<?xml version="1.0" encoding="UTF-8"?>\n<root>' + p[1] + '</root>'

def p_object(p):
    'object : LBRACE members RBRACE'
    p[0] = p[2]

def p_members(p):
    '''members : pair
               | pair COMMA members'''
    if len(p) == 2:
        p[0] = p[1]
    else:
        p[0] = p[1] + p[3]

def p_pair(p):
    'pair : STRING COLON value'
    key = p[1].strip('"')
    p[0] = f'<{key}>{p[3]}</{key}>'

def p_array(p):
    'array : LBRACKET elements RBRACKET'
    p[0] = ''.join(p[2])

def p_elements(p):
    '''elements :
                | value
                | value COMMA elements'''
    if len(p) == 1:
        p[0] = ''
    elif len(p) == 2:
        p[0] = p[1]
    else:
        p[0] = p[1] + p[3]

def p_value(p):
    '''value : STRING
             | NUMBER
             | object
             | array
             | TRUE
             | FALSE
             | NULL'''
    p[0] = p[1]

def p_error(p):
    raise Exception("Синтаксическая ошибка")

parser = yacc.yacc()

def json_to_xml(json_string):
    xml_string = parser.parse(json_string)
    return xml_string

# Пример использования
json_string = ''.join(open("schedulle.json").readlines())
xml_string = json_to_xml(json_string)
print(xml_string)
