import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
//        String s = "barfoofoobarthefoobarman";
//        String [] words = new String[]{"bar","foo","the"};
        String s = "ababaab";
        String [] words = new String[]{"ab","ba","ba"};
        System.out.println(findSubstring(s,words).toString());
    }
//    public static List<Integer> findSubstring(String s, String[] words) {
//        HashMap<Character,List<String>> hm = new HashMap<>();
//        int len = 0;
//        List<Integer> ret = new ArrayList<>();
//        for (String word : words){
//            char key = word.charAt(0);
//            List<String> val = hm.getOrDefault(key, new ArrayList<>());
//            val.add(word);
//            hm.put(key,val);
//            len = len + word.length();
//        }
////        len = len-1;
//        System.out.println(len);
//
//        for (int i=0;i+len<=s.length();i++){
//            String substr1= s.substring(i,i+len);
//            System.out.println(substr1 + " " + i);
//            boolean flag = true;
//            boolean [] visited = new boolean[words.length];
//            Arrays.fill(visited,false);
//            StringBuilder  substr = new StringBuilder(substr1);
//            if (hm.containsKey(substr.charAt(0))){
//                for (String word : words){
//                    System.out.print(substr + " " +word + " "+ substr.indexOf(word) + " ");
//                    System.out.println();
//                    int index = substr.indexOf(word);
//                    if (index < 0){
//                        flag =false;
//                        break;
//                    }else {
//                        substr= substr.delete(index, index+word.length() );
//                        System.out.println(substr);
//                    }
//                }
//                if (flag){
//                    ret.add(i);
//                }
//            }
//            System.out.println();
//        }
//        return ret;
//
//    }

    public static List<Integer> findSubstring(String s, String[] words){
        List<Integer> ret = new ArrayList<>();
        int len = 0;
        for (String word:words)len = len + word.length()-1;
        len = len +1;
        System.out.println(len);
        for (int i=0;i<s.length()-len;i++){
            System.out.println(s.substring(i,i+len));
        }
        return ret;
    }

    public boolean isSubstring(String s,String[] words){
        for (String word:words){
            if (!s.contains(word)) return false;
        }
        return true;
    }
}
