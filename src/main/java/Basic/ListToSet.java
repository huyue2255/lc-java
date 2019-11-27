package Basic; /**
 * Created by yuehu on 8/10/19.
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListToSet
{
    public static void main(String[] args)
    {
        List<String> alphaList = new ArrayList<String>();
        alphaList.add("A");
        alphaList.add("B");
        alphaList.add("C");
        alphaList.add("A");
        alphaList.add("B");
        System.out.println("List values .....");
        for (String alpha : alphaList)
        {
            System.out.println(alpha);
        }
        Set<String> alphaSet = new HashSet<String>(alphaList);
        System.out.println("\nSet values .....");
        for (String alpha : alphaSet)
        {
            System.out.println(alpha);
        }
    }
}
