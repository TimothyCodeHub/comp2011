package comp2011.lec4;

public class IntStack {
    private static final int CAPACITY=128;
	int[] data;
	int top;
	public IntStack() {
		data = new int[CAPACITY];
		top = 0;
	}
	
	public boolean isEmpty()  {
		return top == 0;
	}
	
	public void push(int e) {
		if (top == CAPACITY) {
		    // throw an exception.
		    System.out.println("overflow");
		    return;
		}
		data[top++] = e;	
	}

	public int pop() {
        if (top == 0) {
            // throw an exception.
            System.out.println("downflow");
            return -1;
        }
		return data[--top];
	}
}
