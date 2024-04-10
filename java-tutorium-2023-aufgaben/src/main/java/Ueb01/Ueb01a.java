package Ueb01;

import java.util.Scanner;

public class Ueb01a {

    static final int REQUIRED_NUMBER_OF_MEAT = 1;
    static final int REQUIRED_NUMBER_OF_POTATOES = 4;
    static final int REQUIRED_NUMBER_OF_BEANS = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Abfrage der vorhandenen Zutaten
        System.out.println("Wie viele Stücke Fleisch sind vorhanden?");
        int meatAvailable = scanner.nextInt();
        System.out.println("Wie viele Kartoffeln sind vorhanden?");
        int potatoesAvailable = scanner.nextInt();
        System.out.println("Wie viele Bohnen sind vorhanden?");
        int beansAvailable = scanner.nextInt();

        // Berechnung der Anzahl der möglichen Gerichte
        int potatoDishes = potatoesAvailable / REQUIRED_NUMBER_OF_POTATOES;
        int beanDishes = beansAvailable / REQUIRED_NUMBER_OF_BEANS;
        int meatDishes = meatAvailable / REQUIRED_NUMBER_OF_MEAT;
        int numberOfPossibleDishes = Math.min(meatDishes, (Math.min(potatoDishes, beanDishes)));

        // Berechnung der nicht benötigten Zutaten
        int potatoRest = potatoesAvailable - (numberOfPossibleDishes * REQUIRED_NUMBER_OF_POTATOES);
        int beanRest = beansAvailable - (numberOfPossibleDishes * REQUIRED_NUMBER_OF_BEANS);
        int meatRest = meatAvailable - (numberOfPossibleDishes * REQUIRED_NUMBER_OF_MEAT);

        // Ausgabe
        System.out.println("Es können " + numberOfPossibleDishes + " Gerichte hergestellt werden.");
        System.out.println("Es bleiben über: " + meatRest + " Stück(e) Fleisch, " + potatoRest + " Kartoffel(n) und " + beanRest + " Bohne(n)");

        scanner.close();
    }
}
