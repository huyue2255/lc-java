package Basic;

/**
 * Created by yuehu on 10/3/17.
 * 344/Write a function that takes a string as input and returns the string reversed.
 */
public class ReverseStr {
    public String reverseString(String s) {

        //method1: use StringBuilder,StringBuffer and stringBuilder have the reverse function
//        StringBuilder output = new StringBuilder();
//        output.append(s);
//
//        output = output.reverse();
//        return output;

        //method2: create the new string first then usr the for loop try to add all the reverse element to the new string
        // String output = "";
//        String output = new String();
//        for(int i = s.length() - 1; i >= 0; i--){
//            output +=  s.charAt(i);
//        }
//        return output;
//    }
        //method3 : use string convert to char[]
        String output = "";
        char[] c = s.toCharArray();
        for (int i = c.length - 1; i >= 0; i--) {
            output += c[i];
        }
        return output;
    }

    public static void main(String args[]){
        String s = "hello2255";
        ReverseStr r = new ReverseStr();
        System.out.println(r.reverseString(s));


    }
}

//
//    byte[] strAsByteArray = s.getBytes();
//    byte[] result = new byte[strAsByteArray.length];
//
//        for(int i = 0; i < strAsByteArray.length; i++){
//        result[i] = strAsByteArray[strAsByteArray.length-i-1];
//        }
//
//        return result;