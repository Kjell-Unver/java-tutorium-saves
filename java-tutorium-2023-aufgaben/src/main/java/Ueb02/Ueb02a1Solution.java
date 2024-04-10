package Ueb02;

import java.util.Scanner;

public class Ueb02a1Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String response;

        System.out.println("Magst du Tiere? (j/n)");
        response = scanner.nextLine();
        boolean animals = response.equals("j") || response.equals("J");

        System.out.println("Möchtest du etwas in Hamburg unternehmen? (j/n)");
        response = scanner.nextLine();
        boolean hamburg = response.equals("j") || response.equals("J");

        String result = "";
        if (animals) {
            if (hamburg) {
                result = "Viel Spaß in Hagenbecks Tierpark!";
            } else {
                result = "Viel Spaß im Wildpark Schwarze Berge!";
            }
        } else {
            if (hamburg) {
                result = "Viel Spaß auf dem Dom!";
            } else {
                result = "Viel Spaß auf der Kieler Woche!";
            }
        }
        System.out.println(result);

    }
}
