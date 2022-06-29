public class FindMinimumInRotatedSortedArrayII {

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArrayII app = new FindMinimumInRotatedSortedArrayII();
        int [] nums = {3,3,1,3};
        System.out.println(app.findMin(nums));
    }
    public int findMin(int[] nums) {
        int end = nums.length-1;
        int start = 0;
        return helper(start,end,nums);
    }
    public int helper(int low,int high, int[] nums){
        int mid = low + (high-low)/2;
        if (low == high) return nums[low];
        if (mid == low || mid == high) return Math.min(nums[low],nums[high]);
        if (nums[mid]>nums[high]) return helper(mid+1,high,nums);
        else if (nums[mid]<nums[high]) return helper(low,mid,nums);
        else {
            int left = helper(low,mid-1,nums);
            int right = helper(mid+1,high,nums);
            return  Math.min(left,right);
        }
    }

}
