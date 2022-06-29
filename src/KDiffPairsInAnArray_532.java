import java.util.HashMap;
import java.util.Map;

public class KDiffPairsInAnArray_532 {

    public static void main(String[] args) {
//        int [] nums = {1,2,4,4,3,3,0,9,2,3};
        int [] nums = {3,1,4,1,5};
        int k = 2;
        System.out.println(findPairs(nums,k));
    }
    public static int findPairs(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int count = 0;
        for (int num : nums) hm.put(num,hm.getOrDefault(num,0)+1);
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()){
            if (k==0) {
                if (entry.getValue() >= 2) count++;
            } else {
                    if (hm.containsKey(entry.getKey() + k))count++;
                }
        }
        return count;
    }
}
