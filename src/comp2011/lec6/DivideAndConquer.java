package comp2011.lec6;
import java.util.Arrays;

// finish the methods, 
// write both iterative and recursive versions.
public class DivideAndConquer {
    public static int peak(int[] a) {
        
        return -1;
    }
    
    public static int[] maxmin(int[] a, int low, int high) {
        if (low > high) return null;
        int ans[] = new int[2];
        if (high == low) {ans[0] = ans[1] = high; return ans;}
        if (high == low + 1) {
            ans[0] = (a[low] > a[high])? low:high; 
            ans[1] = low - ans[0] + high;
            return ans;
        }
        
        // in the rest high - low >= 2.
        int mid = low + (high - low) / 2;
        int[] a1 = maxmin(a, low, mid);
        int[] a2 = maxmin(a, mid + 1, high);
        ans[0] = (a[a1[0]] > a[a2[0]])?a1[0]:a2[0];
        ans[1] = (a[a1[1]] < a[a2[1]])?a1[1]:a2[1];        
        return ans;
    }
    
    public static int[] maxmin(int[] a) {
        if (a.length == 0) return null;
        int[] ans = new int[2];
        if (a.length == 1) {ans[0] = ans[1] = 0; return ans;}
        ans[0] = (a[0] > a[1])? 0:1; 
        ans[1] = 1 - ans[0];
//        if (a[0] > a[1]) {ans[0] = 0; ans[1]= 1;}
//        else {ans[0]= 1; ans[1] = 0;}
        for (int i = 2; i < a.length; i++) {
            if (a[i] > a[ans[0]]) { ans[0] = i; continue;}
            if (a[i] < a[ans[1]]) ans[1] = i;            
        }
        return ans;
    }
    
    public static int second(int[] a) {
        
        return -1;
    }
    
    public static int recSecond(int[] a) {
        
        return -1;
    }
    
    public static void main(String args[]) {
        int[] a = {12, 35, 1, 10, 1, 19, 49, 34};
        System.out.println(Arrays.toString(a));
        System.out.println(peak(a));
      //  System.out.println("second largest: a[" + second(a) + "] = " + a[second(a)]);
      //  System.out.println("second largest: a[" + recSecond(a) + "] = " + a[recSecond(a)]);
        int[] ans = maxmin(a, 0, a.length - 1);
        System.out.println("max = " + ans[0] + ", min = " + ans[1]);
    }
}
