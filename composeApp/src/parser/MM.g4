grammar MM;

PO: '(';
PC: ')';
BO: '{';
BC: '}';
BRO: '[';
BRC: ']';
COMMA: ',';
SEMI: ';';
QMARK: '?';
EQ: '=';
DOT: '.';
COLON: ':';

IF: 'if';
FOR: 'for';
FUN: 'fun';
VAR: 'var';
ELSE: 'else';
TRUE: 'true';
BREAK: 'break';
CONST: 'const';
FALSE: 'false';
WHILE: 'while';
RETURN: 'return';

DICE: 'd4' | 'd6' | 'd8' | 'd10' | 'd12' | 'd20' | 'd100';
CURRENCY: 'pp' | 'gp' | 'sp' | 'cp';
TAGNAME: '@'[a-zA-Z][a-zA-Z0-9_]*;
ID: [a-zA-Z_][a-zA-Z0-9_]*;
INT: [0-9]+;
FLOAT: [0-9]*'.'[0-9]+;

STRING: '"' ~('"')* '"';

COMMENT: '//' ~[\r\n]* -> skip;
WS: [ \t\r\n]+ -> skip;

program: preamble declaration* EOF;

preamble: 'source' ID SEMI deps+=dependency*;

dependency: 'import' src=ID PO items=idList PC SEMI;

idList: ids+=ID (COMMA ids+=ID)*;

declaration:
    kind=ID name=ID tags=tagList?                         #simpleDecl
  | kind=ID name=ID tags=tagList? BO body+=bodyDecl* BC   #fullDecl
  | kind=ID names=idList                                  #simpleMultipleDecl
  | kind=ID PO names=idList PC 'all' tags=tagList?        #multipleDecl
  | funDecl                                               #function
  | globalDecl                                            #global;

bodyDecl:
    funDecl                                               #memberFunc
  | globalDecl                                            #memberConst
  | VAR name=ID EQ value=expr SEMI                        #memberField; // TODO: remove fields, they seem obsolete?

funDecl: FUN name=ID PO args=idList? PC BO body+=stmt* BC;

globalDecl: CONST name=ID EQ value=expr SEMI;

tagList: tags+=tag+;

tag:
    name=TAGNAME                                          #simpleTag
  | name=TAGNAME PO args=exprList? PC                     #paramTag;

exprList: exprs+=expr (COMMA exprs+=expr)*;

stmt:
    expr SEMI                                           #exprStmt
  | VAR name=ID EQ value=expr SEMI                      #varDecl
  | CONST name=ID EQ value=expr SEMI                    #constDecl
  | name=ID EQ value=expr SEMI                          #assignStmt
  | IF PO cond=expr PC BO body+=stmt* BC                #ifStmt
  | IF PO cond=expr PC BO bTrue+=stmt* BC ELSE BO bFalse+=stmt* BC
                                                        #ifElseStmt
  | WHILE PO cond=expr PC BO body+=stmt* BC             #whileStmt
  | FOR PO v=ID COLON set=expr PC BO body+=stmt* BC     #forStmt
  | BREAK SEMI                                          #breakStmt
  | RETURN e=expr? SEMI                                 #returnStmt;

expr:
    literal                                               #literalExpr
  | ID                                                    #nameExpr
  | BRO exprs=exprList? BRC                               #listExpr
  | ID PO args=exprList? PC                               #callExpr
  | PO e=expr PC                                          #parenExpr
  | count=expr DICE                                       #diceExpr
  | count=expr CURRENCY                                   #currencyExpr
  | base=expr BRO index=expr BRC                          #indexExpr
  | base=expr DOT name=ID                                 #memberExpr
  | base=expr DOT name=ID PO args=exprList? PC            #memberCallExpr
  | op=('+' | '-' | '!') right=expr                       #unaryExpr
  | left=expr op=('*' | '/' | '%') right=expr             #mulExpr
  | left=expr op=('+' | '-') right=expr                   #addExpr
  | left=expr op=('<' | '>' | '<=' | '>=' | '==' | '!=') right=expr
                                                          #cmpExpr
  | left=expr op=('&&' | '||') right=expr                 #boolExpr
  | cond=expr QMARK bTrue=expr COLON bFalse=expr          #ternaryExpr
  | begin=expr 'to' end=expr 'exclusive'?                 #rangeExpr
  | begin=expr 'to' end=expr 'inclusive'                  #rangeInclusiveExpr;

literal:
    STRING                                                #stringLiteral
  | INT                                                   #intLiteral
  | FLOAT                                                 #floatLiteral
  | DICE                                                  #diceLiteral
  | TRUE                                                  #trueLiteral
  | FALSE                                                 #falseLiteral
  | 'INF'                                                 #infIntLiteral
  | 'INFF'                                                #infFloatLiteral;