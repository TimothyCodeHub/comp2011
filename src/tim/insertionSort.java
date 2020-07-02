package tim;

public class insertionSort {
	
	
	
	public static void insertTion(int[] arr) {
		int len = arr.length;
		
		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int move = i - 1;
			
			while(move >= 0 && arr[move]>key) {
				arr[move + 1 ] = arr[move];
				move--;
			}
			arr[move + 1] = key;
			
		}
	       
		
	}
	
	
	public static void insertTionV2(int[] arr) {
		int len = arr.length;
		
		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int move = i;
			
			while(move > 0 && arr[move-1] > key) {
				arr[move] = arr[move - 1];
				move --;
			}
			
			arr[move] = key;
			
			
			
			
		}
		
		
	}
	
	

	public  static void main(String[] args) {
		int n[] = {5,4,5,2,1};
		insertTionV2(n);
		
		for (int i = 0; i < n.length; i++) {
			System.out.print(n[i] + " ");
		}
		
	}
	
}
