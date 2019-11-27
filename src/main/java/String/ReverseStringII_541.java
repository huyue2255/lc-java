package String;

/**
 * 541. Reverse String II
 * Created by yuehu on 6/6/19.
 * Given a string and an integer k, you need to reverse the first k characters for every 2k
 * characters counting from the start of the string. If there are less than k characters left,
 * reverse all of them. If there are less than 2k but greater than or equal to k characters,
 * then reverse the first k characters and left the other as original.
 * Example:
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 */
public class ReverseStringII_541 {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int i = 0;
        while(i < s.length()) {
            int j = Math.min(i+k-1, s.length());
            swap(arr,i,j);
            i = i + 2*k;
        }
        return String.valueOf(arr);
    }

    public void swap(char[] arr, int i,int j) {
        while(i < j) {
            char temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
    }

    public static void main(String[] args) {
        ReverseStringII_541 s = new ReverseStringII_541();
        String arr = "abcdefghij";
        System.out.println(s.reverseStr(arr,2));
    }
    
}
