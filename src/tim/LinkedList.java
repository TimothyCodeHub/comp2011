package tim;


public class LinkedList<T> {
	
	class Node {
		T element;
		Node next;
		
		public Node(T a) {
			element = a;
			next = null;
		}
	}
	
	Node head;
	
	public LinkedList() {
	   head = null;
	}
	
	public void insertAtFirst(T a) {
		Node node = new Node(a);
		node.next = head;
		head = node;
		
	}
	
	public void show() {
		Node n = head;
		if(head == null) { System.out.print("No element"); return;}
		while(n.next!=null) {
			System.out.println(n.element);
			n = n.next;
		}
		System.out.println(n.element);
	}
	
	public void insertAtLast(T a){
		if(head==null){
			insertAtFirst(a);
		}
		else {
			Node newNode = head;
			while(newNode.next!=null) {
				newNode = newNode.next;
				
			}
			
			Node node = new Node(a);
			 newNode.next = node;
			 
			
		}
	}
	
	public void deleteAtFirst() {
		if(head == null) {
			
		}else {
			Node temp = head;
			head  = head.next;
			temp.next = null;
			
			
		}
	}
	
	public void deleteAtLast() {
		if(head == null) return;
		if(head.next == null) { head = null; return;}
		Node temp = head;
		while(temp.next.next != null)
			temp = temp.next;
		temp.next = null;
		
	}
	
	public void reverse() {
		Node prev,cur,next;
		cur = head;
		prev = null;
		while(cur != null) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		head = prev;
	}
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		// TODO ,Auto-generated method stub
      LinkedList list = new LinkedList();
      
      list.insertAtFirst(8);
      list.insertAtFirst(7);
      list.insertAtFirst(6);
      list.insertAtFirst(5);
      list.insertAtFirst(4);
      list.insertAtFirst(3);
      list.reverse();
      list.show();
	}

}
