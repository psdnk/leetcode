public class MergeSortedArray_88 {

    public static void main(String[] args) {
        int [] nums1= {1,2,3,4,0,0,0};
        int [] nums2 ={1,3,4};
        int m = nums1.length;
        int n = nums2.length;
        merge(nums1,m,nums2,n);
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
            int i = m-1, j = n-1, index = m+n-1;
            while (j>=0){
                if (nums1[i] >= nums2[j]) nums1[index--] = nums1[i--];
                else  nums1[index--] = nums1[j--];
            }

    }
}
