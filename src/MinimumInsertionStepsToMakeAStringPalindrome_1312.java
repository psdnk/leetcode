import java.util.Arrays;

public class MinimumInsertionStepsToMakeAStringPalindrome_1312 {

    public int minInsertions(String s) {
        int [][] dp = new int[s.length()][s.length()];
        for (int [] d : dp) Arrays.fill(d,-1);
        return helper(s,0,s.length()-1,dp);
    }

    public int helper(String s, int i, int j, int [][]dp){
        if (i>j || i<0 || i>=s.length() || j<0 || j>=s.length())return 0;
        if (s.charAt(i) == s.charAt(j)) return dp[i][j] = 1 + helper(s,i+1,j-1,dp);
        else return dp[i][j] = 1 + Math.min(helper(s,i+1,j,dp),helper(s,i,j-1,dp));
    }
}
