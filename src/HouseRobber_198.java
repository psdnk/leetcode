import java.util.Arrays;

public class HouseRobber_198 {

    public static void main(String[] args) {
        int [] nums = {2,7,9,3,1};
        System.out.println(rob(nums));
    }
    public static int rob(int[] nums) {
        int [] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return helper(0,nums,nums.length,dp);
    }

    public static int helper(int index , int [] nums, int n, int [] dp){
        if (index >= n) return 0;
        if (dp[index] != -1) return dp[index];
        return dp[index] = Math.max(helper(index+1,nums,n,dp), nums[index] + helper(index+2,nums,n,dp));
    }
}
