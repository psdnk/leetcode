import java.util.Arrays;

public class FirstAndLastPositionOfElementInSortedArray_34 {
    public static void main(String[] args) {
        int [] nums = {5,7,7,8,8,10};
        int target = 6;
        int[] ret = searchRange(nums, target);
        System.out.println(Arrays.toString(ret));
    }
    public static int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int index = search(nums,0,len-1,target);
        if (index == -1) return new int[]{-1,-1};
        int start = index, end = index;
        while (end+1<len && nums[end+1]==target) end++;
        while (start-1>=0 && nums[start-1]==target) start--;
        return new int[]{start,end};
    }

    private static int search(int[] nums, int low, int high, int target) {
        while (low<=high){
            int mid = low +(high-low)/2;
            if (nums[mid] == target) return mid;
            else if (nums[mid]> target) high=mid-1;
            else low = mid +1;
        }
        return -1;
    }
}
