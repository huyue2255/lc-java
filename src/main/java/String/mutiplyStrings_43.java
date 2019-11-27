package String;

/**
 * Created by yuehu on 7/29/19.
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

 Example 1:

 Input: num1 = "2", num2 = "3"
 Output: "6"
 Example 2:

 Input: num1 = "123", num2 = "456"
 Output: "56088"
 Note:

 The length of both num1 and num2 is < 110.
 Both num1 and num2 contain only digits 0-9.
 Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class mutiplyStrings_43 {
    public String mutiply(String nums1,String nums2) {
       if (nums1 == null || nums2 == null) return "0";
       int[] digits = new int[nums1.length() + nums2.length()];
       for (int i = nums1.length() - 1; i >= 0; i--) {
           for (int j = nums2.length() - 1; j >= 0; j--){
               int product = (nums1.charAt(i) - '0') * (nums2.charAt(j) - '0');
               int p1 = i + j, p2 = i + j + 1;
               int sum = product + digits[p2];
               digits[p1] += sum / 10;
               digits[p2] = sum % 10;
           }
       }
       StringBuilder res = new StringBuilder();
       for (int digit : digits) {
           if(!(digit == 0 && res.length() == 0)){
               res.append(digit);
           }
       }
       return res.length() == 0 ? "0" : res.toString();
    }


    public static void main(String[] args) {
        String nums1 = "0";
        String nums2 = "0";
        mutiplyStrings_43 s = new mutiplyStrings_43();
        String res = s.mutiply(nums1,nums2);
        System.out.println(res);
    }
}
