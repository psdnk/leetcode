import java.util.HashSet;

public class LongestConsecutiveSequence_128 {
    public static void main(String[] args) {
        int [] nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }
    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        int max = 0;
        for (int num  : nums) hashSet.add(num);
        for (int num : nums){
            int count =0;
            if (!hashSet.contains(num-1)){
                while (hashSet.contains(num)){
                    count ++;
                    num = num +1;
                }
                max = Math.max(max,count);
            }
        }
        return max;
    }
}
