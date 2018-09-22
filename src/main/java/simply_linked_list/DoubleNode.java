package simply_linked_list;

public class DoubleNode {

    public int data;

    public DoubleNode next;

    public DoubleNode prev;

    public DoubleNode(int data, DoubleNode next, DoubleNode prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}
