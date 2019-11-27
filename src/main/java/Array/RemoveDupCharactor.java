package Array;

/**
 * Created by yuehu on 5/20/19.
 */
public class RemoveDupCharactor {
    public String removeDuplicates(String s) {
        StringBuilder noDupes = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            String si = s.substring(i-1, i);
            if (noDupes.indexOf(si) == -1) {
                noDupes.append(si);
            }
        }
        return noDupes.toString();
    }

    public static void main(String[] args) {
        RemoveDupCharactor s = new RemoveDupCharactor();
        String str = "hhhoooo";
        System.out.println(s.removeDuplicates(str));
    }
}
