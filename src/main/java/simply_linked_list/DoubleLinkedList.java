package simply_linked_list;


public class DoubleLinkedList {

    private DoubleNode top;

    private DoubleNode tail;

    private int size;


    public void putIntoList(int[] nums) {

        // лист заполняется с конца!!!
        for (int i = nums.length - 1; i >= 0; i--) {
            int element = nums[i];

            DoubleNode currFirst = top;
            DoubleNode newNode = new DoubleNode(element,currFirst,null);
            top = newNode;

            if (currFirst==null) {
                tail = newNode;
            }
            else {
                currFirst.prev = newNode;
            }
            size++;
        }
    }

    public String listToString() {
        DoubleNode head = top;
        String result = "";
        while (head != null) {
            result += head.data + " ";
            head = head.next;
        }
        String res = result.substring(0, result.length() - 1);
        return res;
    }

    void addMiddle(int newElement, int index) {
        checkIndex(index);

        DoubleNode head = top;
        int count = 0;
        while (head != null) {

            if (count == index-1){
                DoubleNode current = head;
                DoubleNode afterNewNode = current.next;
                DoubleNode newNode = new DoubleNode(newElement,afterNewNode,current);

                head.prev = newNode;
                head.next = newNode;
                size++;
                return;
            }

            head = head.next;
            count++;
        }

    }

    void addFirst(int newElement) {
        DoubleNode currFirst = top; //сохраняем ссылку на первый элемент
        DoubleNode newNode = new DoubleNode(newElement,currFirst,null); // обьявление ссылки на новый нод   null <- newElement -> currFirst(top)
        top = newNode;

        if (currFirst == null) { // если список пуст, то хвост - это новый Node
            tail = newNode;
        }
        else currFirst.prev = newNode; // а если нет - то даем ссылку на новый элемент предыдущему элементу   newElement <- currFirst
        size++;
    }

    void addLast(int newElement) {
        DoubleNode head = top;
        if (head == null) {
            addFirst(newElement);
        }


        DoubleNode previousNode = tail;
        DoubleNode newNode = new DoubleNode(newElement,null,previousNode);
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    void checkIndex (int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException();
    }

    public void deleteElement(int index) {
        checkIndex(index);

        DoubleNode head = top;
        int count = 0;
        while (head !=null) {

            if (count == index) {
                DoubleNode prevNode = head.prev;
                DoubleNode nextNode = head.next;
                prevNode.next = nextNode;
                nextNode.prev = prevNode;
            }
            head = head.next;
            count++;
        }
    }

    public DoubleNode getTail() {
        return tail;
    }

    public int getSize() {
        return size;
    }
}
