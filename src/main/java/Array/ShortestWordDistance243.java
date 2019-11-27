package Array;

/**
 * Created by yuehu on 3/29/19.
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

 Example:
 Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

 Input: word1 = “coding”, word2 = “practice”
 Output: 3
 Input: word1 = "makes", word2 = "coding"
 Output: 1
 这个问题是在array里面要找到对应的单词，这个单词必须一个一个字母的去比较，重点equals()
 */
public class ShortestWordDistance243 {
    //time O(n^2)
    //space O(1)
    public int shortestDistance(String[] words, String word1, String word2) {
        int res = words.length;
        for (int i = 0; i < words.length; i++) {
            if(words[i].equals(word1)) {
                for(int j = 0; j < words.length; j++) {
                    if(words[j].equals(word2)) {
                        res = Math.min(res,Math.abs(i - j));
                    }
                }
            }
        }
        return res;
    }
    //time O(n)
    //space O(1)
    public int shortestDistance1(String[] words, String word1, String word2) {
        int res = words.length;
        int a = -1;
        int b = -1;
        for (int i = 0; i < words.length; i++) {
            if(words[i].equals(word1)) {
               a = i;
            }else if(words[i].equals(word2)) {
               b = i;
            }
            if( a != -1 && b != -1) {
                res = Math.min(res,Math.abs(a-b));
            }
        }
        return res;
    }

    public static void main(String args[]){
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};

        ShortestWordDistance243 s = new ShortestWordDistance243();
        int result = s.shortestDistance1(words,"perfect","makes");
        System.out.println(result);

    }
}
