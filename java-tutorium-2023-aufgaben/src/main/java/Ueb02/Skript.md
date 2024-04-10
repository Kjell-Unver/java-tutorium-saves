# Vergleiche und Bedingungen

## Operatoren für Vergleiche 
Um Daten miteinander zu vergleichen, gibt es in Java implementierte Operatoren. Das Ergebnis von Vergleichen ist immer ein boolean (true/false).

| Operator                | Beschreibung            | Kurzbeispiel (true) |
|:------------------------|:------------------------|:--------------------|
| ==                      | gleich                  | 3 == 3              |
| !=                      | ungleich                | 4 != 3              |
| \>                      | größer als              | 4 > 3               |
| <                       | kleiner als             | -4 < -3             |
| \>=                     | größer als oder gleich  | 3 >= 3              |
| <=                      | kleiner als oder gleich | -4 <= 4             |

Bei komplexen Datentypen muss aufgepasst werden, da Java die Referenz (Adresse zum Objekt) vergleicht.
In diesem Fall wird in der Regel eine Vergleichsmethode (z.B. equals) geschrieben.
```java
String myString1 = "foo";
String myString2 = "foo"; // Besonderheit bei Strings: Es wird nicht immer ein neues Objekt erzeugt (String interning)
String myString3 = new String("foo"); // Erzeugung eines neuen String-Objekts wird erzwungen

myString1 == myString1       // true
myString1 == myString2       // true
myString1 == myString3       // false
myString1.equals(myString3)  // true
```

## Logische Operatoren
Mit logischen Operatoren lassen sich mehrere Einzelausdrücke zu einem größeren zusammenfassen und logisch verknüpfen. Die Einzelausdrücke müssen vom Typ boolean sein, der zusammengefasste Ausdruck danach ist es auch. Beim && wird der Ergebnisausdruck nur dann true, wenn vorher beide Einzelausdrücke true sind. Beim || wird der Ergebnisausdruck true, sobald mindestens einer der Einzelausdrücke true ist. Bei größeren Ausdrücken ist es sinnvoll (bzw. manchmal auch erforderlich), Klammern zu setzen, um die gewünschte Auswertungsreihenfolge vorzugeben! Mit dem !-Operator lässt sich ein Ausdruck invertieren.

| Operator     | Beschreibung                                           | Kurzbeispiel                                       |
| :----------- |:-------------------------------------------------------| :------------------------------------------------- |
| !            | Negation: invertiert den Ausdruck                      | boolean lügnerSpricht = !wahrheit;                 |
| &&           | Und: true, genau dann wenn beide Argumente true sind   | boolean krümelmonster = istBlau && magKekse;       |
| &#124;&#124; | Oder: true, wenn mindestens ein Operand true ist       | boolean machePause = hungrig &#124;&#124; durstig; |
| ^            | Exklusives Oder: true, wenn genau ein Operand true ist | boolean zustandPhilosoph = denkt ^ isst;           |

### Wahrheitstabelle

| A     | B     | A && B | A &#124;&#124; B | A ^ B |
|:------|:------|:-------|:-----------------|:------|
| true  | true  | true   | true             | false |
| true  | false | false  | true             | true  |
| false | true  | false  | true             | true  |
| false | false | false  | false            | false |


Beispiel: Der Ausdruck ergibt `true`, wenn zahl = 1 ist ODER zahl größer als 2 UND kleiner als 4 ist
```java
boolean boolVar = (zahl == 1) || ((zahl > 2) && (zahl < 4));
```


Operatoren haben unterschiedliche Priorität (z.B. && hat prio vor ||).
Klammern helfen in unklaren Situationen die Reihenfolge zu verdeutlichen oder festzulegen.
Tabelle mit Prioritäten: [Operator Precedence](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html)

```java
(true || true) && false  // false
true || true && false    // true
true || (true && false)  // true
```

Es gibt auch noch bitweise Operatoren. Diese finden in der täglichen Arbeit selten Anwendung und sollen hier nur zur Vollständigkeit erwähnt werden.
```java
A = 0011 1100
B = 0000 1101
```

