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
        MyCollections.sort(list, true);
        assertEquals("1 2 3 4 5 6 7 8", list.listToString());
    }

    @Test
    public void max() {
        SimplyLinkedList list = new SimplyLinkedList();
        int[] array1 = {8, 5, 3, 1, 7, 4, 2, 6};
        list.putIntoList(array1);
        MyCollections.max(list);
        assertEquals(8, MyCollections.max(list));
    }

    @Test
    public void min() {
        SimplyLinkedList list = new SimplyLinkedList();
        int[] array1 = {8, 5, 3, 1, 7, 4, 2, 6};
        list.putIntoList(array1);
        MyCollections.max(list);
        assertEquals(1, MyCollections.min(list));
    }
    @Test
    public void binarySearch() {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        SimplyLinkedList list = new SimplyLinkedList();
        list.putIntoList(array);
        assertEquals(0, SimplyLinkedList.binarySearch(list, 1)); // находит первый элемент
        assertEquals(4, SimplyLinkedList.binarySearch(list, 5));
        assertEquals(6, SimplyLinkedList.binarySearch(list, 7)); // находит последний элемент
        assertEquals(-1, SimplyLinkedList.binarySearch(list, 10)); // корректно работает, если элемента в массиве нет
    }
}