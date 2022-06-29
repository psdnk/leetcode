import java.util.*;

public class FourSum {
    public static void main(String[] args) {
        FourSum fs = new FourSum();
        int [] nums = {1,0,-1,0,-2,2};
        int target = 0;
        System.out.println(fs.fourSum(nums,target).toString());
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length-1;
//        int j = len-1;
        for (int i=0;i<len-1;i++){
            for (int j=len;j>=0;j--) {
                int m = i + 1;
                int n = j - 1;
                if (nums[i] + nums[j] > target) j--;
                int sum = nums[i] + nums[j];
                while (m >= 0 && m < len && n >= 0 && n < len && m < n) {
                    if (sum + nums[m] + nums[n] > target) n--;
                    else if (sum + nums[m] + nums[n] < target) m++;
                    else ret.add(Arrays.asList(nums[i], nums[j], nums[m], nums[n]));
                }
            }
        }

        return ret;

    }
}
