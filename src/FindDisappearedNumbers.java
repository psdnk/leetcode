import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDisappearedNumbers {
    public static void main(String[] args) {
        int [] nums = {1,1};
        List<Integer> disappearedNumbers = findDisappearedNumbers(nums);
        System.out.println(disappearedNumbers.toString());
    }
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        for (int i=0;i<nums.length;i++){
            int absIndex = Math.abs(nums[i])-1;
            if (nums[absIndex] > 0) nums[absIndex] = -nums[absIndex];
            System.out.println(Arrays.toString(nums));
        }
        for (int i=0;i<nums.length;i++){
            if(nums[i] > 0) ret.add(i+1);
        }
        return ret;
    }
}
