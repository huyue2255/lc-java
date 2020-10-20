package LaiOffer;

import sun.jvmstat.perfdata.monitor.PerfStringVariableMonitor;

import java.util.Arrays;

/**
 * Created by yuehu on 10/20/20.
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        int maj = nums[0];
        int count = 1;

        for(int i = 1; i < nums.length; i++){
            if(maj == nums[i]){
                count++;
                System.out.println("count" + count);
            }else{
                maj = nums[i];
            }

            if(count > nums.length / 2){
                return maj;
            }
        }

        return  maj;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,1,2,4,4,4,4,4};
        MajorityElement m = new MajorityElement();
        System.out.println(m.majorityElement(nums));
    }
}
