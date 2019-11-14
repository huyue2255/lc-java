package LaiOffer;

import java.util.Arrays;

/**
 * Created by yuehu on 11/6/19.
 * Assumption: we hve three color denoted as -1,0 ,1 and all the element valid
 * Solution: three bounds
 * 1. left side of neg is -1 (exclusive of neg)
 * 2. right side of one is 1 (exclusive of one)
 * 3. the part between neg an zero is 0( exclusive zero)
 * 4. the part between zero and one is discovered (inclusive both)
 */
public class RainbowSort {
      public int[] rainbowSort(int[] array) {
          if (array == null || array.length <= 1) {
              return array;
          }
          int neg = 0;
          int one = array.length - 1;
          int zero = 0;
          while (zero <= one) {
              if (array[zero] == -1) {
                  swap(array, neg++, zero++);
              } else if (array[zero] == 0) {
                  zero++;
              } else {
                  swap(array, zero, one--);
              }
          }
          return array;
      }
      private void swap(int[] array, int a, int b) {
          int tmp = array[a];
          array[a] = array[b];
          array[b] = tmp;
    }
      public static void main(String[] args) {
          int[] array = {-1,-1,1,1,-1,0,0,0,0,1,-1};

          RainbowSort s = new RainbowSort();
          s.rainbowSort(array);
          System.out.println(Arrays.toString(array));
    }
}
