package Ueb07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExamplesTest {

    @Test
    public void testToUpper() {
        // given
        char testChar = 'a';

        // when
        char resultChar = Examples.toUpper(testChar);

        // then
        Assertions.assertEquals('A', resultChar);
    }

//    @Test
//    public void testOnlyFourLetters() {
//        // given
//        String hallo = "Hallo";
//
//        // when
//        String output = onlyFourLetters(hallo);
//
//        // then
//        Assertions.assertEquals("Hall", output);
//    }
//
//    @Test
//    public void testOnlyFourLettersWithShortString() {
//        // given
//        String hey = "Hey";
//
//        // when
//        String output = onlyFourLetters(hey);
//
//        // then
//        Assertions.assertEquals("Hey", output);
//    }
}
