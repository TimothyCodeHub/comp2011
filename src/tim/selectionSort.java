package tim;

public class selectionSort {
	
	
	
	
	public void selectionSort(int[] a) {
		int len = a.length;
		int min ;
		
		for (int i = 0; i < len - 1; i++) {
			min = i;
			for (int j = i+1; j < len ; j++) {
				
				if (a[j] < a[min]) {
					min = j;
				}
				
			}	
			int temp = a[min];
			a[min] = a[i];
			a[i] = temp;	
		
			 
		}
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		selectionSort sort = new selectionSort();
		int n[] = {2,0,0,1,4,4,6,7,8,4,56,2,1};
		sort.selectionSort(n);
		
		for (int i = 0; i < n.length; i++) {
			System.out.print(n[i] + " ");
		}

	}

}
