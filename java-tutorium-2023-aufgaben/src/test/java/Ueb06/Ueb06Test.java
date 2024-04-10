package Ueb06;

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
import static org.junit.jupiter.api.Assertions.*;

public class Ueb06Test {
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
            Ueb06.main(args);
            String output = outContent.toString();
            assertThat(output, containsString("Es wurde keine gueltige Array-Laenge uebergeben!"));
        });
    }

    @Test
    public void invalidArg() {
        exit.expectSystemExitWithStatus(1);
        exit.checkAssertionAfterwards(() -> {
            String[] args = {"a"};
            Ueb06.main(args);
            String output = outContent.toString();
            assertThat(output, containsString("Es wurde keine gueltige Array-Laenge uebergeben!"));
        });
    }

    @Test
    public void arrayWithZeroElements() {
        exit.expectSystemExitWithStatus(1);
        exit.checkAssertionAfterwards(() -> {
            String[] args = {"0"};
            Ueb06.main(args);
            String output = outContent.toString();
            assertThat(output, containsString("Es wurde keine gueltige Array-Laenge uebergeben!"));
        });
    }

    @Test
    public void checkBrandInputWithExit() {
        System.setIn(new ByteArrayInputStream(String.format("%sx", System.lineSeparator()).getBytes()));
        String[] args = {"1"};
        Ueb06.main(args);
        String output = outContent.toString();
        assertThat(output, containsString("Es wurde eine ungueltige Marke eingegeben!"));
        assertThat(output, containsString("Die Eingabe wurde abgebrochen!"));
    }

    @Test
    public void checkPlzWithExit() {
        System.setIn(new ByteArrayInputStream(String.format("Shell%s%s1%s9999%s100000%sABCDE%sX", System.lineSeparator(), System.lineSeparator(), System.lineSeparator(), System.lineSeparator(), System.lineSeparator(), System.lineSeparator()).getBytes()));
        String[] args = {"1"};
        Ueb06.main(args);
        String output = outContent.toString();
        assertEquals(5, output.split("Es wurde eine ungueltige PLZ eingegeben!").length - 1);
        assertThat(output, containsString("Die Eingabe wurde abgebrochen!"));
    }

    @Test
    public void checkCityWithExit() {
        System.setIn(new ByteArrayInputStream(String.format("Shell%s10000%s%sa%sabc%sX", System.lineSeparator(), System.lineSeparator(), System.lineSeparator(), System.lineSeparator(), System.lineSeparator()).getBytes()));
        String[] args = {"10"};
        Ueb06.main(args);
        String output = outContent.toString();
        assertEquals(3, output.split("Es wurde ein ungueltiger Ort eingegeben!").length - 1);
        assertThat(output, containsString("Die Eingabe wurde abgebrochen!"));
    }

    @Test
    public void checkPriceWithExit() {
        System.setIn(new ByteArrayInputStream(String.format("Shell%s10000%sWedel%s0000%s0.0%s0.99%s2.01%s1.000%s2.000%sX", System.lineSeparator(), System.lineSeparator(), System.lineSeparator(), System.lineSeparator(), System.lineSeparator(), System.lineSeparator(), System.lineSeparator(), System.lineSeparator(), System.lineSeparator()).getBytes()));
        String[] args = {"5"};
        Ueb06.main(args);
        String output = outContent.toString();
        assertEquals(6, output.split("Es wurde ein ungueltiger Preis eingegeben!").length - 1);
        assertThat(output, containsString("Die Eingabe wurde abgebrochen!"));
    }

    @Test
    public void oneGasStationAndArrayWithOneElement() {
        System.setIn(new ByteArrayInputStream(String.format(
                "Shell%s22880%sWedel%s1.40%s10000%s99999", System.lineSeparator(), System.lineSeparator(), System.lineSeparator(), System.lineSeparator(), System.lineSeparator()
        ).getBytes()));
        String[] args = {"1"};
        Ueb06.main(args);
        String output = outContent.toString();
        assertThat(output, containsString("1. eingegebene Adresse:\nShell\n22880 Wedel\n1.40 Euro"));
    }

    @Test
    public void twoGasStationsAndArrayWithTwoElements() {
        System.setIn(new ByteArrayInputStream(String.format(
                "Shell%s22880%sWedel%s1.40%sEsso%s22105%sHamburg%s1.85%s10000%s99999", System.lineSeparator(), System.lineSeparator(), System.lineSeparator(), System.lineSeparator(), System.lineSeparator(), System.lineSeparator(), System.lineSeparator(), System.lineSeparator(), System.lineSeparator()
        ).getBytes()));
        String[] args = {"2"};
        Ueb06.main(args);
        String output = outContent.toString();
        assertThat(output, containsString("1. eingegebene Adresse:\nShell\n22880 Wedel\n1.40 Euro"));
        assertThat(output, containsString("2. eingegebene Adresse:\nEsso\n22105 Hamburg\n1.85 Euro"));
    }

    @Test
    public void twoGasStationsAndArrayWithThreeElements() {
        System.setIn(new ByteArrayInputStream(String.format(
                "Shell%s22880%sWedel%s1.40%sEsso%s22105%sHamburg%s1.85%sx%s22104%s22105", System.lineSeparator(), System.lineSeparator(), System.lineSeparator(), System.lineSeparator(), System.lineSeparator(), System.lineSeparator(), System.lineSeparator(), System.lineSeparator(), System.lineSeparator(), System.lineSeparator()
        ).getBytes()));
        String[] args = {"3"};
        Ueb06.main(args);
        String output = outContent.toString();
        assertFalse(output.contains("1. eingegebene Adresse:\nShell\n22880 Wedel\n1.40 Euro"));
        assertTrue(output.contains("2. eingegebene Adresse:\nEsso\n22105 Hamburg\n1.85 Euro"));
    }

    @Test
    public void checkInvalidRange() {
        System.setIn(new ByteArrayInputStream(String.format(
                "Shell%s22880%sWedel%s1.40%sEsso%s22105%sHamburg%s1.85%sx%s9999%s100000%s22880%s9999%s100000%s22880%s22881", System.lineSeparator(), System.lineSeparator(), System.lineSeparator(), System.lineSeparator(), System.lineSeparator(), System.lineSeparator(), System.lineSeparator(), System.lineSeparator(), System.lineSeparator(), System.lineSeparator(), System.lineSeparator(), System.lineSeparator(), System.lineSeparator(), System.lineSeparator(), System.lineSeparator()
        ).getBytes()));
        String[] args = {"3"};
        Ueb06.main(args);
        String output = outContent.toString();
        assertEquals(5, output.split("Es wurde eine ungueltige PLZ eingegeben!").length - 1);
        assertTrue(output.contains("1. eingegebene Adresse:\nShell\n22880 Wedel\n1.40 Euro"));
        assertFalse(output.contains("2. eingegebene Adresse:\nEsso\n22105 Hamburg\n1.85 Euro"));
    }

    @Test
    public void checkNoGasstationInRange() {
        System.setIn(new ByteArrayInputStream(String.format(
                "Shell%s22880%sWedel%s1.40%sEsso%s22105%sHamburg%s1.85%sx%s9999%s100000%s22900%s22910", System.lineSeparator(), System.lineSeparator(), System.lineSeparator(), System.lineSeparator(), System.lineSeparator(), System.lineSeparator(), System.lineSeparator(), System.lineSeparator(), System.lineSeparator(), System.lineSeparator(), System.lineSeparator(), System.lineSeparator(), System.lineSeparator(), System.lineSeparator(), System.lineSeparator()
        ).getBytes()));
        String[] args = {"3"};
        Ueb06.main(args);
        String output = outContent.toString();
        assertTrue(output.contains("Es gibt keine Tankstelle mit einer PLZ in der definierten Spanne!"));
        assertFalse(output.contains("1. eingegebene Adresse:\nShell\n22880 Wedel\n1.40 Euro"));
        assertFalse(output.contains("2. eingegebene Adresse:\nEsso\n22105 Hamburg\n1.85 Euro"));
    }
}