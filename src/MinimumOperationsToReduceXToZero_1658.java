import java.util.Arrays;

public class MinimumOperationsToReduceXToZero_1658 {


    public static void main(String[] args) {
        int [] nums = {5,6,7,8,9};
        int x = 4;
        System.out.println(minOperations(nums,x));
    }
    public static int minOperations(int[] nums, int x) {
        int len = nums.length;
        int [][] dp = new int[len+1][len+1];
        for (int [] d : dp) Arrays.fill(d,-2);
        int ret =  helper(nums,0,len,x,dp);
        return ret == Integer.MAX_VALUE ? -1 : ret;
    }

    public static int helper(int [] nums, int i , int j , int x, int [][] dp){
        if (i>j || x<0 || i>=nums.length || j>= nums.length) return Integer.MAX_VALUE;
        if (x == 0) return 0;
        if (dp[i][j] != -2) return dp[i][j];
        int ret = Math.min(helper(nums,i+1,j,x-nums[i],dp), helper(nums,i,j-1,x-nums[j],dp));
        dp[i][j] = ret == Integer.MAX_VALUE ? Integer.MAX_VALUE : ret+1;
        return dp[i][j];
    }
}
