import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class KnightDialer_935 {


    public static void main(String[] args) {
        int n = 3131;
        System.out.println(knightDialer(n));
    }
    static int mod = 1000000007;
    public static int knightDialer(int n) {
        int[][] dp = new int[n+1][10];
        for (int [] d : dp)Arrays.fill(d,-1);
        HashMap<Integer, List<Integer>> routes = new HashMap<>();
        routes.put(0, Arrays.asList(4,6));
        routes.put(1, Arrays.asList(6,8));
        routes.put(2, Arrays.asList(7,9));
        routes.put(3, Arrays.asList(4,8));
        routes.put(4, Arrays.asList(0,3,9));
        routes.put(5, Arrays.asList());
        routes.put(6, Arrays.asList(0,1,7));
        routes.put(7, Arrays.asList(2,6));
        routes.put(8, Arrays.asList(1,3));
        routes.put(9, Arrays.asList(2,4));
        int count =0;
        for (int i=0;i<=9;i++){
            count = count  + helper(routes,i,2,n,dp)%mod;
            count = count%mod;
        }

        return count;
    }

    private static int helper(HashMap<Integer, List<Integer>> routes, int i, int pos, int n, int [][] dp) {

        if (pos == n+1) return 1;
        if (dp[pos][i] != -1) return dp[pos][i];
        int count = 0;
        for (int val : routes.get(i)) {
            count = count + helper(routes, val, pos + 1, n,dp) % mod;
            count = count % mod;
        }
        return dp[pos][i] = count;
    }

}
