import java.util.HashMap;

public class SubarraySumEqualsK_560 {
    public static void main(String[] args) {
        int [] nums = {0,0,0,0,0,0,0,0,0,0};
        int k = 0;
        System.out.println(subarraySum(nums,k));
    }
    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int sum = 0;
        int count = 0;
        for(int num : nums){
            sum = sum + num;
            if (sum == k) count++;
            if (hm.containsKey(sum-k))count= count + hm.get(sum-k);
            hm.put(sum, hm.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
