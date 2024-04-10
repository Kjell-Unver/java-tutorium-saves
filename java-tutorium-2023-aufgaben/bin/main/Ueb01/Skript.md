# Kompilieren und interpretieren

- Computer arbeiten mit Nullen und Einsen.
- Programme müssen in Maschinencode vorliegen, damit sie im Prozessor ausgeführt werden können. Maschinencode is spezifisch für das jeweilige Zielsystem.
- "Höhere" Programmiersprachen (Java, Python, C, C++ etc.) müssen zuerst in Maschinencode übersetzt werden, bevor sie ausgeführt werden können.
- Ein **Interpreter** führt den Quellcode Anweisung für Anweisung während der Laufzeit direkt auf dem Prozessor eines bestimmten Zielsystems aus (Beispiel: Perl).
  - Vorteil: Bessere Fehleranalyse, weil Anweisungen einzeln ausgeführt werden.
  - Nachteil: Programmausführung ist langsam.
- Ein **Compiler** übersetzt zuerst das gesamte Programm in Maschinencode, bevor es läuft (Beispiel: C, C++).
  - Vorteil: Gute Performance bei der Programmausführung.
  - Nachteil: Kompilierung braucht Zeit und Systemressourcen.
- Ein **Just-in-Time-Compiler** (JIT-Compiler) kompiliert während der Laufzeit die Programmteile, die gerade ausgeführt werden sollen.
  - Vorteil: Weil nur einzelne Programmteile kompiliert werden, werden weniger Systemressourcen beansprucht.
  - Nachteil: Ausführungszeit ist langsamer als bei komplett kompiliertem Programmcode.

## Java als Hybridlösung

- Zuerst wird der Java-Quellcode mit einem Compiler in Java-Bytecode übersetzt.
- Danach wird dieser Bytecode vom JIT-Compiler der **Java Virtual Machine** (JVM) auf dem jeweiligen Zielsystem in Maschinencode übersetzt und ausgeführt.
- Wenn ein Programm aus mehr als einer Klasse besteht, kann man alle Dateien (Klassen und weitere Dateien) zu einer JAR-Datei kombinieren.

Beispiel:
```shell
javac MyProgramm.java # erzeugt die Datei MyProgramm.class, die den Bytecode enthält
java MyProgramm # führt die Datei MyProgramm.class in der JVM aus
jar cf Bundle.jar Datei1.class Datei2.class # erzeugt das Java-Archiv Bundle.jar aus Datei1 und Datei2
```

## Vorteile von Java

- Durch die Kompilierung wird eine gute Performance erreicht.
- Der JIT-Compiler ermöglicht die Fehleranalyse während der Laufzeit.
- Durch den Einsatz der JVM kann der Bytecode plattformunabhängig auf unterschiedlichen Zielsystemen ausgeführt werden.


# Variablen in Java

- Variablen speichern Daten während der Laufzeit des Programms.
- Variablen sind von einem bestimmten **Datentyp**, zum Beispiel:
  - *int* für Ganzzahlen, z.B. 5 (primitiver Datentyp)
  - *double* für Gleitkommazahlen, z.B 5.3 (primitiver Datentyp)
  - *String* für Zeichenketten, z.B. "Hallo" (Referenztyp)
- Bei **primitive Datentypen** wird der Wert direkt in die Variable gespeichert. Bei **Referenztypen** wird nur die Referenz (Speicheradresse) des Objekts in der Variablen gespeichert (behandeln wir später).
- Variablen werden in "Camel-Case" geschrieben (klein anfangen, erster Buchstabe jedes neuen Wortes groß. z.B. "myStringVariable").

## Deklaration und Initialisierung von Variablen

- **Deklaration** einer Variable bedeutet, dass man eine Variable anlegt, indem man den Datentyp und den Variablennamen angibt. Variablen müssen deklariert werden, um den benötigten Arbeitsspeicher für den jeweiligen Datentyp zu reservieren.
- **Initialisierung** einer Variable bedeutet, dass man der Variablen zum ersten Mal einen Wert zuweist.
- Für eine Wertzuweisung wird der Zuweisungsoperator **=** verwendet.
- Jede Anweisung in Java (Deklaration, Initialisierung, Wertzuweisung etc.) endet mit einem Semikolon.

