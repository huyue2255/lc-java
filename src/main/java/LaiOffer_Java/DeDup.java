package LaiOffer_Java;

/**
 * Created by yuehu on 8/20/19.
 * dedupe adjacent repeated elements in the sorted array, for the consecutive repeated elements,
 * only retain one of them. Return the length of the array deduplication .
 * 1,2,3,3,3,3,3
 *             i
 *       e
 */
public class DeDup {
    public int dedup (int[] array) {
        if(array == null || array.length == 0) {
            return 0;
        }

        int end = 1; // first available position
        for (int i = 1; i < array.length; i++) {
            if(array[i] == array[i-1]){
                array[end++] = array[i];
            }
        }
        return end;
    }

}
