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

## Scopy

*(TO DO)*

## Instrukcje sterujące - warunkowe i pętle

*(TO DO)*


## Importy

*(TO DO)*

## Biblioteki standardowe

*(TO DO)*

## Sygnalizacja błędów

*(TO DO)*
