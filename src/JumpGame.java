import java.util.Arrays;

public class JumpGame {

    public static void main(String[] args) {
        int [] nums = {3,2,1,0,4};
//        System.out.println(canJump(nums));
        System.out.println(canJumpv2(nums));
    }

    public static boolean helper(int [] nums , int index, int len, int [] dp){
        if (index == len) return true;
        if (dp[index] != -1) return dp[index]==0 ? false : true;
        for (int i = 1;i<=nums[index];i++){
            boolean res = helper(nums, i + index, len,dp);
            dp[index] = res==true ? 1 : 0;
            if (res) return true;
        }
        dp[index] = 0;
        return false;
    }

    public static boolean canJumpv2(int [] nums){
        int [] dp = new int [nums.length];
        Arrays.fill(dp,-1);
        return helper(nums,0,nums.length-1,dp);
    }
    public static boolean canJump(int[] nums) {
        int len = nums.length;
        if(len==0 || len==1) return true;
        int currentIndex= 0;
        boolean [] visited = new boolean[len];
        Arrays.fill(visited,false);
//        int l = currentIndex+nums[currentIndex];
        while(true){
            int l = currentIndex+nums[currentIndex];
            System.out.println("*" +l);
            if (l>=len) break;
            for(int i=currentIndex;i<l;i++){
                System.out.println(i);
                visited[i] = true;
                if(i== len-1) return true;
                currentIndex = i;
            }
        }
        return false;

    }
}
