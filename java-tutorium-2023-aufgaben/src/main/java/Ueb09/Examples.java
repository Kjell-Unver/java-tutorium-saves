package Ueb09;

import java.util.ArrayList;
import java.util.LinkedList;

public class Examples {

    public static void main(String[] args) {

        ArrayList<Integer> arrList = new ArrayList<>();
        arrList.add(5);
        arrList.get(0);
        arrList.remove(0);
        arrList.size();
        for (int i = 0; i < arrList.size(); i++) {
            System.out.println(arrList.get(i));
        }

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(5);
        arrList.get(0);
        linkedList.remove(0);
        linkedList.size();
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i));
        }

        MyList myList = new MyList();
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.getValueAtIndex(i));
        }

    }
}
