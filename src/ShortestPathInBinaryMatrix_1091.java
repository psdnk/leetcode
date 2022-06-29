public class ShortestPathInBinaryMatrix_1091 {

    static  int minPath;
    public static void main(String[] args) {
        int [][] grid = {{0,0,0},{1,1,0},{1,1,0}};
//        int [][] grid = {{1,0,0},{1,1,0},{1,1,0}};
        System.out.println(shortestPathBinaryMatrix(grid));
    }
    public static int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int [][] dir = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,1},{1,-1}};
        boolean[][] visited = new boolean[m][n];
        minPath = Integer.MAX_VALUE;
        if (grid[0][0] == 1) return -1;
        helper(grid,0,0,m,n,visited,dir,1);
        return minPath;
    }

    public static void helper(int[][] grid , int i, int j,int m , int n, boolean[][] visited, int [][] dir, int path){
        if (i<0 || i>= m || j>=n || j<0 || grid[i][j] == 1 || visited[i][j]) return;
        if (i == m-1 && j == n-1){
            // System.out.println(path);
            minPath = Math.min(minPath,path);
        }
        visited[i][j] = true;
        for (int [] d : dir){
            helper(grid,i+d[0],j+d[1],m,n,visited,dir,path+1);
        }
        visited[i][j] = false;
    }

}
