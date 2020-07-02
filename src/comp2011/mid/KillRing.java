package comp2011.mid;
import java.util.Arrays;

/*
 * the basic idea is to extend a circular array.  
 * 
 * DRAW DIAGRAMS!
 */
public class KillRing {
    private static final int MAX_ITEMS = 60;
    
    String[] data;
    int cursor;
    int front;
   
    public KillRing() {
    	data = new String[MAX_ITEMS];
    	cursor = -1;
    	front = 0;

    }

    public boolean isEmpty() {
        return false;
    }

    public void insert(String s) {
    	
    	cursor = (cursor+1) % MAX_ITEMS;
    	data[cursor] = s;
    	
    	
    }

    public String read() {
    	
        return data[cursor];
    }
    
    public void moveCursor() {
    	if(cursor==0) {
    		data[cursor]=null;
    		cursor = MAX_ITEMS -1;
    	}
    	if(cursor > 0) {
    		data[cursor--] = null;
    	}
    	
    	
    	
    }

    public String toString() {
    	front = cursor+1;
    	StringBuilder sb = new StringBuilder();
    	
    	while(front != cursor) {
    		if(data[front]==null) {}
    		else {
    			sb.append(data[front]).append(", ");
    			
    		}
    		front = (front+1)% MAX_ITEMS;
    	}
    	sb.append(data[front]).append(".");
    	return sb.toString();
    }

    public static void main(String[] args) {
        KillRing queue = new KillRing();
        for (int i = 1; i <= 70; i++)
            queue.insert(String.valueOf(i * 10));
        System.out.println(queue);        
        for (int i = 0; i < 15; i++) {
            System.out.println(queue.read());
            queue.moveCursor();
        }
        queue.insert("Data");
        queue.insert("Structures");
        queue.insert("2011");
        queue.insert("2018");
        queue.insert("Fall");
        System.out.println(queue);
        for (int i = 0; i < 3; i++) {
            System.out.println(queue.read());
            queue.moveCursor();
        }
        System.out.println(queue);
    }
}
