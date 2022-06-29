import java.util.ArrayDeque;
import java.util.Arrays;

public class MaximumPointsYouCanObtainFromCards_1423 {
    public static void main(String[] args) {
        int [] cardPoints = {1,2,3,4,5,6,1};
        int k = 3;
        System.out.println(maxScorev1(cardPoints,k));
    }
    public static int maxScore(int[] cardPoints, int k) {
        int len  = cardPoints.length;
        int [][][] dp = new int[len][len][k+1];
        for (int [][] dd : dp){
            for (int [] d : dd) Arrays.fill(d,-1);
        }
        return helper(cardPoints,0,cardPoints.length-1,k, dp);
    }


    public static int helper(int [] cardPoints, int leftIndex,int rightIndex, int k, int [][][] dp){
        if (k==0) return 0;
        if (leftIndex>=cardPoints.length || rightIndex<0) return 0;
        if (dp[leftIndex][rightIndex][k] != -1) return dp[leftIndex][rightIndex][k];
        dp[leftIndex][rightIndex][k] =  Math.max(cardPoints[leftIndex] + helper(cardPoints,leftIndex+1,rightIndex,k-1,dp),
                cardPoints[rightIndex] + helper(cardPoints,leftIndex,rightIndex-1,k-1,dp));
        return dp[leftIndex][rightIndex][k];
    }


    public static int maxScorev1(int[] cardPoints, int k) {
        int max = 0;
        int left = 0;
        int len = cardPoints.length;
        int right = len -k;
        int sum = 0;
        for (int i=right;i<len;i++)sum = sum + cardPoints[i];
        while (right<len){
            max = Math.max(max,sum);
            sum = sum + (cardPoints[left] - cardPoints[right]);
            left++;
            right++;
        }
        return max;

    }
}
