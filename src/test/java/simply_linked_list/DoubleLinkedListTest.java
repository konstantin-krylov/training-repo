package simply_linked_list;

import org.junit.Test;

import static org.junit.Assert.*;

public class DoubleLinkedListTest {

    @Test
    public void putIntoList() {
        DoubleLinkedList list = new DoubleLinkedList();
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        list.putIntoList(array);
        assertEquals("1 2 3 4 5 6 7", list.listToString());
    }

    @Test
    public void addFirst() {
        DoubleLinkedList list = new DoubleLinkedList();
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        list.putIntoList(array);
        list.addFirst(0);
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        assertEquals("4 3 2 1 0 1 2 3 4 5 6 7", list.listToString());
    }

    @Test
    public void addMiddle() {
        DoubleLinkedList list = new DoubleLinkedList();
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        list.putIntoList(array);
        list.addMiddle(55,3);
        assertEquals("1 2 3 55 4 5 6 7", list.listToString());
    }

    @Test
    public void addLast() {
        DoubleLinkedList list = new DoubleLinkedList();
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        list.putIntoList(array);
        list.addLast(8);
        assertEquals("1 2 3 4 5 6 7 8", list.listToString());
    }

    @Test
    public void getSize() {
        DoubleLinkedList list = new DoubleLinkedList();
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        list.putIntoList(array);
        assertEquals(7,list.getSize());

        list.addFirst(0);
        assertEquals(8,list.getSize());

        list.addLast(8);
        list.addMiddle(55, 3);
        assertEquals(10,list.getSize());

    }

    @Test
    public void deleteElement() {
        DoubleLinkedList list = new DoubleLinkedList();
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        list.putIntoList(array);
        list.deleteElement(2);
        assertEquals("1 2 4 5 6 7", list.listToString());
    }
}