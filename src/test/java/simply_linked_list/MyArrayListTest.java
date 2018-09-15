package simply_linked_list;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class MyArrayListTest {

    @Test
    public void putIntoList() {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.putIntoList(array);
        assertEquals("1 2 3 4 5 6 7", myArrayList.listToString());
    }

    @Test
    public void growArray() {
    }

    @Test
    public void listToString() {
    }

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void getElement() {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.putIntoList(array);
        assertEquals(4, myArrayList.getElement(3));

        exception.expect(IndexOutOfBoundsException.class);
        myArrayList.getElement(17);
    }

    @Test
    public void reverse() {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.putIntoList(array);
        myArrayList.reverse();
        assertEquals("7 6 5 4 3 2 1", myArrayList.listToString());
    }

    @Test
    public void addLast() {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.putIntoList(array);
        myArrayList.addLast(8);
        assertEquals("1 2 3 4 5 6 7 8", myArrayList.listToString());
    }

    @Test
    public void addFirst() {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.putIntoList(array);
        myArrayList.addFirst(0);
        assertEquals("0 1 2 3 4 5 6 7", myArrayList.listToString());
    }

    @Test
    public void addMiddle() {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.putIntoList(array);
        myArrayList.addMiddle(777, 3);
        assertEquals("1 2 3 777 4 5 6 7", myArrayList.listToString());
    }

    @Test
    public void max() {
        int[] array = {2000, 17, 1, 3, 20, 5, 100, 7, 900, 1000};
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.putIntoList(array);
        assertEquals(2000, myArrayList.max());
    }

    @Test
    public void min() {
        int[] array = {2000, 17, 1, 3, 20, 5, 100, 7, 900, 1000};
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.putIntoList(array);
        assertEquals(1, myArrayList.min());
    }

    @Test
    public void indexOfMax() {
        int[] array = {2000, 17, 1, 3, 20, 5000, 100, 7, 900, 1000};
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.putIntoList(array);
        assertEquals(5, myArrayList.indexOfMax());
    }


    @Test
    public void sort() {
        int[] array = {2000, 17, 1, 3, 20, 5000, 100, 7, 900, 1000};
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.putIntoList(array);
        MyCollections.sort(myArrayList, false);
        assertEquals("5000 2000 1000 900 100 20 17 7 3 1", myArrayList.listToString());
    }
}