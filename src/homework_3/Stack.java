package homework_3;

import java.util.Arrays;

/**
 * @autor Kunakbaev Artem
 */
public class Stack {
    private int maxSize;
    private int stack[];
    private int top;

    public Stack(int size) {
        maxSize = size;
        stack = new int[maxSize];
        top = -1;
    }

    private boolean isEmpty() {
        return top == -1;
    }

    private boolean isFull() {
        return top == maxSize - 1;
    }

    public void push(int element) {
        if (!isFull()) {
            stack[++top] = element;
        } else {
            System.out.println("Очередь переполнена");
        }
    }

    public int pop() {
        if (!isEmpty()) {
            return stack[top--];
        } else {
            System.out.println("Очередь пуста");
            return 0;
        }
    }

    public int peek() {
        return stack[top];
    }

    public void printStack() {
        System.out.println(Arrays.toString(stack));
    }
}

