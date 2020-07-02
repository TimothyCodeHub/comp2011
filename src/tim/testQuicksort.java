package tim;

import java.util.Arrays;

public class testQuicksort {
	
	public void quicksort(int[] a, int start,int end) {
		if(start>=end)return;
		int pivotIndex = partition(a,start,end);
		
		quicksort(a,start,pivotIndex-1);
		quicksort(a,pivotIndex+1,end);
	}

	
	
	
	
	public int partition(int[] a, int start, int end) {
		int pivot = a[end];
		
		int pivotIndex = start;
		
		for(int i = start;i <= end-1; i++) {
			if(a[i] <= pivot) {
				int temp = a[pivotIndex];
				a[pivotIndex++] = a[i];
				a[i] = temp;
			}
		}
		a[end] = a[pivotIndex];
		a[pivotIndex] = pivot;
		
		return pivotIndex;
	}
	
	public static void main(String[] args) {
		int[] data = {5,4,3,2,1};
		testQuicksort qs = new testQuicksort();
		qs.quicksort(data,0,data.length-1);
		System.out.print(Arrays.toString(data));
		
 	}
}
