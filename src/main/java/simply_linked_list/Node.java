package simply_linked_list;


class Node {
    private int data;

    private Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public static Node putIntoList(int[] nums) {
        Node list = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            int element = nums[i];
            Node prev = list;
            list = new Node(element, prev);
        }

        return list;
    }

    public static void deleteElement(Node top, int index) {

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

    public static int getElement(Node list, int index) {
        int count = 0;
        int result = 0;

        while (list != null) {
            result = list.getData();
            list = list.getNext();
            if (count == index) {
                return result;
            }
            count++;
        }

        throw new IndexOutOfBoundsException();

    }

    public static String listToString(Node list) {
        String result = "";
        while (list != null) {
            result += list.getData() + " -> ";
            list = list.getNext();
        }
        result += list;
        return result;
    }

    public static Node addLast(Node top, int newElement) {

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


