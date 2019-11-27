package Array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yuehu on 5/20/19.
 */
public class FindDuplicateInArray {

    public void findDuplicate(int[] names) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < names.length; i++) {
            if(set.add(names[i]) == false) {
                System.out.println(names[i]);
            }
        }
    }

    public static void main(String[] args) {
        FindDuplicateInArray w = new FindDuplicateInArray();
        int[] arr = {1, 3, 3,4, 4, 5};
        w.findDuplicate(arr);
    }

}
