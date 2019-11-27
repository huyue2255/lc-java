package Array;

/**
 * Created by yuehu on 7/23/19.
 */
public class ContainerWithMostWater_11 {
    public int maxArea(int[] height) {
        int res = 0;
        int l = 0, r = height.length -1;
        while(l < r) {
            res = Math.max(Math.min(height[l],height[r]) * (r-l),res);
            if(height[l] < height[r]) {
                l++;
            }else {
                r--;
            }
        }
        return  res;
    }
}
