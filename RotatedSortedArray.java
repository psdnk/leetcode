public class RotatedSortedArray {

    public static void main(String[] args) {

        int [] nums = {1,3};
        int target = 3;
        System.out.println(search(nums,target));
    }

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length ==0){
            return -1;
        }

        int pivot = findPivot(nums,0,nums.length-1);
        System.out.println(pivot);

//        int leftLow = pivot;
//        int leftHigh  = nums.length-1;
//        int rightLow = 0;
//        int rightHigh = pivot-1;

        int left = 0;
        int right = nums.length-1;

        if (target >= nums[pivot] && target <= right){
            left = pivot;
        }else {
            right= pivot;
        }
//        if(nums[pivot] == target){
//            return pivot;
//        }else if (nums[pivot] > target){
//            right = pivot;
//        }else if (nums[pivot] < target){
//            left= pivot;
//        }
        while (left <= right){
            int mid = left + (right-left)/2;
            if (target ==  nums[mid]){
                return mid;
            }
            else if (target > nums[mid]){
                left = mid +1;
            }else{
                right = mid -1;
            }
        }
        return -1;




//        if(nums[pivot] == target){
//            return pivot;
//        }else if (nums[pivot] > target){
//            return binarySearch(nums,leftLow,leftHigh,target);
//        }else if (nums[pivot] < target){
//            return  binarySearch(nums,rightLow,rightHigh,target);
//        }else {
//            return -1;
//        }

//        return binarySearch(nums,0,nums.length-1, target);

    }


    public static int findPivot(int[] nums,int left,int right){

        while(left < right){
            int mid = left + (right-left)/2;
            if(nums[mid]> nums[right]){
                left = mid +1;
            }else{
                right = mid;
            }
        }
        return left;
    }
    public  static int binarySearch(int[] nums,int low,int high, int target){
        if(low> high){
            return -1;
        }
        int mid = low + (high-low)/2;
        int midValue = nums[mid];
        if(midValue == target){
            return mid;
        }else if(midValue > target){
            return binarySearch(nums,low,mid-1, target);
        }else if(midValue < target){
            return binarySearch(nums,mid+1,high, target);
        }else{
            return -1;
        }
    }
}
