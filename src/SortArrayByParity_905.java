import java.util.Arrays;

public class SortArrayByParity_905 {

    public static void main(String[] args) {
        int [] nums = {0,1};
        int[] ret = sortArrayByParity(nums);
        System.out.println(Arrays.toString(ret));
    }
    public static int[] sortArrayByParity(int[] nums) {
        int i = 0, j = nums.length-1;

        while ( i<j){
            if (nums[i]%2 == 0) i++;
            else {
                swap(i,j,nums);
                j--;
            }
        }
        return nums;
    }

    public static void swap(int i, int j, int [] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
