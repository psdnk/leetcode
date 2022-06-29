import java.util.*;

public class DeleteAndEarn_740 {
    public static void main(String[] args) {
        int [] nums = {2,2,3,3,3,4};
        deleteAndEarn(nums);
    }
    public static int deleteAndEarn(int[] nums) {
        int [] dp = new int[10001];
        int [] freq  = new int[10001];
        for (int num : nums)freq[num] = freq[num]+num;
        for (int i=0;i<10001;i++){
            dp[i] = Math.max(freq[i]+dp[i-2],dp[i-1]);
        }

        return dp[10000];

    }

    public static int helper(int [] nums, int i,HashMap<Integer,List<Integer>> hm){
        if (i== nums.length) return 0;
        hm.put(-1*nums[i],hm.get(nums[i]));
        int l = hm.containsKey(nums[i]-1) == true ? -1*(nums[i]-1) : -1;
        int r = hm.containsKey(nums[i]+1) == true ? -1*(nums[i]-1) : -1;
        if (l !=-1) hm.put(l,hm.get(-1*l));
        if (r !=-1) hm.put(r,hm.get(-1*r));
        int inculde = nums[i] + helper(nums,i+1,hm);
        if (l !=-1) hm.put(-1*l,hm.get(l));
        if (r !=-1) hm.put(-1*r,hm.get(r));
        int exclude = helper(nums,i+1,hm);
        return Math.max(inculde,exclude);
    }
}
