import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum ts = new ThreeSum();
        int [] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> resp = ts.threeSum(nums);
        System.out.println(resp.toString());
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length-1;
        Set<List<Integer>> ret = new HashSet<>();
        for (int i=0;i<len-1;i++){
            int left = i+1;
            int right = len;
            while (left<right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum<0) left++;
                if (sum>0) right--;
                if (sum == 0){
                    List<Integer> p = new ArrayList<>();
                    p.add(nums[i]);
                    p.add(nums[left]);
                    p.add(nums[right]);
                    left++;
                    right--;
                    ret.add(p);
                }
            }
        }
        return new ArrayList<>(ret);

    }
}
