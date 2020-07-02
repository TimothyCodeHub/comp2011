package comp2011.lec4;

import java.util.Arrays;

public class CircularQueue<T> {
    private static final int CAPACITY = 128;
    private T[] data;
    private int front, rear;

    public CircularQueue() {
        data = (T[]) new Object[CAPACITY];
        front = 0;
        rear = -1;
        
    }

    public boolean isEmpty() {
        return (rear + 1) % CAPACITY == front;
    }

    // it's not physically full
    // but we cannot add more elements
    public boolean isFull() {
        return (rear + 2) % CAPACITY == front;
    }

    public void enqueue(T e) {
        if (isFull()) {
            return;
        }
        rear = (rear + 1) % CAPACITY;
        data[rear] = e;
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        front = (front + 1) % CAPACITY;
        return data[front];
    }

    public int size() {
    	return -1;
    }


    public String toString() {
    	return "";
    }

    public static void main(String[] args) {
        CircularQueue<Integer> queue = new CircularQueue<Integer>();
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
