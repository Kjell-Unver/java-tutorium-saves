# Klassen und Objekte

Bisher liefen alle Methoden, die wir benutzt haben. auf Klassenebene ab. Dafür ist der Modifier `static` verantwortlich, zum Beispiel n der main-Methode.

Eine Klasse kann aber auch ein Bauplan sein, um Objekte zu erzeugen. Diese Objekte haben eigene Eigenschaften, die von Objekt zu Objekt unterschiedlich sein können. Außerdem können Objekte eigene Objekt-Methoden haben, die sich dann speziell auf dieses Objekt beziehen.

Wir haben die Klasse `Person`. Mit dieser Klasse als Bauplan lassen sich nun Objekte (oder Instanzen) erzeugen, d.h. einzelne Personen, die jeweils unterschiedliche Eigenschaften wie Name und Alter haben.
```java
public class Person {
    String name;
    int age;
}
```

Man kann eine Instanz mit dem `new`-Operator und dem Konstruktor erzeugen. Die einzelnen Felder (und wenn vorhanden, Methoden) lassen sich dann über die Punkt-Notation aufrufen.
```java
Person alex = new Person();
alex.name = "Alex";
```

## Sichtbarkeit
Im obigen Beispiel kann man auf die Felder `name` und `age` direkt zugreifen, nachdem man ein Objekt vom Typ `Person` erzeugt hat. In der Regel ist dies nicht gut, denn der Vorteil von objektorientierter Programmierung besteht in der Kapselung. Andere Entwickler*innen, die Objekte einer Klasse verwenden, sollen oft nicht alle Felder verändern und alle Methoden aufrufen können, sondern nur Zugriff auf bestimmte Felder und Methoden haben. Um dies zu steuern, werden Modifier wie `public` und `private` benutzt.

### Getter und Setter
Es ist eine Best Practice, alle Felder als `private` zu deklarieren und für den gezielten Zugriff Getter- und Setter-Methoden zur Verfügung zu stellen. Auf die Objektvariablen kann man innerhalb der Klasse mit dem Schlüsselwort `this` zugreifen.
```java
public class Person {
    private String name;
    private int age; 
    
    public String getName() { 
        return this.name;
    }  
    
    public int getAge() { 
        return this.age;
    } 
    
    public void setName(String name) { 
        this.name = name;
    }
    
    public void setAge(int age) { 
        this.age = age;
    }
}
```

Wenn eine Instanz einer Person nun erzeugt wird, kann man über diese Methoden auf die einzelnen Felder des Objekts zugreifen:
```java
Person alex = new Person();
alex.setName("Alex");
alex.setAge(42);
System.out.println(alex.getName() + " ist " + alex.getAge() + " Jahre alt.");
```

### Konstruktoren
Jede Klasse hat einen Konstruktor (auch wenn man den Konstruktor nicht explizit reinschreibt). So ein Standard-Konstruktor erzeugt eine Instanz, aber die Felder werden dabei nicht initialisiert.

Es ist aber möglich, Felder über einen parametrisierten Konstruktor zu initialisieren. Dies kann beispielsweise sinnvoll sein, wenn diese Felder nachträglich nicht mehr über Setter verändert werden sollen.
```java
public class Person {
    private final String name;
    private final int age; 

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}
```

Beim Erzeugen eines neuen Objekts können nun die Werte über Parameter im Konstruktor übergeben werden:
```java
Person alex = new Person("Alex", 42);
System.out.println(alex.getName() + " ist " + alex.getAge() + " Jahre alt.");
```

## Statische Felder und Methoden
Statische Felder und Methoden sind immer dann sinnvoll, wenn sie sich nicht auf ein bestimmtes Objekt beziehen.

Zum Beispiel könnte man in die Klasse `Person` einen Zähler einbauen, wie viele Personen aktuell existieren (in der Java-Welt). 
```java
public class Person {
    private static int counter;

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        counter++;
    }

    public String getName() { 
        return this.name;
    }  
    
    public int getAge() { 
        return this.age;
    } 
    
    public static int getCounter() {
        return counter;
    }
}
```

Klassenmethoden wie `getCounter` werden dann über den Klassennamen aufgerufen, also `Person.getCounter()`.
```java
Person alex = new Person("Alex", 42);
System.out.println(Person.getCounter()); // Ausgabe: 1
Person hans = new Person("Hans", 24);
System.out.println(Person.getCounter()); // Ausgabe: 2
```
