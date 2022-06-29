import java.util.*;

public class SortEvenAndOddIndicesIndependently_2164 {
    public int[] sortEvenOdd(int[] nums) {
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();

        for (int i=0;i<nums.length;i++){
            if (i%2==0)even.add(nums[i]);
            else odd.add(nums[i]);
        }
        Collections.sort(odd,(a,b)->b-a);
        Collections.sort(even);

        int e = 0;
        int o = 0;
        for (int i=0;i<nums.length;i++){
            if (i%2==0)nums[i] = even.get(e++);
            else nums[i] = odd.get(o++);
        }
        return nums;
    }
}
