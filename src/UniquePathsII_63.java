import java.util.Arrays;

public class UniquePathsII_63 {

    public static void main(String[] args) {
        int [][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int [][] dp = new int[m][n];
        for (int[] d : dp) Arrays.fill(d,-1);
        return helper(obstacleGrid,0,0,m,n,dp);
    }

    public static int helper(int [][] obstacleGrid , int i, int j , int m , int n, int [][] dp ){

        if (i<0 || i>=m || j<0 || j>=n || obstacleGrid[i][j] ==1) return 0;
        if (i == m-1 && j== n-1) return 1;
        if (dp[i][j] != -1) return dp[i][j];
        else {
            obstacleGrid[i][j] = 1;
            int count = helper(obstacleGrid,i+1,j,m,n,dp) + helper(obstacleGrid,i,j+1,m,n,dp);
            obstacleGrid[i][j] = 0;
            return dp[i][j] = count;
        }
    }
}
