package tim;

public class DoublyLinkedList {

	private class ListNode{
		private int data;
		private ListNode next;        //node 的三個元素
		private ListNode prev;
		
		public ListNode(int data) {
			this.data = data;          //讓同志們輸入
		}
		
	}
	
	private ListNode head;
	private ListNode tail;          //告訴linkedList 需要head 和tail 和size
	private int size;
	
	public DoublyLinkedList() {
		head = tail = null;          //定義head 和tail 和size是什麼
		size = 0;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public int getSize() {
		return size;
	}
	
	public void insertAtFirst(int num) {
	  ListNode newNode = new ListNode(num);     //創建一個node
	  if (isEmpty()) {
		tail = newNode;          //如果是空的，尾巴就是newnode
		
	}else {
		head.prev = newNode;
	}
	  newNode.next = head;        //現在，head還是head；
	  head = newNode;            //newnode 是head。   這是創造了head=tail如果是empty
	  size++;
	}
	
	public void insertAtLast(int num) {
		  ListNode newNode = new ListNode(num);
		  if (isEmpty()) {
			head = newNode;      //如果是空的。head就是新node
			
		}else {
			tail.next = newNode;      //以前的尾巴的next 連接到新的node   
			newNode.prev = tail;     //新的node的prev 連結到以前的尾巴   
			
		}
		  tail = newNode;          //把尾巴換成了新的node。 這是創造了head=tail如果是empty
		  size++;

	}
	
	public ListNode deleteAtFirst() {
		if(isEmpty()) {
			System.out.println("can not delete");
		}
		ListNode temp = head;      //暫時存一個head
		if (head == tail) {
			tail = null;           //只有一個元素時，直接把尾巴變成null
		}else {
			head.next.prev = null;     //不然的話九把頭的next 的prev 變成null（就是頭）
		}
			
		head = head.next;       //然後把頭換成下一個
		temp.next=null;          //暫存的head刪除掉next。
		size--;
		return temp;
	}
	
	public ListNode deleteAtLast() {
		if (isEmpty()) {
			
		}
		
		ListNode temp = tail;
		if (head==tail) {
			deleteAtFirst();   //只有一個元素時，直接把尾巴變成null
		}else {
			tail.prev.next = null;//不然的話九把尾巴的前一個 的next 變成null（就是頭）
		}
		tail = tail.prev;       //正式的尾巴變成前面一個
		temp.prev=null;          //暫存的尾巴的prev 要刪除連結。
		size--;               
		return temp; 
	}
	
	
	
	public void show() {
		ListNode n = head;
		while(n.next!=null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.print(n.data + " ");
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
	
		list.insertAtLast(5);
		list.insertAtLast(9);
		list.insertAtFirst(6);
		list.show();
	}
	
	
	
	
	
	
}
