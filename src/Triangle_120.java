import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle_120 {


    public static void main(String[] args) {
      List<List<Integer>> triangle =  new ArrayList<>();
      triangle.add(Arrays.asList(2));
      triangle.add(Arrays.asList(3,4));
      triangle.add(Arrays.asList(6,5,7));
      triangle.add(Arrays.asList(4,1,8,3));

        System.out.println(minimumTotal(triangle));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int [][] dp = new int[201][201];
        for (int [] d : dp)Arrays.fill(d,-1);
        return helper(0,0,triangle,dp);

    }

    private static int helper(int i, int j, List<List<Integer>> triangle, int[][] dp) {
        if (i<0 || i>=triangle.size() || j<0 || j>=triangle.get(i).size()) return Integer.MAX_VALUE;
        if (dp[i][j] != -1) return dp[i][j];
        if (i==triangle.size()-1 && j<triangle.get(i).size()) return triangle.get(i).get(j);
        return dp[i][j] = triangle.get(i).get(j) + Math.min(helper(i+1,j,triangle,dp),helper(i+1,j+1,triangle,dp));
    }
}
