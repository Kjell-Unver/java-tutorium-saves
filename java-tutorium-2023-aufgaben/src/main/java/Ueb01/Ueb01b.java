package Ueb01;

import java.util.Scanner;

public class Ueb01b {

    static final int DAYS_OF_YEAR = 336;
    static final int DAYS_OF_MONTH = 28;
    static final int DAYS_OF_WEEK = 7;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //User-Input
        System.out.println("Wie viele Kerben sind schon im Holz?");
        int notches = scanner.nextInt();

        // Berechnung der Jahre und restlichen Kerben
        int years = notches / DAYS_OF_YEAR;
        int notchesLeft = notches % DAYS_OF_YEAR;
        // Berechnung der Monate und restlichen Kerben
        int months = notchesLeft / DAYS_OF_MONTH;
        notchesLeft = notchesLeft % DAYS_OF_MONTH;
        // Berechnung der Wochen und restlichen Kerben
        int weeks = notchesLeft / DAYS_OF_WEEK;
        notchesLeft = notchesLeft % DAYS_OF_WEEK;

        System.out.println(notches + " Kerben entsprechen");
        System.out.println(years + " Jahren");
        System.out.println(months + " Monaten");
        System.out.println(weeks + " Wochen und");
        System.out.println(notchesLeft + " Tagen");

        scanner.close();
    }
}
