# c_flat
Interpretowany język do zapisu muzyki pozwalający wykonywać proste jak i bardziej zaawansowane melodie.

## Instalacja

Aby zainstalować nasz interpreter CFlat, postępuj zgodnie z poniższymi krokami.  
**Wymagane jest posiadanie zainstalowanego JDK w wersji 21.**

---

### 1. Pobierz plik ZIP z interpreterm

Pobierz najnowszą wersję naszego interpretera z poniższego linku: [Link](https://drive.google.com/drive/folders/1ATRqf2of5x2dkOJZIdNhpwM69bydQftP?usp=sharing)

### 2. Rozpakuj archiwum

Rozpakuj pobrany plik ZIP do wybranego folderu na swoim komputerze.

---

### 3. Dodaj folder z programem do zmiennej środowiskowej PATH

Aby móc uruchamiać interpreter z dowolnego miejsca w terminalu, dodaj folder, w którym znajdują się pliki programu, do zmiennej środowiskowej `PATH`.

#### Windows

1. Otwórz **Panel sterowania** → **System** → **Zaawansowane ustawienia systemu** → **Zmienne środowiskowe**.
2. W sekcji „Zmienne systemowe” znajdź zmienną `Path` i kliknij **Edytuj**.
3. Dodaj ścieżkę do folderu z rozpakowanym interpreterm.
4. Zatwierdź zmiany.

### 4. Uruchamianie interpretera

Od tej pory możesz uruchamiać interpreter poleceniem: `cflat <nazwa_pliku>`

### 5. Instalacja wtyczki do kolorowania składni w Visual Studio Code

W folderze z interpreterm znajduje się plik `cflat-0.0.1.vsix` – jest to rozszerzenie do kolorowania składni dla plików `.cb` w edytorze VSCode.

Aby zainstalować rozszerzenie:

1. Otwórz **Visual Studio Code**.
2. Przejdź do zakładki **Extensions** (Rozszerzenia).
3. Kliknij ikonę z trzema kropkami w prawym górnym rogu.
4. Wybierz **Install from VSIX...** lub **Wczytaj rozszerzenie z pliku VSIX**.
5. Wskaż plik `cflat-0.0.1.vsix` z folderu, w którym rozpakowałeś interpreter.
6. Po instalacji składnia plików z rozszerzeniem `.cb` będzie kolorowana.

---

Twój interpreter jest gotowy do użycia!

## Opis techniczny języka
Opis techniczny języka dostępny po kliknięciu linku obok.: [Opis](technical_description.md)

## Dokumentacja dla użytkownika

1. **Struktura kodu źródłowego:**
- zaimportowanie bibliotek (instrukcja `include`)
- zaimportowanie własnych plików z kodem (instrukcja `import`)
- deklaracje zmiennych globalnych
- deklaracje funkcji
- deklaracja funkcji `main`

2. **Importowanie bibliotek:** \
Język udostępnia następujące biblioteki standardowe:
- **blueslib** z funkcjami: `blues_baseline, blues_progression, major_blues_pentatonic, major_blues_pentatonic_reversed, minor_blues_pentatonic, minor_blues_pentatonic_reversed`
- **chordslib** z funkcjami: `augmented_chord, diminished_chord, dominant_seventh_chord, fifth_chord, major_chord, major_seventh_chord, minor_chord, minor_seventh_chord, sus2_chord, sus4_chord`
- **jazzlib** z funkcjami: `jazz_baseline, jazz_progression`
- **orientalscaleslib** z funkcjami: `arabic_scale, arabic_scale_reversed, byzantine_scale, byzantine_scale_reversed, chinese_scale, chinese_scale_reversed, egyptian_scale, egyptian_scale_reversed, gypsy_scale, gypsy_scale_reversed, hindu_scale, hindu_scale_reversed, japan_scale, japan_scale_reversed, jewish_scale, jewish_scale_reversed, mongolian_scale, mongolian_scale_reversed, pershian_scale, pershian_scale_reversed`
- **passageslib** z funkcjami: `augmented_passage, augmented_passage_reversed, diminished_passage, diminished_passage_reversed, dominant_seventh_passage, dominant_seventh_passage_reversed, fifth_passage, fifth_passage_reversed, major_passage, major_passage_reversed, major_seventh_passage, major_seventh_passage_reversed, minor_passage, minor_passage_reversed, minor_seventh_passage, minor_seventh_passage_reversed, sus2_passage, sus2_passage_reversed, sus4_passage, sus4_passage_reversed`
- **progressionslib** z funkcjami: `I_III_IV_vi_progression, I_IV_V_progression, I_ii_iv_progression, I_vi_vi_IV_progression, I_vi_IV_V_progression, i_VII_V_progression, i_VII_VII_VII_progression, IV_V_I_vi_progression, vi_IV_I_V_progression`
- **scaleslib** z funkcjami: `chromatic_scale, chromatic_scale_reversed, dorian_scale, dorian_scale_reversed, locrian_scale, locrian_scale_reversed, lydian_scale, lydian_scale_reversed, major_pentatonic_scale, major_pentatonic_scale_reversed, major_scale, major_scale_reversed, minor_harmonic_scale, minor_harmonic_scale_reversed, minor_melodic_scale, minor_melodic_scale_reversed, minor_neutral_scale, minor_neutral_scale_reversed, minor_pentatonic_scale, minor_pentatonic_scale_reversed, mixolydian_scale, mixolydian_scale_reversed, phrygian_scale, phrygian_scale_reversed, whole_tone_scale, whole_tone_scale_reversed`\
Funkcje skali, pasaży, linii basu i progresji jako argumenty przyjmują kolejno: tonikę (dźwięk bazowy, typ `Note`), liczbę powtórzeń (typ `int`),  długość pojedynczego dźwięku (typ `int`), funkcje akordów tylko tonikę i długość trwania akordu. \
Zaimportowanie biblioteki wraz z jej funkcjami można wykonać na 2 sposoby:
- `include <nazwa_biblioteki>;` zaimportuje całą daną bibliotekę (wszystkie jej funkcje), np: `include blueslib;`
- `include <nazwa_biblioteki>.<nazwa_funkcji>;` zaimportuje tylko wybraną funkcję z danej biblioteki, np. `include blueslib.blues_progression;`

3. **Importowanie plików własnych:**\
Odbywa się z wykorzystaniem instrukcji `import`, po której należy umieścić ścieżkę do importowanego pliku w cudzysłowach, np.\
`import "utils/zwrotka.cb";`\
W importowanych plikach nie mogą występować zmienne globalne.

4. **Deklaracje zmiennych:**\
W języku Cb występuje 5 rodzajów zmiennych:
- `int` reprezentująca liczbę całkowitą
- `bool` reprezentująca wartość logiczną; możliwe wartości to `true` i `false`
- `Note` reprezentująca nutę; możliwe są wartości od `C-2` do `H4` stanowiące niemal pełny zakres 88 dźwięków standardowego fortepianu; możliwe jest wykorzystanie znaku `#` jako muzycznego krzyżyka (półton w górę, np `F#3`) oraz litery `b` jako muzycznego bemola (półton w dół, np. `Cb2`)
- `Chord` reprezentująca akord; budowa jest następująca - w nawiasach kwadratowych należy podać listę dźwięków (min. 2 różne) oddzielonych przecinkami, np. `[C2, E2, G2]`
- `Track` reprezentująca ścieżkę - zaawansowaną strukturę melodii omówioną w dalszej części dokumentacji\
W nazwach zmiennych mogą wystąpować duże i małe litery, cyfry i znak `_`; nazwa musi zaczynać się od litery.\
Deklaracja zmiennej może odbywać się na 2 sposoby:
- `<typ> <nazwa_zmiennej>;` - w tym przypadku zmiennej nie jest przypisywana wartość inicjalna: zmienne typu `Track, Note, Chord` nie będą miały wartości, zmienne typu `int, bool` będą miały wartości domyślne, tj. 0 dla typu `int` i `false` dla typu `bool`\
np. `int a;`, `bool zmienna;`, `Note nuta;`, `Chord ch1;`
- `<typ> <nazwa_zmiennej> = <wartość>;` - w tym przypadku do zmiennej zostanie przypisana podana wartość - może to być zwykła wartość, inna zmienna tego samego typu lub wyrażenie (omówione w dalszej części dokumentacji)\
np. `int a = 15;`, `bool b = true;`, `Note nuta2 = C2;`, `Chord c = [C2, E2, G2];`\

5. **Deklaracje funkcji**\
Odbywają się zgodnie z użyciem słowa kluczowego `melody`, po którym następuje nazwa funkcji (zasady tworzenia nazw analogiczne jak w przypadku zmiennych), lista parametrów w nawiasach okrągłych i ciało funkcji w nawiasach klamrowych: `melody  <nazwa_funkcji> (<lista parametrów>) {...}`\
np. `melody zwrotka(int dlugosc, Note start) {...}`

6. **Deklaracja funkcji main** to szczególny przypadek deklaracji funkcji, musi być zadeklarowana jako `melody main() {...}` w pliku startowym (tym który jest uruchamiany), musi być dokładnie 1 taka deklaracja dla całego programu (nie może wystąpić w innych importowanych plikach)

7. **Komentarze**
- komentarz liniowy `//` komentujący daną linijkę od miejsca jego wystąpienia aż do końca linii
- komentarz blokowy `/* ... */` komentujący cały blok kodu między znacznikami początku i końca komentarza (także wielolinijkowo)

8. **Ustawienia**\
Ustawiane z wykorzystaniem instrukcji `SET` po której następuje nazwa modyfikowanego parametru i przypisanie wartości: `SET <parametr> = <wartość>;`, np. `SET INSTRUMENT=PIANO;`. Możliwe parametry to:
- `PACE` typu `int` modyfikujący głośność melodii w zakresie `0..127`
- `SUSTAIN` typu `int` modyfikujący podtrzymanie dźwięku w zakresie `0..127`
- `INSTRUMENT` ustawiający instrument grający daną melodię; możliwe wartości to: `PIANO, HARPSICHORD, XYLOPHONE, ORGAN, CHURCH_ORGAN, ACCORDION, HARMONICA,
    GUITAR, ELECTRIC_GUITAR, BASS, VIOLIN, VIOLA, CELLO, CONTRABASS, HARP,
    TRUMPET, TROMBONE, TUBA, SAXOPHONE, OBOE, ENGLISH_HORN, BASSOON,
    CLARINET, FLUTE, BELLS, DRUMS`
- `DISTORTION` typu `int` modyfikujący zniekształcenie dźwięku w zakresie `0..127`
- `JAZZ` typu `bool` ustawiający tryb jazz - losowe podnoszenie/obniżanie dźwięków
- `BLUES` typu `bool` ustawiający tryb blues
- `VOLUME` typu `int` modyfikujący głośność w zakresie `0..127`
- `VIBRATO` typu `int` modyfikujący wibrację dźwięku w zakresie `0..127`
- `BALANCE` typu `int` modyfikujący zbalansowanie stereo dźwięku L-P w zakresie `0..127`
- `SOSTENUTO` typu `int` działający jak środkowy pedał fortepianu w zakresie `0..127`
- `SOFT` typu `int` działający jak lewy pedał fortepianu (przyciszenie) w zakresie `0..127`
- `RESONANCE` typu `int` wzmacniający częstotliwość w zakresie `0..127`
- `REVERB` typu `int` modyfikujący pogłos w zakresie `0..127`
- `TREMOLO`  typu `int` modyfikujący wahania głosności w zakresie `0..127`
- `CHORUS`  typu `int` emulujący dźwięk w zakresie `0..127`
- `PHRASER`  typu `int` modyfikujący efekt falowania w zakresie `0..127` \
Ustwienie jest lokalne dla danej funkcji, można je modyfikować przy wywołaniu przesyłając w liście parametrów, np. `(..., REVERB=80);` lub bezpośrednio w ciele funkcji.

9. **Komendy PLAY i PAUSE**\
Komenda `PAUSE` oznacza pauzę (ciszę) przez zadaną liczbę milisekund, tj. `PAUSE <ms>;`, np. `PAUSE 500;`. Możliwe jest także użycie wartości typu `int` zapisanej w zmiennej, np. `PAUSE a;`. \
Komenda `PLAY` oznacza zagranie określonego fragmentu przez określony czas. Zagrać można:
- pojedynczą nutę, np. `PLAY C2 400;` (możliwe wykorzystanie zmiennych, np. `PLAY nuta dlugosc;`)
- sekwencję nut, np. `PLAY C2 E2 G2 400;` (możliwe wykorzystanie zmiennych), czas odnosi się do długości pojedynczej nuty, nie wszystkich
- akord, np. `PLAY [C2, E2, G2] 400;` (możliwe wykorzystanie zmiennych)
- nuty i akordy na zmianę, np `PLAY [C2, E2], D2 E2 [E2, G2] C3 500;`
- funkcję (melodię), np. `PLAY zwrotka();` (szersze omówienie w dalszej części dokumentacji)

10. **Scope'y**\
W języku możliwe jest tworzenie bloków kodu (scope'ów) z wykorzystaniem nawiasów klamrowych `{ ... }`. Tworzone są one automatycznie na potrzeby funkcji oraz instrukcji sterujących (pętli i wyrażeń warunkowych - omówione dalej). Możliwe jest w nich przesłanianie zmiennych (tj. definiowanie zmiennych o tych samych nazwach co inne zmienne). Możliwe jest odnoszenie się do zmiennych z wyższych scope'ów (i w konsekwencji także do zmiennych globalnych) z użyciem instrukcji `up:` (instrukcję `up:` można stackować celem odnoszenia się do odpowednich scope'ów nadrzędnych, np. `up:up:up:i`, aż do zmiennych globalnych), np.

