import java.util.Arrays;
import java.util.HashMap;

public class NextGreaterElementI {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3,5,2,4};
        int[] nums2 = new int[]{6,5,4,3,2,1,7};
        int[] ret = nextGreaterElement(nums1,nums2);
        System.out.println(Arrays.toString(ret));
    }
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> hm =  new HashMap<>();
        int len2 = nums2.length;
        int count = 0;
        int [] ret = new int[nums1.length];
        for (int i=0;i<nums2.length;i++){
            hm.put(nums2[i],i);
        }
        for (int num : nums1){
                int index = hm.get(num) +1;
                ret[count] =-1;
                while (index<len2){
                    if (nums2[index]>num){
                        ret[count] = nums2[index];
                        break;
                    }
                    index++;
                }
                count++;
//                ret[count++] = index+1<len2 && nums2[index+1]>num ? nums2[index+1] : -1;
        }
        return ret;
    }
}
