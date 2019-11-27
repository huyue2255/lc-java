package Array;

/**
 * Created by yuehu on 4/18/19.
 * Q121:Say you have an array for which the ith element is the price of a given stock on day i.

 If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

 Note that you cannot sell a stock before you buy one.
 */
public class BuySellStock121 {

//    public int maxProfit( int[] prices) {
//        if(prices == null || prices.length < 2) return 0;
//        int profit = 0;
//        for(int i = 0; i < prices.length; i++) {
//            for(int j = i+1; j < prices.length; j++){
//                profit = Math.max(profit,prices[j]-prices[i]);
//            }
//        }
//        return profit;
//    }
    public int maxProfit( int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        int minPrice = prices[0];
        int pro = 0;
        for(int price : prices){
           minPrice = Math.min(minPrice,price);
           pro = Math.max(pro,price - minPrice);
        }
        return pro;
    }

    public static void main(String[] args) {
        int[] s = {7,1,45,3,6,4};
        BuySellStock121 a = new BuySellStock121();
        int result = a.maxProfit(s);
        System.out.println(result);
    }
}
