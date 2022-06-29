import java.util.Arrays;

public class DeleteOperationForTwoStrings_583 {

    public static void main(String[] args) {
        String word1 = "sea";
        String word2 = "eat";
        System.out.println(minDistance(word1,word2));
    }
    public static int minDistance(String word1, String word2) {

        int [][] dp = new int[word1.length()+1][word2.length()+1];
        for (int [] d: dp) Arrays.fill(d,-1);
        return  helper(word1,word2,0,0,word1.length(),word2.length(),dp);

    }

    private static int helper(String word1, String word2, int i, int j, int m, int n, int [][] dp) {
        if (word1.length()==i) return word2.length()-j;
        if (word2.length()==j) return word1.length()-i;
        if (dp[i][j] != -1) return dp[i][j];
        if (word1.charAt(i) == word2.charAt(j)) return dp[i][j]=helper(word1,word2,i+1,j+1,m,n,dp);
        return dp[i][j]=1 + Math.min(helper(word1,word2,i+1,j,m,n,dp),helper(word1,word2,i,j+1,m,n,dp));

    }
}
