package comp2011.lec4;

public class Stack<T> {
	private static final int CAPACITY = 128;
	private T[] data;
	private int top;

	public Stack() {
		// Java doesn't allow us to directly instantiate an array of a parameterized type. 
		data = (T[]) new Object[CAPACITY];
		top = -1;
	}

	public void push(T element) {
		if (top == data.length - 1) {
			System.out.println("overflow");
			return;
		}
		data[++top] = element;
	}

	public T pop() {
		if (isEmpty()) {
			System.out.println("downflow");
			return null;
		}
		return data[top--];
	}

	public T peep() {
		return data[top - 1];
	}

	public boolean isEmpty() {
		return top < 0;
	}

	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
        Stack<Integer> iStack = new Stack<Integer>();
	}
}
