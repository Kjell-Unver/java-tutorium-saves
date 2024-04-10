package Ueb02;

import java.util.Scanner;

public class Examples {

    public static void main(String[] args) {

        String myString1 = "foo";
        String myString2 = "foo"; // Besonderheit bei Strings: Es wird nicht immer ein neues Objekt erzeugt (String interning)
        String myString3 = new String("foo"); // Erzeugung eines neuen String-Objekts wird erzwungen

        System.out.print("myString1 == myString1 ");
        System.out.println(myString1 == myString1);

        System.out.print("myString1 == myString2 ");
        System.out.println(myString1 == myString2);

        System.out.print("myString1 == myString3 ");
        System.out.println(myString1 == myString3);

        System.out.print("myString1.equals(myString3) ");
        System.out.println(myString1.equals(myString3));

        // Zahlen werden implizit nach String gecastet, aber der + Operator ist links-nach-recht-assoziativ
        System.out.println(1 + 2 + "3");
        System.out.println("1" + 2 + 3);

        // Obacht beim Verwenden ähnlich aussehender Operatoren. Kann schnell unübersichtlich werden
        int x = 10;
        System.out.println(x+++x);

        Scanner scanner = new Scanner(System.in);
        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();

        boolean isLeapYear = year % 4 == 0 && year % 100 != 0 || year % 400 == 0;

        boolean dateValid = true;
        if (month < 1 || month > 12) dateValid = false;
        else if (day < 1 || day > 31) dateValid = false;
        else {
            switch (month) {
                case 2:
                    if (day > 29 || !isLeapYear && day > 28) dateValid = false;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    if (day > 30) dateValid = false;
                    break;
            }
        }
        if (dateValid) System.out.println("Datum ist gültig");
        else System.out.println("Datum ist ungültig");
    }
}
