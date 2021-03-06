package simply_linked_list;


public class SimplyLinkedList extends MyCollections implements MyLists {

    private Node top;
    private int size;

    public void putIntoList(int[] nums) {

        for (int i = nums.length - 1; i >= 0; i--) {
            int element = nums[i];
            Node prev = top;
            top = new Node(element, prev);
            size++;
        }
    }

    public String listToString() {
        Node head = top;
        String result = "";
        while (head != null) {
            result += head.getData() + " ";
            head = head.getNext();
        }
        String res = result.substring(0, result.length() - 1);
        return res;
    }

    public void deleteElement(int index) {

        //Чтобы удалить элемент в середине связанного списка,
        // необходимо установить указатель «ссылка» предыдущего элемента
        // на указатель «ссылка» объекта, который нужно удалить.
        Node head = top;
        int count = 0;

        while (head != null) {
            if (count == index - 1) {
                head.setNext(head.getNext().getNext());
            }
            head = head.getNext();
            count++;
        }
    }

    public int getElement(int index) {
        Node head = top;
        int count = 0;
        int result = 0;

        while (head != null) {
            result = head.getData();
            head = head.getNext();
            if (count == index) {
                return result;
            }
            count++;
        }

        throw new IndexOutOfBoundsException();

    }

    public void setElement(int index, int value) {
        Node head = top;
        int count = 0;

        while (head != null) {
            if (count == index) {
                head.setData(value);
                return;
            }
            head = head.getNext();
            count++;
        }

        throw new IndexOutOfBoundsException();


    }

    public void addLast(int newElement) {

        //Прячем значение начала списка в переменную
        Node head = top;

        // проверка, если список пуст, применяем метод addFirst
        if (head == null) {
            addFirst(newElement);
        }

        // пробегаем по всему списку до последнего элемента
        while (head.getNext() != null) {
            head = head.getNext();
        }
        head.setNext(new Node(newElement, null));

    }

    public void addFirst(int newElement) {

        Node next = top;
        top = new Node(newElement, next);

    }

    public void addMiddle(int newElement, int index) {

        // проверка, если список пуст, применяем метод addFirst
        if (top == null) {
            addFirst(newElement);
            return;
        }

        Node head = top; // здесь хранится ссылка на начало списка
        int count = 0;

        while (head != null) {
            if (count == index - 1) {
                Node storeNext = head.getNext(); // здесь храним ссылку на элемент, идущий после нового элемента
                head.setNext(new Node(newElement, storeNext));
                return;
            }
            head = head.getNext();
            count++;
        }
        throw new IndexOutOfBoundsException(); // если не зашли в if, значит вывалились из списка
    }

    public void reverse() {
        Node head = top;

        Node prev = null;
        Node next = null;

        while (head != null) {
            next = head.getNext();
            head.setNext(prev);
            prev = head;
            head = next;
        }
        top = prev;
    }

    public int getSize() {
        return size;
    }

    public void addInSort(int newElement) { // добавление элемента в сортированный лист
        Node head = top;

        // находим ячейку, перед той, в которую будем вставлять
        while (head.getNext() != null && head.getNext().getData() < newElement) {
            // если не нашли и следующий элемент - конец списка, значит вставляем в конец
            if (head.getNext() == null) {
                addLast(newElement);
            }
            head = head.getNext();
        }
        Node storeNext = head.getNext(); // здесь храним ссылку на элемент, идущий после нового элемента
        head.setNext(new Node(newElement, storeNext));
    }

    public Node copy() {
        return null;
    }
}
