package String;

/**
 * Created by yuehu on 10/10/18.
 * 657. Robot Return to Origin
 * moves.charAt(i)  也可以用这个拿到一个string 里面的每一个元素，或者把字符串变成字符数组
 */
public class RobotReturnToOrigin {
    public  boolean judgeCircle(String moves) {
        char[] cr = moves.toCharArray();
        int x = 0;
        int y = 0;
        for(int i = 0; i < cr.length; i++) {
            if(cr[i] == 'L') {
                x--;
            }else if(cr[i] == 'R') {
                x++;
            }else if(cr[i] == 'U') {
                y++;
            }else if(cr[i] == 'D') {
                y--;
            }
        }

        return x==0 && y==0;
    }


    public static void main(String[] args) {
        RobotReturnToOrigin a = new RobotReturnToOrigin();

        String s = "LRLRUD";
        a.judgeCircle(s);
        System.out.println(a.judgeCircle(s));
    }

}
