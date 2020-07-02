package tim;

public class TestDoubleLinkedList {
	
 class Node {
	 int data;
	 Node next;
	 Node pre;
	 public Node(int e) {
		 data = e;
		 pre = null;
		 next = null;
	 }
 }
	 
 Node head;

 public TestDoubleLinkedList(){
	 head = null;
	 
 }
 
 void inSertAtFront(int a) {
	 Node newNode = new Node(a);
	 if(head ==null) 
		 head = newNode;
	 else {
		 newNode.next = head;
		 head.pre = newNode;
		 head = newNode;
	 }
 }
 
 void inSertAtLast(int a) {
	 Node newNode = new Node(a);
	 if(head ==null) {
		 inSertAtFront(a);
	 }else {
		 Node cur = head;
		 while(cur.next!=null) {
			 cur = cur.next;
		 }
		 cur.next = newNode;
		 newNode.pre = cur;
	 }
 }
 void deleteAtLast() {
	 Node cur = head;
	 while(cur.next.next !=null) {
		 cur = cur.next;
	 }
	 cur.next = null;
 }
 
 void deleteAtFirst() {
	 if(head.next ==null) {
		 head =null;
	 }else {
	 Node cur = head;
	 head = cur.next;
	 cur = null;
	 }
 }
 
 void print() {
	 Node cur = head;
	 while(cur.next!=null) {
		 System.out.print(" "+cur.data);
	     cur = cur.next;
	 }
	 System.out.print(" "+cur.data);
 }
 
 
 
 public static void main(String[] args) {
	 TestDoubleLinkedList t1 = new TestDoubleLinkedList();
	 t1.inSertAtLast(1);
	 t1.inSertAtLast(3);
	 t1.inSertAtFront(5);
	 t1.inSertAtLast(36);
	 t1.deleteAtLast();
	 t1.deleteAtFirst();
	 t1.print();
	 
	 
	 
 }
 
 
 
 
	 

}
