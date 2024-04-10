package Ueb04;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SentenceInvestigatorTest {

    @Test
    public void shouldCountSpaces() {
        // Given
        String testSentence1 = "I Like Turtles!";
        String testSentence2 = "ILikeTurtles!";
        int expectedWhiteSpaceCount1 = 2;
        int expectedWhiteSpaceCount2 = 0;

        // When
        int result1 = SentenceInvestigator.countWhiteSpaces(testSentence1);
        int result2 = SentenceInvestigator.countWhiteSpaces(testSentence2);

        // Then
        assertEquals(expectedWhiteSpaceCount1, result1);
        assertEquals(expectedWhiteSpaceCount2, result2);
    }

    @Test
    public void shouldSwitchFirstAndLastWord() {
        // Given
        String testSentence = "I Like Turtles!";
        String expectedResult = "Turtles! Like I";

        // When
        String result = SentenceInvestigator.switchFirstAndLastWord(testSentence);

        // Then
        assertEquals(expectedResult, result);
    }

    @Test
    public void shouldReturnMessageForSentencesWithLessThanOneWord() {
        // Given
        String testSentence1 = "Turtles!";
        String testSentence2 = " Turtles!";
        String testSentence3 = "Turtles! ";
        String testSentence4 = "   Turtles!     ";
        String expectedResult = "Der Satz muss mindestens 2 Wörter aufweisen und an erster und letzter Stelle darf kein Leerzeichen vorkommen!";

        // When
        String result1 = SentenceInvestigator.switchFirstAndLastWord(testSentence1);
        String result2 = SentenceInvestigator.switchFirstAndLastWord(testSentence2);
        String result3 = SentenceInvestigator.switchFirstAndLastWord(testSentence3);
        String result4 = SentenceInvestigator.switchFirstAndLastWord(testSentence4);

        // Then
        assertEquals(expectedResult, result1);
        assertEquals(expectedResult, result2);
        assertEquals(expectedResult, result3);
        assertEquals(expectedResult, result4);
    }

    @Test
    public void shouldRemoveVowels() {
        // Given
        String testSentence = "abcdefghijklmnopqrstuvwxyz!?., ";
        String expectedResult = "bcdfghjklmnpqrstvwxyz!?., ";

        // When
        String result = SentenceInvestigator.removeVowels(testSentence);

        // Then
        assertEquals(expectedResult, result);
    }
}