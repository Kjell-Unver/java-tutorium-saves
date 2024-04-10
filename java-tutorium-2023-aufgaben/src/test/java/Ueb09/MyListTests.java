package Ueb09;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests der Methoden, die bereits im Tutorium vorgestellt wurden.
 */
public class MyListTests {

    /**
     * Erzeugt eine Liste mit den übergebenen Werten.
     * @param values Werte, die in die Liste eingefügt werden sollen.
     * @return Liste mit den Werten.
     */
    private MyList createList(int... values) {
        MyList list = new MyList();
        for (int value : values) {
            list.appendValue(value);
        }
        return list;
    }

    // Unit-Tests für isEmpty, size, getValuesAsArray
    // und appendValue (Methoden aus dem Tutorium)
    //-----------------------------------------------

    @Test
    public void shouldBeEmpty() {
        // Given
        MyList list = new MyList();
        // Then
        assertTrue(list.isEmpty());
    }

    @Test
    public void shouldNotBeEmpty() {
        // Given
        MyList list = createList(1, 1, 2, 3, 5);
        // Then
        assertFalse(list.isEmpty());
    }

    @Test
    public void shouldBeSizeFive() {
        // Given
        MyList list = createList(1, 1, 2, 3, 5);
        // Then
        assertEquals(5, list.size());
    }

    @Test
    public void shouldBeSizeZero() {
        // Given
        MyList list = new MyList();
        // Then
        assertEquals(0, list.size());
    }

    @Test
    public void shouldReturnArrayFromList() {
        // Given
        MyList list = createList(1, 1, 2, 3, 5);
        // Then
        assertArrayEquals(new int[]{1, 1, 2, 3, 5}, list.getValuesAsArray());
    }

    @Test
    public void shouldReturnEmptyArrayFromList() {
        // Given
        MyList list = new MyList();
        // Then
        assertArrayEquals(new int[0], list.getValuesAsArray());
    }

    @Test
    public void shouldAppendValueToEmptyList() {
        // Given
        MyList list = new MyList();
        // When
        list.appendValue(1);
        // Then
        assertEquals(1, list.size());
        assertArrayEquals(new int[]{1}, list.getValuesAsArray());
    }

    @Test
    public void shouldAppendValueToList() {
        // Given
        MyList list = createList(1, 1, 2, 3, 5);
        // When
        list.appendValue(8);
        // Then
        assertEquals(6, list.size());
        assertArrayEquals(new int[]{1, 1, 2, 3, 5, 8}, list.getValuesAsArray());
    }

    // Tests für popValue
    //-----------------------------------------------

    @Test
    public void shouldPopValueFromList() {
        // TODO
    }

    @Test
    public void shouldPopValueFromListOfOne() {
        // TODO
    }

    @Test
    public void shouldThrowExceptionPopValueFromEmptyList() {
        // TODO
    }

    // Tests für insertValue
    //-----------------------------------------------

    @Test
    public void shouldInsertValueAtFrontInEmptyList() {
        // TODO
    }

    @Test
    public void shouldInsertValueAtFront() {
        // TODO
    }

    @Test
    public void shouldInsertValueInTheMiddle() {
        // TODO
    }

    @Test
    public void shouldInsertValueAtEnd() {
        // TODO
    }

    @Test
    public void shouldThrowExceptionInsertValueInEmptyList() {
        // TODO
    }

    @Test
    public void shouldThrowExceptionInsertValueIndexOutOfBounds() {
        // TODO
    }

    // Tests für deleteValue
    //-----------------------------------------------

    @Test
    public void shouldDeleteValueAtFront() {
        // TODO
    }

    @Test
    public void shouldDeleteValueInMiddle() {
        // TODO
    }

    @Test
    public void shouldDeleteValueAtEnd() {
        // TODO
    }

    @Test
    public void shouldDeleteValueFromListOfOne() {
        // TODO
    }

    @Test
    public void shouldThrowExceptionDeleteValueIndexOutOfBounds() {
        // TODO
    }

    @Test
    public void shouldThrowExceptionDeleteValueFromEmptyList() {
        // TODO
    }

    // Tests für getvalue
    //-----------------------------------------------

    @Test
    public void shouldGetValueFromList() {
        // TODO
    }

    @Test
    public void shouldThrowExceptionGetValueFromEmptyList() {
        // TODO
    }

    @Test
    public void shouldThrowExceptionGetValueIndexOutOfBounds() {
        // TODO
    }

    // Tests für setValue
    //-----------------------------------------------

    @Test
    public void shouldSetValueInList() {
        // TODO
    }

    @Test
    public void shouldThrowExceptionSetValueAtEmptyList() {
        // TODO
    }

    @Test
    public void shouldThrowExceptionSetValueIndexOutOfBounds() {
        // TODO
    }

    // Tests für valueExists
    //-----------------------------------------------

    @Test
    public void shouldNotExistInEmptyList() {
        // TODO
    }

    @Test
    public void shouldExistInList() {
        // TODO
    }

    @Test
    public void shouldNotExistInList() {
        // TODO
    }

    // Tests für isSorted
    //-----------------------------------------------

    @Test
    public void shouldBeSortedEmptyList() {
        // TODO
    }

    @Test
    public void shouldBeSortedListOfOne() {
        // TODO
    }

    @Test
    public void shouldBeSortedList() {
        // TODO
    }

    @Test
    public void shouldNotBeSortedList() {
        // TODO
    }

    // Tests für insertValueSorted
    //-----------------------------------------------

    @Test
    public void shouldInsertValueSortedInEmptyList() {
        // TODO
    }

    @Test
    public void shouldInsertValueSortedAtFront() {
        // TODO
    }

    @Test
    public void shouldInsertValueSortedInMiddle() {
        // TODO
    }

    @Test
    public void shouldInsertValueSortedAtEnd() {
        // TODO
    }

    // Tests für sort
    //-----------------------------------------------

    @Test
    public void shouldSortList() {
        // TODO
    }

    // Tests für toString
    //-----------------------------------------------

    @Test
    public void shouldReturnStringOfEmptyList() {
        // TODO
    }

    @Test
    public void shouldReturnStringOfList() {
        // TODO
    }
}
