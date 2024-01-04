grammar MM;

/* tokens as in lexer */
DOT:                '.';
SEMI:               ';';
COMMA:              ',';
MULT:               '*';
DIV:                '/';
MOD:                '%';
PLUS:               '+';
MINUS:              '-';
GT:                 '>';
LT:                 '<';
GE:                 '>=';
LE:                 '<=';
EQ:                 '==';
NE:                 '!=';
AND:                '&&';
OR:                 '||';
ASSIGN:             '=';
PLUS_ASSIGN:        '+=';
MINUS_ASSIGN:       '-=';
MULT_ASSIGN:        '*=';
DIV_ASSIGN:         '/=';
MOD_ASSIGN:         '%=';

BLOCK:              '{';
END:                '}';
P_OPEN:             '(';
P_CLOSE:            ')';
BR_OPEN:            '[';
BR_CLOSE:           ']';

FS_SEP:             '#~#';

D:                  'd'|'D';
CP:                 'cp';
FT:                 'ft';
GP:                 'gp';
IF:                 'if';
LB:                 'lb';
IN:                 'in';
PP:                 'pp';
SP:                 'sp';
FOR:                'for';
FUN:                'fun';
ELSE:               'else';
ITEM:               'item';
RACE:               'race';
CLASS:              'class';
SKILL:              'skill';
SPELL:              'spell';
TRAIT:              'trait';
WHILE:              'while';
DAMAGE:             'damage';
ENABLE:             'enable';
SOURCE:             'source';
ABILITY:            'ability';
STRINGS:            'strings';
SUBRACE:            'subrace';
SUBCLASS:           'subclass';
ITEM_TAG:           'item_tag';
ITEM_TRAIT:         'item_trait';
BACKGROUND:         'background';
DEPENDS_ON:         'depends on';
ALLOW_SUBRACE:      'allow subrace';

NUMBER:             [0-9]+('.'[0-9]+)?;

AUTO_TARGETS:       '$'[A-Z][A-Z_]*;

DICE_LIT:           [0-9]+D[0-9]+;
DIST_LIT:           NUMBER FT;
CURRENCY:           GP|PP|SP|CP;
CURRENCY_LIT:       [0-9]+(GP|PP|SP|CP);
WEIGHT_LIT:         NUMBER LB;

