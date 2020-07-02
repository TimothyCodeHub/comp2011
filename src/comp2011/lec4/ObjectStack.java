package comp2011.lec4;

public class ObjectStack {
	private static final int CAPACITY = 128;
	private Object[] data;
	private int top;

	public ObjectStack() {
		data = new Object[CAPACITY];
		top = -1;
	}

	public void push(Object element) {
		if (top == data.length - 1) {
			System.out.println("overflow");
			return;
		}
		data[++top] = element;
	}

	public Object pop() {
		if (isEmpty()) {
			System.out.println("downflow");
			return null;
		}
		return data[top--];
	}

	public Object peep() {
		return data[top - 1];
	}

	public boolean isEmpty() {
		return top < 0;
	}

	public static void main(String[] args) {
		ObjectStack stack = new ObjectStack();
		int n = 100;
		while (n > 0) {
			stack.push(n % 2);
			n /= 2;
		}
		while (!stack.isEmpty()) System.out.print(stack.pop());
	}
}
