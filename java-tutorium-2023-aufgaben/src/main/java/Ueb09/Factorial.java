package Ueb09;

public class Factorial {

    public static void main(String[] args) {
        int n = 3000;
        long startTime = 0;
        long timeDifference = 0;

        startTime = System.nanoTime();
        factorialIter(n);
        timeDifference = System.nanoTime() - startTime;
        System.out.println("Iterativ " + timeDifference);

        startTime = System.nanoTime();
        factorialRec(n);
        timeDifference = System.nanoTime() - startTime;
        System.out.println("Rekursiv " + timeDifference);

        startTime = System.nanoTime();
        factorialRecTail(n);
        timeDifference = System.nanoTime() - startTime;
        System.out.println("Tail recursive " + timeDifference);
    }

    // 5!
    // 1 * 2 * 3 * 4 * 5

    public static int factorialIter(int number) {
        int factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public static int factorialRec(int number) {
        if (number == 1) {
            return 1;
        } else {
            return number * factorialRec(number - 1);
        }
    }

    public static int factorialRecTail(int number) {
        return factorialRecTail(number, 1);
    }

    private static int factorialRecTail(int number, int result) {
        if (number == 1) {
            return result;
        } else {
            return factorialRecTail(number - 1, number * result);
        }
    }

}
