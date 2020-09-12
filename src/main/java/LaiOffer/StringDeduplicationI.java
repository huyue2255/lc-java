package LaiOffer;

/**
 * Created by yuehu on 8/31/20.
 *
 * Q: Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters,
 * and removing them.
 * We repeatedly make duplicate removals on S until we no longer can.
 * Return the final string after all such duplicate removals have been made.
 * It is guaranteed the answer is unique.
 * 类似俄罗斯方块，相同的马上消掉。
 * sample: leelcode => code
 */
public class StringDeduplicationI {
    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();
        int sbLength = 0;
        for(char character : S.toCharArray()) {
            if (sbLength != 0 && character == sb.charAt(sbLength - 1)) {
                sb.deleteCharAt(sbLength - 1);
                sbLength--;
            }
            else {
                sb.append(character);
                sbLength++;
            }
        }
        return sb.toString();
    }

}
