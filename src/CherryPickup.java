import java.util.Arrays;
import java.util.List;

public class CherryPickup {

     int [] dir = {-1,0,1};
//     int max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        int [][] grid = {{3,1,1},{2,5,1},{1,5,5},{2,1,1}};
        CherryPickup cherryPickup = new CherryPickup();
        cherryPickup.cherryPickup(grid);
    }
    public  int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int [][][] dp = new int [71][71][71];
        for (int i=0;i<71;i++){
            for (int j=0;j<71;j++)
                Arrays.fill(dp[i][j],-1);
        }
        int sum = helper(0,0,n-1,grid,m,n,dp);
        System.out.println(sum);
        return sum;

    }

    public   int helper(int i, int col1,int col2, int [][] grid, int m, int n,int [][][] dp){
        if (i<0 || i>=m || col1<0 || col1>=n || col2<0 || col2>=n) return Integer.MIN_VALUE;
        if (dp[i][col1][col2] != -1) return dp[i][col1][col2];
        int max = 0;
        for (int r1=0;r1<3;r1++){
            for (int r2=0;r2<3;r2++){
                max = Math.max(max,helper(i+1,col1+dir[r1],col2 + dir[r2],grid,m,n,dp));
            }
        }
        max = max + ((col1==col2) ? grid[i][col1] : grid[i][col1] + grid[i][col2]);
        dp[i][col1][col2] = max;
        return max;
    }
}