```
int i=500;
{
    int i=5;        // są to 2 niezależne zmienne, 2. kończy żywot wraz z klamrą zamykającą scope
    PLAY C2 up:i;   // C2 będzie brzmieć przez 500 milisekund
}
```

11. **Wywoływanie funkcji i zwrot wartości**\
Wywołanie funkcji odbywa się z poziomu innej funkcji (w tym także `main`) z wykorzystaniem instrukcji `PLAY`, tj. `PLAY nazwa_funkcji(parametry);`. Parametry muszą być przekazane w takiej kolejności w jakiej występują w deklaracji funkcji. Możliwe jest umieszczenie po nich ustawień. Całość może mieć więc postać np. `PLAY zwrotka(C2, 3, 500, INSTRUMENT=PIANO, PACE=50);`. Możliwe jest też oczywiście tworzenie funkcji bezargumentowych.\
Zwrot wartości z funkcji odbywa się z wykorzystaniem instrukcji `RETURN`. "Odebranie" jej w funkcji wywołującej wymaga użycia instrukcji `OUT` przy wywołaniu funkcji. Zwrot musi być przypisany do zmiennej tego samego typu co zwracana wartość, np.
```
melody mel1() {
    RETURN C2;
}

melody main() {
    Note n;
    PLAY mel1() OUT n;
    // n będzie miało wartość C2
}
```

