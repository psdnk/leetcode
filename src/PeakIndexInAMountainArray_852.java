public class PeakIndexInAMountainArray_852 {

    public static void main(String[] args) {
        int [] arr = {0,10,5,2};
        System.out.println(peakIndexInMountainArray(arr));
    }
    public static int peakIndexInMountainArray(int[] arr) {
        int low  = 0 ;
        int high = arr.length-1;
        while (low<high){
            int mid = low + (high-low)/2;
            if (mid == 0){
                if (arr[mid]>arr[mid+1]) return 0;
                else return 1;
            }else if (mid == arr.length-1){
                if (arr[mid]>arr[mid-1]) return mid;
                else return mid-1;
            }else if (arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]) return mid;
            else if (arr[mid-1]>arr[mid+1]) high = mid-1;
            else low = mid+1;
        }
        return low;
    }
}
