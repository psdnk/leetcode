import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        List<String> result = generateParenthesis(3);
        System.out.println(result.toString());
    }
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(n,result,0,0,new StringBuilder());
        return result;

    }
    public static void dfs(int n, List<String> result, int open , int close,StringBuilder sb){
        if (open==close && open==n)result.add(sb.toString());
        if (open>n || close>n || close>open) return;
        if (open>close){
            sb.append(')');
            dfs(n,result,open,close+1,sb);
            sb.setLength(sb.length()-1);
        }
        sb.append('(');
        dfs(n,result,open+1,close,sb);
        sb.setLength(sb.length()-1);
    }
}
