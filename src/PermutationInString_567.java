import java.util.HashMap;

public class PermutationInString_567 {
    public static void main(String[] args) {
//        String s1 = "ab";
//        String s2 = "eidbaooo";
        String s1 = "qff";
        String s2 = "ifisnoskikfqzrmzlv";
        System.out.println(checkInclusion(s1,s2));
    }
    public static boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer> hm = new HashMap<>();
        int len1 = s1.length();
        int len2 = s2.length();
        for(char c : s2.toCharArray())hm.put(c,hm.getOrDefault(c,0)+1);
        for(char c : s1.toCharArray()){
            if(hm.containsKey(c) && hm.get(c)>0) hm.put(c,hm.get(c)-1);
            else return false;
        }
        for (int i=0;i<=len2-len1;i++){
            String x = s2.substring(i,i+len1);
            if (isEqual(x,s1)) return true;
        }
        return false;
    }
    public static boolean isEqual(String x, String y){
        int val = 0;
        for (int i=0;i<x.length();i++){
            val ^=x.indexOf(x.charAt(i));
            val ^=y.indexOf(y.charAt(i));
        }
        System.out.println(x + " : " + y + " : " + val);
        return val==0 ? true : false;
    }
}
