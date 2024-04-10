# Arrays

Ein Array ist eine Datenstruktur, die mehrere Elemente des gleichen Datentyps geordnet vorhalten kann. Man kann sich ein Array wie eine Kommode vorstellen, und in jeder Schublage liegt ein Element. 

Um ein Array zu deklarieren, schreibt man hinter den Datentyp eckige Klammern, z.B. `int[]` für ein Integer-Array.

Bei der Erzeugung eines Arrays muss die Größe (d.h. wie viele Elemente das Array maximal enthalten kann) angegeben werden. Die Größe kann nachträglich nicht mehr geändert werden. Zur besseren Wartbarkeit kann die Größe des Arrays über eine Konstante geregelt werden:

```java
final static int MAX_ENTRIES = 10;

int[] entries = new int[MAX_ENTRIES];
```

Man kann ein Array direkt bei der Initialisierung mit Elementen füllen:
```java
int[] entries = new int[]{1, 3, 5, 7};
```

Die Elemente in einem Array sind geordnet und werden mit Indices durchgezählt. Das erste Element hat den Index `0`. Auf ein Element in einem Array kann man lesend und schreibend wie folgt zugreifen:
```java
final static int MAX_ENTRIES = 10;

int entry;
int[] entries = new int[MAX_ENTRIES];

// schreibend
entry = 3;
entries[4] = entry;

// lesend
entry = entries[4];
```

Arrays sind Objekte, das bedeutet sie verhalten sich anders als primitive Datentypen. Wenn ein Array als Methoden-Parameter gesetzt wird, kann das ursprüngliche Array in der Methode verändert werden, weil hier die Referenz an die Methode übergeben wird ("call by reference"). Vergleiche:
```java
public static void main(String[] args) {
    int number = 5;

    int[] numberArray = new int[1];
    numberArray[0] = 5;

    changeValues(number, numberArray);

    System.out.println(number); // Ausgabe: 5 (unverändert)
    System.out.println(numberArray[0]); // Ausgabe: 6 (verändert)
}

public static void changeValues(int number, int[] numberArray) {
    number = 6;
    numberArray[0] = 6;
}
```

# Kommandozeilenparameter

Die Kommandozeilenparameter werden der `main`-Methode als Parameter in Form eines String-Arrays übergeben. Der erste
Kommandozeilenparameter befindet sich dann beispielsweise an der ersten Position des `args`-Arrays. Werden beim Start
des Programms keine Parameter angegeben, hat das Array die Länge `0`. Folgendes Beispiel gibt den ersten
Kommandozeilenparameter auf der Konsole aus:

```java
    System.out.println(args[0]);
```

# Wrapper-Klassen

Manchmal ist es notwendig, Objekte anstatt primitiver Datentypen zu verwenden. Objekte haben außerdem den Vorteil, dass es Methoden gibt, die man aufrufen kann. Deshalb stehen in Java für alle primitiven Datentypen Wrapper-Klassen zur Verfügung, um sie in Objekte umzuwandeln. Dadurch lassen sich auch Methoden verwenden. 

Für die Umwandlung eines Strings in eine Fließkommazahl kann die Funktion `Double.parseDouble()` verwendet werden. Falls die Umwandlung fehlschlägt, weil es sich um eine ungültige Zahl handelt, wird eine `NumberFormatException` geworfen. Diese lässt sich mittels `try`-`catch` fangen, um auf den Eingabefehler zu reagieren.

Beispiel:

```java
String str = "5.4";
try {
    double x = Double.parseDouble(str);
    // Umwandlung erfolgreich
} catch (NumberFormatException e) {
    // Umwandlung nicht erfolgreich
}
```

Analog hierzu kann ein String mit `Integer.parseInt()` in eine Ganzzahl umgewandelt werden.

# Programmabbruch

Ein Java-Programm lässt sich mit `System.exit(0)` beenden. Der Aufruf beendet die aktuell laufende Java Virtual Machine.
Die Methode `exit()` nimmt als Argument den Status-Code entgegen; nach Konvention zeigt ein Status-Code ungleich Null an, dass
das Programm aufgrund eines Fehlers beendet wurde.

# Formatierte Strings

Mit `System.out.format()` können Werte von Variablen formatiert ausgegeben werden (siehe Aufgabe 3). Die Funktion `format()` kann übrigens auch mehrere Variablen gleichzeitig ausgeben. So kann beispielsweise vor einer formatierten Zahl auch noch ein String ausgegeben werden. Im Format-String wird hierzu der Platzhalter `%s` verwendet. Im nachfolgenden Beispiel wird zusätzlich noch `%n` verwendet, um am Ende der Zeile einen Zeilenumbruch, wie es `println` automatisch macht, zu erzeugen.

Beispiel:
```java
String text = "Test";
System.out.format("%s: %4.2f%n", text, Math.PI);
// Ausgabe:
// Test: 3.14
```
