package tim;

import tim.LinkedList.Node;

public class DLinkedList<T> {

	class Node{
		T element;
		Node prev;
		Node next;
		
		public Node(T data, Node prev, Node next) {   //創建 object
			element = data;
			prev = null;
			next = null;
		}
	}
	
	Node head; Node tail; int size;
	
	public DLinkedList() {
		head =tail = null;   //設置為null
	}
	
	
	public void insertAtFirst(T data) {
		Node node = new Node(data, null, null);   //創建一個object
		if(head==null) {
			head = node;     //insert第一個
		}else {
		node.next = head;       //換head並且改連結
		head.prev = node;
		head = node;
		}
		
		
		
	}
	
	public  void insertAtLast(T data) {
		if(head == null) {
			insertAtFirst(data);
		}
		else {
		Node node = new Node(data, null, null);  //創建一個node先
		
		Node n = head;
		while(n.next != null) {   // 找出最後的位置.
			n = n.next;
			
		}		
		 n.next = node;  // 最後一個的尾巴指向node
		 node.prev = n;	   // node的前面指向n
		}
		
		 
	}
	
	public void deleteAtFirst() {
		if (head==null) {
			System.out.print("overflow");
		}
		else if (head.next==null) {
			head = null;
		}
		else {
			Node n = head.next;
			head.next.prev = null;
			head.next =null;
			head = n;
		}
	}
	
	public void deleteAtLast() {
		if(head == null||head.next==null) {
			deleteAtFirst();
		}
		else {
			Node n = head;
			while(n.next != null) {
				n = n.next;
			}
			Node deleteN = n;
			n.prev.next = null;
			n.prev =null;
			deleteN = null;
			
			
			
			
		}
	}
	
	public void show() {
		if (head==null) {
			System.out.println("No element inside");
		}else {
			Node n = head;
		while(n.next!=null) {
			System.out.println(n.element);
			n = n.next;
		}
		System.out.println(n.element);
		
		
		}
		
	}
	
	
	
	public static void main(String[] args) {
		DLinkedList list = new DLinkedList();
		
	    list.insertAtLast("A");
	    list.insertAtFirst(10);
	    list.insertAtLast(9);
		list.deleteAtFirst();
		list.deleteAtLast();
		list.show();
	}
	
	
	
}
