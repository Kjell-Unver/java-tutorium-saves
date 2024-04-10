package Ueb01;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class Ueb01aTest {
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
    public void exampleIngredients() {
        System.setIn(new ByteArrayInputStream(String.format("5%s18%s57", System.lineSeparator(), System.lineSeparator()).getBytes()));
        Ueb01a.main(null);
        String output = outContent.toString();
        assertThat(output, containsString("Es können 4 Gerichte hergestellt werden."));
        assertThat(output, containsString("Es bleiben über: 1 Stück(e) Fleisch, 2 Kartoffel(n) und 17 Bohne(n)"));
    }

    @Test
    public void exactlyOneDish() {
        System.setIn(new ByteArrayInputStream(String.format("1%s4%s10", System.lineSeparator(), System.lineSeparator()).getBytes()));
        Ueb01a.main(null);
        String output = outContent.toString();
        assertThat(output, containsString("Es können 1 Gerichte hergestellt werden."));
        assertThat(output, containsString("Es bleiben über: 0 Stück(e) Fleisch, 0 Kartoffel(n) und 0 Bohne(n)"));
    }

    @Test
    public void exactlyTenDishes() {
        System.setIn(new ByteArrayInputStream(String.format("10%s40%s100", System.lineSeparator(), System.lineSeparator()).getBytes()));
        Ueb01a.main(null);
        String output = outContent.toString();
        assertThat(output, containsString("Es können 10 Gerichte hergestellt werden."));
        assertThat(output, containsString("Es bleiben über: 0 Stück(e) Fleisch, 0 Kartoffel(n) und 0 Bohne(n)"));
    }

    @Test
    public void oneMeatLeft() {
        System.setIn(new ByteArrayInputStream(String.format("5%s16%s40", System.lineSeparator(), System.lineSeparator()).getBytes()));
        Ueb01a.main(null);
        String output = outContent.toString();
        assertThat(output, containsString("Es können 4 Gerichte hergestellt werden."));
        assertThat(output, containsString("Es bleiben über: 1 Stück(e) Fleisch, 0 Kartoffel(n) und 0 Bohne(n)"));
    }

    @Test
    public void onePotatoLeft() {
        System.setIn(new ByteArrayInputStream(String.format("4%s17%s40", System.lineSeparator(), System.lineSeparator()).getBytes()));
        Ueb01a.main(null);
        String output = outContent.toString();
        assertThat(output, containsString("Es können 4 Gerichte hergestellt werden."));
        assertThat(output, containsString("Es bleiben über: 0 Stück(e) Fleisch, 1 Kartoffel(n) und 0 Bohne(n)"));
    }

    @Test
    public void oneBeanLeft() {
        System.setIn(new ByteArrayInputStream(String.format("4%s16%s41", System.lineSeparator(), System.lineSeparator()).getBytes()));
        Ueb01a.main(null);
        String output = outContent.toString();
        assertThat(output, containsString("Es können 4 Gerichte hergestellt werden."));
        assertThat(output, containsString("Es bleiben über: 0 Stück(e) Fleisch, 0 Kartoffel(n) und 1 Bohne(n)"));
    }
}