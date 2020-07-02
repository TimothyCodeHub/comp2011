package comp2011.lab3;

public class CharStack {
	private static final int CAPACITY = 128;
	private char[] data;
    private int top;
    
    public CharStack() {
        data = new char[CAPACITY];
        top = -1; 
    }
    
    public void push(char element) {
        if(top == data.length-1) {
        	System.out.println("overflow");
        	return;
        }
    	data[top+1] = element;
    	top++;
    	
    }
    
    public char pop() {
    	char oldc = data[top];
    	data[top] = 0;
    	top--;
    	return oldc;
    	
    }
    
    public char peep() {
    	return ' ';
    }
    
    public boolean isEmpty() {
        
        if(top == -1)
    	return true;
        else {
			return false;
		}
        
    }
    
    public String toString() {
    	return new String(data, 0, top);
    	// or
    	// (new String(data)).substring(0, top);
    }
}
