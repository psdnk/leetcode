import java.util.Arrays;

public class LongestIncreasingPathInAMatrix_329 {

    public static void main(String[] args) {
        int [][] matrix = {{9,9,4},{6,6,8},{2,1,1}};
        System.out.println(longestIncreasingPath(matrix));
    }
    public static int longestIncreasingPath(int[][] matrix) {
        int m  = matrix.length;
        int n = matrix[0].length;
        int max  = -1;
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        int [][] dp = new int[m][n];
        for (int [] d : dp) Arrays.fill(d,-1);
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                boolean[][] visited = new boolean[m][n];
                max = Math.max(max,helper(matrix,i,j,m,n,visited,dir, dp));
            }
        }
        return max;
    }

    public static int helper(int [][]matrix, int i, int j, int m, int n , boolean[][] visited, int [][] dir, int[][] dp){
        if (dp[i][j] != -1) return dp[i][j];
        int max = 0;
        visited[i][j] = true;
        for (int [] d : dir){
            int ni = i + d[0];
            int nj = j + d[1];
            if (ni>=0 && ni<m && nj>=0 && nj<n && matrix[ni][nj]> matrix[i][j]){
                max = Math.max(max,helper(matrix,i+d[0],j+d[1],m,n,visited,dir,dp));
            }
        }
        return dp[i][j] = 1+ max;
    }


}
