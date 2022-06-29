import java.util.HashSet;
import java.util.LinkedHashSet;

public class MaximumErasureValue_1695 {
    public int maximumUniqueSubarray(int[] nums) {
        int max = 0;
       for (int i=0;i<nums.length-1;){
                int sum = 0;
           HashSet<Integer> visited = new HashSet<>();
                for (int j=i;j<nums.length;j++){
                    if (!visited.contains(nums[j])){
                        visited.add(nums[j]);
                        sum = sum + nums[j];
                    }else i++;
                }
                max = Math.max(max,sum);
        }

       return max;
    }
}
