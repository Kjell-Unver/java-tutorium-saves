package Ueb08;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ElectionTest {

    @Test
    void orderFirstPassThePostShouldHandleArraysWithLengthZero() {
        int[][] votes = new int[][] {{}, {2}, {3}, {4}, {2}, {3}, {4}, {3}, {4}, {4}};
        int[][] result = Election.orderFirstPassThePost(votes);
        int[][] expected = Election.zipCandidatesAndCounts(new int[] {0, 0, 2, 3, 4});
        assertArrayEquals(expected, result);
    }
}