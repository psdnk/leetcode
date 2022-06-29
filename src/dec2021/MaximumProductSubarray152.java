package dec2021;

public class MaximumProductSubarray152 {
    public static void main(String[] args) {
//        int[] nums = {2,3,-2,4};
        int[] nums = {0,2};
        System.out.println(maxProduct(nums));
    }
    public static int maxProduct(int[] nums) {
        int len = nums.length;
        int [] dp = new int[len];
        if (len==0) return 0;
        if (len == 1) return nums[0];
        dp[0] = nums[0];
        int max = Integer.MIN_VALUE;
        for (int i=1;i<len;i++){
            int val =  Math.max(dp[i-1],dp[i-1]*nums[i]);
            val = Math.max(val,nums[i]);
            if (max<val)dp[i]=val;
            max = max < val ?  val : max;
        }
        return max;

    }
}
