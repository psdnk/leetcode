public class FindMinimuminRotatedSortedArrayII {

    public static void main(String[] args) {
//        int [] nums= {4,5,6,7,0,1,2};
        int [] nums= {3,3,1,3};
//        int [] nums= {2,2,2,0,1};
        System.out.println (findMin ( nums ));
    }

    //[4,5,6,7,0,1,2]
    public static int findMin(int[] nums) {

        int low = 0;
        int high = nums.length-1;
        while (low<high){
            int mid = low + (high-low)/2;
            if ( nums[low] <= nums[mid] && nums[mid] <= nums[high] ){
                high=mid+1;
            }else if ( nums[low] >= nums[mid] && nums[mid] <= nums[high]  ){
                low = mid;
            }else if ( nums[low] <= nums[mid] && nums[mid] >= nums[high] ){
                low = mid+1;
            }else {
                high = mid;
            }
        }
        return nums[low];




    }
}
