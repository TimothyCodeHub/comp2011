package comp2011.lec4;

import java.util.Arrays;

/* Java provides a very good Queue class in the package java.util.
 * So you may never want to implement one by yourself.
 *
 * This (stupid) implementation is for demonstration purpose only. 
 */
public class Queue<T> {
    private static final int CAPACITY=128;
    private T[] data;
    private int front, rear;

    public Queue() {
        data = (T[]) new Object[CAPACITY];
        front = -1;
        rear = -1;
    }

    public void enqueue(T e) {
    	// if () {}
    	data[++rear] = e;
    }

    public boolean isEmpty() {
    	return rear == front;
    }
    
    public T dequeue() {
    	// if
    	T temp = data[++front];
    	//for (int i = 0; i < rear; i++) data[i] = data[i+1];
    	// rear--;
    	return temp; 
    }
    
    public String toString() {
    	return Arrays.toString(data);
    }

	public static void main(String[] args) {
		Queue q = new Queue();
		q.enqueue(2017);
		q.enqueue(9);
		q.enqueue(26);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		q.enqueue(12);
		q.enqueue(30);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
	}
}
