package Basic;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuehu on 7/30/19.
 */
public class MapDemo
{
    public static void main(String[] args)
    {
        Map<String,Integer> m = new HashMap<String,Integer>();

        m.put("zhangsan", 19);
        m.put("lisi", 49);
        m.put("wangwu", 19);
        m.put("lisi",20);
        m.put("hanmeimei", null);
        System.out.println(m);

        System.out.println(m.values());
    }
}