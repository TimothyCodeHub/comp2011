package tim;

public class bubbleSort {
	
	
	
	
	public void bubbleSort(int[] a) {
		int len  = a.length;
		
		
	    for (int i = 0; i < len; i++) {
			for (int j = 0; j < len - i -1; j++) {    // 後面的已經sort了。
				if (a[j] > a[j+1]) {
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		bubbleSort sort = new bubbleSort();
		int n[] = {2,1,0,4};
		sort.bubbleSort(n);
		
		for (int i = 0; i < n.length; i++) {
			System.out.print(n[i] + " ");
		}

	}

}
