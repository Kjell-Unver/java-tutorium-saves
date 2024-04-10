package Ueb08;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author mri
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ArrayUtilsTest {
    @Test
    public void testMaximumIndex() {
        assertEquals(0, ArrayUtils.maximumIndex(new int[]{1, 0, 0, 0, 0}));
        assertEquals(1, ArrayUtils.maximumIndex(new int[]{1, 2, 0, 0, 0}));
        assertEquals(2, ArrayUtils.maximumIndex(new int[]{1, 2, 3, 0, 0}));
        assertEquals(3, ArrayUtils.maximumIndex(new int[]{1, 2, 3, 4, 0}));
        assertEquals(4, ArrayUtils.maximumIndex(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    public void testMaximumIndexFirst() {
        assertEquals(0, ArrayUtils.maximumIndex(new int[]{5, 0, 0, 0, 0}));
        assertEquals(0, ArrayUtils.maximumIndex(new int[]{5, 4, 3, 2, 1}));
    }

    @Test
    public void testMaximumIndexLast() {
        assertEquals(4, ArrayUtils.maximumIndex(new int[]{0, 0, 0, 0, 5}));
        assertEquals(4, ArrayUtils.maximumIndex(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    public void testMaximumIndexEmpty() {
        assertEquals(0, ArrayUtils.maximumIndex(new int[]{}));
    }

    @Test
    public void testMaximumIndexDuplicates() {
        assertEquals(0, ArrayUtils.maximumIndex(new int[]{1, 1, 1, 1, 1}));
        assertEquals(1, ArrayUtils.maximumIndex(new int[]{1, 2, 2, 2, 2}));
        assertEquals(2, ArrayUtils.maximumIndex(new int[]{1, 2, 3, 3, 3}));
        assertEquals(3, ArrayUtils.maximumIndex(new int[]{1, 2, 3, 4, 4}));
        assertEquals(4, ArrayUtils.maximumIndex(new int[]{1, 2, 3, 4, 5, 5}));
    }

    @Test
    public void testBuildOrderIndex() {
        assertArrayEquals(new int[]{}, ArrayUtils.buildOrderIndex(new int[]{}));
        int[] src = new int[]{0, 1, 2, 3, 4};
        assertArrayEquals(src, ArrayUtils.buildOrderIndex(new int[]{5, 4, 3, 2, 1}));
        assertArrayEquals(src, new int[]{0, 1, 2, 3, 4});
        assertArrayEquals(new int[]{1, 0, 2, 3, 4}, ArrayUtils.buildOrderIndex(new int[]{4, 5, 3, 2, 1}));
    }

    @Test
    public void testFilterValue() {
        assertArrayEquals(new int[]{}, ArrayUtils.filterValue(new int[]{}, 0));
        assertArrayEquals(new int[]{}, ArrayUtils.filterValue(new int[]{0}, 0));
        assertArrayEquals(new int[]{}, ArrayUtils.filterValue(new int[]{0, 0}, 0));

        assertArrayEquals(new int[]{1}, ArrayUtils.filterValue(new int[]{1, 0}, 0));
        assertArrayEquals(new int[]{1}, ArrayUtils.filterValue(new int[]{0, 1}, 0));

        assertArrayEquals(new int[]{0, 1}, ArrayUtils.filterValue(new int[]{0, 1}, 2));
        assertArrayEquals(new int[]{1, 0}, ArrayUtils.filterValue(new int[]{1, 0}, 2));

        assertArrayEquals(new int[]{}, ArrayUtils.filterValue(new int[]{2, 2}, 2));
    }
}
