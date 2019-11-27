package Basic;

/**
 * Created by yuehu on 10/8/17.
 */
public class JudgeRouteCircle {
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < moves.length();i++) {
            if (moves.charAt(i) == 'R') {
                x++;
            } else if (moves.charAt(i) == 'L') {
                x--;
            } else if (moves.charAt(i) == 'U'){
                y++;
            }else if(moves.charAt(i) == 'D'){
                y--;
            }
        }

        if(x==0 && y==0){
            return true;
        }else{
            return false;
        }
    }



    public static void main(String args[]){
        JudgeRouteCircle s = new JudgeRouteCircle();
        String moves = "LL";
        System.out.println(s.judgeCircle(moves));
    }
}
