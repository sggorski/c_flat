grammar Music;

program : includes* imports* globalVars? functionDecl* mainDecl? EOF;

globalVars
    : (varDecl ';')+
    ;

includes
    : INCLUDE LIB_VAL ('.' ID)? ';'
    ;

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
    | assignment ';'
    | selfAssignment ';'
    | settings ';'
    | varDecl ';'
    | playStatement ';'
    | pauseStatement ';'
    | controlStatement
    | exprStatement ';'
    | returnStatement ';'
    | continueStatement
    | breakStatement
    | scope
    | print ';'
    ;

print
    : 'PRINT' '(' expr ')';

returnStatement
    : 'RETURN' expr?;

exprStatement
    : expr ;

settings
    : SET settingsAssigment;

settingsAssigment
    : PACE '=' (INT_VAL|(parent)*ID)#pace
    | SUSTAIN '=' (INT_VAL|(parent)*ID) #sustain
    | INSTRUMENT '=' (INSTRUMENT_VALUE|(parent)*ID) #instrument
    | DISTORTION '=' (INT_VAL|(parent)*ID) #distortion
    | JAZZ '=' (BOOL_VAL|(parent)*ID) #jazz
    | BLUES '=' (BOOL_VAL|(parent)*ID) #blues
    | VOLUME '=' (INT_VAL|(parent)*ID) #volume
    | VIBRATO '=' (INT_VAL|(parent)*ID) #vibrato
    | BALANCE '=' (INT_VAL|(parent)*ID) #balance
    | SOSTENUTO '=' (INT_VAL|(parent)*ID) #sostenutoPedal
    | SOFT '=' (INT_VAL|(parent)*ID) #softPedal
    | RESONANCE '=' (INT_VAL|(parent)*ID) #resonance
    | REVERB '=' (INT_VAL|(parent)*ID) #reverb
    | TREMOLO '=' (INT_VAL|(parent)*ID) #tremolo
    | CHORUS '=' (INT_VAL|(parent)*ID) #chorus
    | PHRASER '=' (INT_VAL|(parent)*ID) #phraser
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
    : (parent)*ID '=' expr
    ;

selfAssignment
    : (parent)*ID assOp expr;

varDecl
    : type ID '=' expr #varDeclWithARg
    | type ID  #varDeclWithoutArg
    ;

playStatement
    : PLAY playValues
    ;

playValues
    : NOTE_VAL (INT_VAL | (parent)*ID)                                # playNote
    | chord (INT_VAL | (parent)*ID)                                   # playChord
    | functionCall  ('OUT' (parent)*ID)?                              # playFunc
    | parentID (INT_VAL | parentID)?                                     # playIDVariants
    | (multiPlayValues)+                                     # playMulti
    ;

multiPlayValues:
    (NOTE_VAL | chord | parentID)+ (INT_VAL | parentID);

pauseStatement
    : PAUSE (INT_VAL|(parent)*ID);

controlStatement:
    loop #loopStatement
    | if (elseif)* (else)? #ifStatement;

scope: '{' loopBody '}';

parent: PARENT':';

parentID: parent* ID;

loop:
    'while' '(' expr ')' scope #whileLoop
    | 'for' '(' forInit? ';' expr? ';' forUpdate? ')' scope #forLoop;

loopBody: (statement)+;

if: 'if' '(' expr ')' scope;

elseif: 'else' 'if' '(' expr ')' scope;

else: 'else' scope;

forInit
    : assignment
    | varDecl;

forUpdate
    : playStatement
    | forAssignment;

forAssignment
    :  assignment
    |  selfAssignment;

breakStatement
    : 'break' ';' ;

continueStatement
    : 'continue' ';' ;

functionCall
    : ID '(' arguments? (',')? settingsList? ')'
    ;

arguments
    : expr (',' expr)*
    ;

settingsList
    : settingsAssigment (',' settingsAssigment)*
    ;

expr
    : LP expr RP  #paranthesesExpr
    | LP type RP expr #castExpr
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
    | (parent)*ID #idExpr

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
    : '[' (NOTE_VAL | (parent)*ID) (',' (NOTE_VAL | (parent)*ID))+ ']';

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
INCLUDE: 'include';

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
LIB_VAL: 'blueslib' | 'chordslib' | 'jazzlib' | 'orientalscaleslib' | 'passageslib' | 'progressionslib' | 'scaleslib';

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
                   'CLARINET' | 'FLUTE' | 'BELLS' | 'DRUMS' ;

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

PARENT : 'up';

LINE_COMMENT: '//' ~[\r\n]* -> skip ;
BLOCK_COMMENT: '/*' .*? '*/' -> skip ;
ID : [a-zA-Z_][a-zA-Z_0-9]* ;
WS : [ \t\r\n]+ -> skip ;
SEMICOLON : ';';
