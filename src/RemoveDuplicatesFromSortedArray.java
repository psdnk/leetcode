import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int [] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }
    public static int removeDuplicates(int[] nums) {
            int len =nums.length;
            for (int i=0;i<nums.length;){
                int j= i+1;
                while (j<len && nums[i] == nums[j]) j++;
                if (j<len){
                    nums[++i] = nums[j];
                    j++;
                }else return i;
                System.out.println(Arrays.toString(nums));
            }
        System.out.println(Arrays.toString(nums));
        return 0;

    }
}
