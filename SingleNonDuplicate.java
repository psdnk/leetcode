public class SingleNonDuplicate {
    public static void main(String[] args) {
//        int [] nums = {1,1,2,3,3,4,4,8,8};
//        int [] nums = {3,3,7,7,10,11,11};
                int [] nums = {1,1,2};
        System.out.println(singleNonDuplicate( nums ));
    }
    public static int singleNonDuplicate(int[] nums) {

//        int high = nums.length-1;
//        int low = 0;
//        int mid;
//        if ( high == 0 ){
//            return nums[0];
//        }else if ( nums[0] != nums[1] ){
//            return nums[0];
//        }else if ( nums[high] != nums[high-1] ){
//            return nums[high];
//        }
//
//        while (low<=high){
//            mid = low + (high-low)/2;
//            if ( (nums[mid-1] < nums[mid]) && (nums[mid] < nums[mid+1]) ){
//                return nums[mid];
//            }else if ( mid%2 == 0  && nums[mid] == nums[mid+1] || (mid%2 == 1 && nums[mid] == nums[mid-1])){
//                low = mid+1;
//            }else {
//                high = mid -1;
//            }
//        }
//        return -1;
        return search( nums,0,nums.length-1 );


    }

    public static int search(int [] nums , int start, int end) {

            if (  start > end ) {
                return -1;
            }
//        if ( start == end ){
//            return nums[start];
//        }
            int mid = start + ( end - start ) / 2;
            if ( mid == 0 &&  nums.length > 1 && nums[mid+1] > nums[mid]  ){
                return nums[mid];
            }
            else if ( mid == nums.length-1 && nums[mid-1] > nums[mid] ){
                return nums[mid];
            }else {
             if ( mid > 0 && mid < nums.length && nums[ mid - 1 ] < nums[ mid ] && nums[ mid + 1 ] > nums[ mid ] ) {
                    return nums[ mid ];
                } else {
                 if ( mid % 2 == 0 && nums[ mid ] == nums[ mid + 1 ] || ( mid % 2 == 1 && nums[ mid ] == nums[ mid - 1 ] ) ){
                     return search( nums, mid + 1, end );
                }else {
                     return  search( nums, start, mid-1 );
                 }
                }
            }
    }
}
