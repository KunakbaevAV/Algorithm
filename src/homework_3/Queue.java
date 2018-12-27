package homework_3;

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
}

