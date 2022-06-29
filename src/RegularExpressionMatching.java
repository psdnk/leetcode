public class RegularExpressionMatching {

    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b";
        System.out.println(isMatch(s,p));
    }
    public static boolean isMatch(String s, String p) {
        Boolean [][] dp = new Boolean[s.length()][p.length()];
//        return helper(s,p,0,0,dp);
        return helperv1(s,p,s.length()-1,p.length()-1);
    }

    public static boolean helperv1(String s , String p, int i, int j){
        if (i== -1 && j==-1) return true;
        if (i==-1 && j!=-1) return helperv1(s,p,i,j-1);
        if (i!=-1 && j==-1) return false;
        char c1 = s.charAt(i);
        char c2 = p.charAt(j);

        if (c2== '*') return helperv1(s,p,i,j-1) || helperv1(s,p,i-1,j);
        else if (c2 == '.') return helperv1(s,p,i-1,j-1);
        else if (c1 != c2) return false;
        else return helperv1(s,p,i-1,j-1);
    }

    public static boolean helper(String s , String p, int i, int j,Boolean [][] dp){
        if (i== s.length() && j==p.length()) return true;
        if (i==s.length() && j!=p.length()) return dp[i][j] = helper(s,p,i,j+1,dp);
        if (i!=s.length() && j==p.length()) return false;
        char c1 = s.charAt(i);
        char c2 = p.charAt(j);

        if (dp[i][j] != null) return dp[i][j];

        if (c2== '*') return dp[i][j] = helper(s,p,i,j+1,dp) || helper(s,p,i+1,j,dp);
        else if (c2 == '.') return dp[i][j] = helper(s,p,i+1,j+1,dp);
        else if (c1 != c2) return dp[i][j] = false;
        else return dp[i][j] = helper(s,p,i+1,j+1,dp);
    }


}
