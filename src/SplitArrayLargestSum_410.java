public class SplitArrayLargestSum_410 {

    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5};
        int m = 2;
        System.out.println(splitArray(nums,m));
    }
    public static int splitArray(int[] nums, int m) {
        int low=0;
        int high = 0;
        for (int num : nums){
            low = Math.max(low,num);
            high = high + num;
        }
        while (low<=high){
            int mid = low + (high-low)/2;
            if (isPossibleToSplit(nums,mid,m)) high = mid-1;
            else low = mid+1;
        }
        return low;
    }

    private static boolean isPossibleToSplit(int[] nums, int maxPossibleSum, int m) {
        int totalSubsetCount= 1;
        int totalRunningSum = 0;
        for (int num : nums){
            totalRunningSum = totalRunningSum + num;
            if (totalRunningSum>maxPossibleSum){
                totalRunningSum = 0;
                totalRunningSum = totalRunningSum + num;
                totalSubsetCount++;
            }
            if (totalSubsetCount>m) return false;
        }
        return true;
    }
}
