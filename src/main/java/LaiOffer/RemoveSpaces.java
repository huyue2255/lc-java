package LaiOffer;

/**
 * Created by yuehu on 6/29/20.
 * Q: Remove all leading/trailing and duplicate empty spaces
 * (only leave one empty space if duplicae spaces happen) from the input string
 *
 * approach:
 * 1. skipping all leading/duplicate empty space
 * 2. add one empty space in front of each word. (except for the 1th word in the sentence)
 */
public class RemoveSpaces {
    // Assumption: input is not null
    public String removeSpaces(String input) {
        if (input.isEmpty()) {
            return input;
        }

        char[] array = input.toCharArray();
        int end = 0;
        for (int i = 0; i < array.length; i++) {
            // when we would ignore the current space character:
            // 1. we ignore all the space characters followed by
            // another space character, so that if there are several consecutive space characters
            // only the first one will be remained
            // 2. we ignore also the space character if it is the first character of the input string
            if (array[i] == '_' && (i == 0 || array[i-1] == '_')) {
                continue;
            }
            array[end++] = array[i];
        }
        // Post-processing: it is possible we still have one trailing
        // space character at the end
        System.out.println("end"+end);
        if (end > 0 && array[end - 1] == '_') {
            return new String(array, 0, end - 1);
        }
        return new String(array, 0,end);
    }

    public static void main(String[] args) {
        String input = "hdf_";
        RemoveSpaces r = new RemoveSpaces();
        String result = r.removeSpaces(input);
        System.out.println(result);
    }
}
