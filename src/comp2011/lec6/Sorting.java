package comp2011.lec6;

import java.util.Arrays;

public class Sorting {

    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    // the first correct implementation of recursive sorting 
    // will get bonus
    public static void recursiveBubble(int[] a, int end) {
        if (end == 0) return;
        for (int i = 0; i < end; i++) {
            if (a[i] > a[i+1]) {
                swap(a, i, i+1);
            }
        }
        recursiveBubble(a, end - 1);
    }
    
    public static void recursiveInsertion(int[] a, int begin) {
        
    }
    
    public static void recursiveSelection(int[] a, int begin) {
        if (begin == a.length - 1) return;
        int n = a.length;
        int min = begin;
        for (int i = begin+1; i < n; i++) {
            if (a[min] > a[i]) min = i;
        }
        swap(a, begin, min);
        recursiveSelection(a, begin+1);
    }
        
	public static void selectionSort(int[] a) {
		int n = a.length;
		int[] newA = new int[n];
		int min;
		for (int i = 0; i < n; i++) {
			min = 0;
			for (int j = 1; j < n; j++) {
				if (a[min] > a[j]) min = j;
			}
			newA[i] = a[min];
			// should be a very large number
			a[min] = 1000000;
		}
		for (int i = 0; i < n; i++) a[i] = newA[i];
	}
	
	public static void selectionSortV2(int[] a) {
		int n = a.length;
		int min;
		for (int i = 0; i < n-1; i++) {
			min = i;
			for (int j = i+1; j < n; j++) {
				if (a[min] > a[j]) min = j;
			}
			int temp = a[min];
			a[min] = a[i];
			a[i] = temp;
		}
	}
	
    public static void mergesort(int[] a) {
        int n = a.length;
        int[] b = new int[(n + 1) / 2];
        int[] c = new int[n / 2];
        for (int i = 0; i < (n + 1) / 2; i++) b[i] = a[i];
        for (int i = 0; i < n / 2; i++) c[i] = a[(n + 1) / 2 + i];
        // The four lines above can be replaced by (then the algorithm is even simpler.
        // int[] b = Arrays.copyOfRange(a, 0, (n + 1) / 2);
        // int[] c = Arrays.copyOfRange(a, (n + 1) / 2, n);
        // Note that in copyOfRange, the last index is exclusive.
        mergesort(b);
        mergesort(c);
       // a = merge(b, c);
    }
	
	public static void main(String[] args) {
		int a[] = {10, 8, -4, 89, 2, 0};
		System.out.println(Arrays.toString(a));
		// recursiveBubble(a, a.length - 1);
		recursiveSelection(a, 0);
		System.out.println(Arrays.toString(a));
	}
}
