import com.google.gson.Gson;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yuehu on 9/15/17.
 */
public class A {
    public static List<String> f1() {
        List<String> a = Arrays.asList("a", "b", "C");
        return a;
        //asdfasdfasdf
    }

    @Test
    public void t1() {

        String s = new Gson().toJson(A.f1());
        System.out.println(s);

    }
}
