# Aufgabe 6

## Thema: Klassen und Objekte

Tankstellendaten - bestehend aus den Angaben Marke, PLZ, Ort und Preis - sollen in einem Objekt der Klasse `GasStation` gespeichert werden.
Mehrere GasStations sollen dann in einem Array abgelegt werden können.
Das Programm soll in Ueb06.java im selben Pfad wie dieses Readme abgelegt werden.
Legt für das Objekt bitte zusätzlich eine weitere Datei `GasStation.java` an.

## Anforderungen

* Nacheinander sollen mehrere Tankstellen mit ihren Daten eingelesen und in einem Array abgelegt werden. Wie viele Datensätze dabei maximal in das Array passen, soll über einen Kommandozeilenparameter geregelt werden.
* Wird ein Wert kleiner 1, kein oder ein nicht numerischer Wert als Kommandozeilenparameter übergeben, soll die Fehlermeldung `Es wurde keine gueltige Array-Laenge uebergeben!` angezeigt werden. Anschließend soll sich das Programm mit dem Exit-Code 1 beenden.
* Eine Tankstelle wird durch die Felder Marke (z.B. "Shell"), PLZ, Ort und Preis beschrieben
* Alle vier Felder werden nacheinander vom User abgefragt und zunächst per `Scanner` jeweils in eine einfache Stringvariable eingelesen. Dabei dürfen nur gültige Eingaben (siehe nächster Punkt) angenommen werden - andernfalls muss der User die Eingabe des fehlerhaften Teils (also z.B. der PLZ) wiederholen, bis er gültig ist.
  * Die Marke ist gültig, wenn sie nicht leer ist.
  * Die PLZ muss eine ganze Zahl aus dem Bereich 10000 bis 99999 sein.
  * Der Ort muss mindestens 5 Stellen lang sein ('a1b$c' ist also auch ein gültiger Ort).
  * Der Preis muss wie in Aufgabe 5 zwischen 1 und 2 € liegen (inklusive der Grenzen) und darf maximal 2 Nachkommastellen haben.
* Die Postleitzahl soll eine Ganzzahl als Datentyp, der Preis eine Gleitkommazahl als Datentyp sein, Marke und Ort sind Strings
* Die Datenfelder des Objekts dürfen nur innerhalb des Objekts zugreifbar sein (Stichwort: Sichtbarkeit!). Vor der Eingabe wird das Objekt mittels `new` für die Speicherung der Daten erzeugt.
* Gültig eingegebene Teile werden nach und nach (jeweils direkt nach der gültigen Eingabe des Teils) in das Objekt übernommen, sodass dieses am Ende komplett gefüllt ist. Auf die Felder innerhalb des Objekts darf nicht direkt zugegriffen werden. Verwendet stattdessen Setter-Methoden, um die Teile im Objekt zu speichern.
* Jede korrekt und vollständig eingegebene Tankstelle wird danach als Objekt in ein Array übernommen.
* Wird die Eingabe der Daten durch ein 'x' oder 'X' unterbrochen, sollen alle vollständig eingegebenen Tankstellen im Array erhalten bleiben, die unvollständige wird hingegen verworfen und es werden auch keine weiteren Tankstellen mehr vom User angefordert (das Array muss also nicht komplett gefüllt werden). Auch hier soll in diesem Fall ein Hinweis erscheinen, dass die Eingabe abgebrochen wurde.
* Ist die Eingabe der Tankstellen abgeschlossen, werden vom User noch eine minimale und eine maximale Postleitzahl abgefragt. Die maximale muss dabei echt größer als die minimale sein und beide müssen die Anforderungen an eine gültige Postleitzahl (s.o.) erfüllen. Die minimale Postleitzahl darf also maximal 99998 sein. Diese Abfragen passieren aber nur dann, wenn der User mindestens eine Tankstelle vollständig eingegeben hat.
* Danach werden alle Tankstellen, deren PLZ sich innerhalb dieser so definierten Spanne befinden (inklusive der Grenzen) sinnvoll formatiert und inklusive ihrer Position im Array ausgegeben (ACHTUNG: auf die Tankstellendaten aus dem Objekt darf nur mittels Getter-Methoden zugegriffen werden), z.B. in dieser Form:

        1. eingegebene Adresse:
        Shell
        22880 Wedel
        1.40 Euro
        
        4. eingegebene Adresse:
        Esso
        22105 Hamburg
        1.85 Euro

* Gibt es gar keine Tankstelle in der gewünschten Spanne, soll dem User dies über einen Hinweis mitgeteilt werden (z.B. `Es gibt keine Tankstelle mit einer PLZ in der definierten Spanne!`).
* Danach beendet sich das Programm.

## Tipps

Zum Umwandeln eines Strings in einen Integer bzw. Double könnt Ihr `Integer.parseInt()` bzw. `Double.parseDouble()` verwenden und die evtl. auftretende Exception mit `try { … } catch(…) { … }` behandeln.

Einen Konstruktor benötigt Ihr in dieser Aufgabe nicht, da die einzelnen Felder erst später durch die Setter-Methoden initialisiert werden. Beachtet aber, dass die Felder davor uninitialisiert sind!
Als optionale Zusatzaufgabe könnt ihr eine zweite Lösung mit Konstruktor bauen.

Testet vor der Abgabe selbst mit verschiedenen (und verschieden vielen) Tankstellenangaben, ob das Füllen des Objekts und folgend auch des Arrays wie gefordert funktioniert. Denkt dabei auch daran, dass das Array evtl. nicht immer vollständig gefüllt sein muss (Abbruch durch 'x')!

Formatierung der Ausgabe:

FormatString für diese Übung:
```java
"%d. eingegebene Adresse:%n%s%n%d %s%n%-4.2f Euro"
```

Die Gleitkommazahlen sollen punktsepariert sein. `String.format` macht das abhängig von der `locale`.
Falls euer System deutsch ist, könnt ihr das mit dem ersten Parameter `locale.US` überschreiben, weil die Tests "." als Dezimaltrennzeichen erwarten.

```java
System.out.format(Locale.US, "Preis: %-4.2f", 1.23);
```
