import java.util.Arrays;

public class EditDistance_72 {

    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";
        int ret = minDistance(word1, word2);
        System.out.println(ret);
    }
    public static int minDistance(String word1, String word2) {
        int [][] dp = new int[word1.length()+1][word2.length()+1];
        for (int [] d : dp) Arrays.fill(d,-1);
        return helper(word1, word2, 0, 0,dp);
    }

    public static int helper(String word1, String word2, int i, int j, int[][]dp){
        if (i>=word1.length() || j>=word2.length()) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        if (word1.charAt(i) == word2.charAt(j)){
            return dp[i][j] = helper(word1,word2,i+1,j+1,dp);
        }else {
            return dp[i][j] = 1 + Math.min(helper(word1,word2,i+1,j+1,dp),
                    Math.min(helper(word1,word2,i+1,j,dp),
                            helper(word1,word2,i,j+1,dp)));
        }
    }
}
