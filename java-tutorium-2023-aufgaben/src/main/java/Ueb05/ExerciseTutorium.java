package Ueb05;

import java.util.Scanner;

public class ExerciseTutorium {

    // Kommandozeilenparameter: Länge der Arrays = 3
    public static void main(String[] args) {
        int len = Integer.parseInt(args[0]);
        String today = "2022-11-24";
        String dateRegEx = "[12][0-9]{3}-[01][1-9]";

        int[] age = new int[len];
        String[] dateOfBirth = new String[len];

        Scanner s = new Scanner(System.in);

        for (int i = 0; i < len; i++) {
            String date = s.nextLine();
            dateOfBirth[i] = date;
        }
    }
}
