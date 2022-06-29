import java.util.Arrays;

public class MinMovesKnight {

    public static void main(String[] args) {
        int ret = minMoves(7,6,6,0,1);
        System.out.println(ret);
    }
    public static int minMoves(int n, int startRow, int startCol, int endRow, int endCol) {
        // Write your code here
        int [][] dir = {{-2,-1},{2,-1},{-2,1},{2,1},{-1,-2},{1,-2},{-1,2},{1,2}};
        int min = 999999;
        boolean [][] visited= new boolean[n][n];
        for (boolean[] v : visited) Arrays.fill(v,false);
        return helper(n, startRow, startCol, endRow, endCol, dir, min,visited);

    }

    public static int helper(int n, int startRow, int startCol, int endRow, int endCol,int[][]dir,int min,boolean[][]visited){
        System.out.println(min);
//        if(startRow<0 || startRow>=n || startCol<0 || startRow>=n) return 999999999;
        if(startRow>=0 && startRow<n && startCol>=0 && startCol<n && !visited[startRow][startCol]) {
            visited[startRow][startCol] = true;
            if (startRow == endRow && startCol == endCol) return 1;
            for (int[] d : dir) {
                min = 1 + Math.min(min, helper(n, startRow + d[0], startCol + d[1], endRow, endCol, dir, min,visited));
            }
            visited[startRow][startCol] = false;
        }
        return min;
    }
}
