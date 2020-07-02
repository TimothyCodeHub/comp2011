package comp2011.lec9;

import java.util.Arrays;

class MaxTree {
    // to make it simple, I don't use generics here.
    // it's easy to revise it to use generics.
    private class Node {
        int element;
        public Node leftChild, rightChild;
        public Node(int element) { this.element = element; }
        public String toString() { return String.valueOf(element); }
    }
    Node root;
    public MaxTree(int[] a) {
        int n = a.length;
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(a[i]);
        }
        while (n > 1) {
            for (int i = 0; i < n / 2; i++) {
                int max = Math.max(nodes[i * 2].element, nodes[i * 2 + 1].element);
                Node newNode = new Node(max);
                newNode.leftChild = nodes[i * 2];
                newNode.rightChild = nodes[i * 2 + 1];
                nodes[i] = newNode; // why it's safe to resue the space?
            }
            // n might be odd.
            if (n % 2 != 0)  {
                nodes[n/2] = new Node(nodes[n - 1].element);
                nodes[n/2].leftChild = nodes[n - 1];
            }
            
            n = (n + 1) / 2;
        }
        root = nodes[0];
    }
    public int deleteMax() {
        if (root == null) {
            System.out.print("downflow");
            return -1;
        }
        int res = root.element;
        if (deleteMax(root)) root = null;
        return res;
    }
    public boolean deleteMax(Node curRoot) {
        // if (curRoot == null) return -1;
        if (curRoot.leftChild == null && curRoot.rightChild == null) {
            return true;
        }
        // Note that {} in the following line cannot be omitted!
        if (curRoot.leftChild != null 
                && curRoot.element == curRoot.leftChild.element) {
            if (deleteMax(curRoot.leftChild)) curRoot.leftChild = null;
        }
        else // no need to check, why?
            if (deleteMax(curRoot.rightChild)) curRoot.rightChild = null;

        if (curRoot.leftChild == null && curRoot.rightChild == null) {
            return true;
        }
        // now at least one child left.
        curRoot.element = Integer.MIN_VALUE;
        if (curRoot.leftChild != null)
            curRoot.element = curRoot.leftChild.element;
        if (curRoot.rightChild != null && 
                curRoot.element < curRoot.rightChild.element)
            curRoot.element = curRoot.rightChild.element;
        return false;
    }
}

public class TreeSorting {
    public static void treeSort(int[] a) {
	    MaxTree tree = new MaxTree(a);
	    for (int i = a.length - 1; i >= 0 ; i--) {
	        a[i] = tree.deleteMax();
	    }
	}

	public static void main(String[] args) {
		int a[] = {10, 8, -4, 89, 2, 0};
		System.out.println(Arrays.toString(a));
		treeSort(a);
		System.out.println(Arrays.toString(a));
	}
}
