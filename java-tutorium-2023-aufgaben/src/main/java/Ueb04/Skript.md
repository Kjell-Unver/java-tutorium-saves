# Session 4

## Agenda
- Character
- ASCII
- Strings
- Reguläre Ausdrücke (Ausblick)

### Character
Mittlerweile habt ihr ja schon öfters mit Strings gearbeitet, was eine beliebige Zeichenkette darstellt. Ein Glied dieser 
Kette bzw. ein Zeichen nennt sich Character und wird als primitiver Datentyp mit 'char' deklariert. Eine Variable vom Typ char ist eine 
2 Byte große Variable, in der alle 256 Zeichen der [ASCII-Tabelle](https://tools.piex.at/ascii-tabelle/) dargestellt werden können und 
somit euch das Schreiben von normalen Wörtern und Sätzen ermöglicht wird.

Im Code kann ein char wie folgt dargestellt werden:
```java
char char1 = 'a';

String word = "hallo";
char charOfString = word.charAt(1);
```

### ASCII
Ein Rechner kann bekanntlich ja nur mit Zahlen umgehen und ganz granular gesehen nur mit 1 und 0. Wie also kann er uns Buchstaben oder sogar Sonderzeichen darstellen?

Hierfür gibt es mehrere Codes, anhand derer ein Rechner Zeichen auf Zahlen mappen kann. Der bekannteste Code für Zeichen ist hier der ASCII-Code.
Ursprünglich waren es nur 128 Zeichen im ASCII-Code, welche die gängigen Zeichen wie Zahlen, Buchstaben und bekannte Sonderzeichen wie "!", "?" oder "," abdeckten.
Diese wurde jedoch auf 256 Zeichen erweitert um noch andere Sonderzeichen und Buchstaben aus anderen Sprachen mit einzuschließen.
Ein Zeichen wird in der Tabelle einer Zahl zu gewiesen und diese Zahl lässt sich in diversion Zahlensystem darstellen, wie schlussendlich im Binären-Zahlensystem.

https://tools.piex.at/ascii-tabelle/

### Strings
Hier nochmal zusammen gefasst, was wir bisher über Strings wissen:
- Strings sind Zeichenketten, die mehrere Characters umfassen.
- String ist ein Referenztyp und stellt somit ein Object dar &#8594; String ist *KEIN* primitiver Datentyp
- An einem String lassen sich Methoden aufrufen, um auf dem jeweiligen String Operation auszuführen.
- Mögliche Methoden:
  - indexOf:
    Sucht iterativ nach dem ersten Vorkommen eines bestimmten Characters von der linken bis zur rechten Seite des Strings.
    > int indexOfA = "hallo".indexOf("a"); // indexOfA enthält den Index 1.
  - lastIndexOf:
    Sucht iterativ nach dem ersten Vorkommen eines bestimmten Characters von der rechten bis zur linken Seite des Strings.
    > int lastIndexOfL = "hallo".lastIndexOf("l"); // indexOfL enthält den Index 3.
  - substring:
    Unterteilt einen String in einen weiteren String. Als Parameter werden die Indizes angeben, die den Beginn des neuen Strings und das Ende definieren. (Indizes fangen bei 0 (null) an!)
    > String newSubString = "Hallo Welt!".substring(0,5); // newSubString enthält den String "Hallo".
  - length:
    Gibt die Länge eines Strings bzw. die Anzahl der Zeichen des String zurück.
    > int lengthOfString = "hallo".length(); // Gibt 5 zurück.
  - charAt:
    Gibt den Character an der Stelle zurück, die als Index übergeben wird.
    > char char1 = "hallo".charAt(1); // Gibt den Character 'a' zurück.

### Reguläre Ausdrücke (Ausblick)
Wenn wir bisher Strings miteinander verglichen haben, dann war es immer ein exakter Match der Strings. Somit ist es nicht ohne weiteres direkt 
möglich gewesen zu sagen: Gebe mir eine Liste mit allen Strings wieder, die mit einem Vokal anfangen und mit einem Vokal enden.
Hierfür werden reguläre Ausdrücke benutzt.

```java
public boolean beginsAndEndWithAVowel(String string) {
    Pattern pattern = Pattern.compile("^[aeiouAEIUO][A-Za-z0-9_]*[aeiouAEIUO]$");
    Matcher matcher = pattern.matcher(string);
    
    return matcher.find();
    }
```