
## Thema: Verzweigungen (`if`, `switch`), logische Operatoren (`!`, `&&`, `||`)

In Teil A ist ein Programm für die Auswahl eines Familienausfluges zu erstellen. Dabei werden vom Benutzer verschiedene Randbedingungen abgefragt, anhand derer die für ihn passende Ausflug-Variante am Ende ausgegeben wird.

In Teil B soll ein Programm erstellt werden, welches die Anzahl der Haltestellen der Hamburger U-Bahn-Linien ausgeben kann. Zusätzlich soll das Programm auch die umgekehrte Abfrage (Inverssuche) ermöglichen, also die Frage beantworten können, welche U-Bahn-Linie eine bestimmte Anzahl an Haltestellen hat.

Um den Umgang mit den verschiedenen Verzweigungen und Operatoren intensiv zu üben, sind in den beiden Teilen nur jeweils einzelne Verzweigungen und/oder Operatoren erlaubt bzw. verboten.

## Anforderungen Teil A

* Ein Programm für die Auswahl eines Familienausfluges ist zu erstellen, welches nacheinander folgende Punkte abfragt:
  1. ob der Benutzer Tiere mag oder nicht (als Eingabe soll hier ein Buchstabe möglich sein: 'j' bzw. 'J' oder 'n' bzw. 'N')
  2. ob er etwas in Hamburg oder außerhalb unternehmen möchte ('j'/'J' für in Hamburg und 'n'/'N' für außerhalb)
* Sucht Euch jeweils passende Datentypen aus, um die Antworten des Benutzers abzulegen!
* Wurden alle Eingaben vorgenommen, berechnet das Programm daraus die passende Ausflugsvariante nach folgendem Schema:
  Es wird geschaut, ob der Benutzer Tiere mag und ob er etwas in Hamburg machen möchte. Je nachdem wird als Ausflugsempfehlung dann Hagenbeck (Tiere, in Hamburg), der Wildpark Schwarze Berge (Tiere, nicht in Hamburg), der Dom (keine Tiere, in Hamburg) oder die Kieler Woche (keine Tiere, nicht in Hamburg) ausgegeben. Das so bestimmte Ausflugsziel wird dem Benutzer dann in der Form „Viel Spaß bei/im/auf ...“ ausgegeben.

  Beispiel 1: Der Benutzer mag Tiere aber nichts in Hamburg. Die Ausgabe ist dann

        Viel Spaß im Wildpark Schwarze Berge!
  Beispiel 2: Der Benutzer mag weder Tiere, noch Hamburg. Die Ausgabe ist dann

        Viel Spaß bei der Kieler Woche!
* Das Programm soll in zwei Versionen erstellt werden. Dabei sollen jeweils folgende Verzweigungen und Operatoren (nicht) verwendet werden:
  1. Erlaubt: `if`, `||`. Verboten: `&&`, `!`, `switch`, `toUpperCase`
  2. Erlaubt: `&&`, `||`, `!`, `toUpperCase`. Verboten: (`if`), `switch`
* Die zweite Version arbeitet nur mit Zuweisungen auf boolesche Variablen. 4 Variablen sind dabei von Euch zu deklarieren (`hagenbeck`, `dom`, `wildpark`, `kielerWoche`). Innerhalb der Zuweisungen sind nur `&&` und `||` erforderlich!
  Erst im Ausgabeteil ist `if` dann erlaubt, um jeweils zu prüfen, welche der 4 möglichen Ausgaben erfolgen muss. Dazu ein Beispiel:

    ```java
    if (hagenbeck) {
        System.out.println("Viel Spaß in Hagenbeck!");
    }
    ```
  Nutzt `if` hier wirklich nur für solche simplen Einzeiler zur Ausgabe. Es dürfen keine `else`-Teile und keine Logik in diesem Abschnitt mehr vorkommen!
* Erstellt für die beiden Versionen bitte 2 getrennte Codedateien (Ueb02a1.java und Ueb02a2.java)

## Anforderungen Teil B

* Das Programm fragt nacheinander folgende Punkte ab:
  1. ob eine Inverssuche durchgeführt werden soll (Anzahl Haltestellen → U-Bahn-Linie) ('j'/'J' bzw. 'n'/'N')
  2. die U-Bahn-Linie (von der die Anzahl der Haltestellen angezeigt werden soll) bzw. die Anzahl an Haltestellen (zu der die passende U-Bahn-Linie, im Falle einer Inverssuche, angezeigt werden soll)
* Mit der ersten Abfrage stellt das Programm zunächst fest, in welchem Modus es laufen soll. Nachfolgend ermittelt es aus der zweiten Eingabe anhand einer internen Zuordnung von U-Bahn-Linien zu Anzahl Haltestellen bzw. Anzahl Haltestellen zu U-Bahn-Linien, welche Ausgabe das Programm anzeigen soll.

  Beispiel 1: Der Benutzer führt keine Inverssuche aus und gibt die Linie „U1“ ein. Die Ausgabe ist dann

        Die eingegebene Linie hat 47 Haltestellen.
  Beispiel 2: Der Benutzer führt eine Inverssuche aus und gibt „26“ als Anzahl ein. Die Ausgabe ist dann

        Die Linie U3 hat 26 Haltestellen.
* Wurde zu einer Abfrage kein Ergebnis gefunden, soll eine entsprechende Meldung angezeigt werden.
* Die Anzahlen der Haltestellen sollen in Konstanten abgelegt werden, damit diese im Falle eines Netzausbaus schnell angepasst werden können
* Erlaubt: `switch`. Verboten: `if`, `&&`, `!`, `||`, `toUpperCase`
* Im gesamten Programm dürfen nur 3 Switche verwendet werden!
* Legt das Programm bitte in einer Datei mit dem Namen Ueb02b.java ab

## Anforderungen für beide Teile

* Eingabefehler müssen nicht abgefangen werden. Bedenkt aber, dass bei einer Ja-/Nein-Abfrage der Nutzer sowohl ein 'j' als auch ein 'J' eingeben könnte. Hier muss Euer Programm also beides erkennen, um es dem Nutzer möglichst einfach zu machen (hier hilft ein `||` weiter oder Ihr benutzt die Funktion `toUpperCase`, soweit in der jeweiligen Variante erlaubt!)
* Die Benutzung von Methoden (außer der `main`-Methode), Arrays und Schleifen sowie weiteren, hier noch nicht behandelten Themen ist nicht erlaubt! Hierzu zählen auch dynamische Datenstrukturen wie `List` und `Map` und sonstige Hilfsfunktionen von Java
* Eingabefehler (z.B. "abc" als Anzahl) müssen nicht abgefangen werden
* Kommentiert Euren Code, wo immer es sinnvoll ist
* Benutzt so wenig Variablen wie möglich und wählt sinnvolle Typen!
* Achtet auf einheitliche und sprechende Bezeichner sowie auf eine brauchbare Einrückung

Testet vor der Abgabe selbst mit verschiedenen Werten für die Konstanten und Eingaben und vollzieht im Kopf nach, ob das berechnete Ergebnis stimmen kann.

## Abnahmetests

Hier findet Ihr die Basis-Abnahmetests für diese Übung:

* [Ueb02a1Test.java](../../../test/java/Ueb02/Ueb02a1Test.java)
* [Ueb02a2Test.java](../../../test/java/Ueb02/Ueb02a2Test.java)
* [Ueb02bTest.java](../../../test/java/Ueb02/Ueb02bTest.java)

Bitte beachtet, dass die Abnahme im Tutorium mit umfangreicheren Tests erfolgt.
