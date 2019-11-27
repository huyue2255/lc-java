package Basic;

/**
 * Created by yuehu on 10/1/17.
 */
public class StockI {
    public static int StockI(int[] price){

        if(price == null || price.length == 0){
            return 0;
        }

        int min = price[0];
        int diff = 0;

        for(int i = 0; i < price.length; i++){
           if(min < price[i]){
               int temp = price[i] - min;
               if(diff < temp){
                   diff = temp;
               }
               }else{
               min = price[i];
           }
        }
        return diff;

    }


    public  static void main(String args[]){
        int[] a  = {7,1,5,3,6,4};
        //System.out.print(a.length);
        System.out.print(StockI(a));
    }
}
