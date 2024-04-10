# Aufgabe 1

## Thema: Ein- und Ausgabe, Modulo und ganzzahlige Division

Die 1. Aufgabe besteht aus zwei Teilen. In Teil A soll für gegebene Mengen von Zutaten berechnet werden, wie viele Gerichte sich daraus kochen lassen und wie viele Zutaten am Ende übrigbleiben. Teil B soll zu einer einzugebenden Tagesanzahl berechnen, wie vielen Tagen, Wochen, Monaten und Jahren dies entspricht.

Im Package Ueb01 liegen zwei Codedateien (Ueb01a.java und Ueb01b.java). Löst darin die beiden Teile, sodass jeweils die folgenden Anforderungen erfüllt werden:

## Anforderungen Teil A

* Das Programm soll zu Beginn vom Benutzer abfragen und in drei verschiedene Variablen einlesen, wie viele Stücke Fleisch, wie viele Kartoffeln und wie viele Bohnen als Zutaten vorhanden sind:

        Wieviele Stücke Fleisch sind vorhanden?
        [Eingabe]
        Wieviele Kartoffeln sind vorhanden?
        [Eingabe]
        Wieviele Bohnen sind vorhanden?
        [Eingabe]

* Über drei Konstanten wird festgelegt, wie viele Stücke Fleisch, wie viele Kartoffeln und Bohnen für ein Gericht benötigt werden (z.B. 1 Stück Fleisch, 4 Kartoffeln und 10 Bohnen). Die Berechnung soll später natürlich auch dann noch korrekt funktionieren, wenn diese Konstanten geändert werden!
* Im Programm wird dann anhand der eingelesenen Werte und der Konstanten berechnet, wie viele Gerichte aus den Zutaten zubereitet werden können und wie viele der Zutaten übrigbleiben und dies wird dem Benutzer ausgegeben.
  Dazu ein Beispiel: Die drei Konstanten sind wie oben genannt auf 1, 4 und 10 gesetzt. Der Benutzer gibt an, dass 5 Stücke Fleisch, 18 Kartoffeln und 57 Bohnen vorhanden sind. Somit können 4 Gerichte hergestellt werden und es bleiben 1 Stück Fleisch, 2 Kartoffeln und 17 Bohnen über. Die Ausgabe dazu könnte wie folgt aussehen:

        Es können 4 Gerichte hergestellt werden.
        Es bleiben über: 1 Stück(e) Fleisch, 2 Kartoffel(n) und 17 Bohne(n)

* Bei der Berechnung bestimmt Ihr zunächst für jede der drei Zutaten getrennt, für wie viele Gerichte diese reichen würde. Danach bestimmt Ihr dann von diesen drei berechneten Werten den kleinsten mit der in Java bereits definierten Funktion min. Um diese zu benutzen, muss das Paket java.lang.Math eingebunden werden (import java.lang.Math;).

## Anforderungen Teil B

* Grundidee des 2. Teils ist, dass der Benutzer auf einer einsamen Insel gestrandet ist und für jeden Tag dort eine Kerbe in ein Holzstück macht. Da es sich um einen informatikbegeisterten Menschen handelt, schreibt er sich dann ein Programm zur Berechnung, seit wie vielen Tagen, Wochen, Monate und Jahren er nun schon festsitzt (zufällig wurde auch eine Kiste mit einem Laptop und stapelweise Akkus angespült...) :o)
* Das Programm fragt zu Beginn vom Benutzer ab, wie viele Kerben schon im Holzstück sind und liest diese Zahl ein und speichert sie in eine Variable vom Typ int.
* Anschließend wird berechnet, wie vielen Jahren, Monaten, Wochen und Tagen diese Tagesanzahl entspricht. Vereinfachend nehmen wir dabei an, dass ein Jahr immer 12 Monate hat, ein Monat immer aus 4 Wochen und eine Woche immer aus 7 Tagen besteht. Ein Jahr hat somit 336 "Kerben".
* Diese berechneten Werte sowie die übrigbleibenden Tage werden dann dem Benutzer in der folgenden Form ausgegeben:

        12321 Kerben entsprechen
        36 Jahren
        8 Monaten
        0 Wochen und
        1 Tagen

Ausgabe vorformatiert als Hilfestellung:
```java
System.out.println(notches + " Kerben entsprechen");
System.out.println(years + " Jahren");
System.out.println(months + " Monaten");
System.out.println(weeks + " Wochen und");
System.out.println(notchesLeft + " Tagen");
```

## Anforderungen für beide Teile

* Die Benutzung von `if`, `case` und Schleifen sowie weiteren, hier noch nicht behandelten Themen ist nicht erlaubt!
* Eingabefehler (z.B. "abc" als Tagesanzahl) und daraus resultierende Exceptions müssen nicht abgefangen werden
* Kommentiert Euren Code, wo/wie ihr wollt
* Benutzt so wenig Variablen wie möglich und wählt sinnvolle Typen!
* Achtet auf einheitliche und sprechende Bezeichner sowie auf eine brauchbare Einrückung
* Damit die automatisierten Abnahme-Tests problemlos durchlaufen, ist es erforderlich, die Ausgaben exakt wie in der Aufgabenbeschreibung umzusetzen!

## Abnahmetests

Hier findet Ihr die Basis-Abnahmetests für diese Übung:

* [Ueb01aTest.java](../../../test/java/Ueb01/Ueb01aTest.java)
* [Ueb01bTest.java](../../../test/java/Ueb01/Ueb01bTest.java)
