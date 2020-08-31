package LaiOffer;

/**
 * Created by yuehu on 7/19/20.
 * Q: Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position
 * Determine if you are able to reach the last index.
 */
public class ArrayHopperI {
    // Method 1: DP, canJump[i] means from index 0, can jump to index i.
    public boolean canJump(int[] array) {
        // Assumptions: array is not null and is not empty
        boolean[] canJump = new boolean[array.length];
        canJump[0] = true;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (canJump[j] && array[j] + j >= i) {
                    canJump[i] = true;
                    break;
                }
            }
        }
        return canJump[array.length - 1];
    }

    // Method 2: DP, canJump[i] means from index i,
    // can jump to index array.length - 1
    public boolean canJumpII(int[] array) {
        //Assumptions: array is not null and is not empty
        if (array.length == 1) {
            return true;
        }
        boolean[] canJump = new boolean[array.length];
        // if from index i, it is already possible to jump to the end of the array
        for (int i = array.length - 2; i >= 0; i--) {
            if (i + array[i] >= array.length - 1) {
                canJump[i] = true;
            } else {
                for (int j = array[i]; j >= 1; j--) {
                    if (canJump[j+i]) {
                        canJump[i] = true;
                        break;
                    }
                }
            }
        }
        return canJump[0];
    }

    // Method 3: Greedy solution
    // Keep the max index reachable by jumping x steps, and
    // the max index reachable by jumping x+1 steps

    public boolean canJumpIII(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) return false;
            int curr = i + nums[i];
            max = Math.max(max, curr);
        }
        return max >= nums.length - 1;
    }

    public static void main(String[] args) {
        ArrayHopperI a  = new ArrayHopperI();
        int[] num = {2,2,1,0,7};
        System.out.println(a.canJump(num));
    }

}
