grammar Music;

program : functionDecl* mainDecl EOF;

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
    | breakStatement
    | continueStatement
    ;

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
    :PACE
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
    : type ID '=' expr ';' | type ID ';'
    ;

playStatement
    : PLAY NOTE_VAL INT_VAL ';' #playNote
    | PLAY ID INT_VAL ';' #playChord
    | PLAY functionCall ';' #playFunc
    | PLAY ID ';' #playTrack
    ;

pauseStatement
    : PAUSE INT_VAL ';';

controlStatement
    : 'while' '(' expr ')' '{' statement* '}'
    | 'if' '(' expr ')' '{' statement* '}' ('else' 'if' '(' expr ')' '{' statement* '}')* ('else' '{' statement* '}')?
    | 'for' '(' forInit? ';' expr? ';' forUpdate? ')' '{' statement* '}'
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
    : NOTE_VAL #noteExpr
    | INT_VAL #intExpr
    | BOOL_VAL #boolExpr
    | KEY_VAL #keyExpr
    | expr op expr #operatorExpr
    | LP expr RP  #paranthesesExpr
    | chord #chordExpr
    | ID #idExpr
    | settingsValues #settingsExpr
    ;

op
    : LT | EQ | NEQ | GEQ | LEQ |  GT | DIV | MUL | SUB | ADD | PER | AND | OR | NOT ;

assOp
    : SUMIS | SUBIS | MULIS | DIVIS ;

chord
    : '[' NOTE_VAL (',' NOTE_VAL)+ ']';

trackStatement
    : ID 'ADD' functionCall ';' ;

INT: 'int';
BOOL: 'bool';
CHORD: 'Chord';
NOTE: 'Note';
TRACK : 'Track';

BOOL_VAL: 'true' | 'false';
INT_VAL : [0-9]+ ;
NOTE_VAL : [CDEFGABH]('#'|'b')?[01234] | [CDEFGABH]('#'|'b')?'-1' | [CDEFGABH]('#'|'b')?'-2';

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

ID : [a-zA-Z_][a-zA-Z_0-9]* ;
WS : [ \t\r\n]+ -> skip ;
