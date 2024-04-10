package Ueb02;

import java.util.Scanner;

public class Ueb02bSolution {

    public static void main(String[] args) {
        //U1 : 47 Haltestellen
        //U2 : 25 Haltestellen
        //U3 : 26 Haltestellen
        //U4 : 9 Haltestellen
        Scanner scanner = new Scanner(System.in);
        System.out.println("Möchtest du die Inverssuche starten?");

        switch (scanner.nextLine()) {
            case "j":
            case "J":
                //Check für Inverse
                System.out.println("Wie viele Haltestellen?");
                switch (scanner.nextInt()) {
                    case 47:
                        System.out.println("Die Linie U1 hat 47 Haltestellen.");
                        break;
                    case 25:
                        System.out.println("Die Linie U2 hat 25 Haltestellen.");
                        break;
                    case 26:
                        System.out.println("Die Linie U3 hat 26 Haltestellen.");
                        break;
                    case 9:
                        System.out.println("Die Linie U4 hat 9 Haltestellen.");
                        break;
                    default:
                        System.out.println("Keine Linie gefunden.");
                        break;
                }
                break;
            case "n":
            case "N":
                //Check regulär
                System.out.println("Welche Linie?");
                switch (scanner.nextLine()) {
                    case "U1":
                        System.out.println("Die U1 hat 47 Haltestellen.");
                        break;
                    case "U2":
                        System.out.println("Die U2 hat 25 Haltestellen.");
                        break;
                    case "U3":
                        System.out.println("Die U3 hat 26 Haltestellen.");
                        break;
                    case "U4":
                        System.out.println("Die U4 hat 9 Haltestellen.");
                        break;
                    default:
                        System.out.println("Keine Linie gefunden.");
                        break;
                }
                break;
        }

    }
}