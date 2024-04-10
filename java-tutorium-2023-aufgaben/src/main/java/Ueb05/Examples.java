package Ueb05;

import java.util.Arrays;

public class Examples {

    public static void main(String[] args) {

        System.out.println(args[0]);
        System.out.println(args[1]);

        int myNumber = 5;
        double myDouble = myNumber;
        myNumber = (int) myDouble;

        String myString = "5";
        myNumber = Integer.parseInt(myString);
        myDouble = Double.parseDouble(myString);


        int[] integerArray = new int[3];

        integerArray[0] = -5;
        integerArray[1] = 43;
        integerArray[2] = 27;

        String[] stringArray = new String[3];

        double[] doubleArray = {3.3, 2.1, 5.5};
        //                      0    1    2

//        String s = "abc";
//        System.out.println(s);  // abc
//        s = addAToString(s);
//        System.out.println(s);  // abcA
//
//        int x = 5;
//        System.out.println(x);  // 5
//        add1ToNumber(x);
//        System.out.println(x);  // 5
//
//        System.out.println(integerArray[1]);  // 43
//        addOneToEachElement(integerArray);
//        System.out.println(integerArray[1]);  // 44

        System.out.println(integerArray[1]);  // 43
        int[] nArr = addOneToEachElementAndCreateNewArray(integerArray);
        System.out.println(integerArray[1]);  // 43
        System.out.println(nArr[1]);          // 44
    }

    public static int[] addOneToEachElementAndCreateNewArray(int[] arr) {
        int[] newArr = Arrays.copyOf(arr, arr.length);
        addOneToEachElement(newArr);

//        int[] newArr = new int[arr.length];
//        for (int i = 0; i < newArr.length; i++) {
//            newArr[i] = arr[i] + 1;
//        }
        return newArr;
    }

    public static void addOneToEachElement(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] += 1;
        }
    }

    public static String addAToString(String str) {
        str = str + "A";
        return str;
    }

    public static void add1ToNumber(int number) {
        number = number + 1;
    }

}
