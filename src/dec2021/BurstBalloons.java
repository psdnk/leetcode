package dec2021;

import java.util.Arrays;

public class BurstBalloons {
    public int maxCoins(int[] nums) {
        int [] arr = new int[nums.length+2];
        int [][] dp = new int[502][502];
        Arrays.fill(arr,1);
        int k=1;
        for (int num : nums)arr[k++] = num;
        for (int win = 2;win<arr.length;win++){
            for (int left = 0;left<arr.length-win;left++){
                int right =  win + left;
                for (int i=left+1;i<right;i++){
                    int cost = arr[left] * arr[i] * arr[right];
                    dp[left][right] = Math.max(dp[left][right],dp[left][i] + cost + dp[i][right]);
                }
            }
        }

        return dp[0][arr.length-1];

    }
}
