package homework_3;

import java.util.Arrays;

/**
 * @autor Kunakbaev Artem
 */
public class Queue {
    private int[] queue;
    private int maxSize;
    private int front;
    private int rear;
    private int items;

    public Queue(int size) {
        maxSize = size;
        queue = new int[size];
        front = 0;
        rear = -1;
        items = 0;
    }

    public boolean isEmpty() {
        return items == 0;
    }

    public boolean isFull() {
        return items == maxSize;
    }

    public int size() {
        return items;
    }

    public void insert(int element) {
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queue[++rear] = element;
        items++;
    }

    public int remove() {
        int temp = queue[front++];
        if (front == maxSize) {
            front = 0;
        }
        items--;
        return temp;
    }

    public int peek() {
        return queue[front];
    }

    public void printQueue() {
        System.out.println(Arrays.toString(queue));
    }


}

