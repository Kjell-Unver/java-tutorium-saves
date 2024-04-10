# Schleifen (`while`, `do while`, `for`, `for-each`)

Mit Schleifen lassen sich wiederholende Programmabläufe komprimierter darstellen, sodass man diesen Code nicht doppelt schreiben muss und der Code insgesamt kürzer, lesbarer und leichter wartbarer wird.

## while-Schleife
Bei der while-Schleife wird zuerst die Bedingung überprüft. Nur wenn dessen Ergebnis true ist, wird die nachstehende Schleifenanweisung ausgeführt, sonst wird sie übersprungen. Somit handelt es sich bei der while-Schleife um eine kopfgesteuerte Schleife.

Bei der Bedingung handelt es sich immer um einen Wert vom Typ boolean.

Nachdem die while-Schleife einmal durchlaufen wurde, d.h. die Schleifenanweisung ausgeführt wurde, wird erneut geprüft, ob die Bedingung erfüllt ist.

Die Schleife wird so lange durchlaufen, bis die Bedingung false wird. Ist dies der Fall, wird die Schleife verlassen und die Schleifenanweisung nicht mehr ausgeführt.

```java
int i = 0;

while (i < 10) {
    System.out.println(i);
    i++;
}
```

## do-while-Schleife
Bei der do-while-Schleife wird die Schleifenanweisung immer mindestens einmal ausgeführt. Sie ist daher eine fußgesteuerte Schleife.

Nachdem die Schleifenanweisung das erste Mal ausgeführt wurde, wird die Bedingung überprüft. Ist das Ergebnis der Bedingung true, wird die Schleifenanweisung ein weiteres Mal ausgeführt. Ist das Ergebnis false, wird die do-while-Schleife beendet.

Bei der Bedingung handelt es sich immer, wie bei der while-Schleife auch, um einen Wert vom Typ boolean.

```java
int i = 0;

do {
    i++;
    System.out.println(i);
} while (i < 10);
```

## for-Schleife
Die for-Schleife wird in Java oft als Zählerschleife benutzt, deren hauptsächliche Aufgabe darin besteht, einen einfachen Zähler hochzuzählen und gleichzeitig bestimmte Anweisungen ebenso oft zu wiederholen.

Der Schleifenkopf der for-Schleife besteht aus den folgenden drei Ausdrücken, von denen keiner zwingend erforderlich ist:

- Initialisierungsausdruck – Führt die Initialisierung vor dem Start der Schleife durch.

- Bedingung – Wird zu Beginn der Schleife überprüft und entscheidet, ob die Schleife betreten wird oder werden soll.

- Updateausdruck – Führt Veränderungen nach jedem Schleifendurchlauf aus, z. B. die Erhöhung des Schleifenzählers.

Es dürfen mehrere Einzelausdrücke in den Initialisierungs- und Updateausdruck angegeben werden. Diese müssen jeweils durch ein Komma voneinander getrennt werden. Ist kein Initialisierungsausdruck angegeben, wird keine Initialisierung vor dem Start der for-Schleife durchgeführt.

Das Gleiche trifft auch auf den Updateausdruck zu. Oft wird der Initialisierungsausdruck für die Deklaration von Zählervariablen genutzt. Diese existieren nur innerhalb des Schleifenblocks und sind von außen nicht sichtbar.

Ist keine Bedingung angegeben, setzt der Java-Compiler automatisch true an diese Stelle, wodurch die Bedingung immer erfüllt ist und eine Endlosschleife vorliegt.

```java
int i;

for (i = 1; i <= 10; i++) {
    System. out.println(i);
}
```

## for-each-Schleife
Damit auf speziellen Datenstrukturen wie Arrays und Collection effektiver zugegriffen werden kann, wurde in Java 5 die erweiterte for-Schleife eingeführt. Manche Programmierer kennen diese Sonderform auch als „foreach“-Variante.

Die Syntax der erweiterten for-Schleife ist sehr einfach:

```java
for (Datentyp variable : Listenobjekt)
{
    Schleifenanweisung1;
    Schleifenanweisung2;
}
```

Die erweiterte for-Schleife kann in Java benutzt werden, um den Quelltext kompakter und lesbarer zu machen. Mit ihr kann das einmalige Durchlaufen aller Listenelemente von Anfang bis zum Ende ausgeführt werden.

Für Sonderfälle sollte aber weiterhin die normale for-Schleife verwendet werden.

## Hinweis:
Es gibt auch die Keywords `continue` und `break`, die in diesem Kontext genutzt werden können. Von ihrer Verwendung bei Schleifen wird aber abgeraten, weil es ein unschöner Programmierstil ist!

`continue`:
- Die Schleifenanweisungen nach diesem Keyword werden übersprungen. Der Ablauf des Programms wird bei der Bedingung der Schleife fortgesetzt.

`break`:
- Die gesamte Schleife wird abgebrochen.

# Methoden

