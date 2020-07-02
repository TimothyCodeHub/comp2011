package tim;

public class Queue<T>{
	
	private static final int CAPACITY = 5;
	private int size;
	private int front;
	private int rear;
	private T[] queue;
	
	public Queue() {
		queue = (T[]) new Object[CAPACITY];
		front = 0;
		rear = 0;
		size = 0;
	}
	
	public void enqueue(T num) {
		if (isFull()) {
			System.out.println("is full now");
		}else {
		queue[rear] = num;
		rear = (rear+1) % CAPACITY;
		size++;
		}
		
	}
	
	public T dequeue() {
		if (isEmpty()) {
			return null;
		}
		T data = queue[front];
		front = (front +1) % CAPACITY;
		size--;
		return data;
		
		
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean isFull() {
		return getSize()== CAPACITY;
	}
	
	public boolean isEmpty() {
		return getSize() == 0;
	}
	
	
	public void show() {
		for (int i = 0; i < size; i++) {
			System.out.print(queue[(front+i)%CAPACITY]+" ");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue q = new Queue();
		q.enqueue(5);
		q.enqueue(6);
		q.enqueue(7);
		q.enqueue(8);
		q.enqueue(9);
		q.enqueue(10);
		q.enqueue(11);
	
		q.show();

	}

}
