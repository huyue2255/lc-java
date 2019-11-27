package String;

/**
 * Created by yuehu on 5/16/19.
 */
public class RemoveDupicateInString {
    public String removeDuplicates(String input){
        String result = "";
        for (int i = 0; i < input.length(); i++) {
            if(!result.contains(String.valueOf(input.charAt(i)))) {
                result += String.valueOf(input.charAt(i));
            }
        }
        return result;
    }
    public static void main(String[] args) {
        RemoveDupicateInString s = new RemoveDupicateInString();
        String string = "aabbccdefatafaz";
        System.out.println(s.removeDuplicates(string));
    }
}
