package comp2011.ass2;

public class Stack<T> {
	private static final int CAPACITY = 128;
	private T[] data;
	private int top;

	public Stack() {
		// Java doesn't allow us to directly instantiate an array of a parameterized type. 
		data = (T[]) new Object[CAPACITY];
		top = 0;
	}

	public void push(T element) {
		if (top == data.length) {
			System.out.println("overflow");
			return;
		}
		data[top] = element;
		top++;
	}

	public T pop() {
		
		if (isEmpty()) {
			System.out.println("downflow");
			return null;
		}
		T oldData;
		top--;
		oldData = data[top];
		data[top]=null;
		return oldData;
	}

	public T peep() {
		return data[top-1];
	}

	public boolean isEmpty() {
		return top == 0;
	}
	
	public void show() {
		for (int i = 0; i < top; i++) {
			System.out.print(data[i]+" ");
		}
	}

	public static void main(String[] args) {
	
        Stack<Integer> iStack = new Stack<Integer>();
        
        iStack.push(1);
        iStack.push(2);
      
        iStack.push(3);
        iStack.push(66);
   
        System.out.println(iStack.peep());
        
	}
}
