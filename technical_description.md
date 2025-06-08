# Opis techniczny interpretera języka Cflat

## Dwuprzebiegowość działania interpretera

Działanie interpretera przebiega w dwóch etapach:

1. **Pierwszy przebieg — Listener:**
   - Po sparsowaniu kodu  interpreter uruchamia **listenera**, który przechodzi przez drzewo parsowania.
   - W tym etapie:
     - **Rejestrowane są zmienne**: globalne oraz lokalne w ramach scopów w strukturach `HashMap`.
     - Detekcja **błędów redeklaracji** zmiennych przy pomocy mapy powiązanej stricte z daną funckją lub konretnym scopem.
     - Tworzona jest struktura scopów w formie **drzewa** – każdy scope posiada własną pamięć.
     - **Funkcje** są rejestrowane i zapisywane do mapy na podstawie ich nazw i listy parametrów. Zgłaszane są odpowiednie błędy - język wspiera tylko funckje deklarowane globalnie.

2. **Drugi przebieg — Visitor:**
   - Visitor odwiedza kolejne węzły drzewa i wykonuje odpowiednie akcje.
   - Posiada dostęp do:
     - Globalnej pamięci,
     - Pamięci scopów zdefiniowanych w listenerze,
     - Zarejestrowanych funkcji.
   - W tym etapie realizowane jest właściwe **wykonywanie programu**.

## Kolejność wykonywania działań / operatorów

- Kolejność wykonywania operatorów i instrukcji została osiągnięta poprzez odpowiednią konstrukcję **gramatyki ANTLR4**.
- Reguły zostały zapisane w taki sposób, aby odzwierciedlać **priorytety operatorów** — kolejność reguł oraz ich rekurencyjność determinują, które działania wykonywane są wcześniej.

## Wywoływanie funkcji

- W momencie wywołania funkcji:
  - Jej definicja jest pobierana z pamięci funkcji.
  - Tworzona jest **nowa kopia struktury `Melody`**, odpowiadająca **ramce stosu** dla tej funkcji.
  - Ramka ta trafia na **stos wywołań** — wszystkie instrukcje w funkcji operują na danych z górnej ramki.
  - Każda funkcja posiada:
    - **Własną pamięć** (zarejestrowaną w listenerze),
    - **Własne efekty** (odpowiednio propagowane, funckja domyślnie dziedziczy efekty ze scopa, w którym została wywołana).
- Po zakończeniu działania funkcji, jej ramka jest **ściągana ze stosu**.
- W przypadku wystąpienia instrukcji `return`, zwracana wartość jest **propagowana w górę drzewa parsowania**, aż dotrze do miejsca, gdzie może zostać przypisana do zmiennej lub wyrażenia.

### Castowanie

Mechanizm castowania pozwala na jawne rzutowanie między wybranymi typami (np. `int ↔ Note`, `int ↔ bool`, `Note → int`, `bool ↔ int`) z kontrolą poprawności.  
W przypadku nieobsługiwanej konwersji lub błędnych danych (np. ujemna liczba na nutę) rzucany jest wyjątek `CastError`.

## Scopy

Mechanizm Scopów dla funkcji został omówiony wyżej, tutaj zostanie omówiony mechanizm dla pozostałych przypadków

Pierwszy przebieg:
-   Tworzony jest stos dla Scopów, każdy ze Scopów zawiera pola `parent`, `melodyParent` oraz listę `children`
-   W momencie wejścia do Scope zostaje tworzony nowy obiekt Scope'a, który zostaje następnie dodany do stosu
- Scope, który wcześniej znajdował się najwyżej na stosie staje się rodzicem nowododanego, w przypadku braku takiego Scope'a zamiast tego do pola `melodyParent` zostaje przypisana obecna melodia - czyli funkcja
- Ostatni Scope na stoie  traktowany jest jako aktualny w tym przebiegu - rejestracja zmiennych następuje w pamięci tego Scope'a
- W momencie wyjścia ze Scope'a, zostaje on zdjęty ze stosu i dodany na koniec listy dzieci jego rodzica (`parent` lub `melodyParent`)

Drugi przebieg:
- Rozpoczęcie się Scope'a prowadzi do wyszukania kolejnego Scope'a, który powinien być po aktualnym, jeżeli aktualny Scope nie istnieje oznacza to że obecnym Scopem jest funkcja, w obu przypadkach jako następny Scope wybierane jest pierwsze dziecko z listy Scopów
- Aktualny Scope jest z tym, z którego jako pierwszego będą wyszukiwane zmienne (wyjatkiem jest użycie `up:`),
jeżeli wyszukiwana zmienna nie zostanie znaleziona, następuje przeszukiwanie kolejnych rodziców do momentu znalezienia zmiennej lub dotarcia do sytuacji, w które `parent` jest równe null,
wtedy następuje przeszukanie pamięci funkcji, a na końcu globalnego Scope'a, jeżeli zmienna nie została odszukana następuje wyrzucenie wyjątku `UndefinedError`
- Opuszczenie Scope'a skutkuje ustawieniem aktualnego Scope'a na rodzica (pole `parent`), z rodzica natomiast zostaje usunięte pierwsze dziecko znajdujące się w liście dzieci (ten Scope, z którego wychodzimy)

Użycie return w funkcji:
- Funckja podczas wywołania zapisuje swój adres powrotu (jeżeli byłaby to funkcja to nic się nie dzieje, adresem powrotu jest funkcja, która byłaby na szczycie stosu po tej)
w postaci Scope'a, w której została ona wywołana
- Po użyciu słowa `RETURN` ustawiamy obecny Scope na adres powrotu funkcji


## Instrukcje sterujące - warunkowe i pętle

### Instrukcja if/elseif/else:

Pierwszy przebieg:
- brak

Drugi przebieg:
- Twór if/elseif/else jest poniekąd traktowany jako jedna całość
- Najpierw zostaje sprawdzony warunek if'a
- Jeżeli jest on prawdziwy, następuje przejście do Scope'a tego if'a i wykonujemy to co znajduje się w środku,
następnie usuwamy odpowiednią ilosć Scopów, które odpowiadają elseifom (jeżeli jakieś istnieją) oraz else (jeżeli istnieje)
- W przypadku kiedy expression w if'ie jest fałszywe, zostaje pominięty Scope tego if'a (parent tego Scope'a kasuje swoje dziecko) i przechodzimy do następnej w kolejności instrukcji logicznej
- Jeżeli jest nią else if to postępuje się tak samo jak z if'em, jeżeli to else to po prostu następuje przejście do jego Scope'a i wykonanie instrukcji znajdujących się wewnątrz niego



## Importy

*(TO DO)*

## Biblioteki standardowe

*(TO DO)*

## Sygnalizacja błędów

*(TO DO)*
