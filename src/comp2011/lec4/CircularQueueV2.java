package comp2011.lec4;

import java.util.Arrays;

public class CircularQueueV2<T> {
    private static final int CAPACITY = 128;
    private T[] data;
    private int read, write;
    int size;

    public CircularQueueV2() {
        data = (T[]) new Object[CAPACITY];
        read = 0;
        write = 0;
        
    }

    public boolean isEmpty() {
        return write == read;
    }

    // it's not physically full
    // but we cannot add more elements
    public boolean isFull() {
        return (write + 1) % CAPACITY == read;
    }

    public void enqueue(T e) {
        if (isFull()) {
            return;
        }
        data[write] = e;
        write = (write + 1) % CAPACITY;
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T temp = data[read];
        read = (read + 1) % CAPACITY;
        return temp;
    }

    // how?
    public int size() {
    	return (write - read + CAPACITY) % CAPACITY;
    }


    public String toString() {
    	return "";
    }

    public static void main(String[] args) {
        CircularQueueV2<Integer> queue = new CircularQueueV2<Integer>();
        for (int i = 1; i <= 7; i++)
            queue.enqueue(i * 100);
        for (int i = 0; i < 5; i++)
            System.out.println(queue.dequeue());
        for (int i = 1; i <= 5; i++)
            queue.enqueue(i * 100);
        System.out.println("size = " + queue.size());
        for (int i = 0; i < 7; i++)
            System.out.println(queue.dequeue());
        System.out.println("size = " + queue.size());
    }
}
