package Ueb04;

public class SentenceInvestigatorSolution {
    public static String switchFirstAndLastWord(String testSentence) {
        int firstSpace = testSentence.indexOf(' ');
        int lastSpace = testSentence.lastIndexOf(' ');
        if(firstSpace > 0 && lastSpace > 0 && lastSpace < (testSentence.length() - 1)){
            String firstWord = testSentence.substring(0, firstSpace);
            String lastWord = testSentence.substring(lastSpace + 1);

            return lastWord + testSentence.substring(firstSpace, lastSpace + 1) + firstWord;
        } else {
            return "Der Satz muss mindestens 2 Wörter aufweisen und an erster und letzter Stelle darf kein Leerzeichen vorkommen!";
        }
    }

    public static String removeVowels(String testSentence) {
        String vowels = "AEIOUaeiou";

        for (int i = 0; i < vowels.length(); i++) {
            char vowel = vowels.charAt(i);
            while (testSentence.indexOf(vowel) != -1) {
                int indexOfVowel = testSentence.indexOf(vowel);
                testSentence = testSentence.substring(0, indexOfVowel) + testSentence.substring(indexOfVowel + 1);
            }
        }
        return testSentence;
    }

    public static int countWhiteSpaces(String testSentence) {
        int numberOfWhiteSpaces = 0;
        for (int i = 0; i < testSentence.length(); i++) {
            if (testSentence.charAt(i) == ' '){
                numberOfWhiteSpaces++;
            }
        }
        return numberOfWhiteSpaces;
    }
}
