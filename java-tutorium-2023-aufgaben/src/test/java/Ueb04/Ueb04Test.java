package Ueb04;

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

public class Ueb04Test {
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
    public void countSpaces() {
        System.setIn(new ByteArrayInputStream(String.format("A%1$sTutorium Grundlagen der Programmierung%1$sB%1$sX", System.lineSeparator()).getBytes()));
        Ueb04.main(null);
        String output = outContent.toString();
        assertThat(output, containsString("3 Leerzeichen im Satz gefunden"));
    }

    @Test
    public void swapFirstAndLastWord() {
        System.setIn(new ByteArrayInputStream(String.format("A%1$sNachts ist kaelter als draussen%1$sC%1$sX", System.lineSeparator()).getBytes()));
        Ueb04.main(null);
        String output = outContent.toString();
        assertThat(output, containsString("draussen ist kaelter als Nachts"));
    }

    @Test
    public void swapFirstAndLastWordWithErroneousSentence() {
        System.setIn(new ByteArrayInputStream(String.format("A%1$s  %1$sC%1$sX", System.lineSeparator()).getBytes()));
        Ueb04.main(null);
        String output = outContent.toString();
        assertThat(output, containsString("Der Satz muss mindestens 2 Wörter aufweisen und an erster und letzter Stelle darf kein Leerzeichen vorkommen!"));
    }

    @Test
    public void swapFirstAndLastWordWithErroneousSentence2() {
        System.setIn(new ByteArrayInputStream(String.format("A%1$sHallo%1$sC%1$sX", System.lineSeparator()).getBytes()));
        Ueb04.main(null);
        String output = outContent.toString();
        assertThat(output, containsString("Der Satz muss mindestens 2 Wörter aufweisen und an erster und letzter Stelle darf kein Leerzeichen vorkommen!"));
    }

    @Test
    public void swapFirstAndLastWordWithErroneousSentence3() {
        System.setIn(new ByteArrayInputStream(String.format("A%1$sHallo Leute %1$sC%1$sX", System.lineSeparator()).getBytes()));
        Ueb04.main(null);
        String output = outContent.toString();
        assertThat(output, containsString("Der Satz muss mindestens 2 Wörter aufweisen und an erster und letzter Stelle darf kein Leerzeichen vorkommen!"));
    }

    @Test
    public void removeVowels() {
        System.setIn(new ByteArrayInputStream(String.format("A%1$sHallo Opa, ich habe Emil angerufen%1$sD%1$sX", System.lineSeparator()).getBytes()));
        Ueb04.main(null);
        String output = outContent.toString();
        assertThat(output, containsString("Hll p, ch hb ml ngrfn"));
    }

    @Test
    public void showErrorMessageIfNoSentenceProvided() {
        System.setIn(new ByteArrayInputStream(String.format("B%1$sC%1$sD%1$sX", System.lineSeparator()).getBytes()));
        Ueb04.main(null);
        String output = outContent.toString();
        assertEquals(output.split("Es wurde noch kein Satz eingegeben!").length - 1, 3);
    }

    @Test
    public void oneWhitespace() {
        System.setIn(new ByteArrayInputStream(String.format("A%1$s %1$sB%1$sC%1$sX", System.lineSeparator()).getBytes()));
        Ueb04.main(null);
        String output = outContent.toString();
        assertThat(output, containsString("1 Leerzeichen im Satz gefunden"));
        assertThat(output, containsString("Der Satz muss mindestens 2 Wörter aufweisen und an erster und letzter Stelle darf kein Leerzeichen vorkommen!"));
    }

    @Test
    public void twoWhitespaces() {
        System.setIn(new ByteArrayInputStream(String.format("A%1$s  %1$sB%1$sC%1$sX", System.lineSeparator()).getBytes()));
        Ueb04.main(null);
        String output = outContent.toString();
        assertThat(output, containsString("2 Leerzeichen im Satz gefunden"));
        assertThat(output, containsString("Der Satz muss mindestens 2 Wörter aufweisen und an erster und letzter Stelle darf kein Leerzeichen vorkommen!"));
    }

