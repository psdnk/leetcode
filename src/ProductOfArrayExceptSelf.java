import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int [] nums = {1,2,3,4};
        int[] ret = productExceptSelf(nums);
        System.out.println(Arrays.toString(ret));
    }
    public static int[] productExceptSelf(int[] nums) {
        int product = 1;
        int [] ret = new int[nums.length];
        for (int num : nums)product = product*num;
        for (int i=0;i<nums.length;i++)ret[i] = product/nums[i];
        return ret;
    }
}
