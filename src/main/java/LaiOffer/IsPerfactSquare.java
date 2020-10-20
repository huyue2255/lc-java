package LaiOffer;

/**
 * Created by yuehu on 10/18/20.
 */
public class IsPerfactSquare {
    public boolean isPerfact(int num) {
        int low = 1;
        int high = num;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
