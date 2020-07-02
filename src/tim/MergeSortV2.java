package tim;

import java.util.Arrays;

public class MergeSortV2 {

    public void mergesortV2(int[] a, int begin , int end){

        if (begin >= end) return;
        int l = begin;
        int h = end;
        int m = (l + h) / 2;
        mergesortV2(a, l ,m);
        mergesortV2(a, m+1 ,h);
        merge(a, l, m, h);
    }

    public static void merge(int[] a, int l ,int m ,int h){

        int nL = m - l + 1;
        int nR = h - m;

        int arrL[] = new int[nL];
        int arrR[] = new int[nR];

        int positon_L = 0;
        int position_R = 0;


        for (int i = 0; i < nL; i++){
            arrL[i] = a[ l +i ];
        }
        for (int j = 0; j < nR; j++){
            arrR[j] = a[ m+1 +j ];
        }


        int whole_arr_position = l;
        while(positon_L < nL && position_R < nR){
            if (arrL[positon_L] <= arrR[position_R]){
                a[whole_arr_position] = arrL[positon_L];
                positon_L++;
                whole_arr_position++;
            }
            else{
                a[whole_arr_position] = arrR[position_R];
                position_R++;
                whole_arr_position++;
            }
        }

        while (positon_L < nL){
            a[whole_arr_position] = arrL[positon_L];
            positon_L++;
            whole_arr_position++;
        }


        while (position_R < nR){
            a[whole_arr_position] = arrR[position_R];
            position_R++;
            whole_arr_position++;
        }

    }

    public static void main(String[] args){
        MergeSortV2 ms2 = new MergeSortV2();
        int[] arr = {4,3,2,1};

        ms2.mergesortV2(arr , 0, arr.length-1);


        System.out.print(Arrays.toString(arr));

    }





}
