import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class MaxNumberOfK_SumPairs_1679 {
    public static void main(String[] args) {
        int [] nums = {2,5,4,4,1,3,4,4,1,4,4,1,2,1,2,2,3,2,4,2};
        int k = 3;
        System.out.println(maxOperationsv2(nums,k));
    }
    public static int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0, j = nums.length-1,count = 0;
        while (i<j){
            int sum = nums[i] + nums[j];
            if (sum == k){
                count ++;
                i++;
                j--;
            }else if (sum> k ) j--;
            else i++;
        }
        return count;
    }

    public static int maxOperationsv2(int[] nums, int k) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int count = 0;
        for (int num : nums){
            int rem = k - num;
            if (hashMap.containsKey(rem)){
                count ++;
                Integer val = hashMap.get(rem) == 1 ? hashMap.remove(rem) : hashMap.put(rem, hashMap.get(rem) - 1);
            }else hashMap.put(num,hashMap.getOrDefault(num,0)+1);
        }
        return count;
    }
}
