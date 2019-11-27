package Basic;

/**
 * Created by yuehu on 10/18/17.
 * 比较两个数a、b的大小，不能使用大于/小于、if、switch,?:等判断语句
 * 位操作在算法里面的运用
 */
public class ACompareToB {
    public static void main(String args[]){
        int a = 10;
        int b = 9;
        int z = ((a - b)>>31)&1;
        System.out.println((1-z)*a + z*b);
    }


}
