package Ueb03;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


@RunWith(Parameterized.class)
public class Ueb03Test {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    private final InputStream stdin = System.in;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
        System.setIn(stdin);
    }

    @Test
    public void shouldHaveMethodForCalculatingEven() {

        // Given
        int evenInteger = 42;
        int oddInteger = 1337;

        // When
        boolean evenIsEven = Ueb03.isEven(evenInteger);
        boolean oddIsEven = Ueb03.isEven(oddInteger);

        // Then
        assertTrue(evenIsEven);
        assertFalse(oddIsEven);
    }

    @Test
    public void shouldHaveMethodForCalculatingPrime() {

        // Given
        int prime = 17;
        int notPrime = 42;

        // When
        boolean primeIsPrime = Ueb03.isPrime(prime);
        boolean notPrimeIsPrime = Ueb03.isPrime(notPrime);

        // Then
        assertTrue(primeIsPrime);
        assertFalse(notPrimeIsPrime);
    }

    @Test
    public void shouldHaveMethodForCalculatingTriangular() {

        // Given
        int triangular = 10;
        int nonTriangular = 11;

        // When
        boolean isTriangular = Ueb03.isTriangular(triangular);
        boolean isNotTriangular = Ueb03.isTriangular(nonTriangular);

        // Then
        assertTrue(isTriangular);
        assertFalse(isNotTriangular);
    }

    public static Stream<Arguments> testData() {
        return Stream.of(Arguments.of(
                "0", "100",
                        "  0 gerade: true  prim: false dreieck: true \n" +
                                "  1 gerade: false prim: false dreieck: true \n" +
                                "  2 gerade: true  prim: true  dreieck: false\n" +
                                "  3 gerade: false prim: true  dreieck: true \n" +
                                "  4 gerade: true  prim: false dreieck: false\n" +
                                "  5 gerade: false prim: true  dreieck: false\n" +
                                "  6 gerade: true  prim: false dreieck: true \n" +
                                "  7 gerade: false prim: true  dreieck: false\n" +
                                "  8 gerade: true  prim: false dreieck: false\n" +
                                "  9 gerade: false prim: false dreieck: false\n" +
                                " 10 gerade: true  prim: false dreieck: true \n" +
                                " 11 gerade: false prim: true  dreieck: false\n" +
                                " 12 gerade: true  prim: false dreieck: false\n" +
                                " 13 gerade: false prim: true  dreieck: false\n" +
                                " 14 gerade: true  prim: false dreieck: false\n" +
                                " 15 gerade: false prim: false dreieck: true \n" +
                                " 16 gerade: true  prim: false dreieck: false\n" +
                                " 17 gerade: false prim: true  dreieck: false\n" +
                                " 18 gerade: true  prim: false dreieck: false\n" +
                                " 19 gerade: false prim: true  dreieck: false\n" +
                                " 20 gerade: true  prim: false dreieck: false\n" +
                                " 21 gerade: false prim: false dreieck: true \n" +
                                " 22 gerade: true  prim: false dreieck: false\n" +
                                " 23 gerade: false prim: true  dreieck: false\n" +
                                " 24 gerade: true  prim: false dreieck: false\n" +
                                " 25 gerade: false prim: false dreieck: false\n" +
                                " 26 gerade: true  prim: false dreieck: false\n" +
                                " 27 gerade: false prim: false dreieck: false\n" +
                                " 28 gerade: true  prim: false dreieck: true \n" +
                                " 29 gerade: false prim: true  dreieck: false\n" +
                                " 30 gerade: true  prim: false dreieck: false\n" +
                                " 31 gerade: false prim: true  dreieck: false\n" +
                                " 32 gerade: true  prim: false dreieck: false\n" +
                                " 33 gerade: false prim: false dreieck: false\n" +
                                " 34 gerade: true  prim: false dreieck: false\n" +
                                " 35 gerade: false prim: false dreieck: false\n" +
                                " 36 gerade: true  prim: false dreieck: true \n" +
                                " 37 gerade: false prim: true  dreieck: false\n" +
                                " 38 gerade: true  prim: false dreieck: false\n" +
                                " 39 gerade: false prim: false dreieck: false\n" +
                                " 40 gerade: true  prim: false dreieck: false\n" +
                                " 41 gerade: false prim: true  dreieck: false\n" +
                                " 42 gerade: true  prim: false dreieck: false\n" +
                                " 43 gerade: false prim: true  dreieck: false\n" +
                                " 44 gerade: true  prim: false dreieck: false\n" +
                                " 45 gerade: false prim: false dreieck: true \n" +
                                " 46 gerade: true  prim: false dreieck: false\n" +
                                " 47 gerade: false prim: true  dreieck: false\n" +
                                " 48 gerade: true  prim: false dreieck: false\n" +
                                " 49 gerade: false prim: false dreieck: false\n" +
                                " 50 gerade: true  prim: false dreieck: false\n" +
                                " 51 gerade: false prim: false dreieck: false\n" +
                                " 52 gerade: true  prim: false dreieck: false\n" +
                                " 53 gerade: false prim: true  dreieck: false\n" +
                                " 54 gerade: true  prim: false dreieck: false\n" +
                                " 55 gerade: false prim: false dreieck: true \n" +
                                " 56 gerade: true  prim: false dreieck: false\n" +
                                " 57 gerade: false prim: false dreieck: false\n" +
                                " 58 gerade: true  prim: false dreieck: false\n" +
                                " 59 gerade: false prim: true  dreieck: false\n" +
                                " 60 gerade: true  prim: false dreieck: false\n" +
                                " 61 gerade: false prim: true  dreieck: false\n" +
                                " 62 gerade: true  prim: false dreieck: false\n" +
                                " 63 gerade: false prim: false dreieck: false\n" +
                                " 64 gerade: true  prim: false dreieck: false\n" +
                                " 65 gerade: false prim: false dreieck: false\n" +
                                " 66 gerade: true  prim: false dreieck: true \n" +
                                " 67 gerade: false prim: true  dreieck: false\n" +
                                " 68 gerade: true  prim: false dreieck: false\n" +
                                " 69 gerade: false prim: false dreieck: false\n" +
                                " 70 gerade: true  prim: false dreieck: false\n" +
                                " 71 gerade: false prim: true  dreieck: false\n" +
                                " 72 gerade: true  prim: false dreieck: false\n" +
                                " 73 gerade: false prim: true  dreieck: false\n" +
                                " 74 gerade: true  prim: false dreieck: false\n" +
                                " 75 gerade: false prim: false dreieck: false\n" +
                                " 76 gerade: true  prim: false dreieck: false\n" +
                                " 77 gerade: false prim: false dreieck: false\n" +
                                " 78 gerade: true  prim: false dreieck: true \n" +
                                " 79 gerade: false prim: true  dreieck: false\n" +
                                " 80 gerade: true  prim: false dreieck: false\n" +
                                " 81 gerade: false prim: false dreieck: false\n" +
                                " 82 gerade: true  prim: false dreieck: false\n" +
                                " 83 gerade: false prim: true  dreieck: false\n" +
                                " 84 gerade: true  prim: false dreieck: false\n" +
                                " 85 gerade: false prim: false dreieck: false\n" +
                                " 86 gerade: true  prim: false dreieck: false\n" +
                                " 87 gerade: false prim: false dreieck: false\n" +
                                " 88 gerade: true  prim: false dreieck: false\n" +
                                " 89 gerade: false prim: true  dreieck: false\n" +
                                " 90 gerade: true  prim: false dreieck: false\n" +
                                " 91 gerade: false prim: false dreieck: true \n" +
                                " 92 gerade: true  prim: false dreieck: false\n" +
                                " 93 gerade: false prim: false dreieck: false\n" +
                                " 94 gerade: true  prim: false dreieck: false\n" +
                                " 95 gerade: false prim: false dreieck: false\n" +
                                " 96 gerade: true  prim: false dreieck: false\n" +
                                " 97 gerade: false prim: true  dreieck: false\n" +
                                " 98 gerade: true  prim: false dreieck: false\n" +
                                " 99 gerade: false prim: false dreieck: false\n" +
                                "100 gerade: true  prim: false dreieck: false\n"
                ));
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void shouldCalculateCorrectResult(String lowerBorder, String upperBorder, String result) {
        System.setIn(new ByteArrayInputStream(String.format(lowerBorder + "%s" + upperBorder, System.lineSeparator()).getBytes()));
        Ueb03.main(null);
        String output = outContent.toString();
        assertThat(output, containsString(result));
    }
}