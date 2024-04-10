package Ueb03;

import java.util.Scanner;

public class Examples {

//    public static int addNumbers(int number1, int number2) {
//        return number1 + number2;
//    }
//
//    static void addAndPrintNumbers(int number1, int number2) {
//        System.out.println(number1 + number2);
//    }



    public static void main(String[] args) {


        String name = "Peter";
        String str = String.format("%s ist %-5d Jahre alt%n", name, 18);
        str += String.format("%s ist %-5d Jahre alt%n", name, 180);
        str += String.format("%s ist %-5d Jahre alt%n", name, 1800);
        str += String.format("%s ist %-5d Jahre alt", name, 18000);
        System.out.println(str);


//        int x = 5;
//        int y = 4;
//
//        int result = addNumbers(x, y) - 3;
//
//        result = addNumbers(addNumbers(x, y), addNumbers(x, y));
//        System.out.println(result);
//        x = 7;
//        y = 11;
//        addAndPrintNumbers(x, y);






        // Schleifen in Java

        // while
//        int i = 0;
//        while (i < 10) {
//            System.out.println(++i);  // 1 ... 10
//        }
//        i = 0;
//        while (i < 10) {
//            i++;
//            System.out.println(i);  // 1 ... 10
//        }
//
//        i = 0;
//        while (i < 10) {
//            System.out.println(i++);  // 0 ... 9
//        }
//        i = 0;
//        while (i < 10) {
//            System.out.println(i);  // 0 ... 9
//            i++;
//        }

        // do while
//        i = 0;
//        do {
//            i++;
//            System.out.println(i);
//        } while (i < 10);

        // User gibt immer wieder Zahl ein. Zahl wird so lange ausgegeben, solange zahl < 10

//        Scanner scanner = new Scanner(System.in);
//        int number;
//        boolean continueLoop;
//        do {
//            System.out.print("Gib eine Zahl ein: ");
//            number = scanner.nextInt();
//            continueLoop = number < 10;
//            if (continueLoop) {
//                System.out.println(number);
//            }
//        } while (continueLoop);

//        int number = 0;
//        while (number < 10) {
//            System.out.print("Gib eine Zahl ein: ");
//            number = scanner.nextInt();
//            if (number < 10) {
//                System.out.println(number);
//            }
//        }

//        System.out.print("Gib eine Zahl ein: ");
//        int number = scanner.nextInt();
//        while (number < 10) {
//            System.out.println(number);
//            System.out.print("Gib eine Zahl ein: ");
//            number = scanner.nextInt();
//        }


        // while
//        int j = 0;
//        while (j < 10) {
//            j++;
//            if (j == 7) continue;
//            System.out.println(j);
//        }

        // for
//        int i = 1;
//        for (;;) {
//            if (!(i <= 10)) break;
//            System.out.println(i);
//            i++;
//        }

        // foreach
//        int[] numberArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        for (int i : numberArray) {
//            System.out.println(i);
//        }




    }
}
