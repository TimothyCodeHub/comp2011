package tim;

import java.util.Arrays;

public class testMergeSort {
	
	
	public void divide(int[] a,int start, int end) {
		if(start >= end) return;
		int mid = (start + end) /2;
		
		divide(a,start,mid);
		divide(a,mid+1,end);
		mergeSort(a,start,mid,end);
	}
	
	public void mergeSort(int[] a, int start,int mid, int end) {
		int lenL = mid-start+1;
		int lenR = end-mid;
		int[] arrL = new int[lenL];
		int[] arrR = new int[lenR];
		
		for(int i = 0;i<lenL; i++)
			arrL[i] = a[start+i];
		
		for(int i=0;i<lenR;i++)
			arrR[i] = a[(mid+1)+i];
		
		
		
		int pointL =0;
		int pointR =0;
		int whole = start;
		
		while(pointL <lenL && pointR < lenR) {
			if(arrL[pointL] <= arrR[pointR]) {
				a[whole++] = arrL[pointL++];
			}else {
				a[whole++] = arrR[pointR++];
			}
		}
		
		while(pointL< lenL) {
			a[whole++] = arrL[pointL++];
		}
		
		while(pointR< lenR) {
			a[whole++] = arrR[pointR++];
		}
		
		
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		int[] data = {5,4,3,2,1,0};
		testMergeSort ms = new testMergeSort();
		ms.divide(data,0,data.length-1);
		System.out.print(Arrays.toString(data));
	}

}
