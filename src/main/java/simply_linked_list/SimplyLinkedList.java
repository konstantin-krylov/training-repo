package simply_linked_list;

public class SimplyLinkedList {

    private Node top;

    public SimplyLinkedList(Node top) {
        this.top = top;
    }


    public SimplyLinkedList() {
    }

    public Node putIntoList(int[] nums) {

        for (int i = nums.length - 1; i >= 0; i--) {
            int element = nums[i];
            Node prev = top;
            top = new Node(element, prev);
        }

        return this.top;
    }

    public String listToString() {
        String result = "";
        while (top != null) {
            result += top.getData() + " -> ";
            top = top.getNext();
        }
        result += top;
        return result;
    }

    public void deleteElement(int index) {

        //Чтобы удалить элемент в середине связанного списка,
        // необходимо установить указатель «ссылка» предыдущего элемента
        // на указатель «ссылка» объекта, который нужно удалить.

        int count = 0;

        while (top != null) {
            if (count == index - 1) {
                top.setNext(top.getNext().getNext());
            }
            top = top.getNext();
            count++;
        }
    }

    public int getElement(int index) {
        int count = 0;
        int result = 0;

        while (top != null) {
            result = top.getData();
            top = top.getNext();
            if (count == index) {
                return result;
            }
            count++;
        }

        throw new IndexOutOfBoundsException();

    }

    public Node addLast(int newElement) {

        //Прячем значение начала списка в переменную
        Node first = top;

        // проверка, если список пуст
        if (top == null) return new Node(newElement, null);

        // пробегаем по всему списку до последнего элемента
        while (top.getNext() != null) {
            top = top.getNext();
        }
        top.setNext(new Node(newElement, null));

        return first;

    }

    public static Node addFirst(Node top, int newElement) {

        Node next = top;
        top = new Node(newElement, next);

        return top;
    }

    public static Node addMiddle(Node top, int newElement, int index) {

        // проверка, если список пуст
        if (top == null) return new Node(newElement, null);

        int count = 0;

        Node first = top; // здесь хранится ссылка на начало списка

        while (top != null) {
            if (count == index - 1) {
                Node storeNext = top.getNext(); // здесь храним ссылку на элемент, идущий после нового элемента
                top.setNext(new Node(newElement, storeNext));

                return first;

            }
            top = top.getNext();
            count++;
        }
        throw new IndexOutOfBoundsException(); // если не зашли в if, значит вывалились из списка
    }

    public static Node reverse(Node top) {
        Node prev = null;
        Node next = null;

        while (top != null) {
            next = top.getNext(); // 2; 3;
            top.setNext(prev); // 1 -> null;    2 -> 1;
            prev = top; // 1;   2;
            top = next; // 2;   3;
        }
        top = prev; // 7
        return top;
    }

}
