# Aufgabe 3

## Thema: Schleifen (`for`, `while`, `do while`)

Mithilfe der verschiedenen Schleifentypen sollen für mehrere natürliche Zahlen ein paar Kennwerte ausgegeben werden.

## Anforderungen

* Nach Programmstart wird der Benutzer nacheinander nach einer unteren und oberen Grenze gefragt, zwischen diesen (inklusive der Grenzen) eine Zahl aufsteigend alle Werte durchlaufen soll. Die Grenzen könnten dabei z.B. bei 1 und 50 liegen. Ihr könnt davon ausgehen, dass die obere Grenze immer mindestens um 1 größer als die untere ist.

* Für jeden durchlaufenen Wert sollen folgende Dinge in statischen Methoden bestimmt werden:

  * ist die Zahl gerade?

  * ist die Zahl eine Primzahl? 

  * ist die Zahl eine [Dreieckszahl](https://de.wikipedia.org/wiki/Dreieckszahl)? 

* Pro Zahl sollen dann in jeweils einer Zeile die Zahl selbst sowie die Ergebnisse der drei Prüfungen ausgegeben werden. Die Ausgabe der ersten Zeilen soll wie folgt aussehen:

```
 1 gerade: false prim: false dreieck: true
 2 gerade: true  prim: true  dreieck: false
 3 gerade: false prim: true  dreieck: true
 4 gerade: true  prim: false dreieck: false
 5 gerade: false prim: true  dreieck: false
 6 gerade: true  prim: false dreieck: true
 7 gerade: false prim: true  dreieck: false
 8 gerade: true  prim: false dreieck: false
 9 gerade: false prim: false dreieck: false
10 gerade: true  prim: false dreieck: true
11 gerade: false prim: true  dreieck: false
12 gerade: true  prim: false dreieck: false
...
```

* Überlegt Euch bei allen sich wiederholenden Schritten, welcher Schleifentyp der passendste ist (hinsichtlich Eintritts- und Abbruchbedingung und Häufigkeit der Ausführung des Schleifenrumpfes) und begründet dies ggf. auch bei der Abnahme!

* Jeder Schleifentyp (`for`, `while`, `do while`) muss mindestens ein Mal vorkommen!

* Die Benutzung von Arrays sowie weiteren, hier noch nicht behandelten Themen ist nicht erlaubt! Hierzu zählen auch dynamische Datenstrukturen wie `List` und `Map` und sonstige Hilfsfunktionen von Java

## Tipp

Testet vor der Abgabe selbst mit verschiedenen Zahlen, ob die Ausgaben und Berechnungen korrekt sind! Bei der Entwicklung definiert Ihr Euch am besten zunächst nur einen kleinen Bereich von Zahlen, für die alles berechnet wird. Testet jeden Teil nach seiner Implementierung für sich und baut auch in Schleifen zwischendrin mal Testausgaben ein. So könnt Ihr schon während der Entwicklung Dinge testen und stellt nicht erst am Ende fest, dass irgendwas falsch läuft :-)
