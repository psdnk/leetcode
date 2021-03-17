import java.util.Arrays;

public class UniquePaths {

    public static void main(String[] args) {
        System.out.println (uniquePaths ( 7,3 ));
    }
    public static int uniquePaths(int m, int n) {
        int [][] dp = new int[m][n];
        for ( int i=0;i<m;i++ ){
            Arrays.fill ( dp[i],-1 );
        }
//        int res = dfs ( 0,0,m,n );
//        int res = dfsWithMemoization ( 0,0,m,n ,dp);
        int res = solve ( m,n );
        System.out.println (res);
        return res;

    }

    public static int dfs(int i,int j,int m,int n){
        if ( i<0 || i>=m || j<0 || j>=n ){
            return 0;
        }
        if ( i == m-1 && j== n-1 ){
            return 1;
        }
        return  dfs ( i+1,j,m,n ) + dfs ( i,j+1,m,n );
    }

    public static int dfsWithMemoization(int i, int j,int m, int n , int[][] dp){
        if ( i<0 || i>=m || j<0 || j>=n ){
            return 0;
        }
        if ( i == m-1 && j== n-1 ){
            return 1;
        }
        if ( dp[i][j] != -1 ){
            return dp[i][j];
        }
        dp[i][j] = dfs ( i+1,j,m,n ) + dfs ( i,j+1,m,n );
        return dp[i][j];

    }

    public static int solve(int m, int n){
        int [][] dp = new int[m][n];
        for ( int i=0;i<n;i++ )dp[0][i] = 1;
        for ( int i=0;i<m;i++ )dp[i][0] = 1;

        for ( int i=1;i<m;i++ ){
            for ( int j=1;j<n;j++ ){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];

    }
}
