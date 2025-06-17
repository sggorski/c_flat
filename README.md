# CFlat (C♭) - Music Programming Language

CFlat (C♭) is an interpreted programming language specifically designed for music composition. It allows you to write code that generates musical pieces, from simple melodies to complex polyphonic compositions.

## Overview

CFlat combines programming constructs with musical notation, enabling musicians and programmers to create music through code. The language provides intuitive syntax for musical elements like notes, chords, and tracks, along with programming features like variables, functions, and control structures.

Key features:
- Play individual notes, chords, and complex melodies
- Control musical parameters (instrument, tempo, effects)
- Create polyphonic compositions with multiple tracks
- Use programming constructs (loops, conditionals, functions) for musical patterns
- Import standard musical libraries for scales, chords, and progressions

## Tech Stack

- Java (JDK 21)
- ANTLR4 for grammar definition and parsing
- MIDI for sound generation
- Maven for build management
- Visual Studio Code extension for syntax highlighting

## Installation

### Prerequisites
- Java Development Kit (JDK) 21 or higher

### Steps

1. **Download the interpreter**
   Download the latest version from [this link](https://drive.google.com/drive/folders/1ATRqf2of5x2dkOJZIdNhpwM69bydQftP?usp=sharing)

2. **Extract the archive**
   Extract the ZIP file to a directory of your choice

3. **Add to PATH**
   Add the directory containing the interpreter to your system's PATH environment variable:
   
   **Windows:**
   1. Open Control Panel → System → Advanced system settings → Environment Variables
   2. Find the Path variable and click Edit
   3. Add the path to the directory containing the interpreter
   4. Click OK to save changes

4. **Run the interpreter**
   You can now run the interpreter using the command:
   ```
   cflat <filename>
   ```

5. **Install the VSCode extension**
   For syntax highlighting in Visual Studio Code:
   1. Open Visual Studio Code
   2. Go to Extensions
   3. Click the three dots in the top right corner
   4. Select "Install from VSIX..."
   5. Choose the `cflat-0.0.1.vsix` file from the extracted directory

## Examples

### Hello World (C Major Scale)
```
melody main() {
    SET INSTRUMENT = PIANO;
    PLAY C2 D2 E2 F2 G2 A2 H2 C3 500;
}
```

### Simple Chord Progression
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

### Polyphonic Composition
```
melody melody1() {
    SET INSTRUMENT = PIANO;
    PLAY C2 E2 G2 C3 250;
}

melody melody2() {
    SET INSTRUMENT = BASS;
    PLAY C1 G1 C1 G1 500;
}

melody main() {
    Track track;
    track ADD melody1();
    track ADD melody2();
    PLAY track;
}
```

## Documentation

For more detailed information about the language, please refer to:

- [User Documentation](documentation_eng.md) - Complete guide to language syntax and features
- [Technical Description](technical_description_eng.md) - Technical details about the interpreter implementation

## Authors

- [Paweł Gleindek](https://github.com/pavlvs-91)
- [Kacper Gawroński](https://github.com/Gawronek69)
- [Szymon Górski](https://github.com/sggorski)

Special thanks to [Karol Gawełek](https://github.com/Fizroj) for testing our language and preparing new melodies.

## License

This project is licensed under the terms of the license included in the repository.
