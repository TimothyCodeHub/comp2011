package tim;

import java.util.Arrays;
import java.util.Currency;
import java.util.Timer;

public class MergeSort {

    public void Merge(int[] left_arr,int[] right_arr,int[] whole_arr){
        int lenL = left_arr.length;
        int lenR = right_arr.length;

        int left_position_number = 0;
        int right_position_number = 0;
        int whole_position = 0;

        while(left_position_number < lenL && right_position_number < lenR){  //比較左邊的0位置和右邊的0位置，哪個比較小就放到總arr上

            if (left_arr[left_position_number] <= right_arr[right_position_number]){
                whole_arr[whole_position] = left_arr[left_position_number];
                left_position_number++;
                whole_position++;
            }
            else {
                whole_arr[whole_position] = right_arr[right_position_number];
                right_position_number++;
                whole_position++;
            }
        }

        while (left_position_number < lenL){        //補上左邊如果左邊有東西
            whole_arr[whole_position] = left_arr[left_position_number];
            left_position_number++;
            whole_position++;
        }

        while (right_position_number < lenR){        //補上右邊如果右邊有東西
            whole_arr[whole_position] = right_arr[right_position_number];
            right_position_number++;
            whole_position++;
        }



    }

    public void MergeSort(int[] a){
        int len = a.length;

        if ( len < 2 ) return;

        int mid = len / 2;

        int left[] = new int[mid];
        int right[] = new int[len - mid];

        for (int i = 0; i < mid; i++){  //copy to left arr
            left[i] = a[i];
        }


        for (int j = mid; j < len; j++){   //copy to right arr
            right[j-mid] = a[j];
        }

        MergeSort(left);
        MergeSort(right);
        Merge(left, right, a);


    }






    public static void main(String[] args){
        MergeSort msort = new MergeSort();
        bubbleSort b = new bubbleSort();

        int[] unsort_arr = {4,3,2,1};


          // b.bubblesort(unsort_arr);
        msort.MergeSort(unsort_arr);

        System.out.print(Arrays.toString(unsort_arr));



    }
}
