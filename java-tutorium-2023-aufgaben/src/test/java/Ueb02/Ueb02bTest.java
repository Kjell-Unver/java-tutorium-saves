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

public class Ueb02bTest {
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
                Arguments.of( "j", "47", "U1"),
                Arguments.of( "n", "U1", "47"),
                Arguments.of( "J", "47", "U1"),
                Arguments.of( "N", "U1", "47"),
                Arguments.of( "j", "25", "U2"),
                Arguments.of( "n", "U2", "25"),
                Arguments.of( "J", "25", "U2"),
                Arguments.of( "N", "U2", "25"),
                Arguments.of( "j", "26", "U3"),
                Arguments.of( "n", "U3", "26"),
                Arguments.of( "J", "26", "U3"),
                Arguments.of( "N", "U3", "26"),
                Arguments.of( "j", "9", "U4"),
                Arguments.of( "n", "U4", "9"),
                Arguments.of( "J", "9", "U4"),
                Arguments.of( "N", "U4", "9"),
                Arguments.of( "j", "10", "Keine Linie gefunden."),
                Arguments.of( "n", "U5", "Keine Linie gefunden."),
                Arguments.of( "J", "10", "Keine Linie gefunden."),
                Arguments.of( "N", "U5", "Keine Linie gefunden.")
        );
    }


    @ParameterizedTest
    @MethodSource("testData")
    public void shouldCalculateCorrectResult(String startInverseSearch, String input, String result) {
        System.setIn(new ByteArrayInputStream(String.format(startInverseSearch + "%s" + input, System.lineSeparator()).getBytes()));
        Ueb02b.main(null);
        String output = outContent.toString();
        assertThat(output, containsString(result));
    }
}