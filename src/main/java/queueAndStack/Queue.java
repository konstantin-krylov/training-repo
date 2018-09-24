package queueAndStack;

public class Queue {

    public int[] q;
    public int putloc; // указывает на последний извлеченный элемент
    public int getloc; //всегда указывает на последний добавленный элемент

    // конструктор инициализирует очередь заданного размера
    Queue(int size) {
        q = new int[size + 1];
        putloc = getloc = 0;
    }

    public void put(int num) {
        if (putloc == q.length - 1) {
            System.out.println("Очередь заполнена!");
            return;
        }
        putloc++;
        q[putloc] = num;
    }

    public int get() {
        if (getloc == putloc) {
            System.out.println("Очередь пуста!");
            return -1;
        }
        getloc++;
        return q[getloc];
    }
}
