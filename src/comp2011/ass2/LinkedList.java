package comp2011.ass2;


import comp2011.ass2.Stack;

public class LinkedList<T> {
	static class Node<T> {
		T element;
		Node<T> next;
		
		public Node(T a) {
			element = a;
			next = null;
		}
	}

	Node<T> head;
	
	public LinkedList() {
		head = null;
	}
	
	public void insertFirst(T a) {
		Node<T> newNode = new Node<T>(a);
		
		
		newNode.next = head;
		head = newNode;
		
	} 
	
	// Warning: please don't try to find the merge point 
	// by searching the element 55; it may be any number.
    public Node<T> mergePoint(LinkedList<T> l2) {
    	
    	Stack<Node> stack1 = new Stack<Node>();   //create stack for insertNode
    	Stack<Node> stack2 = new Stack<Node>();
    	Node l1Node = head;
    	Node l2Node = l2.head;
    	while(l1Node != null) {
    		stack1.push(l1Node);             //strore l1 and l2 's Node to 2 stack
    		l1Node = l1Node.next;
    	}
    	   
    	while(l2Node != null) {
    		stack2.push(l2Node);
    		l2Node = l2Node.next;
    	}
    	   
    	
    	Node mergePoint = null;
    	while(stack1.peep().element == stack2.peep().element) {    //pop every Node that have same element until the last one;
    		mergePoint = stack1.pop();
    		stack2.pop();
    	}
    	
    	return mergePoint;
    	
  
    }
    
	public String toString() {
        if (head == null) return "The list is empty.";
        StringBuilder sb = new StringBuilder();
        sb.append(head.element);
        Node<T> cur = head.next;
        while ( cur != null ) {
            sb.append(" -> " + cur.element);
            cur = cur.next;
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        int[] a = {60, 99, 38, 55, 37, 75, 12};
        int[] b = {37, 58, 57, 89};
        LinkedList<Integer> l1 = new LinkedList<Integer>();
        for (int i: a) l1.insertFirst(i);
        LinkedList<Integer> l2 = new LinkedList<Integer>();
        for (int i: b) l2.insertFirst(i);
        
        Node<Integer> n55 = l1.head;
        while(n55.element != 55) n55 = n55.next;
        
        Node<Integer> n99 = l2.head;
        while(n99.next != null) n99 = n99.next;
        n99.next = n55;
        
        System.out.println(l1);
        System.out.println(l2);
        
        Node<Integer> node = l1.mergePoint(l2);
        System.out.println((node==null)?"null":node.element);
    }
}
