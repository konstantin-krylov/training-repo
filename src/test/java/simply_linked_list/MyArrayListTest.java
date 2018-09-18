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
    public void sort() {
        int[] array = {2000, 17, 1, 3, 20, 5000, 100, 7, 900, 1000};
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.putIntoList(array);
        MyCollections.sort(myArrayList, false);
        assertEquals("5000 2000 1000 900 100 20 17 7 3 1", myArrayList.listToString());
    }

    @Test
    public void max() {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.putIntoList(array);
        assertEquals(7, MyCollections.max(myArrayList));
    }

    @Test
    public void min() {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        MyArrayList list = new MyArrayList();
        list.putIntoList(array);
        assertEquals(1, MyCollections.min(list));
    }

    /**
     * Распространенные ошибки:
     * — не работает с массивом из 0/1/2 элементов
     * — не находит первый или последний элемент
     * — некорректно работает, если элемента в массиве нет
     * — некорректно работает, если в массиве есть повторяющиеся элементы
     * — обращение к элементам за пределами массива
     * — козырная, которая была в JDK, переполнение целого при вычислении среднего индекса
     */

    @Test
    public void binarySearch1() {
        int[] array = {1, 2};
        MyArrayList list = new MyArrayList();
        list.putIntoList(array);
        assertEquals(0, MyArrayList.binarySearch(list, 1)); // работает с массивом из 2 элементов
    }

    @Test
    public void binarySearch2() {
        int[] array = {1};
        MyArrayList list = new MyArrayList();
        list.putIntoList(array);
        assertEquals(0, MyArrayList.binarySearch(list, 1)); // работает с массивом из 1 элемента
    }

    @Test
    public void binarySearch3() {
        int[] array = {};
        MyArrayList list = new MyArrayList();
        list.putIntoList(array);
        assertEquals(-1, MyArrayList.binarySearch(list, 1)); // работает с массивом из 0 элементов
    }

    @Test
    public void binarySearch5() {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        MyArrayList list = new MyArrayList();
        list.putIntoList(array);
        assertEquals(0, MyArrayList.binarySearch(list, 1)); // находит первый элемент
        assertEquals(4, MyArrayList.binarySearch(list, 5));
        assertEquals(6, MyArrayList.binarySearch(list, 7)); // находит последний элемент
        assertEquals(-1, MyArrayList.binarySearch(list, 10)); // корректно работает, если элемента в массиве нет
    }

    // Не знаю как написать метод assertEquals для этого метода.
    @Test
    public void count() {
        int[]array = MyCollections.readingFromFile();
        MyArrayList list = new MyArrayList();
        list.putIntoList(array);
        MyCollections.count(list);

    }
}