import java.util.HashMap;

public class FourSumII {

    public static void main(String[] args) {
        int [] nums1 = {1,2};
        int [] nums2 = {-2,-1};
        int [] nums3 = {-1,2};
        int [] nums4 = {0,2};
        int count = fourSumCount(nums1, nums2, nums3, nums4);
        System.out.println(count);
    }
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int result = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for (int num1 : nums1){
            for (int num2 : nums2){
                int key = num1 + num2;
                hm.put(key,hm.getOrDefault(key,0)+1);
            }
        }
        for (int num3 : nums3){
            for (int num4 : nums4){
                int key = num3 + num4;
                result = result + hm.getOrDefault(-1*key,0);
            }
        }
        return result;

    }
}
