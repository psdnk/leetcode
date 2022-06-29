import java.util.Arrays;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean [] visited = new boolean[10];
        Arrays.fill(visited,false);
        int m = board.length;
        int n = board[0].length;
        for (int i=0;i<m;i++){
            Arrays.fill(visited,false);
            for (int j=0;j<n;j++){
                if (visited[board[i][j]]) return false;
                visited[board[i][j]] = true;
            }
        }
        for (int i=0;i<n;i++){
            Arrays.fill(visited,false);
            for (int j=0;j<m;j++){
                if (visited[board[i][j]]) return false;
                visited[board[i][j]] = true;
            }
        }
        for (int i=0;i<n;){
            for (int j=0;j<m;){
                Arrays.fill(visited,false);
                for (int k=i;k<i+3;k++){
                    for (int q=j;q<j+3;q++){
                        if (visited[board[k][q]]) return false;
                        visited[board[k][q]] = true;
                    }
                }
            }
        }
        return false;
    }
}
