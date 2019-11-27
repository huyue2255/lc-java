package Array;


/**
 * Created by yuehu on 10/8/18.
 * 空间复杂度为O(1)。平均时间复杂度为O(n^2)。
 */
public class BubbleSort {

    public void bubbleSort(int[] nums) {
        int i,j,temp,len = nums.length;
        for(i = 0; i < len - 1; i++){
            for(j = 0; j < len - 1 -i; j++){
                if(nums[j] > nums[j+1]){
                    temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }


    public static void main(String args[]){
        int[] b = {1, 3, 5, 23, 2};

        BubbleSort s = new BubbleSort();
        s.bubbleSort(b);
        System.out.println(b[0] + " ");
        System.out.println(b[1] + " ");
        System.out.println(b[2] + " ");
        System.out.println(b[3] + " ");
        System.out.println(b[4] + " ");
    }
}