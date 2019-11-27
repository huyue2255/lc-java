package Array;

/**
 * Created by yuehu on 5/20/19.
 */
    public class FindFixedPoint {
        //Time Complexity: O(n)
        public int linearSearch(int[] arr) {
            int i;
            for(i = 0; i < arr.length; i++)
            {
                if(arr[i] == i)
                    return i;
            }
            return -1;
        }
        //Time Complexity: O(Logn)
        public int binarySearch(int[] arr, int start, int end) {
            if(end >= start) {
                int mid = start + (end-start)/2;
                if(mid == arr[mid]) {
                    return mid;
                }else if(mid > arr[mid]) {
                    return binarySearch(arr,mid+1,end);
                }else {
                    return binarySearch(arr,start,mid-1);
                }
            }
            return -1;
        }
        public static void main(String[] args) {
            FindFixedPoint s = new FindFixedPoint();
            int[] arr =  {-10, -5, 0, 3, 7};
            System.out.println(s.linearSearch(arr));
            System.out.println(s.binarySearch(arr,0,arr.length-1));
        }
}
