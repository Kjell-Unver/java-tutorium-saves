package Ueb02;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

class Ueb02a2Test {
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

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of( "j", "j", "Viel Spaß in Hagenbecks Tierpark!"),
                Arguments.of( "J", "j", "Viel Spaß in Hagenbecks Tierpark!"),
                Arguments.of( "J", "J", "Viel Spaß in Hagenbecks Tierpark!"),
                Arguments.of( "j", "n", "Viel Spaß im Wildpark Schwarze Berge!"),
                Arguments.of( "j", "N", "Viel Spaß im Wildpark Schwarze Berge!"),
                Arguments.of( "n", "j", "Viel Spaß auf dem Dom!"),
                Arguments.of( "N", "j", "Viel Spaß auf dem Dom!"),
                Arguments.of( "n", "n", "Viel Spaß auf der Kieler Woche!"),
                Arguments.of( "N", "N", "Viel Spaß auf der Kieler Woche!")
        );
    }


    @ParameterizedTest
    @MethodSource("testData")
    public void shouldCalculateCorrectResult(String preferringAnimals, String preferringHamburg, String result) {
        System.setIn(new ByteArrayInputStream(String.format(preferringAnimals + "%s" + preferringHamburg, System.lineSeparator()).getBytes()));
        Ueb02a2.main(null);
        String output = outContent.toString();
        assertThat(output, containsString(result));
    }
}