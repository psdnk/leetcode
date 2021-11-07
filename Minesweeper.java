import java.util.Arrays;

public class Minesweeper {
    /*
     * board = {{'E','E','E','E','E'},
     *          {'E','E','M','E','E'},
     *          {'E','E','E','E','E'},
     *          {'E','E','E','E','E'}},
     * click = {3,0}
     * Output: [['B','1','E','1','B'],
     *          ['B','1','M','1','B'],
     *          ['B','1','1','1','B'],
     *          ['B','B','B','B','B']]
     *
     * */
    public static void main(String[] args) {

      char [][] board = {{'E','E','E','E','E'},
                         {'E','E','M','E','E'},
                         {'E','E','E','E','E'},
                         {'E','E','E','E','E'}};
      int [] click = {3,0};
      Minesweeper minesweeper = new Minesweeper();
      minesweeper.updateBoard(board,click);
      for (char[] b:board) System.out.println(Arrays.toString(b));
    }
    public  char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (boolean [] v : visited) Arrays.fill(v,false);
        int [][] dir = new int[][]{{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        int i = click[0];
        int j = click[1];
        if (board[i][j] == 'M'){
            board[i][j] = 'X';
            return board;
        }
        dfs(i,j,m,n,board,dir,visited);
        return board;
    }

    private  void dfs(int i, int j, int m, int n, char[][] board, int[][] dir, boolean[][] visited) {
        if (i < 0 || i >= m || j < 0 || j >= m || visited[i][j] || board[i][j] == 'M') return;
        visited[i][j] = true;
        int mines = 0;
        for (int[] d : dir) {
            int x = d[0] + i;
            int y = d[1] + j;
            if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'M') mines++;
        }
//        System.out.println(i + " : " + j + " - " + mines);
        if (mines > 0) {
            board[i][j] = (char) (mines + '0');
            return;
        }
            board[i][j] = 'B';
            for (int[] d : dir) {
                int x = d[0] + i;
                int y = d[1] + j;
                dfs(x, y, m, n, board, dir, visited);
            }

    }
}
