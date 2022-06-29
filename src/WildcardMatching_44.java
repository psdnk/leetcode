public class WildcardMatching_44 {

    public static void main(String[] args) {
        String s = "aaaaa";
        String p = "*?b";
        System.out.println(isMatch(s,p));
    }

    public static boolean isMatch(String s, String p) {
        Boolean [][] dp = new Boolean[s.length()][p.length()];
        return helper(s,p,0,0,dp);
    }
    public static  boolean helper(String s, String p , int i, int j ,Boolean [][] dp){
        if (i ==s.length() && j== p.length()) return true;
        if (i != s.length() && j==p.length()) return false;
        if(i==s.length() && j != p.length()) return p.charAt(j) == '*' ? helper(s,p,i,j+1,dp): false;
        if (dp[i][j] != null) return dp[i][j];
        char c1 = s.charAt(i);
        char c2 = p.charAt(j);
        if (c2 == '*')dp[i][j] =  helper(s,p,i,j+1,dp) || helper(s,p,i+1,j,dp);
        else if (c2 == '?') dp[i][j] = helper(s,p,i+1,j+1,dp);
        else {
            if (c1 != c2) dp[i][j] = false;
            else dp[i][j] = helper(s, p, i + 1, j + 1, dp);
        }
        return dp[i][j];
    }
}
