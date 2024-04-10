package Ueb08;

import org.junit.Rule;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ueb08Test {
    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

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
    public void handleWrongIdAndExit() {
        System.setIn(new ByteArrayInputStream(String.format("1337%1$s-1", System.lineSeparator()).getBytes()));
        Ueb08.main(null);
        String output = outContent.toString();
        assertEquals(2, output.split("Die Daten von 7 Wahlen sind vorhanden.").length - 1);
        assertEquals(2, output.split("Geben Sie die Nummer einer Wahl \\(0 - 6\\) ein").length - 1);
    }

    @Test
    public void showIdZeroAndExit() {
        System.setIn(new ByteArrayInputStream(String.format("0%1$s-1", System.lineSeparator()).getBytes()));
        Ueb08.main(null);
        String output = outContent.toString();
        assertThat(output, containsString("Ergebnis nach Mehrheitswahlrecht:\n" +
                " 1) E. Herms      : 0\n" +
                " 2) A. Gebäudchen : 0\n" +
                " 3) G. Kayak      : 0\n" +
                " 4) E. Cola       : 0\n" +
                " 5) M. Riema      : 0"));
        assertThat(output, containsString("Ergebnis nach Rangfolgewahl:\n" +
                " 1) E. Herms      : 0\n" +
                " 2) A. Gebäudchen : 0\n" +
                " 3) G. Kayak      : 0\n" +
                " 4) E. Cola       : 0\n" +
                " 5) M. Riema      : 0"));
    }

    @Test
    public void showIdOneAndExit() {
        System.setIn(new ByteArrayInputStream(String.format("1%1$s-1", System.lineSeparator()).getBytes()));
        Ueb08.main(null);
        String output = outContent.toString();
        assertThat(output, containsString("Ergebnis nach Mehrheitswahlrecht:\n" +
                " 1) E. Herms      : 3\n" +
                " 2) A. Gebäudchen : 0\n" +
                " 3) G. Kayak      : 0\n" +
                " 4) E. Cola       : 0\n" +
                " 5) M. Riema      : 0"));
        assertThat(output, containsString("Ergebnis nach Rangfolgewahl:\n" +
                " 1) E. Herms      : 3\n" +
                " 2) A. Gebäudchen : 0\n" +
                " 3) G. Kayak      : 0\n" +
                " 4) E. Cola       : 0\n" +
                " 5) M. Riema      : 0"));
    }

    @Test
    public void showIdTwoAndThreeAndExit() {
        System.setIn(new ByteArrayInputStream(String.format("2%1$s3%1$s-1", System.lineSeparator()).getBytes()));
        Ueb08.main(null);
        String output = outContent.toString();
        assertThat(output, containsString("Ergebnis nach Mehrheitswahlrecht:\n" +
                " 1) E. Cola       : 3\n" +
                " 2) E. Herms      : 0\n" +
                " 3) A. Gebäudchen : 0\n" +
                " 4) G. Kayak      : 0\n" +
                " 5) M. Riema      : 0"));
        assertThat(output, containsString("Ergebnis nach Rangfolgewahl:\n" +
                " 1) E. Cola       : 3\n" +
                " 2) E. Herms      : 0\n" +
                " 3) A. Gebäudchen : 0\n" +
                " 4) G. Kayak      : 0\n" +
                " 5) M. Riema      : 0"));
        assertThat(output, containsString("Ergebnis nach Mehrheitswahlrecht:\n" +
                " 1) E. Herms      : 4\n" +
                " 2) A. Gebäudchen : 1\n" +
                " 3) G. Kayak      : 0\n" +
                " 4) E. Cola       : 0\n" +
                " 5) M. Riema      : 0"));
        assertThat(output, containsString("Ergebnis nach Rangfolgewahl:\n" +
                " 1) E. Herms      : 4\n" +
                " 2) A. Gebäudchen : 1\n" +
                " 3) G. Kayak      : 0\n" +
                " 4) E. Cola       : 0\n" +
                " 5) M. Riema      : 0"));
    }

    @Test
    public void showIdFourAndExit() {
        System.setIn(new ByteArrayInputStream(String.format("4%1$s-1", System.lineSeparator()).getBytes()));
        Ueb08.main(null);
        String output = outContent.toString();
        assertThat(output, containsString("Ergebnis nach Mehrheitswahlrecht:\n" +
                " 1) E. Cola       : 5\n" +
                " 2) M. Riema      : 5\n" +
                " 3) G. Kayak      : 2\n" +
                " 4) E. Herms      : 0\n" +
                " 5) A. Gebäudchen : 0"));
        assertThat(output, containsString("Ergebnis nach Rangfolgewahl:\n" +
                " 1) M. Riema      : 7\n" +
                " 2) E. Cola       : 5\n" +
                " 3) E. Herms      : 0\n" +
                " 4) A. Gebäudchen : 0\n" +
                " 5) G. Kayak      : 0"));
    }

    @Test
    public void showIdFiveAndExit() {
        System.setIn(new ByteArrayInputStream(String.format("5%1$s-1", System.lineSeparator()).getBytes()));
        Ueb08.main(null);
        String output = outContent.toString();
        assertThat(output, containsString("Ergebnis nach Mehrheitswahlrecht:\n" +
                " 1) M. Riema      : 4\n" +
                " 2) E. Cola       : 3\n" +
                " 3) G. Kayak      : 2\n" +
                " 4) E. Herms      : 1\n" +
                " 5) A. Gebäudchen : 0"));
        assertThat(output, containsString("Ergebnis nach Rangfolgewahl:\n" +
                " 1) M. Riema      : 4\n" +
                " 2) E. Cola       : 3\n" +
                " 3) E. Herms      : 0\n" +
                " 4) A. Gebäudchen : 0\n" +
                " 5) G. Kayak      : 0"));
    }

    @Test
    public void showIdSixAndExit() {
        System.setIn(new ByteArrayInputStream(String.format("6%1$s-1", System.lineSeparator()).getBytes()));
        Ueb08.main(null);
        String output = outContent.toString();
        assertThat(output, containsString("Ergebnis nach Mehrheitswahlrecht:\n" +
                " 1) E. Herms      : 7\n" +
                " 2) A. Gebäudchen : 6\n" +
                " 3) G. Kayak      : 6\n" +
                " 4) M. Riema      : 6\n" +
                " 5) E. Cola       : 3"));
        assertThat(output, containsString("Ergebnis nach Rangfolgewahl:\n" +
                " 1) G. Kayak      : 12\n" +
                " 2) A. Gebäudchen : 9\n" +
                " 3) E. Herms      : 0\n" +
                " 4) E. Cola       : 0\n" +
                " 5) M. Riema      : 0"));
    }
}