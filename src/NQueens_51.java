import java.util.*;

public class NQueens_51 {

    public static void main(String[] args) {
        List<List<String>> ret = solveNQueens(4);
        System.out.println(ret.toString());
    }
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> ret = new ArrayList<>();
        char [][] board = new char[n][n];
        for (char [] b : board) Arrays.fill(b,'.');
        Set<Integer> cols = new HashSet<>();
        Set<Integer> negativeDiag = new HashSet<>();
        Set<Integer> positiveDiag = new HashSet<>();
        solve(0,n,board,cols,negativeDiag,positiveDiag,ret);
        return ret;

    }

    public static void solve(int row,int n , char[][] board, Set<Integer> cols,
                             Set<Integer> negativeDiag,Set<Integer> positiveDiag,
                             List<List<String>> ret){
        if (row == n){
            List<String> r = new ArrayList<>();
            for (char [] b : board){
                String s = "";
                for (char c : b) s =s + c;
                r.add(s);
            }
            ret.add(r);
            return;
        }

        for (int c=0;c<n;c++){
            if (cols.contains(c) || negativeDiag.contains(row-c) || positiveDiag.contains(row+c)) continue;

            cols.add(c);
            negativeDiag.add(row-c);
            positiveDiag.add(row+c);
            board[row][c] = 'Q';

            solve(row+1,n,board,cols,negativeDiag,positiveDiag,ret);

            cols.remove(c);
            negativeDiag.remove(row-c);
            positiveDiag.remove(row+c);
            board[row][c] = '.';
        }
    }



}
