package Ueb05;

import java.util.Scanner;

public class Ueb05Solution {

    public static void main(String[] args) {
        try {

            final int ARRAY_LENGTH = Integer.parseInt(args[0]);

            double[] gasPrices = new double[ARRAY_LENGTH];

            Scanner scanner = new Scanner(System.in);

            int i = 0;
            while (i < ARRAY_LENGTH) {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("x")) {
                    i = ARRAY_LENGTH;
                } else {
                    try {
                        if (priceValid(input)) {
                            gasPrices[i] = Double.parseDouble(input);
                            i++;
                        } else {
                            System.out.println("Es wurde ein ungueltiger Preis eingegeben!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Es wurde ein ungueltiger Preis eingegeben!");
                    }
                }
            }

            if (getNumberOfPrices(gasPrices) >= 1) {
                printSummary(gasPrices);
            } else {
                System.out.println("Es wurde kein Preis eingegeben!");
            }

        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Es wurde keine gueltige Array-Laenge uebergeben!");
            System.exit(1);
        }
    }

    static boolean priceValid(String priceString) {
        if (priceString.contains(".") && priceString.substring(priceString.indexOf(".")).length() > 3) {
            return false;
        }
        try {
            double price = Double.parseDouble(priceString);
            return price >= 1.0 && price <= 2.0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    static void printSummary(double[] prices) {
        int numberOfPrices = getNumberOfPrices(prices);
        double minPrice = getMinPrice(prices);
        double maxPrice = getMaxPrice(prices);
        double meanPrice = getPriceSum(prices) / numberOfPrices;
        double priceSpan = maxPrice - minPrice;

        System.out.format("\nAnzahl Preise:   %-4d", numberOfPrices);
        System.out.format("\nKleinster Preis: %-4.2f", minPrice);
        System.out.format("\nGroesster Preis: %-4.2f", maxPrice);
        System.out.format("\nMittelwert:      %-4.2f", meanPrice);
        System.out.format("\nSpanne:          %-4.2f\n", priceSpan);
    }

    static int getNumberOfPrices(double[] prices) {
        int i = 0;
        while (i < prices.length && prices[i] > 0) {
            i++;
        }
        return i;
    }

    static double getMinPrice(double[] prices) {
        double min = Double.MAX_VALUE;
        for (int i = 0; i < getNumberOfPrices(prices); i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
        }
        return min;
    }

    static double getMaxPrice(double[] prices) {
        double max = Double.MIN_VALUE;
        for (int i = 0; i < getNumberOfPrices(prices); i++) {
            if (prices[i] > max) {
                max = prices[i];
            }
        }
        return max;
    }

    static double getPriceSum(double[] prices) {
        double sum = 0;
        for (int i = 0; i < getNumberOfPrices(prices); i++) {
            sum += prices[i];
        }
        return sum;
    }
}