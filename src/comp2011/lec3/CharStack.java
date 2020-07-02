package comp2011.lec3;

public class CharStack {
	private static final int CAPACITY = 128;
	private char[] data;
    private int top;
    
    public CharStack() {
        data = new char[CAPACITY];
        top = 0; 
    }
    
    public void push(char element) {

    }
    
    public char pop() {
    	return ' ';
    }
    
    public char peep() {
    	return ' ';
    }
    
    public boolean isEmpty() {
    	return false;
    }
    
    public String toString() {
    	return new String(data, 0, top);
    	// or
    	// (new String(data)).substring(0, top);
    }
}
