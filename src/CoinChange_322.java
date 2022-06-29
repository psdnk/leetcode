import java.util.Arrays;

public class CoinChange_322 {

    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int [] coins = {1};
        int amount = 2;
        System.out.println(coinChange(coins,amount));
    }
    public static int coinChange(int[] coins, int amount) {
        int [][] dp = new int[coins.length+1][10001];
        for (int [] d : dp) Arrays.fill(d,-1);
        int ret =  helper(coins,0,amount,0,dp);
        return ret == Integer.MAX_VALUE ? -1 : ret;
    }

    public static int helper(int [] coins, int index, int amount, int count, int [][] dp){
        if (amount == 0) {
            if (min>count) min = count;
            System.out.println(min);
            return count;
        }
        else if (index >= coins.length || amount<0 || count> min) return Integer.MAX_VALUE;
        else if (dp[index][amount] != -1) return dp[index][amount];
        else {
//            System.out.println(index + " : " + amount);
            int includeSame = helper(coins,index,amount-coins[index],count+1,dp);
            int includeAndMove = helper(coins,index+1,amount-coins[index],count+1,dp);
            int dontIncludeAndMove = helper(coins,index+1,amount,count,dp);
            int val = Math.min(includeSame,Math.min(includeAndMove,dontIncludeAndMove));
            dp[index][amount] = Math.min(val,dp[index][amount]);
            return val;
        }
    }
}
