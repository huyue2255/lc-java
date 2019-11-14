package LaiOffer;

import com.sun.org.apache.bcel.internal.generic.Select;

import java.util.Arrays;

/**
 * Created by yuehu on 11/2/19.
 *
 * 【3,1,4,5】
 *  i = 0; g = 0;
 *  g = 1;
 *  [1,3,2,5]
 *  i = 1; g = 1;
 *
 */
public class SelectionSort {
    //selection sort an array a[] with size n in ascending order
    public int[] SelectionSort(int[] a, int n) {
        int global, temp;
        for (int i = 0; i < n-1; i++) {// outer loop how many iterations
            global = i;
            for (int j = i+1; j < n; j++) { // find the global min from the rst elements
                if (a[j] < a[global]) {
                    //record the index of the smallest element
                    global = j;
                }
            }
            //swap the global (a[index]) min with a[i]
            temp = a[i];
            a[i] = a[global];
            a[global] = temp;
        }
        return a;
    }

    public int[] SelectionSort1(int[] a) {
        if (a == null || a.length <= 1) {
            return a;
        }
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            swap(a,i,min);
        }
        return a;
    }

    public void swap(int[] a, int left, int right) {
        int temp;
        temp = a[left];
        a[left] = a[right];
        a[right] = temp;
    }

    public static void main(String[] args) {
        int[] a = {3,1,2,5};
        SelectionSort s =  new SelectionSort();
        s.SelectionSort(a, 4);

        System.out.println(Arrays.toString(s.SelectionSort(a, 4)));
    }

}
