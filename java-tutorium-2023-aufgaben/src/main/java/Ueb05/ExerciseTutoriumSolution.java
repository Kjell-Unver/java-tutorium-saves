package Ueb05;

import java.util.Scanner;

public class ExerciseTutoriumSolution {

    public static void main(String[] args) {

        final int ARRAY_LENGTH = Integer.parseInt(args[0]);
        String[] dateOfBirth = new String[ARRAY_LENGTH];
        int[] age = new int[ARRAY_LENGTH];

        String today = "2023-12-14";

        Scanner scanner = new Scanner(System.in);

        int i = 0;
        while (i < ARRAY_LENGTH) {
            System.out.println("Bitte gib dein Geburtsdatum ein.");
            String date = scanner.nextLine();
            if (dateValid(date)) {
                dateOfBirth[i] = date;
                age[i] = calculateAge(date, today);
                i++;
            } else {
                System.out.println("Die Eingabe war ungültig.");
            }
        }

        System.out.format("Heute ist der %s.%n", today);
        printArrays(dateOfBirth, age);
    }

    static boolean dateValid(String date) {
        int day, month, year;
        if (date.length() != 10) {
            return false;
        } else if (date.charAt(4) != '-' || date.charAt(7) != '-') {
            return false;
        } else {
            try {
                day = getDay(date);
                month = getMonth(date);
                year = getYear(date);
            } catch (NumberFormatException e) {
                return false;
            }
        }
        if (day < 1 || day > 31 || month < 1 || month > 12 || year > 2023) {
            return false;
        }
        switch (month) {
            case 4:
            case 6:
            case 9:
            case 11:
                if (day > 30) return false;
                break;
            case 2:
                if (day > 29 || (day > 28 && !isLeapYear(year))) return false;
                break;
        }
        return true;
    }

    private static boolean isLeapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    static int calculateAge(String date, String today) {
        int age = getYear(today) - getYear(date);
        if (getMonth(today) < getMonth(date) || (getMonth(today) == getMonth(date) && getDay(today) < getDay(date))) {
            age--;
        }
        return age;
    }

    static int getYear(String date) {
        // return Integer.parseInt(date.substring(0, 4));
        return Integer.parseInt(date.substring(0, date.indexOf('-')));
    }

    static int getMonth(String date) {
        // return Integer.parseInt(date.substring(5, 7));
        return Integer.parseInt(date.substring(date.indexOf('-') + 1, date.lastIndexOf('-')));
    }

    static int getDay(String date) {
        // return Integer.parseInt(date.substring(8, 10));
        return Integer.parseInt(date.substring(date.lastIndexOf('-') + 1));
    }

    static void printArrays(String[] dateOfBirth, int[] age) {
        for (int i = 0; i < age.length; i++) {
            System.out.format("Die Person. die am %s Geburtstag hat, ist aktuell %d Jahre alt.%n", dateOfBirth[i], age[i]);
        }
    }
}
