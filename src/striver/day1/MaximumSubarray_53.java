package striver.day1;

public class MaximumSubarray_53 {

    public static void main(String[] args) {
        int [] nums = {-2,-3,4,-1,-2,1,5,-3};
        System.out.println(maxSubArray(nums));
    }
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int i=0;i<nums.length;i++){
            sum = sum + nums[i];
            max = Math.max(sum,max);
            if (sum<0) sum =0;
        }
        return max;
    }
}
