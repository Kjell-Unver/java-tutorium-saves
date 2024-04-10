# Aufgabe 9: verkettete Liste mit null-Referenz

Die Klasse `MyList`, die im Tutorium vorgestellt wurde, enthält eine statische Klasse `Element`, die ein Objekt erzeugt, das einen Integer-Wert (`value`) sowie eine Referenz auf ein weiteres `Element`-Objekt (`next`) enthält. Dadurch können `Element`-Objekte verkettet werden. Die Klasse `MyList` hat das Feld `startElement` vom Typ `Element`, welches das erste Element der verketteten Liste speichert.

## Methoden der Klasse `MyList`

* `boolean isEmpty()`: liefert `true`, wenn die Liste mindestens ein Element enthält.
* `int size()`: liefert die Anzahl der Listenelemente.
* `int[] getValuesAsArray()`: liefert ein Array mit den in der Liste enthaltenen Werten.
* `void appendValue(int value)`: erzeugt ein neues Element mit dem Wert `value` und hängt dieses ans Ende der Liste an.

Implementiert in der Klasse `MyList` die noch fehlenden Methoden (gekennzeichnet mit `TODO`):

* `int popValue()`: entfernt das letzte Element aus der Liste und gibt den Wert zurück.
* `void insertValueAtIndex(int value, int index)`: fügt ein Element mit dem Wert `value` an der Stelle `index` ein. Existiert beim Index kein Element, so wird eine `IndexOutOfBoundsException` geworfen.
* `void insertValueAtFront(int value)`: fügt ein Element mit dem Wert `value` an den Anfang der Liste.
* `void deleteValueAtIndex(int index)`: entfernt das Element an der Stelle `index` aus der Liste. Existiert beim Index kein Element, so wird eine `IndexOutOfBoundsException` geworfen.
* `int getValueAtIndex(int index)`: liefert den Wert an der Stelle `index`. Existiert beim Index kein Element, so wird eine `IndexOutOfBoundsException` geworfen.
* `void setValueAtIndex(int value, int index)`: setzt den Wert `value` an der Stelle `index`, wenn es an dieser Stelle bereits ein Element gibt. Existiert beim Index kein Element, so wird eine `IndexOutOfBoundsException` geworfen.
* `boolean valueExists(int value)`: liefert `true`, wenn dieser Wert bereits in der Liste enthalten ist.
* `boolean isSorted()`: liefert `true`, wenn die Liste aufsteigend sortiert oder leer ist.
* `void insertValueSorted(int value)`: fügt ein Element mit dem Wert `value` sortiert in die Liste ein, d. h. vor dem ersten Element mit einem größeren Wert bzw. nach dem letzten Element mit einem kleineren Wert.
* `void sort()`: sortiert die Liste aufsteigend.
* `String toString()`: liefert einen String, der umschlossen von geschweiften Klammern die in der Liste enthaltenen Werte (jeweils durch ein Leerzeichen getrennt) darstellt, z. B.: `"{3 6 7 9}"`

## Unit-Tests

Die Test-Klasse `MyListTests` prüft bis jetzt nur die im Tutorium vorgestellten Methoden der Klasse `MyList`. Mit eigenen Testmethoden könnt Ihr die Funktionalität der übrigen Methoden überprüfen. Implementiert dazu die fehlenden Unit-Tests (gekennzeichnet mit `TODO`), mit welchen sinnvolle Fälle (z.B. leere Liste, Liste mit Elementen) abgetestet werden.

* Zu verwenden sind `assertTrue()`, `assertFalse()`, `assertEquals()`, `assertArrayEquals()` und `assertThrows()`. 
* Wendet `assertEquals()` nicht auf Referenztypen an, sondern nur auf primitive Datentypen.
* Mit `assertThrows()` testet man, ob eine Exception geworfen wird. Zum Beispiel: `assertThrows(IndexOutOfBoundsException.class, () -> list.deleteValueAtIndex(list.size()))`

**Viel Erfolg!**
