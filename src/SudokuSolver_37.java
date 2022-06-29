public class SudokuSolver_37 {
    public void solveSudoku(char[][] board) {
           helper(board,board.length,board[0].length);
    }

    public boolean helper(char[][]board, int row, int col){
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                if (board[i][j] == '.'){
                    for (char c='1' ;c<='9';c++){
                        if (isValid(board,i,j,c)){
                            board[i][j] = c;
                            if (helper(board,row,col)) return true;
                            else board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {

        for (int i=0;i<9;i++){
            if (board[i][col] != '.' && board[i][col] == c) return false;
            if (board[row][i] != '.' && board[row][i] == c) return false;
            if (board[3*(row/3) + i/3][3*(col/3) + i%3] != '.' &&board[3*(row/3) + i/3][3*(col/3) + i%3] == c) return false;
        }
        return true;
    }
}
