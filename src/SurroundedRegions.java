import java.util.Arrays;

public class SurroundedRegions {

    public static void main(String[] args) {
        char [][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        solve(board);
    }
    public static void solve(char[][] board) {
        int m= board.length;
        int n= board[0].length;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if ((i==0 || i== m-1 || j==0 || j== n-1) && board[i][j] == 'O'){
                    dfs(board,i,j,m,n);
                }
            }
        }
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
        for (char[] c : board){
            System.out.println(Arrays.toString(c));
        }
    }
    public static void dfs(char[][] board, int i, int j, int m, int n){
        if (i<0 || i>=m || j<0 || j>=n || board[i][j] != 'O') return;
           board[i][j] = 'S';
           dfs(board, i - 1, j, m, n);
           dfs(board, i + 1, j, m, n);
           dfs(board, i, j - 1, m, n) ;
           dfs(board, i, j + 1, m, n);
    }
}
