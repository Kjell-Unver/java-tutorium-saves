package Ueb07;

import java.util.Arrays;

public class Examples {

    public static void main(String[] args) {

        String hallo = "hallo";
        System.out.println(hallo.toUpperCase());

        char a = 'a';                   // 0110 0001  97
        System.out.println(a << 1);     // 1100 0010 194
        System.out.println(a >> 1);     // 0011 0000  48
        System.out.println(a & 'b');    // 0110 0001
        // 0110 0010
        // 0110 0000  96

        char[] chars = hallo.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.print((char) (chars[i] - 32));
        }
        System.out.println("");

        for (int i = 0; i < chars.length; i++) {
            System.out.print(toUpper(chars[i]));
        }
        System.out.println("");


        int intA = 55;
        int intB = addOne(intA);
        System.out.println(intB);   // 56
        System.out.println(intA);   // 55

        int[] arrA = new int[]{11, 33, 55};
        int[] arrC = addNewOneToEach(arrA);
        System.out.println(Arrays.toString(arrC));  // [12, 34, 56]
        addOneToEachBetter(arrA);
        int[] arrB = arrA;
        System.out.println(Arrays.toString(arrB));  // [12, 34, 56]
        System.out.println(Arrays.toString(arrA));  // [12, 34, 56]

        arrB[0] = 1000;
        System.out.println(Arrays.toString(arrB));  // [1000, 34, 56]
        arrC[1] = 2000;
        System.out.println(Arrays.toString(arrC));  // [12, 2000, 56]
        System.out.println(Arrays.toString(arrA));  // [1000, 34, 56]
    }

    public static char toUpper(char c) {
        switch (c) {
            case 'a':
                return 'A';
            case 'b':
                return 'C';
            case 'h':
                return 'H';
            case 'l':
                return 'L';
            case 'o':
                return 'O';
        }
        return c;
    }

    public static int addOne(int x) {
        int result = x;
        result += 1;
        return result;
    }

    public static int[] addNewOneToEach(int[] arrX) {
        System.out.println("arrX: " + arrX);
        int[] result = new int[arrX.length];
        System.out.println("result: " + result);
        for (int i = 0; i < result.length; i++) {
            result[i] = arrX[i] + 1;
        }
        return result;
    }

    public static int[] addOneToEach(int[] arrX) {
        System.out.println("arrX: " + arrX);
        int[] result = arrX;
        System.out.println("result: " + result);
        for (int i = 0; i < result.length; i++) {
            result[i] += 1;
        }
        return result;
    }

    public static void addOneToEachBetter(int[] arrX) {
        System.out.println("arrX: " + arrX);
        int[] result = arrX;
        System.out.println("result: " + result);
        for (int i = 0; i < result.length; i++) {
            result[i] += 1;
        }
    }
}
