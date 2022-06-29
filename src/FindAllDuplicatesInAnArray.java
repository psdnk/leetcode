import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {

    public static void main(String[] args) {
        int [] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(nums));
    }
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for(int i: nums){
            if (nums[Math.abs(i)-1] < -1)res.add(-1*nums[Math.abs(i)-1]);
            else nums[Math.abs(i)-1] *=-1;
        }
        return res;
    }
}
