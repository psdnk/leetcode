import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class PacificAtlanticWaterFlow_417 {

    public static void main(String[] args) {
        int [][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        List<List<Integer>> ret = pacificAtlantic(heights);
        System.out.println(ret.toString());
    }
    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length, col = heights[0].length;
        List<List<Integer>> ret = new ArrayList<>();
        HashSet<String> pacific = new HashSet<>();
        HashSet<String> atlantic = new HashSet<>();

        for (int j=0;j<col;j++)
            dfs(0,j,row,col,heights,pacific,heights[0][j]);
        for (int j=0;j<col;j++)
            dfs(row-1,j,row,col,heights,atlantic,heights[row-1][j]);

        for (int i=0;i<row;i++)
            dfs(i,0,row,col,heights,pacific,heights[i][0]);
        for (int i=0;i<row;i++)
            dfs(i,col-1,row,col,heights,atlantic,heights[i][col-1]);

        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                String box = i+"_"+j;
                if (pacific.contains(box) && atlantic.contains(box)){
                    ret.add(Arrays.asList(i,j));
                }
            }
        }
        return ret;
    }

    private static void dfs(int i, int j , int row, int col , int[][] heights, HashSet<String> visited , int prevHeight){
        String box = i+"_"+j;
        if (i<0 || i>=row || j<0 || j>=col || heights[i][j]<prevHeight || visited.contains(box)) return;
        visited.add(box);
        dfs(i+1,j,row,col,heights,visited,heights[i][j]);
        dfs(i-1,j,row,col,heights,visited,heights[i][j]);
        dfs(i,j+1,row,col,heights,visited,heights[i][j]);
        dfs(i,j-1,row,col,heights,visited,heights[i][j]);
    }
}


/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */



