public class BestTimeToBuyAndSellStock_121 {

    public static void main(String[] args) {
        int [] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i=0;i<prices.length;i++) {
            min = Math.min(min,prices[i]);
            maxProfit = Math.max(maxProfit,prices[i]-min);
        }
        return maxProfit;
    }
}
