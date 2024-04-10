package Ueb05;

import org.hamcrest.MatcherAssert;
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

public class Ueb05Test {
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
    public void emptyArgs() {
        exit.expectSystemExitWithStatus(1);
        exit.checkAssertionAfterwards(() -> {
            String[] args = {};
            Ueb05.main(args);
            String output = outContent.toString();
            MatcherAssert.assertThat(output, containsString("Es wurde keine gueltige Array-Laenge uebergeben!"));
        });
    }

    @Test
    public void invalidArg() {
        exit.expectSystemExitWithStatus(1);
        exit.checkAssertionAfterwards(() -> {
            String[] args = {"a"};
            Ueb05.main(args);
            String output = outContent.toString();
            assertThat(output, containsString("Es wurde keine gueltige Array-Laenge uebergeben!"));
        });
    }

    @Test
    public void arrayWithZeroElements() {
        exit.expectSystemExitWithStatus(1);
        exit.checkAssertionAfterwards(() -> {
            String[] args = {"0"};
            Ueb05.main(args);
            String output = outContent.toString();
            assertThat(output, containsString("Es wurde keine gueltige Array-Laenge uebergeben!"));
        });
    }

    @Test
    public void onePriceAndArrayWithOneElement() {
        System.setIn(new ByteArrayInputStream("1.00".getBytes()));
        String[] args = {"1"};
        Ueb05.main(args);
        String output = outContent.toString();
        assertThat(output, containsString("Anzahl Preise:   1"));
        assertThat(output, containsString("Kleinster Preis: 1.00"));
        assertThat(output, containsString("Groesster Preis: 1.00"));
        assertThat(output, containsString("Mittelwert:      1.00"));
        assertThat(output, containsString("Spanne:          0.00"));
    }

    @Test
    public void onePriceAndArrayWithTwoElements() {
        System.setIn(new ByteArrayInputStream(String.format("1.00%sX", System.lineSeparator()).getBytes()));
        String[] args = {"2"};
        Ueb05.main(args);
        String output = outContent.toString();
        assertThat(output, containsString("Anzahl Preise:   1"));
        assertThat(output, containsString("Kleinster Preis: 1.00"));
        assertThat(output, containsString("Groesster Preis: 1.00"));
        assertThat(output, containsString("Mittelwert:      1.00"));
        assertThat(output, containsString("Spanne:          0.00"));
    }

    @Test
    public void threePricesAndArrayWithTenElements() {
        System.setIn(new ByteArrayInputStream(String.format("1.0%s1.20%s1.8%sX", System.lineSeparator(), System.lineSeparator(), System.lineSeparator()).getBytes()));
        String[] args = {"10"};
        Ueb05.main(args);
        String output = outContent.toString();
        assertThat(output, containsString("Anzahl Preise:   3"));
        assertThat(output, containsString("Kleinster Preis: 1.00"));
        assertThat(output, containsString("Groesster Preis: 1.80"));
        assertThat(output, containsString("Mittelwert:      1.33"));
        assertThat(output, containsString("Spanne:          0.80"));
    }

    @Test
    public void zeroPricesAndArrayWithFiveElements() {
        System.setIn(new ByteArrayInputStream("X".getBytes()));
        String[] args = {"5"};
        Ueb05.main(args);
        String output = outContent.toString();
        assertThat(output, containsString("Es wurde kein Preis eingegeben!"));
    }

    @Test
    public void fivePricesAndArrayWithFiveElements() {
        System.setIn(new ByteArrayInputStream(String.format("1.0%s1.11%s1.5%s1.99%s2", System.lineSeparator(), System.lineSeparator(), System.lineSeparator(), System.lineSeparator()).getBytes()));
        String[] args = {"5"};
        Ueb05.main(args);
        String output = outContent.toString();
        assertThat(output, containsString("Anzahl Preise:   5"));
        assertThat(output, containsString("Kleinster Preis: 1.00"));
        assertThat(output, containsString("Groesster Preis: 2.00"));
        assertThat(output, containsString("Mittelwert:      1.52"));
        assertThat(output, containsString("Spanne:          1.00"));
    }

    @Test
    public void invalidPricesAndArrayWithFiveElements() {
        System.setIn(new ByteArrayInputStream(String.format("a%1$sabcde%1$s11111%1$s1.000%1$s2.0000%1$s2.1%1$s3%1$sx", System.lineSeparator()).getBytes()));
        String[] args = {"5"};
        Ueb05.main(args);
        String output = outContent.toString();
        assertEquals(7, output.split("Es wurde ein ungueltiger Preis eingegeben!").length - 1);
        assertThat(output, containsString("Es wurde kein Preis eingegeben!"));
    }
}