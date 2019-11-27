package Array;

/**
 * Created by yuehu on 4/18/19.
 * 122. Best Time to Buy and Sell Stock II
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However,
 you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

 case : [5, 1, 2, 3, 4]

 time : O(n);
 space : O(1);
 */
public class BuySellStock122 {
    public int maxProfit2(int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        int pro = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i-1]){
                pro += prices[i] - prices[i-1];
            }
        }
        return pro;
    }
    public static void main(String[] args) {
        int[] s1 = {7,1,5,3,6,4};
        BuySellStock122 a1 = new BuySellStock122();
        int result = a1.maxProfit2(s1);
        System.out.println(result);
    }
}
