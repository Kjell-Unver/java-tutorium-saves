package Ueb02;

import java.util.Scanner;

public class ExtraSession {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Wie alt bist du? ");
        int age = scanner.nextInt();

        // Es dürfen nur Leute bis maximal 21 Jahr in die Bar.
        switch (age) {
            case 18, 19, 20, 21:
                System.out.println("Du kannst einen Whisky bestellen.");
            case 16, 17:
                System.out.println("Bier oder Wein kann ich dir anbieten.");
            default:
                System.out.println("Für dich gibt es Mineralwasser oder Apfelsaftschorle!");
        }


        if (age > 17){
            System.out.println("Du kannst einen Whisky bestellen.");
        }
        if (age >= 16) {
            System.out.println("Bier oder Wein kann ich dir anbieten.");
        }
        System.out.println("Für dich gibt es Mineralwasser oder Apfelsaftschorle!");


        // Binärzahlen und bitweise Operatoren | & >> << ~

        System.out.println(0b100);
        System.out.println(Integer.toString(4, 2));
        System.out.println(Integer.parseInt("100", 2));

        int result = 3 | 4;
        System.out.println(result);

        System.out.println(0b1101);
        System.out.println(16 >> 2);

        System.out.println(Integer.toString(105, 2));   // 1101001
        System.out.println(Integer.toString(105, 16));  // 69

        int basis = 10;

        String binaryResult = "";

        int rest = 105 % basis;     //  1
        int ergebnis = 105 / basis; // 52
        binaryResult = rest + binaryResult;

        rest = ergebnis % basis;    //  0
        ergebnis = ergebnis / basis;// 26
        binaryResult = rest + binaryResult;

        rest = ergebnis % basis;    //  0
        ergebnis = ergebnis / basis;// 13
        binaryResult = rest + binaryResult;

        rest = ergebnis % basis;    //  1
        ergebnis = ergebnis / basis;//  6
        binaryResult = rest + binaryResult;

        rest = ergebnis % basis;    //  0
        ergebnis = ergebnis / basis;//  3
        binaryResult = rest + binaryResult;

        rest = ergebnis % basis;    //  1
        ergebnis = ergebnis / basis;//  1
        binaryResult = rest + binaryResult;

        rest = ergebnis % 2;    //  1
        ergebnis = ergebnis / 2;//  0
        binaryResult = rest + binaryResult;

        System.out.print(binaryResult);

        System.out.println((byte) 0b11111011);

        System.out.println(~4);


    }
}
