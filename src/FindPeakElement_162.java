public class FindPeakElement_162 {

    public static void main(String[] args) {
        int [] nums = {1,2,3,1};
        System.out.println(findPeakElement(nums));
    }
    public static int findPeakElement(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = len-1;
        while (left<right){
            int mid = left + (right-left)/2;
            if (nums[mid]>nums[mid+1]) right=mid;
            else if (nums[mid-1]<=nums[mid])left=mid+1;

        }
        return right;
    }

    public static int helper(int [] nums, int left, int right, int len){
        if (left<0 || left>=len || right<0 || right>=len) return Integer.MIN_VALUE;
        int mid = left + (right-left)/2;
        int l = mid-1 <0 || mid-1>=len ? Integer.MIN_VALUE : nums[mid-1];
        int r = mid+1 <0 || mid+1>=len ? Integer.MIN_VALUE : nums[mid+1];
        if (l<=nums[mid] && r<=nums[mid]) return mid;
        return Math.max(helper(nums,left,mid-1,len),helper(nums,mid+1,right,len));
    }
}
