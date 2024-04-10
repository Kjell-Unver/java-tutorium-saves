package Ueb04;

import java.util.Scanner;

import static Ueb04.SentenceInvestigatorSolution.*;

public class Ueb04Solution {
    public static void main(String[] args) {
        boolean runApplication = true;
        Scanner scanner = new Scanner(System.in);
        String enteredSentence = new String();

        do {
            System.out.println("""
                    A) Satz eingeben\s
                    B) Anzahl Leerzeichen bestimmen\s
                    C) 1. und letztes Wort vertauschen\s
                    D) Alle Vokale entfernen\s
                    X) Ende
                    """);

            String chosenOption = scanner.nextLine();
            switch (chosenOption) {
                case "A":
                    System.out.println("Bitte gebe deinen Satz ein:");
                     enteredSentence = scanner.nextLine();
                     break;
                case "B":
                    if (enteredSentence.isEmpty()){
                        System.out.println("Es wurde noch kein Satz eingegeben!");
                    } else {
                        int numbersOfWhiteSpaces = countWhiteSpaces(enteredSentence);
                        System.out.format("%d Leerzeichen im Satz gefunden", numbersOfWhiteSpaces);
                    }
                    break;
                case "C":
                    if (enteredSentence.isEmpty()){
                        System.out.println("Es wurde noch kein Satz eingegeben!");
                    } else {
                        System.out.println(switchFirstAndLastWord(enteredSentence));
                    }
                    break;
                case "D":
                    if (enteredSentence.isEmpty()){
                        System.out.println("Es wurde noch kein Satz eingegeben!");
                    } else {
                        System.out.println(removeVowels(enteredSentence));
                    }
                    break;
                case "X":
                    runApplication = false;
            }
        } while(runApplication);
    }
}
