import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int [] nums = {2,7,11,15};
        int target = 9;
        int [] ret= twoSum(nums,target);
        System.out.println(Arrays.toString(ret));
    }
    public static int[] twoSum(int[] nums, int target) {
        int [] result = new int [2];
        HashMap<Integer,Integer> hm = new HashMap<>();
        for (int i=0;i<nums.length;i++)hm.put(nums[i],i);
        for (int i=0;i<nums.length;i++){
            int key = target-nums[i];
            if (hm.containsKey(key)){
                result[0] = i;
                result[1] = hm.get(key);
            }
        }
        return result;

    }
}
