public class SearchInsertPosition {

    public static void main(String[] args) {
//        int []nums = {1,3,5,6};
        int []nums = {3,5,7,9,10};

//        int []nums = {1,3};
        int target = 8;
        System.out.println (searchInsert (nums,target  ));
    }
    public static int searchInsert(int[] nums, int target) {
        return search ( nums,0,nums.length-1,target );

    }

    public  static int search(int [] nums,int low, int high, int target){
        if ( low < 0 || high < 0  ){
            return 0;
        }
        if ( low >= nums.length || high >= nums.length  ){
            return 0;
        }
        if(low > high){
            return nums[low] < target ? low+1:low;
        }
        int mid = low + (high-low)/2;

        if ( nums[mid] == target ){
            return mid;
        }else if (target < nums[mid] ){
            return search ( nums,low,mid-1,target );
        }else {
            return search ( nums,mid+1,high,target );
        }
    }
}
