import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsinAString_438 {

    public static void main(String[] args) {
        String s = "aa";
        String p = "bb";
        FindAllAnagramsinAString_438 findAllAnagramsinAString_438 = new FindAllAnagramsinAString_438();
        List<Integer> anagrams = findAllAnagramsinAString_438.findAnagrams(s, p);
        System.out.println(anagrams.toString());
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ret = new ArrayList<>();
        int window = p.length();
        for (int i=0;i<=s.length()-window;i++){
            String substr = s.substring(i,i+window);
            System.out.println(substr + " : " + p);
            if (isAnagramv1(substr,p)){
                ret.add(i);
            }
        }
        return ret;

    }

    public boolean isAnagram(String s1, String s2){
        int res = 0;
        for(int i=0;i<s1.length();i++){
            int v1 = s1.charAt(i)-'a';
            int v2 = s2.charAt(i)-'a';
            res = res^v1^v2;
        }
        return res==0 ? true : false;
    }
    public boolean isAnagramv1(String s1, String s2){
        int [] arr = new int[26];
        for (int i=0;i<s1.length();i++){
            arr[s1.charAt(i)-'a']++;
            arr[s2.charAt(i)-'a']--;
        }
        for (int i=0;i<26;i++)if (arr[i]!=0)return false;
        return true;
    }
}
