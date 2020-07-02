package tim;

public class testQueue {
	static final int CAPACITY = 128;
	int size;
	int front;
	int rear;
	int[] queueData;
	public testQueue() {
		 queueData = new int[CAPACITY];
		size = front = rear =0;
	}
	
	void enQueue(int a) {
		queueData[rear] = a;
		rear = (rear+1)%CAPACITY;
		size++;
	}
	int deQueue() {
		int temp = queueData[front];
		queueData[front] = -1;
		front = (front+1)%CAPACITY;
		size--;
		return temp;
	}
	boolean isEmpty(){
		return size==0;
	}
	
}
