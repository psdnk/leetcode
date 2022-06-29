public class NumberOfIslands_200 {
    public int numIslands(char[][] grid) {
        int count  = 0, m= grid.length, n= grid[0].length;
        int [][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (grid[i][j] == '1'){
                    count++;
                    helper(i,j,m,n,grid,dir);
                }
            }
        }
        return count;
    }

    private void helper(int i, int j, int m, int n, char[][] grid,int[][] dir) {
        if (i<0 || i>=m || j<0 || j>=n || grid[i][j] =='0') return;
        grid[i][j] = '0';
        for (int [] d : dir){
            helper(i+d[0],j+d[1],m,n,grid,dir);
        }
    }
}
