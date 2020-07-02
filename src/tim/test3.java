package tim;

import java.util.Arrays;

public class test3 {
	
	
	public void bubblesort(int[] a) {
		int n = a.length;
		
		for(int i=0; i<a.length; i++) {
			for(int j =1; j <a.length-i;j++) {
				if(a[j-1]>a[j])
					swap(a,j-1,j);
			}
		}
	}
	
	public void insertionSort(int[] a) {
		int n = a.length;
		int key;
		
			for(int i=1;i<a.length;i++) {
				key = a[i];
				int j = i-1;
				while(j>=0 && a[j]>key) {
					a[j+1] = a[j];
					j--;
				}
				
				a[j+1] = key;
				
				
			}
		
	}
	
	public void selectionSort(int[] a) {
		int n = a.length;
		
		
	for(int j=0; j < n-1 ;j++) {
		int minIndex = j;
		for(int i = j; i<n; i++) {
			 if(a[minIndex] > a[i]) {
				 minIndex = i;
			 }
		}
		swap(a,minIndex,j);
		}
		
	}
	
	
	
	public void swap(int[] arr,int a,int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	

	
	
	

	
	
	public  static void main(String[] args) {
		test3 t3 = new test3();
		int[] a = {5,4,3,9,2,1};
		t3.selectionSort(a);
		System.out.println(Arrays.toString(a));
	}
}
