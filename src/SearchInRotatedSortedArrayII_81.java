public class SearchInRotatedSortedArrayII_81 {

    public static void main(String[] args) {
        int [] nums = {1,0,1,1,1};
        int target = 0;
        System.out.println(search(nums,target));
    }
    public static boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while (left<=right){
            int mid = left + (right-left)/2;
            if (nums[mid] == target) return true;
            if (nums[mid]<=nums[right]){
                if (target>nums[mid] && target<=nums[right]) left = mid+1;
                else right = mid-1;
            }else {
                if (target<nums[mid] && target>= nums[left]) right = mid-1;
                else left = left = mid+1;
            }
        }
        return false;
    }
}