    @Test
    public void startAndEndWithWhitespace() {
        System.setIn(new ByteArrayInputStream(String.format("A%1$s a %1$sB%1$sC%1$sX", System.lineSeparator()).getBytes()));
        Ueb04.main(null);
        String output = outContent.toString();
        assertThat(output, containsString("2 Leerzeichen im Satz gefunden"));
        assertThat(output, containsString("Der Satz muss mindestens 2 Wörter aufweisen und an erster und letzter Stelle darf kein Leerzeichen vorkommen!"));
    }

    @Test
    public void oneLetter() {
        System.setIn(new ByteArrayInputStream(String.format("A%1$s#a#%1$sB%1$sC%1$sD%1$sX", System.lineSeparator()).getBytes()));
        Ueb04.main(null);
        String output = outContent.toString();
        assertThat(output, containsString("0 Leerzeichen im Satz gefunden"));
        assertThat(output, containsString("Der Satz muss mindestens 2 Wörter aufweisen und an erster und letzter Stelle darf kein Leerzeichen vorkommen!"));
        assertThat(output, containsString("##"));
    }

    @Test
    public void twoLetters() {
        System.setIn(new ByteArrayInputStream(String.format("A%1$s#aa#%1$sB%1$sC%1$sD%1$sX", System.lineSeparator()).getBytes()));
        Ueb04.main(null);
        String output = outContent.toString();
        assertThat(output, containsString("0 Leerzeichen im Satz gefunden"));
        assertThat(output, containsString("Der Satz muss mindestens 2 Wörter aufweisen und an erster und letzter Stelle darf kein Leerzeichen vorkommen!"));
        assertThat(output, containsString("##"));
    }

    @Test
    public void twoDifferentLetters() {
        System.setIn(new ByteArrayInputStream(String.format("A%1$sab%1$sB%1$sC%1$sX", System.lineSeparator()).getBytes()));
        Ueb04.main(null);
        String output = outContent.toString();
        assertThat(output, containsString("0 Leerzeichen im Satz gefunden"));
        assertThat(output, containsString("Der Satz muss mindestens 2 Wörter aufweisen und an erster und letzter Stelle darf kein Leerzeichen vorkommen!"));
    }

    @Test
    public void twoSingleLetterWords() {
        System.setIn(new ByteArrayInputStream(String.format("A%1$sa b%1$sB%1$sC%1$sX", System.lineSeparator()).getBytes()));
        Ueb04.main(null);
        String output = outContent.toString();
        assertThat(output, containsString("1 Leerzeichen im Satz gefunden"));
        assertThat(output, containsString("b a"));
    }

    @Test
    public void oneWord() {
        System.setIn(new ByteArrayInputStream(String.format("A%1$sOTTO%1$sB%1$sC%1$sD%1$sX", System.lineSeparator()).getBytes()));
        Ueb04.main(null);
        String output = outContent.toString();
        assertThat(output, containsString("0 Leerzeichen im Satz gefunden"));
        assertThat(output, containsString("Der Satz muss mindestens 2 Wörter aufweisen und an erster und letzter Stelle darf kein Leerzeichen vorkommen!"));
        assertThat(output, containsString("TT"));
    }

    @Test
    public void sentence() {
        System.setIn(new ByteArrayInputStream(String.format("A%1$sOTTO ist toll%1$sB%1$sC%1$sD%1$sX", System.lineSeparator()).getBytes()));
        Ueb04.main(null);
        String output = outContent.toString();
        assertThat(output, containsString("2 Leerzeichen im Satz gefunden"));
        assertThat(output, containsString("toll ist OTTO"));
        assertThat(output, containsString("TT st tll"));
    }

    @Test
    public void vowels() {
        System.setIn(new ByteArrayInputStream(String.format("A%1$s#aeiouAEIOU#%1$sB%1$sC%1$sD%1$sX", System.lineSeparator()).getBytes()));
        Ueb04.main(null);
        String output = outContent.toString();
        assertThat(output, containsString("0 Leerzeichen im Satz gefunden"));
        assertThat(output, containsString("Der Satz muss mindestens 2 Wörter aufweisen und an erster und letzter Stelle darf kein Leerzeichen vorkommen!"));
        assertThat(output, containsString("##"));
    }
}