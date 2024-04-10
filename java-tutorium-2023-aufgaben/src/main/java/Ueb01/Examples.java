package Ueb01;

public class Examples {

    // psvm
    public static void main(String[] args) {

        // sout
        System.out.println("Hallo OTTO-Welt");

        int intValue;   // 32 Bit
        long longValue; // 64 Bit
        // intValue = 9_223_372_036_854_775_807;
        longValue = 9_223_372_036_854_775_807L;

        float floatValue = 3.14F;   // 32 Bit
        double doubleValue = 3.14;  // 64 Bit

        short shortValue;   // 16 Bit
        byte byteValue;     //  8 Bit   -128...127

        byteValue = 127;
        System.out.println(byteValue);
        byteValue += 1;
        System.out.println(byteValue);

        intValue = 5;
        longValue = intValue;
        System.out.println(longValue);
        longValue = 5_000_000_000L;
        intValue = (int) longValue;
        System.out.println(intValue);

        intValue = 5;
        doubleValue = intValue;
        System.out.println(doubleValue);
        doubleValue = 5.93;
        intValue = (int) doubleValue;
        System.out.println(intValue);

        doubleValue = 7654321e-6;   // 7.654321
        System.out.println(doubleValue);

    }
}