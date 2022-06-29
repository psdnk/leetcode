import java.util.HashMap;
import java.util.HashSet;

public class DecodeWays_91 {

    static HashSet<String> set;
    public static void main(String[] args) {
        String s = "12";
        System.out.println(numDecodings(s));
    }
    public static int numDecodings(String s) {
        set = new HashSet<>();
        for (int i=1;i<=26;i++)set.add(""+i+"");
       return helperv2(s,0);
    }

    public static int helper(String s, int index){
        if (index == s.length()) return 1;
        if (index > s.length()) return 0;
        int jumpOne = helper(s, index+1);
        int jumpTwo = index+1<s.length() && isValid(s.charAt(index) +"" +  s.charAt(index+1)) ? helper(s,index+2) : 0;
        return jumpOne+jumpTwo;
    }

    public static boolean isValid(String str){
        int val = Integer.parseInt(str);
        System.out.println(str);
        return set.contains(str);
    }

    public static int helperv2(String s, int index){

        if (index>=s.length()) return 0;
        if (index == s.length()-1) return 1;

        int result = helperv2(s,index+1);
        if (index<s.length()-1 &&
                Integer.parseInt(s.substring(index,index+2))<=26 &&
                Integer.parseInt(s.substring(index,index+2))>=10)
        result = result +  helperv2(s,index+2);
return result;
    }
}
