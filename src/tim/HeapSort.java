package tim;

import java.util.Arrays;

public class HeapSort {

void heapsort(int[] a) {
	for (int i = 1; i < a.length; i++)
		insert(a, i);
    // insertV2(a);
	
  for (int i = a.length - 1; i > 0; i--)
		a[i] = deleteMax(a, i);
  
}

int deleteMax(int[] a, int end) {
	
	int temp = a[0];
	a[0] = a[end];
	a[end] = temp;
	shiftdown(a, 0,end);
	return temp;
}

void insert(int[] a, int end) {
	shiftup(a,end);
}

void insertV2(int[]a) {
	int len = a.length;
	int[] h = new int[a.length];

	for(int i =0; i<a.length; i++) {
		h[i] = a[i];
		shiftup(h,i);
	}
	System.arraycopy(h,0,a,0,h.length);
}

void shiftdown(int[] a,int key,int end) {  
	
	int cur = key; //5
	int leftchild = 2*cur +1;

	if(end == 2 * cur + 2) {if(a[cur] < a[leftchild]) swap(a,cur,leftchild); return;};
	if (end <= 2 * cur +1) return;

	end--;
	int rightchild = 2*cur +2;
	int larger = (a[leftchild] > a[rightchild]? leftchild:rightchild);

	System.out.println(Arrays.toString(a));
	if(a[cur] < a[larger]) {
		swap(a, cur,larger);    
		cur = larger;
		shiftdown(a, cur,end);
	}

}

void swap(int[]a, int b, int c) {
	int temp = a[b];
	a[b] = a[c];
	a[c] = temp;
}

void shiftup (int[]a, int end) {
	int key = end;
	if(key < 0) return;
	int parent = (key -1)/2;
	if(a[key] > a[parent]) {
		swap(a, key, parent);
		key = parent;
		shiftup(a,key);
	}
}

public static void main(String[] args) {
	HeapSort hs = new HeapSort();

	int[] data = {3,2,6,13,8,4,10,7,14,11,12,5,9};
	System.out.println(Arrays.toString(data));
	hs.heapsort(data);
	System.out.println(Arrays.toString(data));
	

	
}


	

}
