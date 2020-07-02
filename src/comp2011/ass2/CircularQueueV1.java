package comp2011.ass2;

// In this version, we try to mimic the physical setting of a queue.
// I.e., when there is only one element, it is both front and rear.
public class CircularQueueV1<T> {
    private static final int CAPACITY = 128;
    private T[] data;
    private int front, rear;
    int size;

    public CircularQueueV1() {
        data = (T[]) new Object[CAPACITY];
        front = 0;
        rear = 0;
        size = 0;
    }

    public boolean isEmpty() {
    	return size ==0;
    }

    // it's not physically full
    // but we cannot add more elements
    public boolean isFull() {
    	return size == CAPACITY;
    }

    public void enqueue(T e) {
    	if (isFull()) {
			System.out.println("The enqueue is full");
		}else {
		data[rear] = e;
    	rear = (rear + 1) % CAPACITY;
    	size++;
		}
    	
    }

    public T dequeue() {
    	if (isEmpty()) {
			return null;
		}else {
		T oldData = data[front];
    	front = (front + 1 ) % CAPACITY;
    	size--;
    	return oldData;
		}
    	
    }

    public int size() {
    	return size;
    }

    public String toString() {
    	return null;
    }

    public static void main(String[] args) {
        CircularQueueV1<Integer> queue = new CircularQueueV1<Integer>();
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
