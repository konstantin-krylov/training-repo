package simply_linked_list;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class NodeTest {


    @Test
    public void putIntoList() {
        SimplyLinkedList list = new SimplyLinkedList();
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        list.putIntoList(array);
        assertEquals("1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> null", list.listToString());
    }

    @Test
    public void deleteElement() {
        SimplyLinkedList list = new SimplyLinkedList();
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        list.putIntoList(array);
        list.deleteElement(3);
        assertEquals("1 -> 2 -> 3 -> 5 -> 6 -> 7 -> null", list.listToString());
    }

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void getElement() {
        SimplyLinkedList list = new SimplyLinkedList();
        int[] array = {1, 2, 3, 4, 5, 6, 7};

        list.putIntoList(array);
        assertEquals(4, list.getElement(3));
//        assertEquals(7, list.getElement(6));

        exception.expect(IndexOutOfBoundsException.class);
        list.getElement(17);
    }


    @Test
    public void addLast() {
        SimplyLinkedList list = new SimplyLinkedList();
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        list.putIntoList(array);

        list.addLast(45);

        assertEquals("1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 45 -> null",list.listToString());
    }
//
//    @Test
//    public void addFirst() {
//        assertEquals("45 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> null",Node.listToString(Node.addFirst(top,45)));
//    }
//
//    @Test
//    public void addMiddle() {
//        assertEquals("1 -> 2 -> 3 -> 67 -> 4 -> 5 -> 6 -> 7 -> null", Node.listToString(Node.addMiddle(top, 67, 3)));
//        assertEquals("67 -> null", Node.listToString(Node.addMiddle(null, 67, 3)));
//
//        exception.expect(IndexOutOfBoundsException.class);
//        Node.addMiddle(top,67, 12);
//    }
//
//    @Test
//    public void reverse() {
//        assertEquals("7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> null", Node.listToString(Node.reverse(top)));
//    }
}