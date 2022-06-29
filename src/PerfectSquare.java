import java.util.Arrays;

public class PerfectSquare {

    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }
    public static int numSquares(int n) {
        int [] dp = new int[n+1];
        Arrays.fill(dp,-1);
       return helper(n,dp);
    }

    public static int helper(int n,int [] dp){
        if (dp[n] != -1) return dp[n];
        if (n<=3) return n;
        for (int i=1;i*i<=n;i++){
            ans = Math.min(ans,1+helper(n-i*i,dp));
        }
        dp[n] = ans;
        return ans;
    }
}
