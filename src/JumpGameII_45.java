import java.util.Arrays;

public class JumpGameII_45 {
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int [] nums = {1,2,1,1,1};
        System.out.println(jump(nums));
    }
    public static int jump(int[] nums) {
        int [] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return helper(0,nums,0,dp);
    }

    public static int helper(int index , int [] nums, int count, int [] dp){
        if (index == nums.length-1) return count;
        if (index >= nums.length) return Integer.MAX_VALUE;
        if (dp[index] != -1) return dp[index];
        for (int i=index+1;i<nums.length && i<=index+nums[index];i++){
             min = Math.min(dp[i] !=-1 ? dp[i] : min,helper(i,nums,count+1,dp));
             dp[i] = min;
        }
        return dp[index] = min;
    }
}
