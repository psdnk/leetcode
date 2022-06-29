import java.util.Arrays;

public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        UniqueBinarySearchTrees uniqueBinarySearchTrees = new UniqueBinarySearchTrees();
        System.out.println(uniqueBinarySearchTrees.numTrees(3));
    }
    public int numTrees(int n) {
        int [] dp = new int [n+1];
        Arrays.fill(dp,-1);
        dp[0] = 1;
        return helper(dp,n);

    }
    public int helper(int[]dp , int n){
        if (n<0) return 0;
        if(n==1) return dp[n]=1;
        if(n==2) return dp[n]=2;
        System.out.println(n);
        if(dp[n] != -1) return dp[n];
        int ans = 0;
        for(int i=1;i<=n;i++){
            ans = ans + helper(dp,i-1) * helper(dp,n-i);
        }
        return dp[n] = ans;
    }
}
