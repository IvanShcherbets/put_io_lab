# Kalkulator ceny zamówienia

Projekt ćwiczeniowy na laboratoria z Gita: jeden plik `Program.java` korzystający
wyłącznie ze standardowej biblioteki Javy. Starter celowo zawiera błędy opisane
poniżej. Przypadki kontrolne pokazują specyfikację, a nie zawsze stan początkowy.

## Uruchamianie

Potrzebujesz JDK 11 lub nowszego. Z głównego katalogu własnego repozytorium:

```bash
java 04-git/Program.java 3 100 10
```

Nie kompiluj osobno. Tryb uruchamiania pliku źródłowego nie wymaga plików `.class`
w katalogu projektu ani narzędzi budowania.

Argumenty, w kolejności:

1. Liczba produktów: liczba całkowita nieujemna, np. `3`; 0 jest dozwolone.
2. Cena jednostkowa: liczba nieujemna, np. `100` lub `19.99`.
3. Rabat procentowy: liczba od 0 do 100 włącznie, np. `10` lub `12.5`.

Używaj kropki dziesiętnej, bez symbolu waluty i bez znaku `%`.
Cena zamówienia to `liczba * cena * (1 - rabat / 100)`.
Wynik jest wypisywany na stdout w formacie `Cena: 270.00` (dwa miejsca po
kropce, niezależnie od ustawień regionalnych); poprawne wykonanie ma kod 0.
Niepoprawne dane oznaczają komunikat na stderr, kod 1 i brak ceny na stdout.
To mały przykład do nauki Gita, nie produkcyjny system rozliczeń: używamy
`double` i małych wartości, nie modelujemy podatków ani zaokrąglania księgowego.

## Przykład bez rabatu

```bash
java 04-git/Program.java 2 50 0
```

Oczekiwany wynik:

```text
Cena: 100.00
```
## Przypadek bez produktów
```bash
java 04-git/Program.java 0 100 0
```

Oczekiwany wynik:

```text
Cena: 0.00
```
## Przypadek z ujemną liczbą produktów.
```bash
java 04-git/Program.java -1 100 0
```

Oczekiwany komunikat:

```text
Błąd: liczba produktów nie może być ujemna.

```
Strumień wyjściowy: stderr

Kod zakończenia: 1

## Przypadki kontrolne

Wykonuj polecenia ręcznie i porównuj wyniki. Nie potrzebujesz frameworka testowego.
W Bash/Git Bash kod zakończenia sprawdzaj przez `echo $?` bezpośrednio po `java`.
Poniższe wyniki są **docelowe**. Nie wymagamy, żeby starter przechodził wszystkie
przypadki przed wykonaniem ćwiczeń.

| Polecenie z głównego katalogu repozytorium | Oczekiwany wynik | Kod |
|---|---|---|
| `java 04-git/Program.java 3 100 10` | stdout: `Cena: 270.00` | 0 |
| `java 04-git/Program.java 2 50 0` | stdout: `Cena: 100.00` | 0 |
| `java 04-git/Program.java 1 19.99 0` | stdout: `Cena: 19.99` | 0 |
| `java 04-git/Program.java 2 -50 0` | stderr: `Błąd: cena musi być nieujemna, a rabat od 0 do 100.` | 1 |
| `java 04-git/Program.java 2 50 101` | stderr: `Błąd: cena musi być nieujemna, a rabat od 0 do 100.` | 1 |
| `java 04-git/Program.java abc 50 0` | stderr: `Błąd: podaj liczbę całkowitą produktów oraz liczbową cenę i rabat.` | 1 |
| `java 04-git/Program.java` | stderr: `Użycie: java 04-git/Program.java liczba cena rabat` | 1 |

## Stan początkowy startera i kolejność pracy

- Zadanie 1: nieaktualny wynik przykładu bez rabatu w opisie powyżej.
- Zadanie 2: niepoprawny tytuł dokumentacji i brak przykładu dla 0 produktów.
- Zadanie 3: ujemna liczba produktów nie jest odrzucana. Docelowy komunikat:
  `Błąd: liczba produktów nie może być ujemna.` na stderr, kod 1.
- Zadanie 4: konflikt propozycji walidacji; po rozwiązaniu 0 pozostaje dozwolone.
- Zadanie 5: rabat odejmowany jest jako kwota, a nie procent ceny zamówienia.
  Starter dla `3 100 10` daje `Cena: 290.00` zamiast `Cena: 270.00`.
  Brakuje też przykładów rabatu 25% i 100%, dodawanych w osobnym worktree.

Ta lista opisuje wersję początkową. Po zakończeniu wszystkich ćwiczeń program
powinien spełniać specyfikację i wszystkie przypadki kontrolne, również te
dopisane podczas pracy.
