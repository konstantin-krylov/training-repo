package queueAndStack;

public class MyStack {

    private int[] stack;
    private int tos;


    MyStack(int size) {
        stack = new int[size];
        tos = 0;

    }

    void pop(int num) {
        if (tos == stack.length) {
            System.out.println("Stack is full");
            return;
        }
        stack[tos] = num;
        tos++;
    }

    int push() {
        if (tos == 0) {
            System.out.println("Stack is empty");
        }
        tos--;
        return stack[tos];
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack(5);
        for (int i = 0; i < 4; i++) {
            stack.pop(i);
        }
        for (int i = 0; i < 4; i++) {
            int val = stack.push();
            System.out.println(val + " ");
        }
    }
}
