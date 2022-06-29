import java.util.Arrays;

public class MinimumPathSum_64 {

    public static void main(String[] args) {
        int [][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));
    }
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int [] d : dp) Arrays.fill(d,-1);
        return helper(grid,0,0,m,n,dp);
    }

    public static int helper(int [][] grid, int i, int j,int m, int n, int[][] dp){
        if (i<0 || i>=m || j<0 || j>=n) return Integer.MAX_VALUE;
        if (i==m-1 && j==n-1) return grid[i][j];
        if (dp[i][j] !=-1) return dp[i][j];
        else return dp[i][j] = grid[i][j]  + Math.min(helper(grid,i,j+1,m,n,dp),helper(grid,i+1,j,m,n,dp));
    }
}