```java
// reine Deklaration
String myFavoriteFood;
// reine Initialisierung einer vorher deklarierten Variable
myFavoriteFood = "Schwarzwälder Kirschtorte";
// beides in der selben Zeile:
int myFavoriteNumber = 42;
// Neue Wertzuweisung:
myFavoriteNumber = 313;
```
## Konstanten

Benötigt man in einem Programm Werte, die sich während der gesamten Laufzeit nicht verändern, sollten diese in **Konstanten** abgelegt werden.
- Konstanten werden mit dem Keyword **final** markiert.
- Konstanten stellt man an den Anfang einer Klasse.
- Damit Konstanten allgemein zugänglich sind, stellt man in der Regel die folgenden Modifier voran: **public static** (dazu später mehr).
- Konstanten werden mit Unterstrichen getrennt großgeschrieben.
- Vorteil: die gespeicherten Werte können an zentraler Stelle für das gesamte Programm geändert werden.

Beispiel:
```java
// Deklaration und Initialisierung von einer Konstanten
public static final double PI = 3.141592;
```

## Primitive Datentypen
- Daten werden im Speicher in magnetischen Zuständen (Bits) gespeichert (1 oder 0).
- Unterschiedliche Datentypen brauchen unterschiedlich viel Speicher.
- Daten können unterschiedlich repräsentiert werden, z.B. Dezimal 12 = Hexadezimal C = Binär 1100 (kommt intensiv in der Schule dran)
- In Java gibt es acht primitive Datentypen:

| Datentyp |  Größe | Wertebereich                                                      |
|:---------|-------:|:------------------------------------------------------------------|
| byte     |  8 bit | Ganzzahl -128 bis 127                                             |
| short    | 16 bit | Ganzzahl -32768 bis 32767                                         |
| int      | 32 bit | Ganzzahl -2.147.483.648 bis 2.147.483.647                         |
| long     | 64 bit | Ganzzahl -9.223.372.036.854.775.808 bis 9.223.372.036.854.775.807 |
| float    | 32 bit | Gleitkommazahl mit 6-7 Zeichen Präzision                          |
| double   | 64 bit | Gleitkommazahl mit 15 Zeichen Präzision                           |
| char     | 16 bit | 16-bit Unicode Zeichen                                            |
| boolean  |  1 bit | true oder false                                                   |


## Typkonvertierung
- Von **Typkonvertierung** spricht man, wenn man Werte eines Datentyps in eine Variable eines anderen Datentyps speichern möchte, z.B. double x = 4;
- Implizite Typkonvertierung kann zu Kompilierungsfehlern führen.
- Explizite Typkonvertierung (Casting) ist möglich, indem man den Zieldatentyp in Klammern angibt, z.B. int x = (int) 2.0;
- Typkonvertierung kann zu Datenverlust führen, z.B. int y = (int) 2.75;

Beispiel:
```java 
float floatValue;
double doubleValue;
floatValue = 2; // Implizite Konvertierung funktioniert von int nach float
floatValue = 2.0; // FEHLER! Funktioniert nicht, weil double der Standard für Gleitkommazahlen ist
floatValue = 2.0F; // Mit dem F-Suffix wird die Zahl explizit als float gekennzeichnet
doubleValue = floatValue; // Implizite Konvertierung funktioniert von float zu double
floatValue = doubleValue; // FEHLER! Implizite Konvertierung funktioniert nicht von double zu float
floatValue = (float) doubleValue; // Explizite Konvertierung (Casting), aber Datenverlust möglich
```

## Sichtbarkeit und Zugangsbeschränkung
Der Zugriff auf Felder (Variablen/Konstanten) wird über Modifier geregelt (dazu im Lauf des Tutoriums mehr).

| Modifier    | Class | Package | Subclass | World |
|-------------|-------|---------|----------|-------|
| public      | Yes   | Yes     | Yes      | Yes   |
| protected   | Yes   | Yes     | Yes      | No    |
| no modifier | Yes   | Yes     | No       | No    |
| private 	   | Yes   | No      | No       | No    |

Beispiel:
```java
public int publicAnswer = 42;
```


# Arithmetische Ausdrücke

