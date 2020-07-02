package comp2011.lecB;

/*
 * The list added to the class comp2011.lec5.List
 * a toArray method, a search method
 * and the size.
 */
public class List {
    private static class Node {
        int data;
        Node next;
        
        public Node(int a) {data = a; next = null;}
    }

	private Node head;  //firstNode
	private int size;
	
	public List () {
		head = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void insertAtFront(int a) {
		Node node = new Node(a);
		node.next = head;
		head = node;
		size++;
	}

	public void insertAtEnd(int a) {
		Node node = new Node(a);
		// this check cannot be omitted
		// otherwise you get NullPointerException on an empty list.
		if (head == null) {
			insertAtFront(a);
			return;
		}
		Node cur = head;
		while(cur.next != null) cur = cur.next;
		cur.next = node;
		size++;
	}

	public void insertAfter(Node node, int a) {
		Node newNode = new Node(a);
		if (node == null) {
			System.out.println("Oops...");
			return;
		}
		newNode.next = node.next;
		node.next = newNode;
		size++;
	}

	public Node search(int a) {
		Node cur = head;
		while(cur != null && cur.data != a) cur = cur.next;
	    return cur;
	}

	public int deleteFirst() {
		if (head == null) {
			System.out.println("Oops...");
			return -1;
		}
		Node node = head;
		head = head.next;
		node.next = null;
		size--;
	    return node.data;
	}

	public int deleteLast() {
		if (head == null || head.next == null) 
			return deleteFirst();
		Node second = head;
		Node cur = second.next;
		// when the thile loop finishes,
		// cur points to the last node.
		while(cur.next != null) {
			second = cur;
			cur = cur.next;
		}
		second.next = null;
		size--;
	    return cur.data;
	}

    public int length() {
    	return size;
    }
    
    public int[] toArray() {
    	int[] a = new int[size];
    	Node cur = head;
    	for (int i = 0; i < size; i++) {
    		a[i] = cur.data;
			cur = cur.next;
    	}
    	return a;
    }
    
    public String toString() {
		StringBuilder sb = new StringBuilder(); 
		Node cur = head;
		while(cur != null) { 
			sb.append(cur.data);
			if (cur.next != null) sb.append(", ");
			cur = cur.next;
		}
	    return sb.toString();
	}

	public static void main(String[] args) {
		List list = new List();
		list.insertAtFront(37);
		list.insertAtFront(99);
		list.insertAtFront(12);
		System.out.println(list);
		list.insertAtFront(75);
		System.out.println(list);
		list.insertAtEnd(38);
		System.out.println(list);
		list.insertAfter(list.search(12), 85);
		System.out.println(list);
		System.out.println("delete the first, which is " + list.deleteFirst());		
		System.out.println(list);
		System.out.println("delete the last, which is " + list.deleteLast());		
		System.out.println(list);
	}
}