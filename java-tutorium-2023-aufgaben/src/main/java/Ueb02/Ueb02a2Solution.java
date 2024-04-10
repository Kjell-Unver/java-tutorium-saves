package Ueb02;

import java.util.Scanner;

public class Ueb02a2Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String response;

        System.out.println("Magst du Tiere? (j/n)");
        response = scanner.nextLine();
        boolean animals = response.equals("j") || response.equals("J");

        System.out.println("Möchtest du etwas in Hamburg unternehmen? (j/n)");
        response = scanner.nextLine();
        boolean hamburg = response.equals("j") || response.equals("J");

        boolean hagenbeck = animals && hamburg;
        boolean wildpark = animals && !hamburg;
        boolean dom = !animals && hamburg;
        boolean kielerWoche = !animals && !hamburg;

        String result = "";
        if (hagenbeck) {
            result = "Viel Spaß in Hagenbecks Tierpark!";
        }
        if (dom) {
            result = "Viel Spaß auf dem Dom!";
        }
        if (wildpark) {
            result = "Viel Spaß im Wildpark Schwarze Berge!";
        }
        if (kielerWoche) {
            result = "Viel Spaß auf der Kieler Woche!";
        }
        System.out.println(result);
    }
}

