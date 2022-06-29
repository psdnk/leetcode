public class LongestIncreasingSubsequence_300 {
    public static void main(String[] args) {
        int [] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));

    }
    public static int lengthOfLIS(int[] nums) {
        return helper(nums,0,0);
    }

    public static int helper(int [] nums, int currIndex,int prevIndex){
        if (currIndex == nums.length) return 0;
        int taken =0;
       if (nums[prevIndex]<nums[currIndex])  taken = 1 + helper(nums,currIndex+1,currIndex);
       int notTaken = helper(nums,currIndex+1, prevIndex);
       return Math.max(taken,notTaken);
    }
}
