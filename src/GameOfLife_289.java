import java.util.Arrays;

public class GameOfLife_289 {
    public static void main(String[] args) {
        int [][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gameOfLife(board);
    }
    public static void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int [][] dir = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                int count  = getLiveCellCount(i,j,dir,board,m,n);
                if (board[i][j] == 1 && (count<2 || count>3)) board[i][j] = -1;
                if (board[i][j] == 0 && count==3) board[i][j] = 2;
            }
        }
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (board[i][j] == -1) board[i][j] =0;
                if (board[i][j] == 2) board[i][j] =1;
            }
        }
        for (int i=0;i<m;i++) System.out.println(Arrays.toString(board[i]));
    }

    private static int getLiveCellCount(int i, int j, int[][] dir,int[][] board, int m, int n) {
        int count =0;
        for (int [] d : dir){
            int r = i + d[0];
            int c = j + d[1];
            if (r>=0 && r<m && c>=0 && c<n && Math.abs(board[r][c]) == 1)count++;
        }
        return count;
    }
}
