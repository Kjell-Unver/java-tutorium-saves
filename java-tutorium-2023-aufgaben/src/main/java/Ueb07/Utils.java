package Ueb07;

import java.util.Scanner;

public class Utils {
    // Gibt eine Fehlermeldung aus und beendet das Programm mit dem Exit-Code 1
    static void printErrorAndExit(String errorMessage) {
        System.out.println(errorMessage);
        System.exit(1);
    }

    // Liest die Array-LÃ¤nge aus dem Kommandozeilenparameter-Array aus und gibt
    // diese zurÃ¼ck. Wurde keine oder eine ungÃ¼ltige Array-LÃ¤nge Ã¼bergeben, soll
    // die Funktion -1 zurÃ¼ckgeben
    static int getArrayLengthFromArgs(String[] args) {
        return args.length;
    }

    // Liest mehrere Strings vom Benutzer ein. Speichert die Strings in lines ab
    // und gibt die Anzahl der eingelesenen Strings zurÃ¼ck
    static int getStrings(String[] lines) {
        boolean running = true;
        int i = 0;
        Scanner scanner = new Scanner(System.in);
        do {
//          System.out.println("Gebe einen String ein:");
            String input = scanner.nextLine();
            if (input.length() == 1 && (input.charAt(0) == 'x' || input.charAt(0) == 'X')) {
                running = false;
            } else {
                lines[i] = input;
                i++;
                running = i < lines.length;
            }
        } while (running);
        return lines.length;
    }

    // Berechnet den Wert der Potenz. Zur Vereinfachung kann davon ausgegangen werden,
    // dass der Exponent immer grÃ¶Ãer oder gleich Null ist
    static int power(int base, int exponent) {
        int result = 1;

        for (int i = 0; i < exponent; i++) {
            result *= base;
        }

        return result;
    }

    // Wandelt einen String in eine Ganzzahl um. Zur Vereinfachung kann davon
    // ausgegangen werden, dass s immer eine Ganzzahl grÃ¶Ãer oder gleich Null enthÃ¤lt
    static int toNumber(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result *= 10;
            result += s.charAt(i) - 48;
        }
        return result;
    }

    // Gibt zurueck, ob das Zeichen c ein Ziffernzeichen ist
    static boolean isDigit(char c) {
        return c < 58 && c > 47;
    }

    // Gibt zurueck, ob s ausschliesslich aus Ziffernzeichen besteht
    static boolean isNumber(String s) {
        if (s.length() == 0) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            if (!isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    // Erhoeht in s jede Ziffer um 1 und macht aus einer 9 eine 0.
    static String shiftDigits(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            char toCheckChar = s.charAt(i);
            if (toCheckChar < 57) {
                toCheckChar++;
            } else {
                toCheckChar = '0';
            }
            result += toCheckChar;
        }
        return result;
    }

    // Gibt zurueck, ob in s mindestens ein Grossbuchstabe enthalten ist
    static boolean hasCapital(String s) {
        for (int i = 0; i < s.length(); i++) {
            char toCheckChar = s.charAt(i);
            if (isCapital(toCheckChar)) {
                return true;
            }
        }
        return false;
    }

    // Macht in s bei allen Buchstaben aus Klein- Grossbuchstaben und
    // umgekehrt und gibt das Ergebnis inklusive Anzahl der Vertauschungen zurÃ¼ck
    static String changeCapitalization(String s) {
        String result = "";
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            char toChangeChar = s.charAt(i);
            if (isCapital(toChangeChar)) {
                result += (char) (toChangeChar + ' ');
                counter++;
            } else if (toChangeChar < 123 && toChangeChar > 96) {
                result += (char) (toChangeChar - ' ');
                counter++;
            } else {
                result += toChangeChar;
            }
        }
        return result + " (" + counter + " Vertauschungen)";
    }

    // Spiegelt den String s und gibt das Ergebnis zurÃ¼ck
    static String mirrorString(String s) {
        String result = "";
        for (int i = (s.length() - 1); i > -1; i--) {
            result += s.charAt(i);
        }
        return result;
    }

    // Gibt die laufende Nummer des Strings, die angewandte Methode, den
    // Ursprungszustand und den neu berechneten String formatiert (z.B. mit einem -> dazwischen) aus
    static void print(int nr, String method, String old, String res) {
        System.out.println(nr + " " + method + ": " + old + " --> " + res);
    }

    static boolean isCapital(char c) {
        return c < 91 && c > 64;
    }
}
