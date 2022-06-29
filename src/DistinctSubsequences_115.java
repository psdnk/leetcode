import java.util.List;

public class DistinctSubsequences_115 {

    int count =0;

    public static void main(String[] args) {
        String s  = "";
    }
    public int numDistinct(String s, String t) {
        helper(s,t,0,new StringBuilder());
        return count;
    }

    public void helper(String s , String t , int index, StringBuilder sb){
        if (s.length() == index){
            if (sb.toString().equals(t)) count++;
            return;
        }
        sb.append(s.charAt(index));
        helper(s,t,index+1,sb);
        sb.deleteCharAt(sb.length()-1);
        helper(s,t,index+1,sb);
    }
}
