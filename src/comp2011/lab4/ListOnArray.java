package comp2011.lab4;

import java.util.Arrays;

public class ListOnArray {
	private int[] data;
	private static final int SIZE = 128; // it needs to be even.
    private  int[] dataAvaliable;
	public ListOnArray() {
		 dataAvaliable = new int[SIZE];
         data = new int[SIZE];
         data[0] = 0;
         data[SIZE-1] = 0;
         for (int i = 0; i < dataAvaliable.length; i++) {
        	if(i%2 ==0)
			dataAvaliable[i] = i+1;
			
		}
         for (int i = 2; i < SIZE-1; i++) {
		   data[i] = (i+1) ;
		   
		   i = i +1;
		}
         
		
	}

	public boolean isEmpty() {
		if(data[0]==0) {
			return true;
		}
		return false;
	}

	public boolean isFull() {
		if(data[SIZE-1] == 0) {
			return true;
		}
		return false;
	}

	public void err() {
		System.out.println("Oops...");
	}

	public void insertAtFront(int x) {
	}

	public void insertAtTail(int x) {
	}

	public int deleteFirst() {
		return -1;
	}

	public int deleteLast() {
        return -1;
	}

	// this method should print out the numbers in the list in order
	// for example, after the demonstration, it should be "75, 85, 38, 49"
	public String toString() {
		return "";
	}

	public static void main(String[] args) {
		ListOnArray list = new ListOnArray();
		System.out.println(Arrays.toString(list.data));
		System.out.println(Arrays.toString(list.dataAvaliable));
		
		//list.insertAtFront(75);
		//list.insertAtFront(99);
		//list.insertAtTail(85);
		//list.insertAtTail(38);
		//System.out.println(list);
		//list.deleteFirst();
		//System.out.println(list);
		//list.insertAtTail(49);
		//System.out.println(list);
	}
}
