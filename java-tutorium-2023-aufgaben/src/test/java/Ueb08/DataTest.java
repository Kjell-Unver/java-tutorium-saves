package Ueb08;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;

import static org.junit.jupiter.api.Assertions.*;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DataTest {

    @Test
    public void testNumberOfCandidates() {
        assertEquals(5, Data.getNumberOfCandidates());
    }

    @Test
    public void testNumberOfElections() {
        assertEquals(7, Data.getNumberOfElections());
    }

    @Test
    public void testValidCandidateId() {
        assertTrue(Data.isValidCandidateId(0));
        assertTrue(Data.isValidCandidateId(4));
        assertFalse(Data.isValidCandidateId(-1));
        assertFalse(Data.isValidCandidateId(5));
    }

    @Test
    public void testValidElectionId() {
        assertTrue(Data.isValidElectionId(0));
        assertTrue(Data.isValidElectionId(6));
        assertFalse(Data.isValidElectionId(-1));
        assertFalse(Data.isValidElectionId(7));
    }

    @Test
    public void testCandidateNameById() {
        assertNull(Data.getCandidateNameById(-1));
        assertEquals("E. Herms", Data.getCandidateNameById(0));
        assertEquals("M. Riema", Data.getCandidateNameById(4));
    }

    @Test
    public void testVotes() {
        assertArrayEquals(new int[][]{}, Data.getVotes(0));
        assertNull(Data.getVotes(20));
    }

    @Test
    /* Bei diesem Test wurde versucht nur auf Wissen aus der Vorlesung 
    zurückzugreifen. Eine elegantere Weise ist möglich. 
    */
    public void testVotesDeepCopy() {
        // erwartete Wahl
        int[][] votesExpected = {{0, 1}, {2, 1}, {3, 1}, {4, 1}, {2, 1},
                {3, 1}, {4, 1}, {3, 1}, {4, 1}, {4, 1}};

        // erwartete Wahl wird mit der Wahl Nr. 5 verglichen
        int[][] votesCopy = Data.getVotes(5);
        assertArrayEquals(votesExpected, votesCopy);

        // Änderung der Werte außerhalb
        votesCopy[0][0] = 5;

        // erwartete Wahl wird erneut mit der Wahl Nr. 5 verglichen
        // Änderung darf keinen Einfluss auf die Werte dieses Datensatzes haben
        assertArrayEquals(votesExpected, Data.getVotes(5));
    }
}
