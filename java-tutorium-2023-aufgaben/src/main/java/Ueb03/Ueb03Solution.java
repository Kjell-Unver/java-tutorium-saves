package Ueb03;

import java.util.Scanner;

public class Ueb03Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Was ist Ihre untere Grenze für das Programm?");
        int lowerBound = scan.nextInt();
        System.out.println("Was ist Ihre obere Grenze für das Programm?");
        int upperBound = scan.nextInt();

        for (int i = lowerBound; i <= upperBound; i++){
            System.out.format("%" + String.valueOf(upperBound).length() + "d gerade: %-5b prim: %-5b dreieck: %-5b\n", i, isEven(i), isPrime(i), isTriangular(i));
        }
    }
    public static boolean isEven(int toCheckInteger) {
        return toCheckInteger % 2 == 0;
    }

    public static boolean isPrime(int toCheckInteger) {
        if (toCheckInteger <= 2) {
            return (toCheckInteger == 2);
        }
        int i = 2;
        do {
            if (toCheckInteger % i == 0) {
                return false;
            }
            i++;
        } while (i * i <= toCheckInteger);

        return true;
    }

    public static boolean isTriangular(int toCheckInteger) {
        int triangular = 0;
        int a = 0;
        while (triangular < toCheckInteger) {
            triangular = a * (a + 1) / 2;
            a++;
        }

        return triangular == toCheckInteger;
    }
}
