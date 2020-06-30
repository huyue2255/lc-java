package LaiOffer;

/**
 * Created by yuehu on 6/30/20.
 * Assumptions:
 * 1). the words are seperated by one space character.
 * 2). there are no leading or trailling spaces
 * 3). input is not null
 */
public class ReverseWords {
    public String reverseWords(String input) {
        // try to convert it to char array and solve the problem in-place
        char[] array = input.toCharArray();
        // 1. reverse the whole char array
        reverse(array, 0, array.length - 1);
        int start = 0;
        // 2. reverse each of the words
        for (int i = 0; i < array.length; i++) {
            // the start index of the word.
            if (array[i] != ' ' && (i == 0 || array[i-1] == ' ')) {
                start = i;
            }
            // the end of the word.
            if (array[i] != ' ' && (i == array.length - 1 || array[i+1] == ' ')) {
                reverse(array, start, i);
            }
        }
        return new String(array);
    }

    private void reverse(char[] array, int a, int b) {
        while(a < b) {
            char tmp = array[b];
            array[b] = array[a];
            array[a] = tmp;
            a++;
            b--;
        }
    }

    public static void main(String[] args) {
        String input = "hello world Grace and happy Monday";
        ReverseWords s = new ReverseWords();
        System.out.println(s.reverseWords(input));
    }
}
