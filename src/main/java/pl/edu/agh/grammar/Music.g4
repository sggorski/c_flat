grammar Music;

program : imports* functionDecl* mainDecl? EOF;

imports
    : IMPORT STRING_VAL ';'
    ;

functionDecl
    : 'melody' ID LP parameters? RP '{' statement* '}'
    ;

mainDecl
    : 'melody' 'main' LP  RP '{' mainStatement* '}'
    ;

parameters
    : parameter (',' parameter)*
    ;

parameter
    : type ID
    ;

type
    : INT
    | BOOL
    | CHORD
    | NOTE;

mainStatement
    : statement
    |  trackStatements;

statement
    : functionDecl
    | assignment
    | selfAssignment
    | settings
    | varDecl
    | playStatement
    | pauseStatement
    | controlStatement
    | exprStatement
    ;

exprStatement
    : expr SEMICOLON;

loopStatement
    : breakStatement
    | continueStatement ;


settings
    : SET settingsAssigment ';';

settingsAssigment
    : PACE '=' (INT_VAL|ID)#pace
    | SUSTAIN '=' (INT_VAL|ID) #sustain
    | INSTRUMENT '=' (INSTRUMENT_VALUE|ID) #instrument
    | DISTORTION '=' (INT_VAL|ID) #distortion
    | JAZZ '=' (BOOL_VAL|ID) #jazz
    | BLUES '=' (BOOL_VAL|ID) #blues
    | VOLUME '=' (INT_VAL|ID) #volume
    | VIBRATO '=' (INT_VAL|ID) #vibrato
    | BALANCE '=' (INT_VAL|ID) #balance
    | SOSTENUTO '=' (INT_VAL|ID) #sostenutoPedal
    | SOFT '=' (INT_VAL|ID) #softPedal
    | RESONANCE '=' (INT_VAL|ID) #resonance
    | REVERB '=' (INT_VAL|ID) #reverb
    | TREMOLO '=' (INT_VAL|ID) #tremolo
    | CHORUS '=' (INT_VAL|ID) #chorus
    | PHRASER '=' (INT_VAL|ID) #phraser
    ;

settingsValues
    : PACE
    | SUSTAIN
    | INSTRUMENT
    | DISTORTION
    | JAZZ
    | BLUES
    | VOLUME
    | VIBRATO
    | BALANCE
    | SOSTENUTO
    | SOFT
    | RESONANCE
    | REVERB
    | TREMOLO
    | CHORUS
    | PHRASER
    ;

assignment
    : ID '=' expr ';'
    ;

selfAssignment
    : ID assOp expr ';';

varDecl
    : type ID '=' expr ';' #varDeclWithARg
    | type ID ';' #varDeclWithoutArg
    ;

playStatement
    : PLAY playValues ';'
    ;

playValues
    : NOTE_VAL (INT_VAL | ID)                                # playNote
    | chord (INT_VAL | ID)                                   # playChord
    | functionCall  ('OUT' ID)?                              # playFunc
    | ID (INT_VAL | ID)?                                     # playIDVariants
    | (multiPlayValues)+                                     # playMulti
    ;

multiPlayValues:
    (NOTE_VAL | chord | ID)+ (INT_VAL | ID);

pauseStatement
    : PAUSE (INT_VAL|ID) ';';

controlStatement
    : 'while' '(' expr ')' '{' (statement|loopStatement)+'}' #whileLoop
    | 'if' '(' ifexpre=expr ')' '{' (statement|loopStatement)+ '}' ('else' 'if' '(' expr ')' '{' (statement|loopStatement)+ '}')* ('else' '{' (statement|loopStatement)+ '}')? #if
    | 'for' '(' forInit? ';' expr? ';' forUpdate? ')' '{' (statement|loopStatement)+ '}' #forLoop
    ;


forInit
    : ID
    | type ID '=' expr
    | ID '=' expr
    ;

forUpdate
    : functionCall
    | forAssignment;

forAssignment
    :  ID '=' expr
    |  ID assOp expr;

breakStatement
    : 'break' ';' ;

continueStatement
    : 'continue' ';' ;

functionCall
    : ID '(' arguments* (',')? settingsList? ')'
    ;

arguments
    : expr (',' expr)*
    ;

