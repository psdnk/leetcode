public class EditDistance {

    public static void main(String[] args) {
        String s1 = "intention";
        String s2 = "execution";
        System.out.println(editDistanceDP(s1,s2));
        System.out.println(editDistance( s1,s2,s1.length(),s2.length() ));
    }

    public static int editDistance(String s1,String s2,int m,int n){

        if ( m == 0  ){
            return n;
        }
        if ( n == 0 ){
            return m;
        }

        if ( s1.charAt( m-1 ) == s2.charAt( n-1 ) ){
            return  editDistance( s1,s2,m-1,n-1 );
        }

        return 1 + Math.min( Math.min( editDistance( s1,s2,m,n-1 ), //insert in m
                                   editDistance( s1,s2,m-1,n )), //remove in m
                                   editDistance( s1,s2,m-1,n-1 )); //replace in both m& n
    }

    public  static  int editDistanceDP(String word1, String word2){
        int [][]dp = new int[word1.length()+1][word2.length()+1];

        int m = word1.length();
        int n = word2.length();
        for ( int i=0;i<=n;i++ ){
            dp[0][i] = i;
        }
        for ( int j=0;j<=m;j++ ){
            dp[j][0] = j;
        }
        for ( int i=1;i<=m;i++ ){
            for ( int j=1;j<=n;j++ ){

                if ( word1.charAt( i-1 ) == word2.charAt( j-1 ) ){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = 1 +  Math.min(Math.min( dp[i][j-1],dp[i-1][j]),dp[i-1][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
