package Ueb07;

import static Ueb07.Utils.*;

public class Ueb07 {

    private static final String METHOD_SHIFT_DIGITS = "Ziffern erhöhen";
    private static final String METHOD_CHANGE_CAPITALIZATION = "Groß-/Kleinschreibung vertauschen";
    private static final String METHOD_MIRROR_STRING = "Spiegeln";

    public static void main(String[] args) {

        if (getArrayLengthFromArgs(args) < 1 || !isNumber(args[0])){
            printErrorAndExit("Es wurde keine gueltige Array-Laenge uebergeben!");
        }

        String[] input = new String[toNumber(args[0])];

        int numberOfEnteredStrings = getStrings(input);
        int lineCounter = 1;

        for (int i = 0; i < numberOfEnteredStrings; i++){
            if (input[i] != null) {
                if (isNumber(input[i])) {
                    print(lineCounter, METHOD_SHIFT_DIGITS, input[i], shiftDigits(input[i]));
                    lineCounter++;
                } else if (hasCapital(input[i])) {
                    print(lineCounter, METHOD_CHANGE_CAPITALIZATION, input[i], changeCapitalization(input[i]));
                    lineCounter++;
                } else {
                    print(lineCounter, METHOD_MIRROR_STRING, input[i], mirrorString(input[i]));
                    lineCounter++;
                }
            }
        }
    }
}
