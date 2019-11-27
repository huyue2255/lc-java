package Basic;

import java.util.HashMap;

/**
 * Created by yuehu on 9/26/18.
 */


//Given an array of integers, and a number ‘sum’,
//find the number of pairs of integers in the array whose sum is equal to ‘sum’.
//Time Complexity : O(n2);Auxiliary Space : O(1)

public class ArrayTargetPairNum {

    public static void getPairsCount(int[] arr, int sum)
    {

        int count = 0;// Initialize result

        // Consider all possible pairs and check their sums
        for (int i = 0; i < arr.length; i++)
            for (int j = i + 1; j < arr.length; j++)
                if ((arr[i] + arr[j]) == sum)
                    count++;

        System.out.printf("Count of pairs is %d",count);
    }


//    A better solution is possible in O(n) time.
//
//    Below is the Algorithm.
//
//    Create a map to store frequency of each number in the array. (Single traversal is required)
//    In the next traversal, for every element check if it can be combined with any other element
//    (other than itself!) to give the desired sum. Increment the counter accordingly.
//    After completion of second traversal, we’d have twice the required value stored in counter because every pair is counted two times.
//    Hence divide count by 2 and return.

    // Returns number of pairs in arr[0..n-1] with sum equal
    // to 'sum'

    static int arr[] = new int[]{1, 5, 7, -1, 5} ;
    public int getPairsCount(int n, int sum)
    {
        HashMap<Integer, Integer> hm = new HashMap<>();

        // Store counts of all elements in map hm
        for (int i=0; i<n; i++){

            // initializing value to 0, if key not found
            if(!hm.containsKey(arr[i]))
                hm.put(arr[i],0);

            hm.put(arr[i], hm.get(arr[i])+1);
        }
        int twice_count = 0;

        // iterate through each element and increment the
        // count (Notice that every pair is counted twice)
        for (int i=0; i<n; i++)
        {
            if(hm.get(sum-arr[i]) != null)
                twice_count += hm.get(sum-arr[i]);

            // if (arr[i], arr[i]) pair satisfies the condition,
            // then we need to ensure that the count is
            // decreased by one such that the (arr[i], arr[i])
            // pair is not considered
            if (sum-arr[i] == arr[i])
                twice_count--;
        }

        // return the half of twice_count
        return twice_count/2;
    }


    public static void main(String args[])
    {
        ArrayTargetPairNum a = new ArrayTargetPairNum();
        int[] arr = { 1, 5, 7, -1, 5 };
        int sum = 6;
        a.getPairsCount(arr, sum);

        int sum1 = 6;
        System.out.println("hashmap: Count of pairs is " +
                a.getPairsCount(arr.length,sum1));
    }

}



