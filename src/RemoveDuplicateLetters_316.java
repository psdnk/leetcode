import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

public class RemoveDuplicateLetters_316 {
    static String ret;

    public static void main(String[] args) {
        removeDuplicateLetters("cbacdcbc");
    }
    public static String removeDuplicateLetters(String s) {

        HashMap<Character,Integer> hm = new HashMap<>();
        for (int i=0;i<s.length();i++)hm.put(s.charAt(i),i);
        System.out.println(hm);
        for (int i=0;i<s.length();i++){

        }
        return "";
//        ret = "";
//        LinkedHashSet<Character> set = new LinkedHashSet<>();
//        helper(s,0,set);
//        return ret;
    }

    private static void helper(String s, int index, LinkedHashSet<Character> set) {
        if (index >= s.length()){
            System.out.println(set.toString());
            return;
        }else {
            char c = s.charAt(index);
            if (!set.contains(c)){
                System.out.println(set);
                set.add(c);
                helper(s,index+1,set);
                set.remove(c);
            }
        }
    }
}
