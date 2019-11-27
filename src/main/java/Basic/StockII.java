package Basic;

/**
 * Created by yuehu on 10/1/17.
 */
public class StockII {
    public static int StockII(int[] price){

        if(price == null || price.length == 0){
            return 0;
        }

        int max = price[0];
        int min = price[0];
        int diff = 0;

        for(int i = 1; i < price.length; i++){
            if(max < price[i]){
                max = price[i];
            }else{
                diff += max - min;
                max = price[i];
                min = price[i];
            }

        }
            diff += max - min;
            return diff;
    }


    public  static void main(String args[]){
        int[] a  = {1,2,9,3,6};
        //System.out.print(a.length);
        System.out.print(StockII(a));
    }
}
