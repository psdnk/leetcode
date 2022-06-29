public class ShortestUnsortedContinuousSubarray_581 {

    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5};
        System.out.println(findUnsortedSubarray(nums));
    }
    public static int findUnsortedSubarray(int[] nums) {
       int low = 0;
       int high = nums.length-1;
       while (low+1<nums.length && nums[low]<= nums[low+1])low++;
       while (high-1>=0 && nums[high-1]<= nums[high])high--;
       if (low == nums.length-1) return 0;
       int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
       for (int i=low;i<=high;i++){
           min = Math.min(min,nums[i]);
           max = Math.max(max,nums[i]);
       }
       while (low-1>=0 && nums[low-1]>= min) low--;
       while (high+1<nums.length && nums[high+1]<= max)high++;
       return high-low+1;
    }
}
