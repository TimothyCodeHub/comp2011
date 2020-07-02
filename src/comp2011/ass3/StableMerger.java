package comp2011.ass3;
import java.util.ArrayList;
import java.util.Arrays;

class Student {
	String name;
	double grade;
	public Student(String n, double g) {
		name = n; grade = g;
	}
	public String toString() {
		return "(" + name + ", " + grade + ")";
	}
}

public class StableMerger {
	//merge function
	public static Student[] merge1(Student[][] a) {
		int alen = a.length;
		int wholeLen = 0;
		int[] kArraysLen = new int[alen];
		for(int i=0; i<alen; i++) {
			kArraysLen[i] = a[i].length;
			wholeLen += kArraysLen[i];
		}
		
		Student[] list = new Student[wholeLen];
		int t = 0;
		for(int i =0;i<alen;i++) {
			for(int j =0; j<kArraysLen[i];j++) {
				list[t] = a[i][j];
				t++;
			}
		}
		
	   mergeSort(list, 0, wholeLen-1);
	    
		
		
		return list;
	}
	public static void mergeSort(Student[] list,int l,int h) {
		if (l >=  h) return;
        int begin = l;
        int end = h;

        int mid = (l + h) / 2;

        mergeSort(list,begin, mid);
        mergeSort(list,mid + 1,end);

        mergeV1(list, begin,mid,end);
	}	
	public static void mergeV1(Student[] list,int l,int m,int h) {
		int lenL = m - l +1;
        int lenR = h - m ;
		
		Student[] arrL = new Student[lenL];  
        Student[] arrR = new Student[lenR];
        
        for (int i = 0; i <lenL ; i++){
            arrL[i] = list[l+i];
        }
        for (int j = 0; j <lenR; j++){
            arrR[j] = list[j+ (m+1)];
        }
        
        int lPosistion = 0;
        int rPosisiton = 0;
        int whole_position = l;
        
        while(lPosistion < lenL && rPosisiton < lenR){
            if (arrL[lPosistion].grade <= arrR[rPosisiton].grade){
                list[whole_position] = arrL[lPosistion];
                lPosistion++;
            }
            else {
                list[whole_position] = arrR[rPosisiton];
                rPosisiton++;
            }
            whole_position++;
        }
        
        while (lPosistion < lenL){
            list[whole_position] = arrL[lPosistion];
            lPosistion++;
            whole_position++;
        }

        while (rPosisiton < lenR) {
            list[whole_position] = arrR[rPosisiton];
            rPosisiton++;
            whole_position++;
        }
        
		
	}
	//end of merge function
	
	//heap function
	public static Student[] merge2(Student[][] a) {
		int aLen = a.length;
		int wholeLen = 0;
		int[] kArraysLen = new int[aLen];
		for(int i=0; i<aLen; i++) {
			kArraysLen[i] = a[i].length-1;
			wholeLen += kArraysLen[i]+1;
		}
		Student[] studentList = new Student[wholeLen];
		
		
		for(int i = 0; i < wholeLen; i++) {
			
		int minIndex = findMin(a, aLen);		
	    studentList[i]= a[minIndex][0];
	    a[minIndex][0] = a[minIndex][kArraysLen[minIndex]];
	    a[minIndex][kArraysLen[minIndex]] = null;
	    kArraysLen[minIndex] -= 1;
	    shiftDown(a, minIndex, kArraysLen[minIndex],0);
	    
		}
		
		return studentList;
	}
	public static int findMin(Student[][] a, int len) {
        int minIndex = 0;
		for(int i = 0; i < len; i++) {
			if(a[i][0]==null) { minIndex += 1; }
			else if(a[minIndex][0].grade > a[i][0].grade) minIndex = i;
		}
		return minIndex;
	}	
	public static void shiftDown(Student[][] a, int minIndex, int end,int cur) {
		
		int leftChild  = 2*cur + 1;
		
		if(end == 2 * cur + 2) {if(a[minIndex][cur].grade > a[minIndex][leftChild].grade) 
			swap(a,minIndex,cur, leftChild); return;};
		
		int rightChild = 2*cur + 2;
		if (end <= 2 * cur +1) return;
		int smaller = (a[minIndex][leftChild].grade < a[minIndex][rightChild].grade? leftChild : rightChild);
		
		if(a[minIndex][cur].grade > a[minIndex][smaller].grade) {
			swap(a, minIndex, cur,smaller); 
			cur = smaller;
			shiftDown(a,minIndex,end,cur);
		}
		
	}	
	public static void swap(Student[][] a,int minIndex,int key,int larger) {
		Student temp = a[minIndex][key];
		a[minIndex][key] = a[minIndex][larger];
		a[minIndex][larger] = temp;
	}
	//end of heap function
	

	
	public static void main(String[] args) {
		String[][] names = {{"Carrie Lam", "CY Leung", "Donald Tsang"}, 
		        {"Eason Chan", "Denise Ho", "Jennifer Chan", "Joey Yung", "Kay Tse", "Cheung Jacky"},
		        {"Winnie", "Mickey", "Teddy", "Peppa"}};
		double[][] grades = {{60, 60, 60}, {40, 60, 70, 80, 90, 95}, {0, 90, 95, 100}};
		Student[][] all = new Student[names.length][];
		for (int i = 0; i < names.length; i++) {
			all[i] = new Student[names[i].length];
			for (int j = 0; j < names[i].length; j++) 
			    all[i][j]= new Student(names[i][j], grades[i][j]);
		}
		
		System.out.println(Arrays.toString(all[0]));
		System.out.println(Arrays.toString(all[1]));
		System.out.println(Arrays.toString(all[2]));
		System.out.println(Arrays.toString(merge1(all)));
		System.out.println(Arrays.toString(merge2(all)));
		
	}
}