12. **Instrukcja PRINT**\
Jest to instrukcja czysto pomocniczna np. podczas debuggingu, umożliwia wypisanie wartości jakiejś zmiennej na ekran konsoli, np. `PRINT(n);`.

13. **Operacje na zmiennych i operatory**
- **operacje logiczne:** możliwe jest wykonywanie operacji logicznych `AND, OR, NOT` na wartościach logicznych `true` i `false` oraz zmiennych typu `bool`, obsługiwane są także nawiasy dla ustalenia kolejności wykonywania działań, np.
```
bool b1 = true AND (false OR true);
bool b2 = NOT b1 OR false;
```
- **operacje arytmetyczne:** dostępne są operacje `+,-,*,/` na zmiennych typu `int` (dostępne jest także nawiasowanie) z kolejnością wykonywania działań, np. `int i = (10 + 5) * 2;`
- **operacje porównywania** dające w efekcie zmienną typu `bool`: operatory to `==, !=, <, <=, >, >=`. Porównywać można liczby (np. `5 > 2`) i nuty (według wysokości, np. `C2 > C1, E3 == Fb3`)
- **operacje automodyfikacji** zmieniające wartość danej zmiennej: operatory to `+=, -=, *=, /=`, można je wykonywać na nutach i liczbach (np. `int i=5; i+=1;` da `i=6`)
- **operacje na nutach:** można do nuty dodawać/odejmować liczbę przesuwając ją o zadaną liczbę półtonów w górę/w dół (np. `Note n = C2 + 5;` da w wyniku `F5`) oraz mnożyć/dzielić ją przez liczbę przeskakując niniejszym między oktawami (np. `Note n2 = C2 * 2;` przesunie `C2` o 1 oktawę do góry dając `C3`)
- **operacje na akordach:** do akordu można dodawać/odejmować nuty za pomocą operatorów `+=, -=` a także możliwe jest dodawawanie i odejmowanie od siebie akordów, np.
```
Chord ch = [C2, E2];
ch += G2;               // ch = [C2, E2, G2]
Chord ch2 = [C2, E2, G2, H2, C3];
Chord ch3 = ch2 - ch;   // ch3 = [H2, C3];
ch3 += ch;              // ch3 = ch2
```

