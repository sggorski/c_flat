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
    | settings
    | varDecl
    | playStatement
    | pauseStatement
    | controlStatement
    | trackStatement
    ;


settings
    : SET  settingsAssigment ';';

settingsAssigment
    : PACE '=' INT_VAL #pace
    | SUSTAIN '=' INT_VAL #sustain
    | INSTRUMENT '=' INSTRUMENT_VALUE #instrument
    | DISTORTION '=' INT_VAL #distortion
    | JAZZ '=' BOOL_VAL #jazz
    | BLUES '=' BOOL_VAL #blues
    | VOLUME '=' INT_VAL #volume
    | PACE '=' INT_VAL #pace
    | KEY '=' KEY_VAL #key
    ;

assignment
    : ID '=' expr ';'
    ;

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
    ;

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
    : NOTE_VAL #note
    | INT_VAL #int
    | BOOL_VAL #bool
    | expr op expr #operator
    | LP expr RP  #parantheses
    | chord #chordExpr
    | ID #id
    ;
op
: LT | EQ | NEQ | GEQ | LEQ |  GT | DIV | MUL | SUB | ADD | PER;

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
NOTE_VAL : 'C2' |  'H' |  'C';


PACE: 'PACE';
DISTORTION : 'DISTORTION';
VOLUME : 'VOLUME';
JAZZ : 'JAZZ';
BLUES : 'BLUES';
INSTRUMENT : 'INSTRUMENT';
SUSTAIN : 'SUSTAIN';
KEY : 'KEY';

INSTRUMENT_VALUE : 'PIANO' |  'VIOLIN' | 'DRUMS' | 'HARP';
KEY_VAL : 'Fd' | 'Hd' | 'C1m';

SET : 'SET';
PLAY : 'PLAY';
PAUSE : 'PAUSE';

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

ID : [a-zA-Z_][a-zA-Z_0-9]* ;
WS : [ \t\r\n]+ -> skip ;
