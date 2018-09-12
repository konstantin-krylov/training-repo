package simply_linked_list;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.TestCase.assertEquals;


public class NodeTest {


    public SimplyLinkedList createList() {
        return new SimplyLinkedList();
    }

    @Test
    public void putIntoList() {
        MyLists list = createList();
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        list.putIntoList(array);
        assertEquals("1 2 3 4 5 6 7", list.listToString());
    }

    @Test
    public void deleteElement() {
        SimplyLinkedList list = new SimplyLinkedList();
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        list.putIntoList(array);
        list.deleteElement(3);
        assertEquals("1 2 3 5 6 7", list.listToString());
    }

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void getElement() {
        MyLists list = createList();
        int[] array = {1, 2, 3, 4, 5, 6, 7};

        list.putIntoList(array);
        assertEquals(4, list.getElement(3));
        assertEquals(7, list.getElement(6));

        exception.expect(IndexOutOfBoundsException.class);
        list.getElement(17);
    }


    @Test
    public void addLast() {
        SimplyLinkedList list = new SimplyLinkedList();
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        list.putIntoList(array);

        list.addLast(45);

        assertEquals("1 2 3 4 5 6 7 45", list.listToString());
    }

    @Test
    public void addFirst() {
        SimplyLinkedList list = new SimplyLinkedList();
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        list.putIntoList(array);

        list.addFirst(45);
        assertEquals("45 1 2 3 4 5 6 7", list.listToString());
    }

    @Test
    public void addMiddle() {
        /** Тест, если список пуст*/
        SimplyLinkedList list1 = new SimplyLinkedList();
        list1.addMiddle(67, 0);
        assertEquals("67", list1.listToString());


        SimplyLinkedList list = new SimplyLinkedList();
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        list.putIntoList(array);
        list.addMiddle(67, 3);
        assertEquals("1 2 3 67 4 5 6 7", list.listToString());

        /** Тест, если выходим за пределы списка*/
        exception.expect(IndexOutOfBoundsException.class);
        list.addMiddle(67, 12);
    }

    @Test
    public void reverse() {
        MyLists list = createList();
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        list.putIntoList(array);

        list.reverse();
        assertEquals("7 6 5 4 3 2 1", list.listToString());
    }

    @Test
    public void sort() {
        SimplyLinkedList list = new SimplyLinkedList();
        int[] array1 = {8, 5, 3, 1, 7, 4, 2, 6};
        list.putIntoList(array1);
        list.sort();
        assertEquals("1 2 3 4 5 6 7 8", list.listToString());
    }

    @Test
    public void ascendingSort() { // Doesn't work!!

        SimplyLinkedList list1 = new SimplyLinkedList();
        int[] array1 = {8, 5, 3, 1, 7, 4, 2, 6};
        list1.putIntoList(array1);
        list1.ascendingSort();
        assertEquals("1 2 3 4 5 6 7 8", list1.listToString());
    }
}