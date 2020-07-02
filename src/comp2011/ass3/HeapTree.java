package comp2011.ass3;

/*
 * A binary tree having the heap-order property,
 * but may not be complete.
 */
public class HeapTree {
	private class Node {
		int element;
		public Node leftChild, rightChild;

		public Node(int key) {
			this.element = key;
		}

		public String toString() {
			return String.valueOf(element);
		}
	}

	Node root;

	public HeapTree() {
		root = null;
	}

	public HeapTree(int e) {
		root = new Node(e);
	}

	// after this operation, t2 no longer exists.
	public void merge(HeapTree t2) {
		   if(t2.root ==null) return;

	        if(root ==null) {root = t2.root; return;}

	        if(root.element < t2.root.element){
	            Node temp = root;
	            root = t2.root;
	            t2.root = temp;
	        }

	        Node cur = root;
	        while(t2.root != null) {
	            if(cur.rightChild==null) {cur.rightChild = t2.root;break;}
	            if (cur.rightChild.element < t2.root.element) {
	                Node temp = cur.rightChild;
	                cur.rightChild = t2.root;
	                t2.root = temp;
	            }
	            cur = cur.rightChild;
	        }
		
	}


	public void show() {
		Node n = root;
		if(n ==null) { System.out.println("There is no Node "); return;}
		while (n.rightChild != null) {
			System.out.print(n.element + " ");
			n = n.rightChild;
		}
		System.out.print(n.toString() + " ");
	}
	
	//function below is other function but not fufill the requirement.
	/*public void mergeV2(HeapTree t2) {
		Node parentNode = root;

		if (root == null) {

			root = t2.root;
			parentNode = root;
			t2.root = t2.root.leftChild;

		}

		while (parentNode.leftChild != null) {
			parentNode = parentNode.leftChild;
		}

		while (t2.root != null) {

			Node temp = t2.root;
			t2.root = t2.root.leftChild;
			temp.leftChild = root;
			root = temp;
			shiftdown(root);
			// shiftdownV2(root);
			//System.out.println();
            //show();
		}
		
	}
	
	public void shiftdown(Node n) {
		if (n.leftChild == null)
			return;

		if (n.element < n.leftChild.element) {
			int temp = n.leftChild.element;
			n.leftChild.element = n.element;
			n.element = temp;

			shiftdown(n.leftChild);
		}

	}

	public void shiftdownV2(Node n) { // interation function

		while (n.element < n.leftChild.element) {

			int temp = n.leftChild.element;
			n.leftChild.element = n.element;
			n.element = temp;

			n = n.leftChild;
			if (n.leftChild == null)
				break;
		}

	}
   
   */

	public static void main(String[] args) {
		int[] a1 = { 214, 562, 83, 115, 97, 722, 398, 798, 408, 199, 37, 336 };
		int[] a2 = { 100, 79, 67, 2, 7, 73, 42, 24, 63, 36, 13, 25, 1 };
		HeapTree t1 = new HeapTree(); // an empty one
        for (int i:a1) 
            t1.merge(new HeapTree(i));
        HeapTree t2 = new HeapTree(); // an empty one
        for (int i:a2) 
            t2.merge(new HeapTree(i));
        t1.merge(t2);
        t1.show();
        // you may add something to here test your codes.
	}
}
