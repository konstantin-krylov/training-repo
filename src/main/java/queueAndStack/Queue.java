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


    public static void main(String[] args) {
        int val;

        Queue bigQ = new Queue(100);
        Queue smallQ = new Queue(4);

        for (int i = 0; i < 26; i++) {
            bigQ.put(i*3);
        }
        for (int i = 0; i < 26; i++) {
            val = bigQ.get();
            System.out.print(val+" ");
        }
        System.out.println("\n");

        for (int i = 0; i < 7; i++) {
            smallQ.put(3*i);
            System.out.println("Trying to put "+3*i);
        }
        for (int i = 0; i < 7; i++) {
            int tmp = smallQ.get();
            System.out.println(tmp);
        }
    }
}
