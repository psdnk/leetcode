import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestHappyPrefix_1392 {

    public static void main(String[] args) {
        String s = "ababab";
        System.out.println(longestPrefix(s));
    }
    static int max= 0;
    static String ret;
    public static String longestPrefix(String s) {
        HashSet<String> set = new HashSet<>();
        helper(s,0,set,false);
        helper(s,s.length()-1,set,true);
        return ret;
    }

    public static void helper(String s , int index , HashSet<String> set,boolean check){
        if (!check && index>=s.length()-1) return;
        if (check && index<=0) return;
        String sub = check== false ? s.substring(0,index+1) : s.substring(index,s.length());
//        System.out.println(sub);
        if (check){
            if (set.contains(sub) && sub.length()>max) {
                max = sub.length();
                ret = sub;
            }
            helper(s,index-1,set,check);
        }else {
            set.add(sub);
            helper(s,index+1,set,check);
        }
    }
}
