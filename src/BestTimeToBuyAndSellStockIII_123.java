public class BestTimeToBuyAndSellStockIII_123 {

    static int profit = 0;
    public static void main(String[] args) {
        int [] prices = {3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        return helper(prices,0,1,prices.length,0);
    }
    public static int helper(int [] prices, int index , int buy, int n, int count){
        System.out.println(count);
        if (index == n) return 0;
        if (buy==1 && count<=2){
            profit = Math.max(-prices[index] + helper(prices,index+1,0,n,count+1),helper(prices,index+1,1,n,count));
        }else {
            profit = Math.max(prices[index] + helper(prices,index+1,1,n,count),helper(prices,index+1,0,n,count));
        }
        return profit;
    }
}
