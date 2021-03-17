import java.util.HashMap;

public class SubArraySum {


    public static void main(String[] args) {
        int [] nums = {28,54,7,-70,22,65,-6};
        int k=100;
        System.out.println(subarraySum(nums,k));
        System.out.println(5&5);
    }
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        if (nums == null || nums.length < 1){
            return -1;
        }
        for (int i=0;i<nums.length;i++){
            int sum = 0;
            for (int j=i;j<nums.length;j++){
                sum = sum + nums[j];
//                if (sum > k){
//                    break;
//                }
                if (sum == k){
                    count = count +1;
                }
            }
        }
        return count;

    }
    public static int subArraySumV2(int [] nums, int k){
        HashMap<Integer,Integer> hm = new HashMap<>();
        int sum = 0;
        int count = 0;
        hm.put(0,1);
        for (int i=0;i<nums.length;i++){
            sum = sum + nums[i];
            if (hm.containsKey(sum)){
                hm.put(sum, hm.get(sum)+1);
                count = count +1;
            }
            hm.put(sum,1);
        }

        return hm.get(k);
    }
}
