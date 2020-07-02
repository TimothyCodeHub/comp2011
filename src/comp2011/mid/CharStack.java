package comp2011.mid;

public class CharStack {
	private char[] data;
	private int top;
	
	public CharStack() {
		data = new char[16];
		top = -1;
	}
	
	public void push(char c) {
		data[++top] = c;
	}
	
	public char pop() {
		if(isEmpty()) System.out.println("Hey, I'm still empty");
		return data[top--];
	}
	
	public char peek() {
		if(isEmpty()) System.out.println("Hey, I'm still empty");
		return data[top];
	}
	
	public boolean isEmpty() {
		return top < 0;
	}
	
	public String toString() {
		//return (new String(data)).substring(0, top + 1);
		return (new String(data, 0, top + 1));
	}
}
