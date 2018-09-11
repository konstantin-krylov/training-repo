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
        assertEquals(" 1 2 3 4 5 6 7 ", myArrayList.listToString());
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

        exception.expect(IllegalArgumentException.class);
        myArrayList.getElement(17);
    }

    @Test
    public void reverse() {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.putIntoList(array);
        myArrayList.reverse();
        assertEquals(" 7 6 5 4 3 2 1 ", myArrayList.listToString());
    }
}