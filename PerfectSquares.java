import java.util.Arrays;

public class PerfectSquares {

    //static int [] dp;
    public static void main(String[] args) {
        //System.out.println (numSquares ( 19 ));
        System.out.println (solveByRecursion ( 19 ));
        int n=19;
        int [] dp = new int[n+1];
        Arrays.fill ( dp,-1 );
        //System.out.println (solveByRecursionAndMemoiztion ( n ,dp));
        System.out.println (solveDP ( n ));
        System.out.println (solveLegendreAlgo(n));
    }
    public static int numSquares(int n) {
        int sqrt = (int)Math.sqrt ( (double)n );
        //System.out.println (sqrt);
        int [] sq = new int[sqrt+1];
        for ( int i=1;i<=sqrt+1;i++ ){
            sq[i-1] = i*i;
        }
        System.out.println ( Arrays.toString (sq));
        int count =0;
        int temp = n;
        for ( int i=sq.length-1;i>=0;i-- ){
            if ( temp == 0 ){
                return count;
            }

            if ( sq[i] <= temp ){
                if ( n % sq[ i ] == 0 && count ==0) {
                    count = n / sq[ i ];
                    return count;
                }
                temp= temp- sq[i];
                count = count +1;
            }else{
                if (sq[i] > temp && count >0 && temp!= n ) {
                if ( n % sq[ i ] == 0 ) {
                    count = n / sq[ i ];
                    return count;
                }
            }else {
                    count=0;
                    temp=n;
                }
            }
        }
//        while (low<= high){
//            int mid = low + (high-low)/2;
//            if ( sq[mid] == n ){
//                count = count +1;
//            }
//            if ( n > sq[mid] ){
//                low = mid +1;
//            }
//            if ( n < sq[mid] ){
//
//                high = mid-1;
//            }
//        }
        if ( temp == 0 ){
            return count;
        }
        return count + (temp);
    }

    //recursion
    public static int solveByRecursion(int n){
        if ( n<=3 ){
            return n;
        }
        int ans = n;
        for ( int i=1;i*i<=n;i++ ){
            ans = Math.min ( ans,1+solveByRecursion( n-i*i ) );
        }
        return ans;
    }

    // recursion + memoization

    public static int solveByRecursionAndMemoiztion(int n,int[] dp){
        System.out.println (Arrays.toString ( dp ));
        if ( n<=3 ){
            return n;
        }

        if ( dp[n] != -1 ){
            return dp[n];
        }
        int ans = n;
        for ( int i=1;i*i<=n;i++ ){
            Math.min ( ans,1+solveByRecursionAndMemoiztion ( n - i*i,dp ) );
        }
        dp[n]= ans;
        return ans;

    }

    public static int solveDP(int n){
        int [] dp = new int[n+1];
        dp[0]=0;
        for ( int i=1;i<=n;i++ ){
            dp[i] = i;
            for ( int j=1;j*j<=i;j++ ){
                dp[i] = Math.min ( dp[i],1+dp[i-j*j] );
            }

        }
        return dp[n];
    }
    //legendre's theorem
    //n<=3 return n
    //if is perfect sq - sqrt(n) * sqrt(n) = n ? then return 2;
    //check if n is in  4^a(8b+7) then return 4;
    //check if i->1 to i*i<=n -
        //if(i*i + n-i*i) == n ? return 2
    //return 3;

    public static int solveLegendreAlgo(int n){
        int sqrt = (int)Math.sqrt ( (double)n );
        if ( n<= 3 ){
            return n;
        }
        if ( sqrt*sqrt == n ){
            return 1;
        }
        while (n%4 ==0){
            n=n/4;
        }
        if(n%8 == 7){
            return 4;
        }
        for ( int i=1;i*i<=n;i++ ){
            int base = (int)Math.sqrt ( (double) i );
            if ( base*base == (n-i*i) ){
                return 2;
            }
        }

        return 3;
    }
}