| Operator      | Beschreibung                                                                                                         | Kurzbeispiel                       |
| :-----------  |:---------------------------------------------------------------------------------------------------------------------|:-----------------------------------|
| &             | Binärer UND-Operator: 1 wenn beide Operanden 1 an der Stelle haben.                                                  | (A & B) ergibt 12 (0000 1100)      |
| &#124;        | Binärer ODER-Operator: 1 wenn mind. ein Operand 1 an der Stelle hat.                                                 | (A &#124; B) ergibt 61 (0011 1101) |
| <<            | Binärer Left-Shift-Operator: Stellen des linken Operanden werden nach links bewegt und rechts mit Nullen aufgefüllt. | A << 2 ergibt 240 (1111 0000)      |
| \>>           | Binärer Right-Shift-Operator: Stellen des linken Operanden werden nach rechts bewegt.                                | A \>> 2 ergibt 15 (0000 1111)      |
| ~             | Binärer Komplement-Operator: flipt die Bits.                                                                         | ~A  ergibt -61 (1100 0011)         |


## Blöcke
Ein Block fasst eine Gruppe von Anweisungen zusammen, die hintereinander ausgeführt werden. Anders gesagt: Ein Block ist eine Anweisung, die in geschweiften Klammern { } eine Folge von Anweisungen zu einer neuen Anweisung zusammenfasst:

    {
        Anweisung1;
        Anweisung2;
        ...
    }

Ein Block kann überall dort verwendet werden, wo statt einer einzelnen Anweisung mehrere Anweisungen hintereinander ausgeführt werden sollen, z. B. bei `if` oder `else`-`if`. Der neue Block hat jedoch eine Besonderheit in Bezug auf Variablen, da er einen lokalen Bereich für die darin befindlichen Anweisungen inklusive der Variablen bildet.


## Bedingte Anweisung (`if`)
Mit `if` könnt Ihr eine Bedingung in Euer Programm einbauen. Die auf das `if` folgende Bedingung muss sich zu `true` oder `false` auswerten lassen. Ergibt sie `true`, wird der Code im `if`-Teil ausgeführt.
```java
    if (zahl > 3) {
        zahl = zahl * 2;
        System.out.println(zahl);
    }
```

## Verzweigung (`if`-`else`)
Folgt nach dem `if`-Teil noch ein `else`-Teil und ergibt die Bedingung des `if`-Teils false, wird der Code im `else`-Teil ausgeführt. Falls im `if`- oder `else`-Teil mehr als eine Anweisung stehen soll, muss der gesamte Block in geschweifte Klammern {} eingeschlossen werden.
```java
if (zahl > 3) {
    zahl = zahl * 2;
    System.out.println(zahl);
} else {
    zahl = zahl + 4; 
}
```

## Mehrfache Verzweigung (`switch`)
Ein `switch` erlaubt eine Mehrfachauswahl. Wollt Ihr also in Abhängigkeit vom Wert einer Variablen mehrere verschiedene Dinge tun, dann ist ein switch sinnvoller und lesbarer als mehrere geschaltelte `if`. Mit `case` werden dann mehrere konstante Werte angegeben, die der Ausdruck annehmen kann. All diese Werte dürfen sich nicht überschneiden, es darf also kein Wert existieren, der mehrfach vorkommt. Zusätzlich kann beim `switch` auch ein `default`-Teil angegeben werden. Der Code darin wird durchlaufen, wenn der Ausdruck zu keiner der Konstanten passt. Es ist wichtig darauf zu achten, dass nach Ausführung einer Anweisung der `case`-Block mit `break` unterbrochen wird, da die folgenden Sprungmarken sonst ebenfalls geprüft und ggf. ausgeführt werden.
```java
if (zahl == 1) {
    System.out.println("Die Zahl ist = 1");
} else if(zahl == 2) {
    zahl += 1;
    System.out.println("Die Zahl + 1 ist = " + zahl);
} else {
    System.out.println("Ganz große Zahl");
}
```
Die gleiche Logik können wir mit dem switch Statement etwas übersichtlicher gestalten:

```java
switch zahl {
case 1 :
    System.out.println("Die Zahl ist = 1");
    break;
case 2:
    zahl += 1;
    System.out.println("Die Zahl + 1 ist = " + zahl);
    break;
default:
    System.out.println("Ganz große Zahl");
}
```

## Vergleichen von Strings
Strings können in Java nicht mit `==` verglichen werden. Hierzu gibt es die Funktion `equals`.
```java
String text = "test";
if (text.equals("test")) {
   System.out.println("Die Variable enthält den Wert test");
}
```
