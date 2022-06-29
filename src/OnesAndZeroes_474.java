public class OnesAndZeroes_474 {

    public static void main(String[] args) {
        String [] strs = {"00","000"};
        int m = 1, n = 10;
        System.out.println(findMaxForm(strs,m,n));
    }
    public static int findMaxForm(String[] strs, int m, int n) {
        int [][][] dp = new int[m + 1][n + 1][strs.length];
        int[][] count = count(strs);
        int ret =  helper(strs,0,m,n,count,dp);
        return ret == Integer.MIN_VALUE ?  0 : ret;
    }

    public static int helper(String[] strs, int index, int m , int n, int [][] count,int[][][] dp){
        if (index>=strs.length || (m+n)<=0) return 0;
        if (dp[m][n][index] > 0) {
            return dp[m][n][index];
        }

        int countElIfCurrInc = 0;
        int countElIfCurrExc = 0;

        int zeroFreq = count[index][0];
        int oneFreq = count[index][1];


        if (m >= zeroFreq && n >= oneFreq) {
            countElIfCurrInc = 1 + helper(strs, m - zeroFreq, n - oneFreq, index + 1, count,dp);
        }
        countElIfCurrExc = helper(strs, m, n, index + 1, count,dp);

        dp[m][n][index] = Math.max(countElIfCurrInc, countElIfCurrExc);

        return dp[m][n][index];
    }

    public static int [][] count(String[] strs){
        int [][] count = new int[strs.length][2];
        for (int i=0;i<strs.length;i++){
            for (int j = 0;j<strs[i].length();j++){
                int i1 = strs[i].charAt(j) == '0' ? count[i][0]++ : count[i][1]++;
            }
        }
        return count;
    }
}
