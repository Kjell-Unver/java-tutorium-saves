# Aufgabe 4 

## Thema: Stringverarbeitung (`indexOf`, `lastIndexOf`, `substring`, `length`, `charAt`)

Menügesteuert kann der Benutzer einfache Veränderungen an einem eingegebenen Satz vornehmen. 

## Anforderungen

* Das Programm zeigt dem Benutzer ein Menü zur Auswahl der folgenden Aktion an. Dies wird nach Abschluss der Aktion ebenfalls wieder angezeigt, bis der Benutzer das Programm beendet (eine Schleife ist also erforderlich...). 

* Das Menü beinhaltet folgende Punkte, die jeweils bei Eingabe des genannten Buchstabens ausgeführt werden sollen: 

```
A) Satz eingeben 
B) Anzahl Leerzeichen bestimmen 
C) 1. und letztes Wort vertauschen 
D) Alle Vokale entfernen 
X) Ende
```

* Gibt der Benutzer einen anderen Buchstaben ein, passiert nichts oder das Menü wird erneut ausgegeben. 

* Bei Auswahl des Menüpunktes A erfolgt eine Aufforderung, einen Satz einzugeben, der in eine String-Variable eingelesen wird. Diese Variable darf von den Aktionen der Menüpunkte B, C und D nicht verändert werden! Ggf. ist also vorher in einer weiteren Stringvariable eine Kopie des Satzes anzufertigen. 

* Führt der Benutzer Menüpunkt B aus, wird der eingelesene Satz zeichenweise durchlaufen und die Anzahl der Leerzeichen darin wird gezählt und anschließend ausgegeben (z.B. "3 Leerzeichen im Satz gefunden"). 

* Menüpunkt C ermittelt das erste und das letzte Wort im Satz (also alles bis zum ersten bzw. alles ab dem letzten Leerzeichen) und gibt dann einen Satz aus, bei dem diese beiden Teile vertauscht wurden. 

  * Bsp: Aus "Nachts ist kälter als draußen" wird dadurch "draußen ist kälter als Nachts". 

* Zur Bestimmung der Position des 1. Leerzeichens nutzt bitte die Funktion indexOf. Die Lage des letzten Leerzeichens lässt sich dann am besten mittels lastIndexOf ermitteln. 

* Menüpunkt C darf nur dann funktionieren, wenn der Satz mindestens 2 Wörter aufweist und an erster und letzter Stelle des Strings kein Leerzeichen vorkommt. Ansonsten soll die Fehlermeldung `Der Satz muss mindestens 2 Wörter aufweisen und an erster und letzter Stelle darf kein Leerzeichen vorkommen!` erscheinen.

* Bei Menüpunkt D werden alle Vokale (egal, ob groß- oder kleingeschrieben) aus dem Satz entfernt. Danach erfolgt ebenfalls die Ausgabe des neuen Satzes. 

  * Bsp: Aus "Hallo Opa, ich habe Emil angerufen" entsteht somit "Hll p, ch hb ml ngrfn". 

* Nutzt hier optimalerweise eine for-Schleife zum Durchlaufen aller Vokale, die ihr vorab in einer Konstanten hinterlegt! So lässt sich jeweils ein Vokal suchen und ggf. löschen, bis alle Vorkommen aus dem String verschwunden sind. 

* Die Menüpunkte B, C und D dürfen nur auswählbar sein, wenn zuvor bereits ein Satz eingegeben wurde. Ansonsten wird bei der Eingabe von B, C oder D im Menü die Fehlermeldung `Es wurde noch kein Satz eingegeben!` angezeigt und das Menü wird wieder ausgegeben.

* Jeder Aufruf der Menüpunkte B, C und D arbeitet immer wieder auf dem originalen, vom Nutzer eingegebenen Satz und nicht auf einem ggf. bereits durch vorher ausgeführte Menüpunkte veränderten Satz! Führt man also z.B. den Menüpunkt C mehrfach nacheinander aus, kommt immer dasselbe heraus und das 1. und letzte Wort werden nicht jedes Mal wieder neu vertauscht 

* Durch erneute Eingabe des Menüpunktes A kann der eingegebene Satz auch durch einen neuen überschrieben werden 

* Mit einem 'X' kann der Benutzer das Programm beenden 

* Nutzt wo immer es geht die oben genannten Stringfunktionen und schreibt diese nicht selbst mühsam mit Schleifen etc. neu! Die Verwendung anderer, oben nicht genannter Stringfunktion ist verboten!

* Erstellt eine Hilfsklasse ("SentenceInvestigator") mit den statischen Methoden: countWhiteSpaces, switchFirstAndLastWord und removeVowels;
    
  * Für diese Klasse gibt es einen separaten Test.
  
  * Ihr könnt auch zusätzliche Funktionalitäten auslagern.  

* Die Benutzung Arrays sowie weiteren, hier noch nicht behandelten Themen ist nicht erlaubt! Hierzu zählen auch dynamische Datenstrukturen wie `List` und `Map` und sonstige Hilfsfunktionen von Java

## Hilfe 

Testet vor der Abgabe selbst mit verschiedenen Sätzen, ob die Menüpunkte B, C und D funktionieren und ob auch die weitere geforderte Funktionalität gegeben ist!

Nutzt eine Hilsklasse namens SentenceInvestigator, die die Logik hinter den Menüpunkten implementiert.

Die Hilfsklasse definiert Ihr Euch z.B. wie folgt:
```java
private class Helper {
    
    public static String helpMe() { 
        return "ok";
    }  
    
    public static int whatIsTheMeaning() { 
        return 42;
    } 
    
    public static String echo(String name) { 
        return name;
    }
}
```

Um statische Methoden aufzurufen muss die Klasse nicht instanziert werden. Die Methoden  können direkt an der Klasse aufgerufen werden.

```java
int theMeaning = Helper.whatIsTheMeaning()
```