package simply_linked_list;

public class MyArrayList implements MyLists {

    private int[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 16;

    public MyArrayList() {
        elements = new int[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        elements = new int[capacity];
    }

    public void putIntoList(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (size == elements.length) {
                growArray();
            }
            elements[size] = nums[i];
            size++;
        }
    }

    /**
     * увеличить массив если в нем закончилось место
     */
    public void growArray() {
        int[] newArray = new int[elements.length * 2];
        System.arraycopy(elements, 0, newArray, 0, size - 1);
        elements = newArray;
    }

    public String listToString() {
        String result = "";
        for (int i = 0; i < size; i++) {
            result += elements[i] + " ";
        }
        String res = result.substring(0, result.length() - 1);
        return res;
    }

    public int getElement(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        return elements[index];
    }

    public void reverse() {
        int[] newArray = new int[size];
        for (int i = 0; i < size; i++) {
            newArray[newArray.length - 1 - i] = elements[i];
        }
        elements = newArray;
    }

    public void addLast(int newElement) {
        if (size == elements.length) {
            growArray();
        }
        elements[size++] = newElement;
    }

    public void addFirst(int newElement) {
        int[] newArray = new int[size + 1];
        newArray[0] = newElement;
        System.arraycopy(elements, 0, newArray, 1, size);
        size++;
        elements = newArray;
    }

    public void addMiddle(int newElement, int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException();

        int[] newArray = new int[size + 1];
        System.arraycopy(elements, 0, newArray, 0, index);
        newArray[index] = newElement;
        System.arraycopy(elements, index, newArray, index + 1, size - index);
        size++;
        elements = newArray;
    }
}
