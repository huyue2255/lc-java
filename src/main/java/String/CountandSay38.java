package String;

/**
 * Created by yuehu on 5/1/19.
 * 38. Count and Say
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 */

//i = 1, res = 1,
// while loop
/*
    count = 0; c = 1;
*/

//for loop
//    n = 5
/*
    j = 0; count = 1;
    j = 1; sb = 11; res = 11;

    count = 0; res.length = 2; c = 1;
    j = 0; count = 1;
    j = 1; count = 2;
    j = 2; sb = 21; res = 21;

    count = 0; res.length = 2; c = 2
    j = 0; count = 1;
    j = 1; sb = 12; count = 1; c = 1;
    j = 2; sb = 1211; res = 1211
*/
public class CountandSay38 {
    public String countAndSay(int n) {
       int i = 1;
       String res = "1";
       while(i < n){
           int count = 0;
           StringBuilder sb = new StringBuilder();
           char c = res.charAt(0);
           for(int j = 0; j <= res.length(); j++){
               if(j != res.length() && res.charAt(j) == c){
                   count++;
               }else {
                   sb.append(count);
                   sb.append(c);
                   if(j != res.length()){
                       count = 1;
                       c = res.charAt(j);
                   }
               }
           }
           res = sb.toString();
           i++;
       }
       return res;
    }

    public static void main(String[] args) {
        int n = 6;
        CountandSay38 s = new CountandSay38();
        System.out.println(s.countAndSay(n));
    }

}
