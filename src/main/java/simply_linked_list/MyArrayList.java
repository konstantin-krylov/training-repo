package simply_linked_list;

public class MyArrayList implements MyLists{

    private int[] elements;
    private int size;
    private int index;
    private static final int DEFAULT_CAPACITY = 16;

    public MyArrayList() {
        elements = new int[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        elements = new int[capacity];
    }

    public void putIntoList(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (index == elements.length) {
                growArray();
            }
            elements[index] = nums[i];
            index++;
            size++;
        }
    }

    /**
     * увеличить массив если в нем закончилось место
     */
    public void growArray() {
        int[] newArray = new int[elements.length * 2];
        System.arraycopy(elements, 0, newArray, 0, index - 1);
        elements = newArray;
    }

    public String listToString() {
        String result = " ";
        for (int tmp : elements) {
            result += tmp + " ";
        }
        return result;
    }

    public int getElement(int index) {
        if (index < 0 || index >= this.index) {
            throw new IllegalArgumentException();
        }
        return elements[index];
    }

    public void reverse() {
        int[] newArray = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            newArray[newArray.length - 1-i] = elements[i];
        }
        System.arraycopy(newArray,0,elements,0,index);
    }
}
