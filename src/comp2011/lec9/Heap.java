package comp2011.lec9;

import java.util.Arrays;

/*
 * the heap structure
 * warning: this is NOT the heap in memory management.
 * */
public class Heap<T> {
    private static class Node<T> {
        // The explicit use of variable key is non-standard.
        // We use it here to avoid the use of Comparator
        int key;
        T obj;

        public Node(int key, T data) {
            this.key = key;
            this.obj = data;
        }

        public String toString() {
            return key + ": " + obj;
        }
    }

	private Node<T>[] data;
	int size;
	
    public Heap(int capacity) {
    	data = new Node[capacity];
    	size = 0;
    }
    
    private void swap(int i, int j) {
        Node<T> temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
    public void down(int p) { 
        if (p * 2 + 2 > size) return;
        int larger = p * 2 + 1;
        if (larger + 1 < size && data[larger].key < data[larger+1].key) 
            larger++;
        if (data[p].key >= data[larger].key) return;
        swap(p, larger);
        down (larger);
    }
    
    public T deleteMax() {
        if (size == 0) { ; return null;}
        
        T ans = data[0].obj;
        data[0] = data[--size];
        down (0);
        return ans; 
    }
    public void up(int c) {
        if (c == 0) return;
        int p = (c - 1) / 2;
        if (data[c].key <= data[p].key) return;
        swap(c, p);
        up(p);
    }
    public void insert(int key, T x) {
        if (size == data.length) { ; return;}
        data[size] = new Node<T>(key, x);
        up(size++);
    }

    public void preorder() { }
    public void inorder() {
        inorder(0);
    }
    public void inorder(int r) {
        if (r >= size) return;
        inorder(r*2 + 1);
        System.out.println(data[r]);
        inorder(r*2 + 2);
    }
    public void postorder() { }
    public void levelDisplay() { }
    
    public void heapsort(T[] a) {}
    
    public String toString() {
        return Arrays.toString(data);
    }
}