14. **Instrukcja warunkowa**\
Język udostępnia instrukcje `if, else if, else`. Po `if` i `else if` musi wystąpić warunek (zmienna lub wartość typu `bool`). Wykonany zostanie tylko ta gałąź kodu, której warunek wejścia będzie spełniony, np.
```
if(5 > 6) {
    PLAY C1 500;
} else if(5 > 7) {
    PLAY C2 500;
} else if(5 < 7) {
    // tu warunek jest spełniony, zagrane zostanie C3
    PLAY C3 500;
} else {
    // else wykona się zawsze gdy żaden z warunków nie został spełniony
    PLAY c4 500;
}
```

15. **Pętle**\
Język udostępnia 2 rodzaje pętli (powtarzane w kółko bloki kodu): `while` i `for`. Składnia nakazuje po `while` umieścić warunek logiczny wejścia do pętli (analogicznie jak w `if`), `for` ma składnię następującą: `for(inicjalizacja_zmiennej; warunek; modyfikacja_zmiennej)`, później następuje ciało pętli, np.
```
Note n = C2;

while(n != C#3) {
    PLAY n 200;
    n += 1;
}
// zagrana zostanie gama chromatyczna, tj. wszystkie dźwięki od C2 do C3 włącznie

for(int i=0; i<5; i+=1) {
    PLAY C2 E2 G2 200;
}
// 5 razy zostanie zagrany pasaż C-dur
```

