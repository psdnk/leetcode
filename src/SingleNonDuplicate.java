public class SingleNonDuplicate {

    public static void main(String[] args) {
        SingleNonDuplicate singleNonDuplicate = new SingleNonDuplicate();
        int [] nums = {1,1,2,3,3,4,4,8,8};
//        int [] nums = {3,3,7,7,10,11,11};
        System.out.println(singleNonDuplicate.singleNonDuplicate(nums));
    }
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        return helper(low,high,nums,high);

    }
    public int helper(int low, int high, int[] nums, int len){
        int mid = low  + (high-low)/2;
        int left = mid-1;
        int right = mid + 1;
        System.out.println(mid + " - " +nums[mid] + " - " + left + " - " + right + " - " + low + " - " + low );
        if (left<0 || right>len) return -1;
        else if (left<low && (nums[right] != nums[mid])) return nums[mid];
        else if (right>high && (nums[left] != nums[mid])) return nums[mid];
//        else if ((nums[left] == nums[mid]) || (nums[right] ==nums[mid])) return -1;
        else if ((nums[left] != nums[mid] )&& (nums[right] !=nums[mid])) {
            System.out.println(nums[mid]);
            return nums[mid];
        }
        else return Math.max(helper(low,mid-1,nums,len),helper(mid+1,high,nums,len));
    }
}
