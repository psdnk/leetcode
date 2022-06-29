import java.util.Arrays;

public class UniquePaths {
    int count = 0;
    public int uniquePaths(int m, int n) {
        boolean[][]visited = new boolean[m][n];
        int[][] dp = new int[m][n];
        for (int i=0;i<m;i++) Arrays.fill(dp[i],-1);
        return dfs(0,0,m,n,visited,dp);
//        return count;
    }
    public void dfs(int i, int j , int m, int n , boolean[][] visited){
        if (i<0 || i>=m || j<0 || j>=n || visited[i][j]) return;
        if (i==m-1 && j== n-1){
            count++;
            visited[i][j] = false;
            return;
        }
        visited[i][j] = true;
        dfs(i+1,j,m,n,visited);
        dfs(i,j+1,m,n,visited);
        visited[i][j] = false;
    }

    public int dfs(int i, int j , int m, int n , boolean[][] visited,int[][]dp){
        if (i<0 || i>=m || j<0 || j>=n || visited[i][j]) return 0;
        if (i==m-1 && j== n-1){
            visited[i][j] = false;
            return 1;
        }
        if (dp[i][j] !=-1) return dp[i][j];
        visited[i][j] = true;
        int tot = dfs(i+1,j,m,n,visited,dp)+dfs(i,j+1,m,n,visited,dp);
        dp[i][j] = tot;
        visited[i][j] = false;
        return tot;
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(3,7));
    }
}
