public class UniquePathsIII {
    int count = 0;

    public static void main(String[] args) {
        UniquePathsIII uniquePathsIII = new UniquePathsIII();
        int [][] grid = {{1,0,0,0},{0,0,0,0},{0,0,0,2}};
        System.out.println(uniquePathsIII.uniquePathsIII(grid));
    }
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int total = 0;
        int ii = 0;
        int jj = 0;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (grid[i][j] == 1){
                    ii=i;
                    jj=j;
                }
                if (grid[i][j] == 0) total++;
            }
        }
        helper(ii,jj,m,n,grid,total);
        return count;
    }

    private void helper(int i, int j, int m, int n, int[][] grid, int total) {
        if (i<0 || i>=m || j<0 || j>=n || grid[i][j] < 0) return;
        if (grid[i][j] ==2) {
            if (total< 0) count++;
            return;
        }
        grid[i][j] = -2;
        helper(i-1,j,m,n,grid,total-1);
        helper(i+1,j,m,n,grid,total-1);
        helper(i,j-1,m,n,grid,total-1);
        helper(i,j+1,m,n,grid,total-1);
        grid[i][j] = 0;
    }
}
