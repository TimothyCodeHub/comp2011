package comp2011.lec4;

public class LinkedList<T> {
	class Node {
		T element;
		Node next;
		
		public Node(T a) {
			element = a;
			next = null;
		}
	}

	Node head, tail;
	
	public LinkedList () {
		head = tail = null;
	}
	
	public void insertFirst(T a) {
		Node newNode = new Node(a);
		newNode.next = head;
		head = newNode;
	} 

	public void insertLast(T a) {
	    if (head == null) {insertFirst(a); return;}
	    
	    Node cur = head;
	    while(cur.next != null) cur = cur.next;
        Node newNode = new Node(a);
        newNode.next = null;
	    cur.next = newNode;
	}
	
	public void insertAfter(Node node, T a) {
	}
	
	public T removeFirst() {
	    if (head == null) {System.out.println("downflow"); return null;}
	    Node temp = head;
	    head = head.next;
	    temp.next = null; 
		return temp.element;
	}

	public T removeLast() {
//        if (head == null) {System.out.println("downflow"); return null;}
//        if (head.next == null) {
//            Node temp = head;
//            head = null;
//            return temp.element;
//        }
        
	    if (head == null || head.next == null) return removeFirst();
	    
	    Node secondToLast = head;
        while(secondToLast.next.next != null) secondToLast = secondToLast.next;
        Node temp = secondToLast.next;
        secondToLast.next = null; 
        return temp.element;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
}
