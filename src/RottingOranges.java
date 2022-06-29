import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public static void main(String[] args) {
        RottingOranges ro = new RottingOranges();
//        int [][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        int [][] grid = {{2,2},
                         {1,1},
                         {0,0},
                         {2,0}};
        System.out.println(ro.orangesRottingv2(grid));
    }
        public int orangesRotting(int[][] grid) {
            int m= grid.length;
            int n = grid[0].length;
            boolean [][] visited = new boolean[m][n];
            for (boolean[] v : visited)Arrays.fill(v,false);
            Queue<String> q = new LinkedList<>();
            int [][] dir = new int[][] {{-1,0},{1,0},{0,-1},{0,1}};
            for (int i=0;i<m;i++){
                for (int j=0;j<n;j++){
                    if (grid[i][j] == 2){
                        q.add(i+":"+j);
                    }
                }
            }
            int currentSize = q.size();
            int count =0;
            while (!q.isEmpty()){
                int tempSize= 0 ;
                while (currentSize>0){
                    String val = q.poll();
                    int x = Integer.valueOf(val.split(":")[0]);
                    int y = Integer.valueOf(val.split(":")[1]);
                    visited[x][y] = true;
                    grid[x][y] = 2;
                    currentSize--;
                    for (int [] d : dir){
                        int r = x + d[0];
                        int c = y + d[1];
                        if (r>=0 && r<m && c>=0 && c<n && !visited[r][c] && grid[r][c] == 1){
                            visited[r][c] = true;
                            q.add(r+":"+c);
                            tempSize++;
                        }
                    }
                }
                if (tempSize!=0)
                    count++;
                currentSize = tempSize;
            }
            boolean found = false;
            for (int []g : grid){
                for (int v : g){
                    if (v == 1){
                        found = true;
                        break;
                    }
                }
            }
            return found==true ? -1 : count;
        }

    int count = 0;
    public int orangesRottingv2(int[][] grid) {
        int m =  grid.length;
        int n = grid[0].length;
        boolean [][] visited = new boolean[m][n];
        for (boolean[] v : visited)Arrays.fill(v,false);
        for (int i=0;i<m;i++){
            for (int j= 0;j<n;j++){
                if (!visited[i][j] && grid[i][j]==2){
                    helper(i,j,m,n,grid,visited,0);
                }
            }
        }
        return count;
    }

    public void helper(int i, int j , int m , int n , int[][]grid, boolean[][] visited , int time ){
        if (i<0 || i>=m || j<0 || j>=n || visited[i][j] || grid[i][j] ==0) return;
        System.out.println(time);
        visited[i][j] = true;
        grid[i][j] = 2;
        helper(i+1,j,m,n,grid,visited,time+1);
        helper(i-1,j,m,n,grid,visited,time+1);
        helper(i,j+1,m,n,grid,visited,time+1);
        helper(i,j-1,m,n,grid,visited,time+1);
        count = Math.max(count,time);
//        count = count+1;
    }
}
