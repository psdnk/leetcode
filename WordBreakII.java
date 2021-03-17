import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreakII {
    List<String> wordDict = null;
    String s= null;

    public static void main(String[] args) {
        WordBreakII wb = new WordBreakII ();
//        String s = "catsanddog";
//        List<String> wordDict = Arrays.asList ("cat", "cats", "and", "sand", "dog");
        String s = "pineapplepenapple";
        List<String> wordDict = Arrays.asList ("apple", "pen", "applepen", "pine", "pineapple");
        System.out.println (wb.wordBreak ( s,wordDict ) );
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        this.s = s;
        this.wordDict = wordDict;
        int length = s.length ();
        List<String> [] result = new ArrayList[length]; //stores list of String for every position
        helper(0,length,result);
        return result[0];
    }
    public List<String> helper(int position,int length,List<String>[] result){
        if ( result[position] != null ){
            return result[position];
        }
        List<String> postr = new ArrayList<>();
        for ( String w : wordDict ){
            if ( s.startsWith ( w,position ) ){
                if ( position + w.length () == length ){
                    postr.add(w);
                    continue;
                }
                List<String> tempList = helper ( position + w.length (),length,result );
                for ( String r : tempList ){
                    postr.add (w+" "+r);
                }
            }
        }
        result[position] = postr;
        return postr;
    }
}
