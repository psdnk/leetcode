import java.util.Arrays;

public class WordSearch {

    public static void main(String[] args) {
        char [][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
//        char [][] board = {{'A','B','C','E'},
//                           {'S','F','C','S'},
//                           {'A','D','E','E'}};
//        String word = "ABCB";
        System.out.println(exist(board,word));
    }
    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int [][] dp = new int[m][n];
        for (int []d : dp) Arrays.fill(d,-1);
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (board[i][j] == word.charAt(0)){
                    if(helper(board,i,j,dp,m,n,word,0)){
                        return true;
                    }
                }
            }
        }
        return false;

    }

    public static boolean helper(char[][]board, int i, int j , int [][] dp, int m , int n,String word, int index){
        if (i<0 || i>=m || j<0 || j>=n) return false;
        if (index == word.length()) return true;
        if (dp[i][j] != -1) return dp[i][j] ==0 ? false : true;
        if (board[i][j] == word.charAt(index)){
            dp[i][j] = 0;
            boolean res =  helper(board,i,j+1,dp,m,n,word,index+1) ||
                           helper(board,i+1,j,dp,m,n,word,index+1) ||
                           helper(board,i-1,j,dp,m,n,word,index+1) ||
                           helper(board,i,j-1,dp,m,n,word,index+1);
             dp[i][j] = res== true ? 1 : 0;
             return res;
        }else {
            return false;
        }
    }
}
