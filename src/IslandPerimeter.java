public class IslandPerimeter {
    public static void main(String[] args) {
        int [][] grid = {{0,1,0,0},
                         {1,1,1,0},
                         {0,1,0,0},
                         {1,1,0,0}};
        System.out.println(islandPerimeter(grid));
    }

    public static int islandPerimeter(int[][] grid) {
        int r= grid.length;
        int c = grid[0].length;
        boolean [][] visited = new boolean[r][c];
        int perimeter = 0;
        for (int i=0;i<r;i++){
            for (int j=0;j<c;j++){
                if (!visited[i][j] && grid[i][j] == 1){
                    dfs(i,j,r,c,perimeter,grid,visited);
                    break;
                }
            }
        }

        return perimeter;
    }

    private static void dfs(int i, int j,int r, int c, int perimeter, int[][] grid, boolean[][] visited) {
        System.out.println(i + " : " + j + " : " + perimeter);
        if (i<0 || i>=r || j<0 || j>=c) perimeter++;
        if (j>0 && grid[i][j-1] == 0)perimeter++;
        if (j+1<c && grid[i][j+1] == 0)perimeter++;
        if (i>0 && grid[i-1][j] == 0)perimeter++;
        if (i+1<r && grid[i+1][j] == 0)perimeter++;
        visited[i][j] = true;
        if (j>0 && grid[i][j-1] == 1 && !visited[i][j-1]) dfs(i,j-1,r,c,perimeter,grid,visited);
        if (j+1<c && grid[i][j+1] == 1 && !visited[i][j+1]) dfs(i,j+1,r,c,perimeter,grid,visited);
        if (i>0 && grid[i-1][j] == 1 && !visited[i-1][j]) dfs(i-1,j,r,c,perimeter,grid,visited);
        if (i+1<r && grid[i+1][j] == 1 && !visited[i+1][j]) dfs(i+1,j,r,c,perimeter,grid,visited);
        return;
    }
}
