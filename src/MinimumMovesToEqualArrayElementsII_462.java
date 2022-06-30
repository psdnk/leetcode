import java.util.Arrays;

public class MinimumMovesToEqualArrayElementsII_462 {

    // TC - O(nlogn)
    public static void main(String[] args) {
        int [] nums = {1,10,2,9};
        System.out.println(minMoves2(nums));
    }
    public static int minMoves2(int[] nums) {
        int len  = nums.length;
        Arrays.sort(nums);
        int midElement = nums[len/2];
        int count =0;
        for (int num : nums)count = count + Math.abs(num-midElement);
        return count;
    }
}
