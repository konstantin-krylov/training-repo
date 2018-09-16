package simply_linked_list;

public interface MyLists {
    void putIntoList(int[] nums);

    String listToString();

    int getElement(int index);

    void setElement(int index, int value);

    void reverse();

    void addLast(int newElement);

    void addFirst(int newElement);

    void addMiddle(int newElement, int index);

    int getSize();
}