package comp2011.mid;
import java.util.Arrays;

public class ListOnArray {
	private int[] data;
	private static final int SIZE = 10; // it needs to be even.

	public ListOnArray() {
		data = new int[SIZE];

		data[0] = 0; // may be omitted in Java.
		for (int i = 2; i < SIZE - 2; i += 2)
			data[i] = i + 1;
		data[SIZE - 1] = 1;
		data[SIZE - 2] = 0;
	}

	public boolean isEmpty() {
		return data[0] == 0;
	}

	public boolean isFull() {
		return data[SIZE - 1] == 0;
	}

	public void err() {
		System.out.println("Oops...");
	}

	public void insertAtFront(int x) {
		if (isFull()) { err(); return; }
		int i = data[SIZE - 1];
		data[SIZE - 1] = data[i + 1];
		data[i + 1] = data[0];
		data[0] = i;
		data[i] = x;
	}

	public void insertAtTail(int x) {
		if (isFull()) { err(); return; }
		if (isEmpty()) { insertAtFront(x); return; }
		int i = 0;
		while (data[i] != 0) i = data[i] + 1;

		int n = data[SIZE - 1];
		data[SIZE - 1] = data[n + 1];

		data[i] = n;
		data[n] = x;
		data[n + 1] = 0;
	}

	public int deleteFirst() {
		if (isEmpty()) { err(); return -1; }
		int head = data[0];
		data[0] = data[head + 1];
		data[head + 1] = data[SIZE - 1];
		data[SIZE - 1] = head;
		return data[head];
	}

	public int deleteLast() {
		if (isEmpty()) { err(); return -1; }
		int tail = data[0];
		if (data[tail + 1] == 0) { return deleteFirst(); }
		int i = 0;
		while (data[tail + 1] != 0) {
			i = tail; 
			tail = data[i + 1];
		}
		data[i + 1] = 0;
		data[tail + 1] = data[SIZE - 1];
		data[SIZE - 1] = tail;
		return data[tail];
	}

	/*
	 * This is simpler than you may expect.
	 * So, don't make it too complicated.
	 * 
	 * DRAW DIAGRAMS!
	 */
	public void reverse() {
		
		int next = data[0];  // store next position
		int prev = 0;       //store prev position
		
		while(next != 0) {    
			int temp = data[next+1];  //temp = nextposion
			data[next+1] = prev;
			prev = next;    
			next = temp;
			
		}
		data[0]= prev;
		
		
	    
	    
		  
		
	}

	// this method should print out the numbers in the list in order
	// for example, after the demonstration, it should be "75, 85, 38, 49"
	public String toString() {
        if (isEmpty()) return "The list is empty.";
		StringBuilder sb = new StringBuilder();
		int i = data[0];
        sb.append(data[i++]);
		while (data[i] != 0) {
			i = data[i];
			sb.append(", ").append(data[i++]);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		ListOnArray list = new ListOnArray();
		System.out.println(Arrays.toString(list.data));
		System.out.println(list);
		list.insertAtFront(75);
		list.insertAtFront(99);
		list.insertAtTail(85);
		list.insertAtTail(38);

		System.out.println(Arrays.toString(list.data));
		System.out.println(list);
		list.deleteFirst();
		System.out.println(Arrays.toString(list.data));
		System.out.println(list);
		list.insertAtTail(49);
		System.out.println(Arrays.toString(list.data));
		System.out.println(list);
		list.reverse();
		System.out.println(Arrays.toString(list.data));
		System.out.println(list);		
	}
}