settingsList
    : settingsAssigment (',' settingsAssigment)*
    ;

expr
    : LP expr RP  #paranthesesExpr
    | NOT expr #notExpr
    | expr mullDivOp expr #mullDivOperatorExpr
    | expr addSubOp expr #addSubOperatorExpr
    | expr orderOp expr #orderOperatorExpr
    | expr eqOp expr #eqOperatorExpr
    | expr andOp expr #andOperatorExpr
    | expr orOp expr #orOperatorExpr
    | INSTRUMENT eqOp INSTRUMENT_VALUE #instrumentOperatorExpr
    | chord #chordExpr
    | settingsValues #settingsExpr
    | intVal #intExpr
    | BOOL_VAL #boolExpr
    | NOTE_VAL #noteExpr
    | ID #idExpr

    ;


orderOp
    : LT  | GEQ | LEQ |  GT ;

eqOp:
     EQ | NEQ;


andOp
    :  AND;

orOp
    : OR;

addSubOp
    : SUB | ADD;

mullDivOp
    : DIV | MUL | PER;

assOp
    : SUMIS | SUBIS | MULIS | DIVIS ;

chord
    : '[' NOTE_VAL (',' NOTE_VAL) + ']';

trackStatements
    : trackStatement #trackAdd
    | trackDeclaration #trackDeclare
    ;

trackStatement
    : ID 'ADD' functionCall ';' ;

trackDeclaration
    : TRACK ID ';';

intVal
    : ('-'|'+')? INT_VAL;

IMPORT: 'import';

INT: 'int';
BOOL: 'bool';
CHORD: 'Chord';
NOTE: 'Note';
TRACK : 'Track';

BOOL_VAL: 'true' | 'false';
INT_VAL : [1-9][0-9]* | '0' ;
NOTE_VAL : [CDEFGABH]('#'|'b')?[01234] | [CDEFGABH]('#'|'b')?'-1' | [CDEFGABH]('#'|'b')?'-2';
STRING_VAL: '"' (ESC|.)*? '"';
ESC : '\\"' | '\\\\' ;

PACE: 'PACE';
DISTORTION : 'DISTORTION';
VOLUME : 'VOLUME';
JAZZ : 'JAZZ';
BLUES : 'BLUES';
INSTRUMENT : 'INSTRUMENT';
SUSTAIN : 'SUSTAIN';
VIBRATO : 'VIBRATO';
BALANCE : 'BALANCE';
SOSTENUTO : 'SOSTENUTO';
SOFT : 'SOFT';
RESONANCE : 'RESONANCE';
REVERB : 'REVERB';
TREMOLO : 'TREMOLO';
CHORUS : 'CHORUS';
PHRASER : 'PHRASER';

INSTRUMENT_VALUE : 'PIANO' | 'HARPSICHORD' | 'XYLOPHONE' | 'ORGAN' | 'CHURCH_ORGAN' | 'ACCORDION' | 'HARMONICA' |
                   'GUITAR' | 'ELECTRIC_GUITAR' | 'BASS' | 'VIOLIN' | 'VIOLA' | 'CELLO' | 'CONTRABASS' | 'HARP' |
                   'TRUMPET' | 'TROMBONE' | 'TUBA' | 'SAXOPHONE' | 'OBOE' | 'ENGLISH_HORN' | 'BASSOON' |
                   'CLARINET' | 'FLUTE' |'DRUMS' ;

SET : 'SET';
PLAY : 'PLAY';
PAUSE : 'PAUSE';

SUMIS : '+=';
DIVIS : '/=';
MULIS : '*=';
SUBIS : '-=';

LP : '(';
RP : ')';
EQ : '==';
NEQ : '!=';
GT : '>';
LT : '<';
GEQ : '>=';
LEQ : '<=';
DIV : '/';
MUL : '*';
ADD : '+';
SUB : '-';
PER : '%';

AND : 'AND' ;
OR : 'OR' ;
NOT : 'NOT' ;


LINE_COMMENT: '//' ~[\r\n]* -> skip ;
BLOCK_COMMENT: '/*' .*? '*/' -> skip ;
ID : [a-zA-Z_][a-zA-Z_0-9]* ;
WS : [ \t\r\n]+ -> skip ;
SEMICOLON : ';';
