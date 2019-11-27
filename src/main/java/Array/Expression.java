package Array;

/**
 * Created by yuehu on 4/10/19.
 */
public class Expression {
    public int calculate(String s) {
        int eval = 0;
        int toSubtract = 0;
        char operation = '+';
        for (char token : s.toCharArray()) {
            if (Character.isDigit(token)) {
                int n = Character.getNumericValue(token);
                if (operation == '+') {
                    eval = eval + n;
                    toSubtract = n;
                }
                else if (operation == '-') {
                    eval = eval - n;
                    toSubtract = -1 * n;
                }else if (operation == '*') {
                    eval = eval - toSubtract + toSubtract * n;
                    toSubtract = toSubtract * n;
                }
                else if (operation == '/') {
                    eval = eval - toSubtract + toSubtract / n;
                    toSubtract = toSubtract / n;
                }
            }
            else
                operation = token;
        }
        return eval;
    }

    public static void main(String[] args) {
        Expression e = new Expression();
        String s1 = "1+3*7";
        e.calculate(s1);
        System.out.println(e.calculate(s1));

    }
}


