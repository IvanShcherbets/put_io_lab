# System aukcyjny

## Wprowadzenie

Specyfikacja wymagań funkcjonalnych w ramach informatyzacji procesu sprzedaży produktów w oparciu o mechanizm aukcyjny. 

## Procesy biznesowe

---
<a id="bc1"></a>
### BC1: Sprzedaż aukcyjna 

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Opis:** Proces biznesowy opisujący sprzedaż za pomocą mechanizmu aukcyjnego. |

**Scenariusz główny:**
1. [Sprzedający](#ac1) wystawia produkt na aukcję. ([UC1](#uc1))
2. [Kupujący](#ac2) oferuje kwotę za produkt wyższą od aktualnie najwyższej oferty. ([UC2](#uc2), [BR1](#br1))
3. [Kupujący](#ac2) wygrywa aukcję. ([UC3](#uc3), [BR2](#br2))
4. [Kupujący](#ac2) przekazuje należność Sprzedającemu za pośrednictwem systemu. ([UC4](#uc4))
5. [Sprzedający](#ac1) przekazuje produkt Kupującemu, który potwierdza jego otrzymanie. ([UC5](#uc5))

**Scenariusze alternatywne:** 

2.A. Oferta Kupującego została przebita, a [Kupujący](#ac2) pragnie przebić aktualnie najwyższą ofertę.
* 2.A.1. Przejdź do kroku 2.

3.A. Czas aukcji upłynął i [Kupujący](#ac2) przegrał aukcję. ([BR2](#br2))
* 3.A.1. Koniec przypadku użycia.

---

## Aktorzy

<a id="ac1"></a>
### AC1: Sprzedający

Osoba oferująca towar na aukcji.

<a id="ac2"></a>
### AC2: Kupujący

Osoba chcąca zakupić produkt na aukcji.


## Przypadki użycia poziomu użytkownika

### Aktorzy i ich cele

[Sprzedający](#ac1):
* [UC1](#uc1): Wystawienie produktu na aukcję
* [UC3](#uc3): Sprawdzenie wyniku aukcji
* [UC4](#uc4): Dokonanie płatności
* [UC5](#uc5): Potwierdzenie otrzymania produktu
* UC7: Przeglądanie historii ofert
* UC8: Przeglądanie historii płatności

[Kupujący](#ac2)
* [UC2](#uc2): Złożenie oferty na aukcji
* [UC3](#uc3): Sprawdzenie wyniku aukcji
* [UC4](#uc4): Dokonanie płatności
* [UC5](#uc5): Potwierdzenie otrzymania produktu
* UC6: Przeglądanie dostępnych aukcji
* UC7: Przeglądanie historii ofert
* UC8: Przeglądanie historii płatności

---
<a id="uc1"></a>
### UC1: Wystawienie produktu na aukcję

**Aktorzy:** [Sprzedający](#ac1)

**Scenariusz główny:**
1. [Sprzedający](#ac1) zgłasza do systemu chęć wystawienia produktu na aukcję.
2. System prosi o podanie danych produktu i ceny wywoławczej.
3. [Sprzedający](#ac1) podaje dane produktu oraz cenę wywoławczą.
4. System weryfikuje poprawność danych.
5. System informuje o pomyślnym wystawieniu produktu na aukcję.

**Scenariusze alternatywne:** 

4.A. Podano niepoprawne lub niekompletne dane produktu.
* 4.A.1. System informuje o błędnie podanych danych.
* 4.A.2. Przejdź do kroku 2.

---

<a id="uc2"></a>
### UC2: Złożenie oferty na aukcji

**Aktorzy:** [Kupujący](#ac2)

**Scenariusz główny:**
1. [Kupujący](#ac2) zgłasza chęć złożenia oferty na wybranej aukcji.
2. System sprawdza status aukcji i przedstawia aktualną najwyższą ofertę.
3. [Kupujący](#ac2) podaje proponowaną kwotę.
4. System sprawdza poprawność oferty zgodnie z [BR1](#br1).
5. System ponownie weryfikuje status aukcji i aktualną najwyższą ofertę, a następnie zapisuje ofertę i aktualizuje najwyższą oferowaną kwotę.
6. System informuje [Kupującego](#ac2) o pomyślnym złożeniu oferty.

**Scenariusze alternatywne:**

2.A. Na aukcji nie złożono jeszcze żadnej oferty.
* 2.A.1. System przedstawia cenę wywoławczą ustaloną przez [Sprzedającego](#ac1) jako ofertę początkową.
* 2.A.2. Przejdź do kroku 3.

2.B. Aukcja została zakończona.
* 2.B.1. System informuje, że składanie ofert nie jest już możliwe.
* 2.B.2. Koniec przypadku użycia.

4.A. Proponowana kwota jest zbyt niska.
* 4.A.1. System informuje o minimalnej wymaganej kwocie.
* 4.A.2. Przejdź do kroku 3.

5.A. W trakcie składania oferty inny [Kupujący](#ac2) złożył wyższą ofertę.
* 5.A.1. System informuje [Kupującego](#ac2) o zmianie najwyższej oferty.
* 5.A.2. Przejdź do kroku 2.

5.B. Aukcja zakończyła się przed zapisaniem oferty.
* 5.B.1. System informuje, że aukcja została zakończona i oferta nie może zostać przyjęta.
* 5.B.2. Koniec przypadku użycia.

---

<a id="uc3"></a>
### UC3: Sprawdzenie wyniku aukcji

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Scenariusz główny:**

1. [Kupujący](#ac2) lub [Sprzedający](#ac1) zgłasza chęć sprawdzenia wyniku wybranej aukcji.
2. System sprawdza status aukcji.
3. System sprawdza złożone oferty.
4. System ustala zwycięzcę aukcji zgodnie z [BR2](#br2).
5. System przedstawia wynik aukcji oraz kwotę zwycięskiej oferty.
6. System informuje [Kupującego](#ac2), czy wygrał aukcję, lub [Sprzedającego](#ac1), kto został zwycięzcą.

**Scenariusze alternatywne:**

2.A. Aukcja jeszcze się nie zakończyła.
* 2.A.1. System informuje, że aukcja nadal trwa, i przedstawia aktualną najwyższą ofertę.
* 2.A.2. Koniec przypadku użycia.

3.A. Nie złożono żadnej oferty.
* 3.A.1. System informuje, że aukcja zakończyła się bez zwycięzcy.
* 3.A.2. Koniec przypadku użycia.

---

<a id="uc4"></a>
### UC4: Dokonanie płatności

**Aktorzy:** [Kupujący](#ac2), [Sprzedający](#ac1)

**Scenariusz główny:**

1. [Kupujący](#ac2) zgłasza chęć dokonania płatności za wygraną aukcję.
2. System sprawdza wynik aukcji zgodnie z [BR2](#br2).
3. System przedstawia kwotę do zapłaty.
4. [Kupujący](#ac2) dokonuje płatności za pośrednictwem systemu.
5. System weryfikuje poprawność płatności.
6. System rejestruje płatność i przekazuje należność [Sprzedającemu](#ac1).
7. System informuje [Kupującego](#ac2) i [Sprzedającego](#ac1) o pomyślnym zakończeniu płatności.

**Scenariusze alternatywne:**

2.A. [Kupujący](#ac2) nie wygrał aukcji.
* 2.A.1. System informuje, że dokonanie płatności nie jest możliwe.
* 2.A.2. Koniec przypadku użycia.

5.A. Płatność nie została zrealizowana.
* 5.A.1. System informuje [Kupującego](#ac2) o nieudanej płatności.
* 5.A.2. Przejdź do kroku 4.

6.A. Przekazanie należności [Sprzedającemu](#ac1) nie powiodło się.
* 6.A.1. System zapisuje informację o oczekującym przekazaniu środków.
* 6.A.2. System informuje [Sprzedającego](#ac1) o problemie z przekazaniem należności.
* 6.A.3. Koniec przypadku użycia.

---

<a id="uc5"></a>
### UC5: Potwierdzenie otrzymania produktu

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Scenariusz główny:**

1. [Sprzedający](#ac1) zgłasza do systemu chęć uzyskania danych [Kupującego](#ac2) potrzebnych do wysyłki produktu.
2. System udostępnia [Sprzedającemu](#ac1) dane [Kupującego](#ac2) niezbędne do wysyłki.
3. [Sprzedający](#ac1) wysyła produkt [Kupującemu](#ac2).
4. [Sprzedający](#ac1) informuje system o wysłaniu produktu.
5. System aktualizuje status produktu na "Wysłany" i informuje [Kupującego](#ac2).
6. [Kupujący](#ac2) po otrzymaniu i obejrzeniu produktu potwierdza jego odbiór i akceptację w systemie.
7. System aktualizuje status produktu na "Dostarczony" i oznacza aukcję jako zrealizowaną.
8. System informuje [Sprzedającego](#ac1) o zakończeniu transakcji.

**Scenariusze alternatywne:**

2.A. Dane [Kupującego](#ac2) są niekompletne.
* 2.A.1. System informuje [Sprzedającego](#ac1) o braku wymaganych danych.
* 2.A.2. System prosi [Kupującego](#ac2) o uzupełnienie danych.
* 2.A.3. Przejdź do kroku 2 po uzupełnieniu danych.

6.A. [Kupujący](#ac2) nie otrzymał produktu.
* 6.A.1. [Kupujący](#ac2) zgłasza problem z dostarczeniem produktu.
* 6.A.2. System zapisuje zgłoszenie i informuje [Sprzedającego](#ac1).
* 6.A.3. Aukcja pozostaje niezamknięta.
* 6.A.4. Koniec przypadku użycia.

6.B. [Kupujący](#ac2) po obejrzeniu produktu decyduje się go zwrócić.
* 6.B.1. [Kupujący](#ac2) zgłasza chęć zwrotu produktu w systemie.
* 6.B.2. System rejestruje zgłoszenie i informuje [Sprzedającego](#ac1).
* 6.B.3. [Kupujący](#ac2) odsyła produkt [Sprzedającemu](#ac1).
* 6.B.4. [Sprzedający](#ac1) potwierdza otrzymanie zwróconego produktu w systemie.
* 6.B.5. System aktualizuje status produktu na "Zwrócony" i inicjuje zwrot należności [Kupującemu](#ac2).
* 6.B.6. System informuje obie strony o zakończeniu procesu zwrotu.
* 6.B.7. Koniec przypadku użycia.


## Obiewkty biznesowe (inaczje obiekty dziedzinowe lub informatycjne)

### BO1: Aukcja

Aukcja jest formą zawierania transakcji kupna-sprzedaży, w której Sprzedający określa cenę wywoławczą produktu, natomiast Kupujący mogą oferować własną ofertę zakupu każdorazowo proponując kwotę wyższą od aktualnie oferowanej kwoty. Aukcja kończy się po upływie określonego czasu. Jeśli złożona została co najmniej jedna oferta zakupy produkt nabywa ten Kupujący, który zaproponował najwyższą kwotę. 

### BO2: Produkt

Fizyczny lub cyfrowy obiekt, który ma zostać sprzedany w ramach aukcji.

### BO3: Oferta

Oferta jest propozycją zakupu produktu złożoną przez Kupującego w ramach aukcji. Zawiera proponowaną kwotę oraz informacje o Kupującym.

### BO4: Płatność

Płatność jest operacją przekazania należności za wygraną aukcję od Kupującego do Sprzedającego za pośrednictwem systemu.

## Reguły biznesowe

<a id="br1"></a>
### BR1: Złożenie oferty

Złożenie oferty wymaga zaproponowania kwoty wyższej niż aktualnie oferowana o minimum 1,00 PLN.


<a id="br2"></a>
### BR2: Rozstrzygnięcie aukcji

Aukcję wygrywa ten z [Kupujący](#ac2)ch, który w momencie jej zakończenia (upłynięcia czasu) złożył najwyższą ofertę.

## Macierz CRUDL


| Przypadek użycia                                  | Aukcja | Produkt | Oferta | Płatność | 
| ------------------------------------------------- | ------ | ------- | ------ | -------- |
| UC1: Wystawienia produktu na aukcję               |    C   |    C    |    -   |     -    |
| UC2: Złożenie oferty na aukcji                    |    R   |    R    |    C, R|     -    |
| UC3: Sprawdzenie wyniku aukcji                    |    R   |    -    |    R   |     -    |
| UC4: Dokonanie płatności                          |    R   |    -    |    -   |     C, U |
| UC5: Potwierdzenie otrzymania produktu            |    U   |    U    |    -   |     R, U |
| UC6: Przeglądanie dostępnych aukcji               |    L   |    L    |    -   |     -    |
| UC7: Przeglądanie historii ofert                  |    R   |    R    |    L   |     -    |
| UC8: Przeglądanie historii płatności              |    -   |    -    |    -   |     L    |

