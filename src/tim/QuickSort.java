package tim;

import java.util.Arrays;

public class QuickSort {

    public void quickSort(int[] a,int start,int end){
        if (start >= end) return;
        int pIndex = partistion(a,start,end);

        quickSort(a,start,pIndex-1);
        quickSort(a,pIndex+1,end);

    }

    public int partistion(int[] a, int start, int end){
    	int pIndex2 = start+(int)(Math.random() * (end-start));

        int temp = a[end];

        a[end] = a[pIndex2];
        a[pIndex2] = temp;
    	
        int pivot = a[end];
        int pIndex = start;

        for (int i = start;i <= end-1; i++){
            if (a[i] <= pivot){
                int temp1 = a[i];
                a[i] = a[pIndex];
                a[pIndex] = temp1;
                pIndex++;
            }

        }

        int temp2 = a[pIndex];
        a[pIndex] = a[end];
        a[end] = temp2;

        return pIndex;


    }

    public static void main(String[] args){
        QuickSort qs = new QuickSort();
        int[] unsort_arr = {4,3,2,1};
        qs.quickSort(unsort_arr,0,unsort_arr.length-1);

        System.out.print(Arrays.toString(unsort_arr));


        System.out.println();


        int[] unsort_arr2 = new int[100000];
        for (int i = 99999 ; i > 0; i--){
            unsort_arr2[99999-i] = i;
        }

        long startTime2=System.currentTimeMillis();   //获取开始时间
        qs.quickSort(unsort_arr2 , 0, unsort_arr2.length-1);
        long endTime2=System.currentTimeMillis(); //获取结束时间
        System.out.print(Arrays.toString(unsort_arr2));
        System.out.println();
        System.out.println("程序运行时间： "+(endTime2-startTime2)+"ms");




    }




}
