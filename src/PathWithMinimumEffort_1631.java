public class PathWithMinimumEffort_1631 {


    public static void main(String[] args) {
        int [][] heights = {{1,2,2},{3,8,2},{5,3,5}};
        System.out.println(minimumEffortPath(heights));
    }
    static int minheight  = Integer.MAX_VALUE;
    public static int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int [][] dir = {{-1,0},{0,1},{0,-1},{0,1}};
        boolean [][] visited = new boolean[m][n];
//        dfs(heights,0,0,m,n,Integer.MAX_VALUE,dir,visited);
        return minheight;
    }

    public static void dfs(int [][] heights, int i, int j, int m , int n, int prevHeight, int [][] dir, boolean[][] visited, int pathMax){
        if (i<0 || i>=m || j<0 || j>=n || visited[i][j]) return;
        if (i == m-1 && j == n-1){
//            minheight = Math.min(minheight , Math.abs(prevHeight - heights[i][j]));
            return;
        }
        visited[i][j] = true;
//        if (Math.abs(prevHeight - heights[i][j]) > minheight) return;
        minheight = Math.min(minheight , Math.abs(prevHeight - heights[i][j]));
//        for (int [] d : dir) dfs(heights,i+d[0],j+d[1],m,n,heights[i][j],dir,visited);
    }
}