16. **Break i continue**\
Wewnątrz pętli możliwe jest wykorzystanie instrukcji `break` (zrywającej pętlę po zajściu danego warunku) oraz `continue` (omijającą daną iterację pętli), np.
```
Note n = C2;

while(n != C#3) {
    if (n == E2 OR n == G2) {
        continue;
    }

    PLAY n 200;
    n += 1;
}
// zagrana zostanie gama chromatyczna poza dźwiękami E2 i G2

for(int i=0; i<5; i+=1) {
    PLAY C2 E2 G2 200;
    if(i == 3) {
        break;
    }
}
// 4 razy zostanie zagrany pasaż C-dur, ze względu na zerwanie w czwartej iteracji
```

17. **Rzutowanie**\
Rzutowanie (ang. casting) umożliwia jawną zmianę typu danej zmiennej. Operator castowania to `(nowy_typ)`. W Cb rzutować można:
- typ `int` na typ `bool`: gdy liczba jest równa 0 zmienna logiczna przyjmie wartość `false`, w innym wypadku `true`, np. `bool b = (bool) 15; // b  będzie true`
- typ `bool` na typ `int`: gdy wartość logiczna jest prawdą liczba przyjmie wartość `1`, fałszem - `0`, np. `int i = (int) true; // i=1`
- typ `Note` na typ `int`: rzutowanie to polega na przypisaniu do zmiennej liczbowej wartości nuty w bibliotece MIDI
- typ `int` na typ `Note`: operacja odwrotna do powyższego rzutowania `Note` -> `int`

18. **Struktura Track**\
Jest to zaawansowana struktura pozwalająca na granie utworów polifonicznych (tj. wielogłosowych). Może być utworzona tylko w głównym scope'ie funkcji `main`. Polega na zadeklarowaniu zmiennej tego typu (`Track`) a następnie przypisaniu do niej funkcji z parametrami (instrukcja `ADD`), po czym można taką zmienną typu `Track` zgrać standardowym poleceniem `PLAY`. Grane będą jednocześnie wszystkie melodie, np. zakłądając istnienie funkcji `mel1` i `mel2` można to wykonać tak (obsługiwane są też oczywiście parametry funkcji - jak przy pojedynczym wywołaniu):
```
Track t;
t ADD mel1();
t ADD mel2();
PLAY t;
```
