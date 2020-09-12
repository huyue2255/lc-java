package LaiOffer;

/**
 * Created by yuehu on 9/1/20.
 */
public class LargestAndSecondLargest {
    /* Function to print first smallest and second smallest
      elements */
    static void print2largest(int arr[])
    {
        int first, second, arr_size = arr.length;

        /* There should be atleast two elements */
        if (arr_size < 2)
        {
            System.out.println(" Invalid Input ");
            return;
        }

        first = second = Integer.MIN_VALUE;
        for (int i = 0; i < arr_size ; i ++)
        {
            /* If current element is larger than first
              then update both first and second */
            if (arr[i] > first)
            {
                second = first;
                first = arr[i];
            }

            /* If arr[i] is in between first and second
               then update second  */
            else if (arr[i] > second && arr[i] != first)
                second = arr[i];
        }
        if (second == Integer.MIN_VALUE)
            System.out.println("There is no second" +
                    "largest element");
        else
            System.out.println("The smallest element is " +
                    first + " and second largest" +
                    " element is " + second);
    }

    /* Driver program to test above functions */
    public static void main (String[] args)
    {
        int arr[] = {12, 13, 1, 10, 34, 1};
        print2largest(arr);
    }
}
