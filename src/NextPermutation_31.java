import java.util.Arrays;

public class NextPermutation_31 {

    public static void main(String[] args) {
        int [] nums = {1,2,1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void nextPermutation(int[] nums) {
        int len  = nums.length-1;
        int i = len-1,j=len;
        while (i>=0 && nums[i]>=nums[j]){
            i--;
            j--;
        }
        if (i>=0) swap(nums,i,j);
        else reverse(nums,0,len);
    }

    public  static void swap(int [] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int [] nums , int i ,int j){
        while (i<=j) swap(nums,i++,j--);
    }
}
