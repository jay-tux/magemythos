grammar MM;

/* tokens as in lexer */
DOT:                '.';
SEMI:               ';';
COMMA:              ',';

BLOCK:              '{';
END:                '}';
P_OPEN:             '(';
P_CLOSE:            ')';

FS_SEP:             '#~#';

IN:                 'in';
FOR:                'for';
ITEM:               'item';
RACE:               'race';
CLASS:              'class';
SKILL:              'skill';
SPELL:              'spell';
ENABLE:             'enable';
SOURCE:             'source';
ABILITY:            'ability';
STRINGS:            'strings';
SUBRACE:            'subrace';
SUBCLASS:           'subclass';
BACKGROUND:         'background';
DEPENDS_ON:         'depends on';

AUTO_TARGETS:       '$'[A-Z][A-Z_]*;

IDENTIFIER:         [a-zA-Z_][a-zA-Z0-9_]*;
STRING_LIT:         '"'~["]*'"' {setText(getText().substring(1, getText().length()-1));};

NEWLINE:            [\r\n]+ -> channel(HIDDEN);
WS:                 [ \t]+ -> channel(HIDDEN);
COMMENT:            '//'~[\r\n]*[\r\n] -> channel(HIDDEN);

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
        |           skillDecl                                               #dndSkill;

classDecl:          CLASS name=IDENTIFIER (dispName=description)? (P_OPEN d=description P_CLOSE)? BLOCK END;

raceDecl:           RACE name=IDENTIFIER (dispName=description)? (P_OPEN d=description P_CLOSE)? BLOCK END;

subclassDecl:       SUBCLASS name=IDENTIFIER (dispName=description)? FOR cls=IDENTIFIER (P_OPEN d=description P_CLOSE)? BLOCK END;

subRaceDecl:        SUBRACE name=IDENTIFIER (dispName=description)? FOR race=IDENTIFIER (P_OPEN d=description P_CLOSE)? BLOCK END;

itemDecl:           ITEM name=IDENTIFIER (dispName=description)? (P_OPEN d=description P_CLOSE)? BLOCK END;

spellDecl:          SPELL name=IDENTIFIER (dispName=description)? (P_OPEN d=description P_CLOSE)? BLOCK END;

backgroundDecl:     BACKGROUND name=IDENTIFIER (dispName=description)? (P_OPEN d=description P_CLOSE)? BLOCK END;

abilityDecl:        ABILITY name=IDENTIFIER (dispName=description)? (P_OPEN d=description P_CLOSE)? SEMI;

skillDecl:          SKILL name=IDENTIFIER (dispName=description)? (P_OPEN d=description P_CLOSE)? DEPENDS_ON ability=IDENTIFIER SEMI;

description:        STRING_LIT                                              #stringDescr
           |        STRINGS DOT name=IDENTIFIER                             #refDescr;