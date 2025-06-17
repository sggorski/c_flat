# CFlat (Cb)
An interpreted music notation language that allows playing both simple and more advanced melodies.

## Installation

To install the CFlat interpreter, follow the steps below.  
**JDK version 21 is required.**

---

### 1. Download the interpreter ZIP file

Download the latest version of our interpreter from the following link: [Link](https://drive.google.com/drive/folders/1ATRqf2of5x2dkOJZIdNhpwM69bydQftP?usp=sharing)

### 2. Extract the archive

Extract the downloaded ZIP file to a chosen folder on your computer.

---

### 3. Add the program folder to the PATH environment variable

To run the interpreter from anywhere in the terminal, add the folder containing the program files to the `PATH` environment variable.

#### Windows

1. Open **Control Panel** → **System** → **Advanced system settings** → **Environment Variables**.
2. In the "System variables" section, find the `Path` variable and click **Edit**.
3. Add the path to the folder with the extracted interpreter.
4. Confirm the changes.

### 4. Running the interpreter

From now on, you can run the interpreter with the command: `cflat <filename>`

### 5. Installing the syntax highlighting plugin for Visual Studio Code

In the interpreter folder, there is a file `cflat-0.0.1.vsix` – this is a syntax highlighting extension for `.cb` files in the VSCode editor.

To install the extension:

1. Open **Visual Studio Code**.
2. Go to the **Extensions** tab.
3. Click the three-dot icon in the top-right corner.
4. Select **Install from VSIX...** or **Load extension from VSIX file**.
5. Point to the `cflat-0.0.1.vsix` file in the folder where you extracted the interpreter.
6. After installation, files with the `.cb` extension will have syntax highlighting.

---

Your interpreter is ready to use!

## Technical description of the language
The technical description of the language is available by clicking the link next to it: [technical description](technical_description_eng.md)

## User documentation

### Hello world!
Below are example `Hello world!` programs. A detailed explanation of individual instructions and commands can be found later in the documentation:
- A program playing the `C-major` scale (also known as `do-re-mi-fa-sol-la-si-do`):

```
melody main() {
    SET INSTRUMENT = PIANO;
    PLAY C2 D2 E2 F2 G2 A2 H2 C3 500;
}
```

- A program playing the children's melody "The Cat Climbed the Fence":

```
melody main() {
    SET INSTRUMENT = PIANO;
    PLAY G1 500 E1 E1 250;
    PLAY F1 500 D1 D1 250;
    PLAY C1 E1 250 G1 500;
    PLAY C1 E1 250 G1 500;
    
    PAUSE 500;
    
    PLAY G1 500 E1 E1 250;
    PLAY F1 500 D1 D1 250;
    PLAY C1 E1 250 C1 500;
    PLAY C1 E1 250 C1 500;
    PLAY C0 1000;
}
```

- A program playing the `C-major` cadence:

```
melody main() {
    SET INSTRUMENT = PIANO;
    SET PACE = 500;
    PLAY [C0, C2, E2, G2] 500;
    PLAY [F0, F2, A2, C3] 500;
    PLAY [G0, D2, F2, G2, H2] 500;
    PLAY [C0, C2, E2, G2, C3] 1000;
}
```

### Syntax and semantics of commands

1. **Source code structure:**
- Library imports (`include` instruction)
- Importing custom code files (`import` instruction)
- Global variable declarations
- Function declarations
- `main` function declaration

2. **Comments**  
   A comment is a part of the program code that is ignored by the interpreter - it is used for notes and explanations in the code. The `Cb` language provides 2 types of comments:
- Line comment `//` commenting the line from its occurrence to the end of the line
- Block comment `/* ... */` commenting the entire block of code between the start and end markers (can span multiple lines)

```
// I can write whatever I want here :)

melody main() {
    PLAY C2 E2 G2 500;
    /* PLAY C#2 5000;
    PAUSE 200;
    PLAY B-1 250; */
    // The above fragment will not be executed - it's part of the comment, even though it's valid Cb code
}
```

3. **Variable declarations:**  
   The Cb language has 5 types of variables:
- `int` representing an integer
- `bool` representing a logical value; possible values are `true` and `false`
- `Note` representing a note; possible values range from `C-2` to `H4`, covering almost the full range of 88 notes of a standard piano; the `#` symbol can be used as a sharp (raising the pitch by a semitone, e.g., `F#3`) and the letter `b` as a flat (lowering the pitch by a semitone, e.g., `Cb2`)
- `Chord` representing a chord; the structure is as follows - in square brackets, provide a list of notes (at least 2 different ones) separated by commas, e.g., `[C2, E2, G2]`
- `Track` representing a track - an advanced melody structure discussed later in the documentation  
  Variable names can contain uppercase and lowercase letters, numbers, and the `_` character; the name must start with a letter.  
  Variable declaration can be done in 2 ways:
- `<type> <variable_name>;` - in this case, the variable is not assigned an initial value: variables of type `Track, Note, Chord` will have no value, variables of type `int, bool` will have default values, i.e., 0 for `int` and `false` for `bool`  
  e.g., `int a;`, `bool variable;`, `Note note;`, `Chord ch1;`
- `<type> <variable_name> = <value>;` - in this case, the variable will be assigned the given value - it can be a plain value, another variable of the same type, or an expression (discussed later in the documentation)  
  e.g., `int a = 15;`, `bool b = true;`, `Note note2 = C2;`, `Chord c = [C2, E2, G2];`

```
melody main() {
    int i; // defaults to 0
    bool b = false;
    Note n = C2;
    Chord ch; // will be null - empty value
    ch = [C2, E2, G2,]; // now becomes a C-major chord
    Track t; // more on this later
    PLAY n n n i;   // playing a melody using variables
}
```


4. **Settings**  
   Set using the `SET` instruction followed by the name of the modified parameter and the assigned value: `SET <parameter> = <value>;`, e.g., `SET INSTRUMENT=PIANO;`. Possible parameters are:
- `PACE` of type `int` modifying the melody tempo in the range `0..127`
- `SUSTAIN` of type `int` modifying the note sustain in the range `0..127`
- `INSTRUMENT` setting the instrument playing the melody; possible values are: `PIANO, HARPSICHORD, XYLOPHONE, ORGAN, CHURCH_ORGAN, ACCORDION, HARMONICA,
    GUITAR, ELECTRIC_GUITAR, BASS, VIOLIN, VIOLA, CELLO, CONTRABASS, HARP,
    TRUMPET, TROMBONE, TUBA, SAXOPHONE, OBOE, ENGLISH_HORN, BASSOON,
    CLARINET, FLUTE, BELLS, DRUMS`
- `DISTORTION` of type `int` modifying the sound distortion in the range `0..127`
- `JAZZ` of type `bool` setting the jazz mode - randomly raising/lowering notes
- `BLUES` of type `bool` setting the blues mode
- `VOLUME` of type `int` modifying the volume in the range `0..127`
- `VIBRATO` of type `int` modifying the note vibrato in the range `0..127`
- `BALANCE` of type `int` modifying the stereo balance L-R in the range `0..127`
- `SOSTENUTO` of type `int` acting like the middle piano pedal in the range `0..127`
- `SOFT` of type `int` acting like the left piano pedal (softening) in the range `0..127`
- `RESONANCE` of type `int` amplifying the frequency in the range `0..127`
- `REVERB` of type `int` modifying the reverb in the range `0..127`
- `TREMOLO`  of type `int` modifying volume fluctuations in the range `0..127`
- `CHORUS`  of type `int` emulating the sound in the range `0..127`
- `PHRASER`  of type `int` modifying the phaser effect in the range `0..127`  
  The setting is local to the given function and can be modified when calling by passing it in the parameter list, e.g., `(..., REVERB=80);` or directly in the function body.

```
melody main() {
    SET INSTRUMENT = ORGAN;
    SET PACE = 500;
    SET DISTORTION = 127;
    SET REVERB = 127;
    SET TREMOLO = 0;
    PLAY [D2, F2, A2] 1000;     // the organ sound will be modified according to the defined effects
}
```


5. **PLAY and PAUSE commands**  
   The `PAUSE` command means a pause (silence) for the given number of milliseconds, i.e., `PAUSE <ms>;`, e.g., `PAUSE 500;`. It is also possible to use an `int` value stored in a variable, e.g., `PAUSE a;`.  
   The `PLAY` command means playing a specified fragment for a specified time. You can play:
- a single note, e.g., `PLAY C2 400;` (variables can be used, e.g., `PLAY note duration;`)
- a sequence of notes, e.g., `PLAY C2 E2 G2 400;` (variables can be used), the time refers to the duration of a single note, not all
- a chord, e.g., `PLAY [C2, E2, G2] 400;` (variables can be used)
- alternating notes and chords, e.g., `PLAY [C2, E2], D2 E2 [E2, G2] C3 500;`
- a function (melody), e.g., `PLAY verse();` (more on this later in the documentation)
- a `Track` structure - a polyphonic melody (more on this later in the documentation)

```
melody main() {
    PLAY C2 E2 G2 500;
    PLAY C3 1000;
    PLAY [C2, E2] G2 [C2, E2] C1 250;
    PLAY C2 250 D2 E2 500 F2 G2 A2 1000 H2 C3 500;
}
```


6. **Function declarations**  
   Done using the `melody` keyword, followed by the function name (naming rules analogous to variables), a parameter list in parentheses, and the function body in curly braces: `melody  <function_name> (<parameter list>) {...}`  
   e.g., `melody verse(int duration, Note start) {...}`

7. **Main function declaration** is a special case of function declaration, it must be declared as `melody main() {...}` in the startup file (the one being run), there must be exactly 1 such declaration for the entire program (it cannot occur in other imported files)

```
melody my_melody(Note note, int duration) {
    Note n2 = note + 4;
    PLAY note n2 note n2 note n2 duration;
}

melody main() {
    SET INSTRUMENT = GUITAR;
    PLAY my_melody(C2, 600);
    PAUSE 500;
    PLAY C3 200;
}
```

8. **Scopes**  
   The language allows creating code blocks (scopes) using curly braces `{ ... }`. They are created automatically for functions and control statements (loops and conditional expressions - discussed later). It is possible to shadow variables (i.e., define variables with the same names as other variables). It is possible to refer to variables from higher scopes (and consequently also to global variables) using the `up:` instruction (the `up:` instruction can be stacked to refer to appropriate parent scopes, e.g., `up:up:up:i`, up to global variables), e.g.,

```
int i=1000;

melody main() {
    int i=500;
    {
        int i=5; // these are 2 independent variables, the 2nd one ends its life with the closing brace of the scope
        PLAY C2 up:i; // C2 will sound for 500 milliseconds
    }
    PLAY C1 up:i; // referring to the global variable
}
```

9. **Function calls and return values**  
   Function calls are made from another function (including `main`) using the `PLAY` instruction, i.e., `PLAY function_name(parameters);`. Parameters must be passed in the same order as in the function declaration. Settings can be placed after them. The whole can therefore look like, e.g., `PLAY verse(C2, 3, 500, INSTRUMENT=PIANO, PACE=50);`. Of course, it is also possible to create parameterless functions.  
   Returning a value from a function is done using the `RETURN` instruction. "Receiving" it in the calling function requires using the `OUT` instruction when calling the function. The return must be assigned to a variable of the same type as the returned value, e.g.,
   In a function call you can not only pass parameters, but also specify with which SETTINGS function will be played 
```
melody mel1() {
    PLAY C1 1000;
    RETURN C2;
}

melody mel2(int n){
    PLAY C2 n;
}

melody main() {
    Note n;
    PLAY mel1() OUT n; // n will have the value C2
    PLAY mel2(1000,INSTRUMENT=BELLS, DISTORTION=127); // you can pass settings in a function call, settings that arenot specified will be copied from a current scope
    PRINT(n);
}
```

10. **PRINT instruction**  
    This is a purely auxiliary instruction, e.g., for debugging, it allows printing the value of a variable to the console, e.g., `PRINT(n);`.

11. **Operations on variables and operators**
- **Logical operations:** it is possible to perform logical operations `AND, OR, NOT` on logical values `true` and `false` and variables of type `bool`, parentheses are also supported to determine the order of operations, e.g.,

```
bool b1 = true AND (false OR true);
bool b2 = NOT b1 OR false;
```
- **Arithmetic operations:** the operations `+,-,*,/` are available on variables of type `int` (parentheses are also supported) with the standard order of operations, e.g., `int i = (10 + 5) * 2;`
- **Comparison operations** resulting in a `bool` variable: operators are `==, !=, <, <=, >, >=`. Numbers (e.g., `5 > 2`) and notes (by pitch, e.g., `C2 > C1, E3 == Fb3`) can be compared.
- **Self-modification operations** changing the value of a given variable: operators are `+=, -=, *=, /=`, they can be performed on notes and numbers (e.g., `int i=5; i+=1;` will give `i=6`)
- **Operations on notes:** you can add/subtract a number to/from a note, shifting it by the given number of semitones up/down (e.g., `Note n = C2 + 5;` will result in `F5`) and multiply/divide it by a number, jumping between octaves (e.g., `Note n2 = C2 * 2;` will shift `C2` up by 1 octave, giving `C3`)
- **Operations on chords:** you can add/remove notes to/from a chord using the `+=, -=` operators, and it is also possible to add and subtract chords from each other, e.g.,
```
Chord ch = [C2, E2];
ch += G2; // ch = [C2, E2, G2]
Chord ch2 = [C2, E2, G2, H2, C3];
Chord ch3 = ch2 - ch; // ch3 = [H2, C3];
ch3 += ch; // ch3 = ch2
```

12. **Conditional statement**  
    The language provides `if, else if, else` statements. After `if` and `else if`, a condition (a variable or value of type `bool`) must appear. Only the branch whose entry condition is met will be executed, e.g.,
```
melody main() {
    if(5 > 6) {
        PLAY C1 500;
    } else if(5 > 7) {
        PLAY C2 500;
    } else if(5 < 7) {
        // this condition is met, C3 will be played
        PLAY C3 500;
    } else {
        // else will always execute if none of the conditions are met
        // in this case, it won't, because the 2nd else-if condition was met
        PLAY C4 500;
    }
}
```

13. **Loops**  
    The language provides 2 types of loops (blocks of code repeated over and over): `while` and `for`. The syntax requires placing a logical entry condition after `while` (analogous to `if`), `for` has the following syntax: `for(variable_initialization; condition; variable_modification)`, followed by the loop body, e.g.,
```
melody main() {
    Note n = C2;
    while(n != C#3) {
        PLAY n 200;
        n += 1;
    }
    // a chromatic scale will be played, i.e., all notes from C2 to C3 inclusive
    
    for(int i=0; i<5; i+=1) {
        PLAY C2 E2 G2 200;
    }
    // a C-major passage will be played 5 times
}
```

14. **Break and continue**  
    Inside loops, it is possible to use the `break` instruction (breaking the loop when a given condition is met) and `continue` (skipping a given loop iteration), e.g.,
```
melody main() {
    Note n = C2;
    while(n != C#3) {
        if (n == E2 OR n == G2) {
            continue;
        }
    
        PLAY n 200;
        n += 1;
    }
    // a chromatic scale will be played, excluding the notes E2 and G2
    
    for(int i=0; i<5; i+=1) {
        PLAY C2 E2 G2 200;
        if(i == 3) {
            break;
        }
    }
    // a C-major passage will be played 4 times, due to breaking in the 4th iteration
}
```

15. **Casting**  
    Casting allows explicit type conversion of a variable. The casting operator is `(new_type)`. In Cb, you can cast:
- `int` to `bool`: when the number is 0, the logical variable will be `false`, otherwise `true`, e.g., `bool b = (bool) 15; // b will be true`
- `bool` to `int`: when the logical value is true, the number will be `1`, false - `0`, e.g., `int i = (int) true; // i=1`
- `Note` to `int`: this casting assigns the MIDI library value of the note to the numeric variable
- `int` to `Note`: the reverse operation of the above `Note` -> `int` casting

16. **Track structure**  
    This is an advanced structure allowing for playing polyphonic pieces (i.e., multi-voice). It can only be created in the main scope of the `main` function. It involves declaring a variable of this type (`Track`) and then assigning a function with parameters to it (the `ADD` instruction), after which such a `Track` variable can be played with the standard `PLAY` command. All melodies will be played simultaneously, e.g., assuming the existence of functions `mel1` and `mel2`, this can be done as follows (function parameters are also supported - as in a single call):
```
melody mel1() {
    PLAY C0 C0 500;
}

melody mel2(Note n) {
    Note n2 = n + 4;
    Note n3 = n2 + 3;
    Note n4 = n * 2;
    PLAY n n2 n3 n4 250;
}

melody main() {
    Track t;
    t ADD mel1(INSTRUMENT=BASS);
    t ADD mel2(C2);
    PLAY t;
}
```

17. **Importing libraries:**  
    The language provides the following standard libraries:
- **blueslib** with functions: `blues_baseline, blues_progression, major_blues_pentatonic, major_blues_pentatonic_reversed, minor_blues_pentatonic, minor_blues_pentatonic_reversed`
- **chordslib** with functions: `augmented_chord, diminished_chord, dominant_seventh_chord, fifth_chord, major_chord, major_seventh_chord, minor_chord, minor_seventh_chord, sus2_chord, sus4_chord`
- **jazzlib** with functions: `jazz_baseline, jazz_progression`
- **orientalscaleslib** with functions: `arabic_scale, arabic_scale_reversed, byzantine_scale, byzantine_scale_reversed, chinese_scale, chinese_scale_reversed, egyptian_scale, egyptian_scale_reversed, gypsy_scale, gypsy_scale_reversed, hindu_scale, hindu_scale_reversed, japan_scale, japan_scale_reversed, jewish_scale, jewish_scale_reversed, mongolian_scale, mongolian_scale_reversed, pershian_scale, pershian_scale_reversed`
- **passageslib** with functions: `augmented_passage, augmented_passage_reversed, diminished_passage, diminished_passage_reversed, dominant_seventh_passage, dominant_seventh_passage_reversed, fifth_passage, fifth_passage_reversed, major_passage, major_passage_reversed, major_seventh_passage, major_seventh_passage_reversed, minor_passage, minor_passage_reversed, minor_seventh_passage, minor_seventh_passage_reversed, sus2_passage, sus2_passage_reversed, sus4_passage, sus4_passage_reversed`
- **progressionslib** with functions: `I_III_IV_vi_progression, I_IV_V_progression, I_ii_iv_progression, I_vi_vi_IV_progression, I_vi_IV_V_progression, i_VII_V_progression, i_VII_VII_VII_progression, IV_V_I_vi_progression, vi_IV_I_V_progression`
- **scaleslib** with functions: `chromatic_scale, chromatic_scale_reversed, dorian_scale, dorian_scale_reversed, locrian_scale, locrian_scale_reversed, lydian_scale, lydian_scale_reversed, major_pentatonic_scale, major_pentatonic_scale_reversed, major_scale, major_scale_reversed, minor_harmonic_scale, minor_harmonic_scale_reversed, minor_melodic_scale, minor_melodic_scale_reversed, minor_neutral_scale, minor_neutral_scale_reversed, minor_pentatonic_scale, minor_pentatonic_scale_reversed, mixolydian_scale, mixolydian_scale_reversed, phrygian_scale, phrygian_scale_reversed, whole_tone_scale, whole_tone_scale_reversed`  
  Scale, passage, baseline, and progression functions take the following arguments respectively: the tonic (base note, type `Note`), the number of repetitions (type `int`), the duration of a single note (type `int`), chord functions only take the tonic and the chord duration.  
  Importing a library with its functions can be done in 2 ways:
- `include <library_name>;` will import the entire library (all its functions), e.g.: `include blueslib;`
- `include <library_name>.<function_name>;` will import only the selected function from the library, e.g. `include blueslib.blues_progression;`

```
include blueslib;
include passageslib.major_passage;

melody main() {
    PLAY blues_progression(H1, 1, 1000);
    PLAY major_passage(C2, 2, 500);
}
```
18. **Importing custom files:**  
    Done using the `import` instruction, followed by the path to the imported file in quotes, e.g.,  
    `import "utils/verse.cb";`  
    Imported files must not contain global variables.
```
import "utils/verse_I.cb";
import "chorus.cb";

melody main() {
    PLAY verse_I();
    PLAY chorus();
    // assumes the existence of parameterless functions in the imported files analogous to their names
}
```
