package Basic;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by yuehu on 9/26/18.
 */
public class ArrayTargetPair {

//    public boolean hasArrayTwoCandidate(int A[], int arr_size, int sum) {
//        int l, r;
//        Arrays.sort(A);
//
//    }


//    Question: Given a sequence of positive integers A and an integer T,
//    return whether there is a continuous sequence of A that sums up to exactly T

    public boolean hasSequence(int[] nums, int T) {
        if (T <=0)
            return false;
        if (nums.length == 0)
            return false;
        int i = 0;
        int start = 0;
        int sum = 0;
        while (i < nums.length) {
            if (sum + nums[i] < T)
                sum += nums[i];
            else if (sum + nums[i] == T)
                return true;
            else {
                sum += nums[i];
                while (sum > T) {
                    sum -= nums[start];
                    start++;
                }
                if (sum == T)
                    return true;
            }
            i++;
        }
        return false;
    }

//    Write a program that, given an array A[] of n numbers and another number x,
//    determines whether or not there exist two elements in S whose sum is exactly x.

//    Time Complexity: Depends on what sorting algorithm we use.
//    If we use Merge Sort or Heap Sort then (-)(nlogn) in worst case.
//    If we use Quick Sort then O(n^2) in worst case.
//    Auxiliary Space : Again, depends on sorting algorithm.
//    For example auxiliary space is O(n) for merge sort and O(1) for Heap Sort.

    public boolean hasArrayTwoCandidates(int A[],
                                         int arr_size, int sum)
    {
        int l, r;
        /* Sort the elements */
        Arrays.sort(A);

        /* Now look for the two candidates
        in the sorted array*/
        l = 0;
        r = arr_size-1;
        while (l < r)
        {
            if(A[l] + A[r] == sum)
                return true;
            else if(A[l] + A[r] < sum)
                l++;
            else // A[i] + A[j] > sum
                r--;
        }
        return false;
    }

    public void printpairs(int arr[],int sum)
    {
        HashSet<Integer> s = new HashSet<Integer>();
        for (int i=0; i<arr.length; ++i)
        {
            int temp = sum-arr[i];

            // checking for condition
            if (temp>=0 && s.contains(temp))
            {
                System.out.println("Pair with given sum " +
                        sum + " is (" + arr[i] +
                        ", "+temp+")");
            }
            s.add(arr[i]);
        }
    }

    public static void main(String args[]){
        ArrayTargetPair a = new ArrayTargetPair();
        int[] b = {1, 3, 5, 23, 2};
        System.out.println(a.hasSequence(b,7));

        int A[] = {1, 4, 45, 6, 10, -8};
        int n = 16;
        int arr_size = A.length;

        // Function calling
        if(a.hasArrayTwoCandidates(A, arr_size, n))
            System.out.println("Array has two " +
                    "elements with given sum");
        else
            System.out.println("Array doesn't have " +
                    "two elements with given sum");


        a.printpairs(A,  n);

    }

}
//https://www.geeksforgeeks.org/write-a-c-program-that-given-a-set-a-of-n-numbers-and-another-number-x-determines-whether-or-not-there-exist-two-elements-in-s-whose-sum-is-exactly-x/