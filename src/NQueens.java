import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class NQueens {
    List<List<String>> ret = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        List<String> path = new ArrayList<>();
        for (int i=0;i<n;i++)
            helper(0,i,1,n,path);
        return null;
    }

    public void helper(int i, int j, int count,int n,List<String> path){
        if (count == n) return;
        if (isValid(i,j,n,path)){

        }

    }

    private boolean isValid(int i, int j, int n, List<String> path) {
        return false;
    }
}
