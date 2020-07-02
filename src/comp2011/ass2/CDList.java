package comp2011.ass2;

public class CDList {
	class DNode {
		int element;
		DNode previous, next;

		DNode(int data) {
			this.element = data;
		}
	}

	private DNode head;

	// this method is provided for the purpose of test (in the main).
	// it's not for your use.
	public void insert(int e) {
		DNode newNode = new DNode(e);
		if (head == null) {
			newNode.next = newNode;
			newNode.previous = newNode;
			head = newNode;
			return;
		}
		newNode.next = head;
		newNode.previous = head.previous;
		head.previous = newNode;
		newNode.previous.next = newNode;
	}

	// you are not allowed to use insert()
	// or add any new method to this class
	public CDList[] split() {
		CDList[] cdlist = new CDList[2];
		CDList list1 = new CDList();
		CDList list2 = new CDList();

		// time: O(n)

		DNode list1tailNode = head;
		DNode list2headNode = head.previous; // using loop to find the tail of list1 and head of list2
		while (list1tailNode.next != list2headNode && list2headNode.previous != list1tailNode) {
			list1tailNode = list1tailNode.next;
			list2headNode = list2headNode.previous;
			if (list1tailNode.next == head 
					&& list2headNode.previous == head.previous) {   //check odd number
				list1tailNode = list1tailNode.next;
			}
		}

		DNode list1headNode = head; // store list1 head and list 2 tail
		DNode list2tailNode = head.previous;

		list1headNode.previous = list1tailNode; // change head's previous and tail's next
		list1tailNode.next = list1headNode;

		list2headNode.previous = list2tailNode;
		list2tailNode.next = list2headNode;

		list1.head = list1headNode; // store list1head to list
		list2.head = list2headNode; // store list2head to list

		cdlist[0] = list1; // store list to list array
		cdlist[1] = list2;

		return cdlist;
	}

	public String toString() {
		if (head == null)
			return "The list is empty.";
		StringBuilder sb = new StringBuilder();
		DNode cur = head;
		sb.append(cur.element);
		cur = cur.next;
		while (cur != head) {
			sb.append(", " + cur.element);
			cur = cur.next;
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		int[] a = { 10, 9, 99, 37, 12, 25, 1, 77 };
		CDList l = new CDList();
		for (int i : a)
			l.insert(i);
		System.out.println(l);
		CDList[] lists = l.split();
		System.out.println(lists[0]);
		System.out.println(lists[1]);
	}
}
