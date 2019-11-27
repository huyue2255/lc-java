package Basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yuehu on 8/11/19.
 */
class NumberOfPairs
{
    static int arr[] = new int[]{6,6,3,3,5,1} ;

    // Returns number of pairs in arr[0..n-1] with sum equal
    // to 'sum'
    static int numberOfPairs(int[] a, int k)
    {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int element:a)
        {
            List<Integer> list = new ArrayList<>();
            if(map.containsKey(element)) {
                list.add(element);
                list.add(map.get(element));
                if(!res.contains(list))
                    res.add(list);
            }
            else{
                map.put(k - element, element);
            }
        }
        return res.size();
    }

    // Driver method to test the above function
    public static void main(String[] args) {

        int sum = 12;
        System.out.println("Count of pairs is " +
                numberOfPairs(arr,sum));

    }
}