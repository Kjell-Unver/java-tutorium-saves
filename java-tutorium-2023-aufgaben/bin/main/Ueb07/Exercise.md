# Aufgabe 7

## Thema: Strings zeichenweise, Methoden und Tests

Bei mehreren in ein Array einzulesenden Strings sollen zeichenweise einfache Veränderungen vorgenommen werden.

### Anforderungen

* In ein Array vom Typ `String` sollen Strings vom Benutzer eingelesen werden können. 
* Wie viele Datensätze dabei maximal in das Array passen, soll über einen Kommandozeilenparameter geregelt werden.
* Wird ein Wert kleiner 1, kein oder ein nicht numerischer Wert als Kommandozeilenparameter übergeben, soll die Fehlermeldung `Es wurde keine gueltige Array-Laenge uebergeben!` angezeigt werden. Anschließend soll sich das Programm mit dem Exit-Code 1 beenden.
* Möchte der Benutzer weniger Strings als die vom Kommandozeilenparameter vorgesehene Maximalzahl eingeben, kann er die Eingabe jederzeit mit 'x' beenden (es ist folglich nicht möglich, den String 'x' für die Bearbeitung einzugeben)
* Auf jeden eingegebenen String wird nach Ende der Eingabe eine der folgenden Veränderungen angewandt:
    * Wenn der String ausschließlich Ziffernzeichen ('0' bis '9') enthält, werden alle Ziffern darin um 1 erhöht und aus der '9' wird eine '0'.
    * Enthält der String ansonsten mindestens einen Großbuchstaben, wird bei allen Buchstaben die Groß- / Kleinschreibung vertauscht und die Anzahl der Vertauschungen wird mit berechnet. Alle Umlaute, Sonderzeichen, Satzzeichen, Steuerzeichen etc. werden hiervon nicht verändert.
    * Ansonsten wird der String mit allen enthaltenen Zeichen gespiegelt
* Abschließend werden alle Strings zeilenweise nummeriert ausgegeben, wobei jeweils am Anfang die angewandte Methode steht (also z.B. "Ziffern erhöhen", "Groß-/Kleinschreibung vertauschen" und "Spiegeln"), danach der eingegebene Ursprungszustand des Strings und am Ende das berechnete neue Ergebnis. Zum Beispiel könnte das für die eingegebenen Strings '1349', 'Liebe Gäste!' und 'klein erna' so aussehen:

        1 Ziffern erhöhen: 1349 -> 2450
        2 Groß-/Kleinschreibung vertauschen: Liebe Gaeste! -> lIEBE gAESTE! (11 Vertauschungen)
        3 Spiegeln: klein erna -> anre nielk

* In dieser Aufgabe dürfen folgende vordefinierte Methoden von Java NICHT verwendet werden (es soll - wie das Thema der Aufgabe schon sagt - zeichenweise auf den Strings gearbeitet werden):
    * Alle Stringmethoden mit Ausnahme von `length()` und `charAt()`
    * `Integer.parseInt()`, `Double.parseDouble()` und ähnliche Methoden, die Strings in Zahlen umwandeln
    * Alle Methoden aus `Math`
    * `try` und `catch`
* Euer Programm soll folgende Methoden aufweisen (zusätzlich zum Hauptprogramm). Die genauen sinnvollen Parameter und Rückgabetypen überlegt Euch bitte selbst! Das Hauptprogramm selbst wird dadurch relativ kurz (in der Beispiel-Lösung hat es ohne Kommentare gerade mal noch 15 Zeilen...).

```java 
    // Gibt eine Fehlermeldung aus und beendet das Programm mit dem Exit-Code 1
    ... printErrorAndExit(... errorMessage) {}
  
    // Liest die Array-Länge aus dem Kommandozeilenparameter-Array aus und gibt
    // diese zurück. Wurde keine oder eine ungültige Array-Länge übergeben, soll
    // die Methode -1 zurückgeben
    ... getArrayLengthFromArgs(... args) {}
  
    // Liest mehrere Strings vom Benutzer ein. Speichert die Strings in lines ab
    // und gibt die Anzahl der eingelesenen Strings zurück
    int getStrings(String[] lines) {}
  
    // Berechnet den Wert der Potenz. Zur Vereinfachung kann davon ausgegangen werden,
    // dass der Exponent immer größer oder gleich Null ist
    ... power(... base, ... exponent) {}
  
    // Wandelt einen String in eine Ganzzahl um. Zur Vereinfachung kann davon
    // ausgegangen werden, dass s immer eine Ganzzahl größer oder gleich Null enthält
    ... toNumber(... s) {

    // Gibt zurueck, ob das Zeichen c ein Ziffernzeichen ist
    ... isDigit(... c) {}

    // Gibt zurueck, ob s ausschliesslich aus Ziffernzeichen besteht
    ... isNumber(... s) {}

    // Erhoeht in s jede Ziffer um 1 und macht aus einer 9 eine 0.
    ... shiftDigits(... s) {}

    // Gibt zurueck, ob in s mindestens ein Grossbuchstabe enthalten ist
    ... hasCapital(... s) {}

    // Macht in s bei allen Buchstaben aus Klein- Grossbuchstaben und
    // umgekehrt und gibt das Ergebnis inklusive Anzahl der Vertauschungen zurück
    ... changeCapitalization(... s) {}

    // Spiegelt den String s und gibt das Ergebnis zurück
    ... mirrorString(... s) {}

    // Gibt die laufende Nummer des Strings, die angewandte Methode, den
    // Ursprungszustand und den neu berechneten String formatiert (z.B. mit einem -> dazwischen) zuürck
    ... print(... nr, ... method, ... old, ... res) {}
```

### Testing

* Schreibt im Pair jeweils eigene Unittests in die Testklasse `Ueb07Test` und euer Partner*in implementiert den Code (und ihr wechselt euch ab beim Schreiben der Tests und der Implementierung des Codes). Diese Tests sollen die oben aufgeführten Methoden (VOR der Implementierung) sinnvoll abtesten.
* Ausgaben dürfen ausschließlich über die Methoden `print` und `printErrorAndExit` erfolgen. Ein `System.out.println` / `system.out.print` in der `main` ist nicht erlaubt!
* Globale Variablen sind nicht zugelassen, es soll stattdessen umfangreich mit Parametern gearbeitet werden! Globale Konstanten sind natürlich erlaubt.
