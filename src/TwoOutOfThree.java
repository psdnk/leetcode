import java.util.*;
import java.util.stream.Collectors;

public class TwoOutOfThree {

    public static void main(String[] args) {
        System.out.println(5&6&7);
    }
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> ret = new ArrayList<>();
        int [] nums = new int[101];
        Arrays.fill(nums,0);
        Set<Integer> s = convertToSet(nums1);
        for (int num : s)nums[num]++;
        s = convertToSet(nums2);
        for (int num : s)nums[num]++;
        s = convertToSet(nums3);
        for (int num : s)nums[num]++;
        for (int i=0;i<nums.length;i++){
            if (nums[i] >=2) ret.add(i);
        }
        return ret;


    }

    private Set<Integer> convertToSet(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int n : nums)hashSet.add(n);
        return hashSet;
    }
}