Ähnlich wie bei Schleifen lässt sich durch Methoden mehrfach verwendeter Code aus dem Hauptprogramm ausgliedern, sodass 
man diesen Code nicht doppelt schreiben muss und ihn stattdessen wiederverwenden kann. Das macht den Code kürzer, lesbarer und leichter wartbar.

Die Parameterübergabe erfolgt in Java bei primitiven Datentypen und Strings nach dem Prinzip "call by value". Das bedeutet, dass die übergebenen Werte immer kopiert werden.
Eine Variable, die vor einem Methodenaufruf deklariert wird und dann einer Methode übergeben wird, enthält daher nach dem Methodenaufruf immer denselben Wert wie zuvor, 
auch wenn innerhalb der Methode Veränderungen darauf vorgenommen werden.  
ACHTUNG: Modifiziert man innerhalb einer Methode einen Parameter, der auf ein Objekt (dazu gehören auch Arrays) zeigt, ändert sich auch der Wert außerhalb der Methode. 
Man spricht dann von "call by reference". Hierauf gehen wir in einer zukünftigen Aufgabe noch genauer ein.

Eine Methode kann einen Rückgabewert haben. Der Typ dieses Rückgabewerts wird in der Signatur der Methode deklariert. Hierbei kann es sich um einen primitiven Datentypen, 
Referenztypen oder um das Keyword `void` handeln.
Mit dem Keyword `void` hat die betrachtete Methode keinen Rückgabewert.

Signatur einer Methode:

> `<Sichtbarkeit der Methode>` `<Ist die Methode statisch?>` `<Typ des Rückgabewerts>` `nameDerMethode`(`Parametertyp` `parameterName`, ...){}
Beispiel für eine Methodensignatur:
```java
private static int calculateSum(int firstSummand, int secondSummand) {
    // ...
}
```

Ein Beispiel für eine Methode ohne Rückgabe Wert:
```java
private static void scream(String inputString) {   
    System.out.println(inputString.toUpperCase() + "!");
}

public static void main(final String[] args) {
	String greeting = "hallo";
	scream(greeting); // ergibt "HALLO!" in der Ausgabe
}
```

Ein Beispiel for eine Methode mit Rückgabewert:
```java
public static String findBestDestination(boolean likesAnimals, boolean likesHamburg) {
        if (likesAnimals && likesHamburg) {
            return "Hagenbecks Tierpark";
        } else if (likesAnimals) {
            return  "Wildpark Schwarze Berge";
        } else if (likesHamburg) {
            return  "Dom";
        } else {
            return "Kieler Woche";
        }
    }

public static void main(final String[] args) {
	String destinationForAnimalLoverInHamburg = findBestDestination(true, true);
    System.out.println("Das passende Ziel für einen Tierliebhaber in Hamburg ist " + destinationForAnimalLoverInHamburg);
}
```

### Was ist der Unterschied zwischen Methode und Funktion?

Häufig werden Begriffe wie "Methode" und "Funktion" gleich verwendet.

Eine häufige Unterscheidung ist, dass eine "Methode" immer abhängig von einer Klasse ist, während eine "Funktion" unabhängig von einer Klasse ist. Nach dieser Definition gibt es in Java nur Methoden, nämlich Objektmethoden und statische Methoden (Objektmethoden lernen wir in späteren Sitzungen kennen).

Manchmal findet man auch, dass die "Funktion" als Überbegriff und "Methode" und "Prozedur" als Unterbegriffe verstanden werden. Eine "Methode" kann dann als eine Funktion mit Rückgabewert, eine "Prozedur" als eine Funktion ohne Rückgabewert definiert werden. Aber diese Unterscheidung ist seltener.

## Formatierte Strings

`System.out.format` kann Euch bei der formatierten Ausgabe behilflich sein! Bei der Nutzung dieser Ausgabe-Methode baut man den auszugebenden String nicht durch Konkatenation von Strings und Variablen auf, sondern definiert vorab einen String mit Platzhaltern, welche beim Aufruf der Methode durch die Werte der übergebenen Variablen ersetzt werden.

Folgende Platzhalter können nützlich sein: `%d` (Ganzzahl), `%b` (Boolean), `%s` (String) und `%n` (Zeilenumbruch). Die Platzhalter lassen sich zusätzlich in ihrer Breite konfigurieren. Ein `%2d` sorgt beispielsweise dafür, dass eine Ganzzahl-Variable immer zweistellig rechtsbündig ausgegeben wird. Soll die Ausgabe stattdessen linksbündig sein, muss zusätzlich noch ein Minuszeichen verwendet werden: `%-2d`.

Ein Beispiel:
```java
int number1 = 1;
int number10 = 17;
String street = "Werner-Otto-Str.";
String town = "Hamburg";

System.out.format("%s %2d, %s%n", street, number1, town);
System.out.format("%s %2d, %s%n", street, number10, town);
System.out.format("%s %-5d, %s%n", street, number10, town);

// Ausgabe:
// Werner-Otto-Str.  1, Hamburg
// Werner-Otto-Str. 17, Hamburg
// Werner-Otto-Str. 17   , Hamburg
```
