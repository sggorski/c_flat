grammar Music;

program : imports* functionDecl* mainDecl? EOF;

imports
    : IMPORT STRING_VAL ';'
    ;

functionDecl
    : 'melody' ID LP parameters? RP '{' statement* '}'
    ;

mainDecl
    : 'melody' 'main' LP  RP '{' statement* '}'
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
    | NOTE
    | TRACK;

statement
    : functionDecl
    | assignment
    | selfAssignment
    | settings
    | varDecl
    | playStatement
    | pauseStatement
    | controlStatement
    | trackStatement
    ;

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
    | KEY '=' (KEY_VAL|ID) #key
    ;

settingsValues
    : PACE
    | SUSTAIN
    | INSTRUMENT
    | DISTORTION
    | JAZZ
    | BLUES
    | VOLUME
    | KEY
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
    : PLAY NOTE_VAL INT_VAL ';' #playNote
    | PLAY ID INT_VAL ';' #playChord
    | PLAY functionCall ';' #playFunc
    | PLAY ID ';' #playTrack
    | PLAY ((ID|NOTE_VAL|chord) ((ID|NOTE_VAL|chord))* (INT_VAL|ID))+ ';' #playMulti
    ;

pauseStatement
    : PAUSE INT_VAL ';';

controlStatement
    : 'while' '(' expr ')' '{' (statement|loopStatement)+'}' #whileLoop
    | 'if' '(' expr ')' '{' (statement|loopStatement)+ '}' ('else' 'if' '(' expr ')' '{' (statement|loopStatement)+ '}')* ('else' '{' (statement|loopStatement)+ '}')? #if
    | 'for' '(' forInit? ';' expr? ';' forUpdate? ')' '{' (statement|loopStatement)+ '}' #forLoop
    ;

forInit
    : ID
    | type ID '=' expr
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
    | chord #chordExpr
    | settingsValues #settingsExpr
    | INT_VAL #intExpr
    | BOOL_VAL #boolExpr
    | KEY_VAL #keyExpr
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

trackStatement
    : ID 'ADD' functionCall ';' ;

IMPORT: 'import';

INT: 'int';
BOOL: 'bool';
CHORD: 'Chord';
NOTE: 'Note';
TRACK : 'Track';

BOOL_VAL: 'true' | 'false';
INT_VAL : '-'?[1-9][0-9]* | '-'?'0' ;
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
KEY : 'KEY';

INSTRUMENT_VALUE : 'PIANO' |  'VIOLIN' | 'DRUMS' | 'HARP';
KEY_VAL : 'C' | 'C#' | 'D' | 'Eb' | 'E' | 'F' | 'F#' | 'G' | 'Ab' | 'A' | 'B' | 'H' |
          'Cm' | 'C#m' | 'Dm' | 'Ebm' | 'Em' | 'Fm' | 'F#m' | 'Gm' | 'G#m' | 'Am' | 'Bm' | 'Hm' ;

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
