public class InterleavingString_97 {

    public static void main(String[] args) {
        /*
         */
        String s1= "bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa";
        String s2= "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab";
        String s3= "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab";
        System.out.println(isInterleave(s1,s2,s3));
    }
    public static boolean isInterleave(String s1, String s2, String s3) {
        Boolean [][] dp = new Boolean[s1.length()+1][s2.length()+1];
        return helper(s1,0,s2,0,s3,0,s1.length(),s2.length(),s3.length(),dp);
    }


    public static boolean helper(String s1, int i, String s2, int j, String s3, int index, int n, int m , int len, Boolean[][]dp){
        if (index == len){
            if(i==n && j==m)return true;
            else return false;
        }
        if (dp[i][j] != null) return dp[i][j];
        if (i<n && j<m && s1.charAt(i)==s3.charAt(index) && s2.charAt(j)==s3.charAt(index)){
            return dp[i][j] = helper(s1,i+1,s2,j,s3,index+1,n,m,len,dp) || helper(s1,i,s2,j+1,s3,index+1,n,m,len,dp);
        }else if (i<n && s1.charAt(i)==s3.charAt(index)){
            return dp[i][j] = helper(s1,i+1,s2,j,s3,index+1,n,m,len,dp);
        }else if (j<m && s2.charAt(j)==s3.charAt(index)){
            return dp[i][j] = helper(s1,i,s2,j+1,s3,index+1,n,m,len,dp);
        }//else if ((i<n && s1.charAt(i)!=s3.charAt(index)) ||(j<m && s2.charAt(j)!=s3.charAt(index)))return false;
        else return dp[i][j] = false;
    }
}
