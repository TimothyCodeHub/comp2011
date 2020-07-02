package tim;

import java.util.Arrays;

public class testStack {
	static final int CAPACITY = 128;
	int [] stack;
	int top;
	int size;
	public testStack() {
		
		stack = new int[CAPACITY];
		top = 0;
		size = 0;
		
	}
	
	void push(int a) {
		//stack[top++]=a;
		//size++;
		
		if(size>1 && peek()==a) {
			pop();
			
		}else {
			stack[top++]=a;
			size++;
		}
	}
	
	 int pop() {
		int  temp = stack[--top];
		stack[top] = -1;
		size--;
		return temp;
	}
	
	int peek() {
		return stack[size-1];
	}
	
	int getSize() {
		return size;
	}
	
	boolean isEmpty() {
		return size ==0;
	}
	
	void printStack() {
		System.out.println(Arrays.toString(stack));
	}
	
	public static void main(String[] args) {
		testStack t1 = new testStack();
		t1.push(1);
		t1.push(2);
		t1.push(3);
		t1.push(3);
		t1.push(2);
		t1.push(3);
		t1.push(3);
		t1.push(2);
		t1.push(4);
		t1.push(4);
		t1.push(2);
		t1.printStack();
		
	}
	
}
