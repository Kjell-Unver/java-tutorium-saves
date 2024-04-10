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

public class Ueb01bTest {
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
    public void exampleNotchesCount() {
        System.setIn(new ByteArrayInputStream("12321".getBytes()));
        Ueb01b.main(null);
        String output = outContent.toString();
        assertThat(output, containsString("12321 Kerben entsprechen"));
        assertThat(output, containsString("36 Jahren"));
        assertThat(output, containsString("8 Monaten"));
        assertThat(output, containsString("0 Wochen und"));
        assertThat(output, containsString("1 Tagen"));
    }

    @Test
    public void onlyOneDay() {
        System.setIn(new ByteArrayInputStream("1".getBytes()));
        Ueb01b.main(null);
        String output = outContent.toString();
        assertThat(output, containsString("1 Kerben entsprechen"));
        assertThat(output, containsString("0 Jahren"));
        assertThat(output, containsString("0 Monaten"));
        assertThat(output, containsString("0 Wochen und"));
        assertThat(output, containsString("1 Tagen"));
    }

    @Test
    public void onlyOneWeek() {
        System.setIn(new ByteArrayInputStream("7".getBytes()));
        Ueb01b.main(null);
        String output = outContent.toString();
        assertThat(output, containsString("7 Kerben entsprechen"));
        assertThat(output, containsString("0 Jahren"));
        assertThat(output, containsString("0 Monaten"));
        assertThat(output, containsString("1 Wochen und"));
        assertThat(output, containsString("0 Tagen"));
    }

    @Test
    public void onlyOneMonth() {
        System.setIn(new ByteArrayInputStream("28".getBytes()));
        Ueb01b.main(null);
        String output = outContent.toString();
        assertThat(output, containsString("28 Kerben entsprechen"));
        assertThat(output, containsString("0 Jahren"));
        assertThat(output, containsString("1 Monaten"));
        assertThat(output, containsString("0 Wochen und"));
        assertThat(output, containsString("0 Tagen"));
    }

    @Test
    public void onlyOneYear() {
        System.setIn(new ByteArrayInputStream("336".getBytes()));
        Ueb01b.main(null);
        String output = outContent.toString();
        assertThat(output, containsString("336 Kerben entsprechen"));
        assertThat(output, containsString("1 Jahren"));
        assertThat(output, containsString("0 Monaten"));
        assertThat(output, containsString("0 Wochen und"));
        assertThat(output, containsString("0 Tagen"));
    }

    @Test
    public void oneDayWeekMonthYear() {
        System.setIn(new ByteArrayInputStream("372".getBytes()));
        Ueb01b.main(null);
        String output = outContent.toString();
        assertThat(output, containsString("372 Kerben entsprechen"));
        assertThat(output, containsString("1 Jahren"));
        assertThat(output, containsString("1 Monaten"));
        assertThat(output, containsString("1 Wochen und"));
        assertThat(output, containsString("1 Tagen"));
    }

    @Test
    public void twoDaysWeeksMonthsYears() {
        System.setIn(new ByteArrayInputStream("744".getBytes()));
        Ueb01b.main(null);
        String output = outContent.toString();
        assertThat(output, containsString("744 Kerben entsprechen"));
        assertThat(output, containsString("2 Jahren"));
        assertThat(output, containsString("2 Monaten"));
        assertThat(output, containsString("2 Wochen und"));
        assertThat(output, containsString("2 Tagen"));
    }

    @Test
    public void oneDayAndWeek() {
        System.setIn(new ByteArrayInputStream("8".getBytes()));
        Ueb01b.main(null);
        String output = outContent.toString();
        assertThat(output, containsString("8 Kerben entsprechen"));
        assertThat(output, containsString("0 Jahren"));
        assertThat(output, containsString("0 Monaten"));
        assertThat(output, containsString("1 Wochen und"));
        assertThat(output, containsString("1 Tagen"));
    }

    @Test
    public void oneWeekAndMonth() {
        System.setIn(new ByteArrayInputStream("35".getBytes()));
        Ueb01b.main(null);
        String output = outContent.toString();
        assertThat(output, containsString("35 Kerben entsprechen"));
        assertThat(output, containsString("0 Jahren"));
        assertThat(output, containsString("1 Monaten"));
        assertThat(output, containsString("1 Wochen und"));
        assertThat(output, containsString("0 Tagen"));
    }

    @Test
    public void oneMonthAndYear() {
        System.setIn(new ByteArrayInputStream("364".getBytes()));
        Ueb01b.main(null);
        String output = outContent.toString();
        assertThat(output, containsString("364 Kerben entsprechen"));
        assertThat(output, containsString("1 Jahren"));
        assertThat(output, containsString("1 Monaten"));
        assertThat(output, containsString("0 Wochen und"));
        assertThat(output, containsString("0 Tagen"));
    }
}