Arithmetische Ausdrücke haben immer die Form "varA << Operator >> varB"
```java
int myInt = 1 + 2;
```
Ausgaben von Berechnungen können auch inline geschrieben werden:
```java
System.out.println( 1 + 2 ); // Ausgabe: 3
```
Text (Zeichenketten) wird immer unverändert ausgegeben:
```java
System.out.println( "1 + 2" ); // Ausgabe: 1 + 2
```

## Division
Ganzzahlige Division schneidet Nachkommaanteil des Ergebnisses ab.

Beispiele:
```java
8 / 4; // 2
11 / 4; // 2
-11 / 4; // -2
```

## Modulo
Fünfte "Grundrechenart" Divisionsrest wird als Modulus bezeichnet. Der Modulo-Operator ist das **%**-Zeichen.
Java benutzt zur Berechnung ganzzahlige Division:

Formel: a % b = a – (a / b) * b

```java
int a = -5
int b = 2
//-5 % 2 = -5 - (-5 / 2) * 2
//-5 % 2 = -5 - (-2) * 2
//-5 % 2 = -5 +4
//-5 % 2 = -1
-5 % -2; // -1
```

## Zusammengesetzte Ausdrücke
Mehrere Ausdrücke können kombiniert werden. Auch in Java gilt Klammer vor Punkt (*, /, %) vor Strich (+, -)
Klammern sind um jeden Ausdruck erlaubt: dabei spielt es keine Rolle, ob Klammern die
Auswertungsreihenfolge beeinflussen oder nicht.

```java
2 + 3 * 4  // 14
2 + (3 * 4)  // 14
(2 + 3) * 4  // 20
```

## Kompatibilität
Allgemein: ein Typ T ist kompatibel zu einem anderen Typ U, wenn ein
Wert vom Typ T einer Variablen vom Typ U zugewiesen werden kann.

Beispiel int → double

Zu jedem int-Wert gibt es einen äquivalenten double-Wert (2 → 2.0)
```java
// zwei Operanden gleichen Typs -> Ergebnistyp = Operandentyp
1 + 2 // 3 (int)
// gemischte Operandentypen int/double -> Ergebnistyp ist immer double
1.0 + 2 // 3.0 (double)
1 + 2. // 3.0 (double)
```
Hier sehen wir implizite/automatische Typkonvertierung, d.h. Umwandlung eines Typs in einen
anderen.
- Konvertierung int → double findet immer dann statt, wenn int verfügbar
  ist, aber double gebraucht wird.
- zu vielen double-Werten gibt es keinen äquivalenten int-Wert
  - zum Beispiel 1E100
  - deshalb hier keine implizite Typkonvertierung von double → int
- double-Werte, die äquivalente int-Wert haben (also im Wertebereich von Integer sind) können konvertiert werden.
  - double d = 2; // implizite Typkonvertierung 2 → 2.0


# Input Output

## Eingabe
Für die Eingabe benötigt ihr einen Scanner, der zu Beginn des Programms einmalig mit folgender Zeile erzeugt werden muss:

```java
Scanner scanner = new Scanner(System.in);
```

Danach können dann Eingaben von der Konsole eingelesen werden. Folgende Beispiele lesen Eingaben unterschiedlichen Typs vom Benutzer ein:
```java
int intEingabe = scanner.nextInt();
double doubleEingabe = scanner.nextDouble();
String stringEingabe = scanner.nextLine();
```

Um den Scanner sauber zu schließen benutzt man folgenden Befehl:
```java
scanner.close();
```

## Ausgabe
Für die Ausgabe benötigt Ihr die Funktionen `print`/`println`. Dieses Beispiel gibt den Text "Hallo Welt" aus:
```java
// ohne Zeilenumbruch
System.out.print("Hallo Welt!");

// mit Zeilenumbruch
System.out.println("Hallo Welt!");
```

Ausblick zu formatierter Ausgabe. Bei formatierter Ausgabe können Werte für Platzhalter angegeben werden.
Dabei gibt es unterschiedliche "Format Specifier" für unterschiedliche Datentypen (z.B. %d steht für Zahlen)
```java
System.out.format("Wert: %d", 23);
// --> Wert: 23
```

# Tipp zu den Übungen

**Testet** vor der Abgabe selbst mit verschiedenen Werten für die drei Konstanten und die Zutaten- bzw. Tagesanzahl und vollzieht im Kopf nach, ob die berechneten Ergebnisse stimmen können.
