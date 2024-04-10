package Ueb06;

import java.util.Arrays;

public class Person {

    // Klassen-Variablen
    private static int personCounter;

    // Objektvariablen
    private String name;
    private int[] birthDate;
    private int numberOfFriends;

    // Konstruktoren
    //public Person() {}

    public Person(String name, int[] birthDate) {
        this(name, birthDate, 0);
    }

    public Person(String name, int[] birthDate, int numberOfFriends) {
        this.name = name;
        this.birthDate = birthDate;
        this.numberOfFriends = numberOfFriends;
        personCounter++;
    }

    // Getter-Methoden
    public int[] getBirthDate() {
        return birthDate;
    }

    public int[] getBirthDateAsNewArray() {
        return Arrays.copyOf(birthDate, 3);
    }

    public int getNumberOfFriends() {
        return numberOfFriends;
    }

    // Setter-Methoden
    public void setNumberOfFriends(int friends) {
        if (friends > 0) numberOfFriends = friends;
    }

    // Objekt-Methoden
    public int getAge(int[] currentDate) {
        return currentDate[0] - this.birthDate[0];
    }

    // Klassen-Methode
    public static int getPersonCounter() {
        return personCounter;
    }

}
