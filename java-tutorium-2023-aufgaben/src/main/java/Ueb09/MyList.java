package Ueb09;

public class MyList {

    private Element startElement;

    //----------------------------------------
    // MyList constructor
    //----------------------------------------
    public MyList() {
        startElement = null;
    }

    //----------------------------------------
    // Class for the elements of the list
    //----------------------------------------
    private static class Element {

        private int value;
        private Element next;

        private Element(int value) {
            this.value = value;
            this.next = null;
        }
    }

    //----------------------------------------
    // MyList methods
    //----------------------------------------
    public boolean isEmpty() {
        return startElement == null;
    }

    public int size() {
        int elementCounter = 0;
        Element listElement = startElement;
        while (listElement != null) {
            elementCounter++;
            listElement = listElement.next;
        }
        return elementCounter;
    }

    public int[] getValuesAsArray() {
        int[] arr = new int[size()];
        Element listElement = startElement;
        int i = 0;
        while (listElement != null) {
            arr[i++] = listElement.value;
            listElement = listElement.next;
        }
        return arr;
    }

    public void appendValue(int value) {
        Element newElement = new Element(value);
        // list is empty
        if (isEmpty()) {
            startElement = newElement;
            return;
        }
        // list has at least one element
        Element listElement = startElement;
        while (listElement.next != null) {
            listElement = listElement.next;
        }
        listElement.next = newElement;
    }

    public int popValue() {
        // TODO
        // if list is empty, throw IndexOutOfBoundsException
        return 1;
    }

    public void insertValueAtIndex(int value, int index) {
        // TODO
        // if index not in list, throw IndexOutOfBoundsException
    }

    public void insertValueAtFront(int value) {
        // TODO
    }

    public void deleteValueAtIndex(int index) {
        // TODO
        // if index not in list, throw IndexOutOfBoundsException
    }

    public int getValueAtIndex(int index) {
        // TODO
        // if index not in list, throw IndexOutOfBoundsException
        return 1;
    }

    public void setValueAtIndex(int value, int index) {
        // TODO
        // if index not in list, throw IndexOutOfBoundsException
    }

    public boolean valueExists(int value) {
        // TODO
        return false;
    }

    public boolean isSorted() {
        // TODO
        return false;
    }

    public void insertValueSorted(int value) {
        // TODO
    }

    public void sort() {
        // TODO
    }

    public String toString() {
        // TODO
        return "";
    }
}
