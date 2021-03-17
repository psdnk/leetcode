public class CountBits {

    public static void main(String[] args) {

    }
    public static int[] countBits(int num) {

        int dp []  = new int[num+1];
        dp[0] = 0;
        if ( num >=1 )
            dp[1] = 1;
        for ( int i=2;i<=num;i++ ){
            if ( i%2 == 1 ){
                dp[i] = dp[i-1] + dp[1];
            }else {
                dp[i] = dp[i/2];
            }
        }
        return dp;
    }
}
