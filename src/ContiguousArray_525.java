import java.util.Arrays;

public class ContiguousArray_525 {
    public static void main(String[] args) {
        int [] nums = {0,1,0,0,0,1,1,0,1,1,1,0};
        System.out.println(findMaxLength(nums));
    }
    public static int findMaxLength(int[] nums) {
        int zero = 0;
        int one = 0;
        int [] dp = new int[nums.length];
        Arrays.fill(dp,1);
        if (nums[0] == 0)zero++;
        else one++;
        for (int i=1;i<nums.length;i++){
            int num = nums[i];
            if (num==0)zero++;
            else one++;
            if (one == zero){
                dp[i] = dp[i-1]+1;
            }else dp[i] = dp[i-1];
        }
        System.out.println(Arrays.toString(dp));
        return dp[nums.length-1];

    }
}
