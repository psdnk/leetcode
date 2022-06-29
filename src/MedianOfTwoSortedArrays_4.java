public class MedianOfTwoSortedArrays_4 {

    public static void main(String[] args) {
        int [] nums1 = {1,3};
        int [] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m =  nums1.length;
        int n =  nums2.length;
        int count = (m+n)/2;
        int i=0,j=0;
        while (count>0){
            while (i<=m-1 && nums1[i]<=nums2[j]){
                i++;
                count--;
            }

            while (j<=n-1 && nums1[j]<=nums2[i]){
                j++;
                count--;
            }
        }

        if ((m+n)%2 == 0){
            return (nums1[i]+nums2[j])/2;
        }else return (nums1[i])/2;

    }
}
