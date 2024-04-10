# Aufgabe 5

## Thema: Arrays

Für eine Menge einzugebender Benzinpreise sollen einfache Statistiken zur Verfügung gestellt werden.

## Anforderungen

* Vom Programm werden nacheinander mehrere Benzinpreise eingelesen und in einem Array abgelegt. Wie viele Preise dabei maximal in das Array passen, soll über einen Kommandozeilenparameter geregelt werden.

* Wird kein oder ein nicht numerischer Wert als Kommandozeilenparameter übergeben, soll die Fehlermeldung `Es wurde keine gueltige Array-Laenge uebergeben!` angezeigt werden. Anschließend soll sich das Programm mit dem Exit-Code 1 beenden.

* Ein*e Benutzer\*in gibt so lange Preise ein, bis entweder das Array voll ist oder man bei einer der Eingaben ein 'x' eingibt. In dem Fall wird die Eingabe sofort beendet, alle vorher eingegebenen Benzinpreise bleiben aber erhalten. Wurde die Eingabe mit 'x' beendet und gar kein Preis eingegeben, dann soll die Meldung `Es wurde kein Preis eingegeben!` ausgegeben werden.

* Es sollen nur gültige Preise (von 1 bis 2 € inklusiv der Grenzen, maximal mit 2 Nachkommastellen) eingegeben werden können! Wird ein fehlerhafter Preis eingegeben, soll die Fehlermeldung `Es wurde ein ungueltiger Preis eingegeben!` angezeigt werden und anschließend die erneute Eingabe eines korrekten Preises möglich sein.

* Nach dem Ende der Eingabe werden die Daten wie folgt ausgewertet:

  * Die Anzahl der eingegebenen Preise wird ausgegeben

  * Der kleinste und der größte eingegebene Preis wird ausgegeben

  * Der Mittelwert (arithmetisches Mittel) aller eingegebenen Preise wird ausgegeben

  * Die Spanne zwischen dem größten und dem kleinsten Preis wird ausgegeben

Beispiel:
Für die eingegebenen Benzinpreise 1.0, 1.20 und 1.8 wird folgende Ausgabe erwartet:

  ```
  Anzahl Preise:   3
  Kleinster Preis: 1.00
  Größter Preis:   1.80
  Mittelwert:      1.33
  Spanne:          0.80
  ```

* Danach beendet sich das Programm von selbst.

* Die Ausgabe soll dabei wie oben zu sehen so erfolgen, dass die Zahlwerte linksbündig erscheinen und je nach Typ ohne oder mit zwei Nachkommastellen ausgegeben werden.

* Die Benutzung dynamischer Datenstrukturen wie `List` und `Map` und sonstige Hilfsfunktionen von Java sind nicht erlaubt.

* Nutzt statische Hilfsmethoden, um den Code lesbarer zu gestalten.

## Tipps

Testet vor der Abgabe selbst mit verschiedenen Preisen, ob die Statistiken wie gefordert berechnet werden. Denkt dabei
auch daran, dass das Array evtl. nicht immer vollständig gefüllt sein muss (Abbruch durch 'x')! Auch für gar keinen
eingegebenen Preis sollen sinnvolle Ausgaben entstehen...

Formatierungsstrings für die Ausgabe:
```java
"\nAnzahl Preise:   %-4d"
"\nKleinster Preis: %-4.2f"
"\nGroesster Preis: %-4.2f"
"\nMittelwert:      %-4.2f"
"\nSpanne:          %-4.2f\n"
```