IDENTIFIER:         [a-zA-Z_][a-zA-Z0-9_]*;
STRING_LIT:         '"'~["]*'"' {setText(getText().substring(1, getText().length()-1));};

NEWLINE:            [\r\n]+ -> channel(HIDDEN);
WS:                 [ \t]+ -> channel(HIDDEN);
COMMENT:            '//'~[\r\n]*[\r\n] -> channel(HIDDEN);
ML_COMMENT:         '/*' (ML_COMMENT | '/' ~'*' | ~'/')*? '*/' -> channel(HIDDEN);

ANY:                .;

/* strings list file */
strings:            singleString* EOF;

singleString:       key=IDENTIFIER '=' value=STRING_LIT SEMI;

/* rules as in parser */
mageProg:           header enables* topLevel* EOF;

header:             SOURCE src=IDENTIFIER SEMI                              #sourceHeader
      |             SOURCE src=IDENTIFIER DEPENDS_ON deps=STRING_LIT* SEMI  #sourceHeaderDeps
      |             SOURCE src=IDENTIFIER SEMI setStrings                   #sourceHeaderStrings
      |             SOURCE src=IDENTIFIER DEPENDS_ON deps=STRING_LIT* SEMI setStrings
                                                                            #sourceHeaderDepsStrings;

setStrings:         STRINGS IN file=STRING_LIT (COMMA file=STRING_LIT)* SEMI;

enables:            ENABLE AUTO_TARGETS* SEMI;

topLevel:           classDecl                                               #dndClass
        |           raceDecl                                                #dndRace
        |           subclassDecl                                            #dndSubClass
        |           subRaceDecl                                             #dndSubRace
        |           itemDecl                                                #dndItem
        |           spellDecl                                               #dndSpell
        |           backgroundDecl                                          #dndBg
        |           abilityDecl                                             #dndAbility
        |           skillDecl                                               #dndSkill
        |           traitDecl                                               #dndTrait
        |           itemTraitDecl                                           #dndItemTrait
        |           damageDecl                                              #dndDamage
        |           itemTagDecl                                             #dndItemTag
        |           funDecl                                                 #function;

classDecl:          CLASS name=IDENTIFIER (dispName=description)? (P_OPEN d=description P_CLOSE)? BLOCK declBody* END;

raceDecl:           RACE name=IDENTIFIER (dispName=description)? (P_OPEN d=description P_CLOSE)? ALLOW_SUBRACE? BLOCK declBody* END;

subclassDecl:       SUBCLASS name=IDENTIFIER (dispName=description)? FOR cls=IDENTIFIER (P_OPEN d=description P_CLOSE)? BLOCK declBody* END;

subRaceDecl:        SUBRACE name=IDENTIFIER (dispName=description)? FOR race=IDENTIFIER (P_OPEN d=description P_CLOSE)? BLOCK declBody* END;

itemDecl:           ITEM name=IDENTIFIER (dispName=description)? (P_OPEN d=description P_CLOSE)? worth=CURRENCY_LIT weight=WEIGHT_LIT P_OPEN traits=identifierSet P_CLOSE BR_OPEN tags=identifierSet BR_CLOSE BLOCK (declBody)* END;

spellDecl:          SPELL name=IDENTIFIER (dispName=description)? (P_OPEN d=description P_CLOSE)? BLOCK declBody* END;

backgroundDecl:     BACKGROUND name=IDENTIFIER (dispName=description)? (P_OPEN d=description P_CLOSE)? BLOCK declBody* END;

abilityDecl:        ABILITY name=IDENTIFIER (dispName=description)? (P_OPEN d=description P_CLOSE)? SEMI;

skillDecl:          SKILL name=IDENTIFIER (dispName=description)? (P_OPEN d=description P_CLOSE)? DEPENDS_ON ability=IDENTIFIER SEMI;

traitDecl:          TRAIT name=IDENTIFIER (dispName=description)? (P_OPEN d=description P_CLOSE)? BLOCK declBody* END;

itemTagDecl:        ITEM_TAG name=IDENTIFIER (dispName=description)? (P_OPEN d=description P_CLOSE)? SEMI;

itemTraitDecl:      ITEM_TRAIT name=IDENTIFIER (dispName=description)? (P_OPEN d=description P_CLOSE)? BLOCK declBody* END;

damageDecl:         DAMAGE name=IDENTIFIER (dispName=description)? (P_OPEN d=description P_CLOSE)? SEMI;

declBody:           funDecl;

funDecl:            FUN name=IDENTIFIER P_OPEN identifierSet P_CLOSE BLOCK stmt* END;

identifierSet:      (IDENTIFIER (COMMA IDENTIFIER)*)?;

stmt:               expr SEMI                                               #exprStmt
    |               BLOCK stmt* END                                         #blockStmt
    |               IF P_OPEN expr P_CLOSE stmt (ELSE stmt)?                #ifStmt
    |               WHILE P_OPEN expr P_CLOSE stmt                          #whileStmt
    |               FOR P_OPEN v=IDENTIFIER IN expr P_CLOSE stmt            #forStmt
    |               v=ref (ASSIGN|PLUS_ASSIGN|MINUS_ASSIGN|MULT_ASSIGN|DIV_ASSIGN|MOD_ASSIGN) expr SEMI
                                                                            #assignStmt;

ref:                base=expr DOT name=IDENTIFIER                           #dotRef
    |               base=expr BR_OPEN expr BR_CLOSE                         #indexRef
    |               name=IDENTIFIER                                         #nameRef;

args:               (expr (COMMA expr)*)?;

expr:               literal                                                 #literalExpr
    |               name=IDENTIFIER                                         #identifierExpr
    |               base=expr DOT name=IDENTIFIER                           #dotExpr
    |               base=expr BR_OPEN expr BR_CLOSE                         #indexExpr
    |               IDENTIFIER P_OPEN args P_CLOSE                          #functionCallExpr
    |               P_OPEN expr P_CLOSE                                     #parenExpr
    |               expr (MULT|DIV|MOD) expr                                #multExpr
    |               expr (PLUS|MINUS) expr                                  #addExpr
    |               expr (GT|LT|GE|LE|EQ|NE) expr                           #compExpr
    |               expr (AND|OR) expr                                      #boolExpr;

literal:            NUMBER                                                  #numberLit
       |            DICE_LIT                                                #rawDiceLit
       |            DIST_LIT                                                #distanceLit
       |            CURRENCY_LIT                                            #currencyLit
       |            WEIGHT_LIT                                              #weightLit
       |            description                                             #stringLit;

description:        STRING_LIT                                              #stringDescr
           |        STRINGS DOT name=IDENTIFIER                             #refDescr;