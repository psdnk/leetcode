import java.util.HashMap;
import java.util.Map;

public class ValidPalindromeII_680 {
    public static void main(String[] args) {
        System.out.println(validPalindrome("abca"));
    }
    public static boolean validPalindrome(String s) {
//        HashMap<Character,Integer> map = new HashMap<>();
//        int count = 0;
//        for (char c : s.toCharArray()){
//            map.put(c,map.getOrDefault(c,0)+1);
//        }
//        for (Map.Entry<Character,Integer> entry : map.entrySet()){
//            count = entry.getValue()%2==1 ? count +1  : count;
//        }
//        return count>2 ? false : true;
       int i=0;
       int j = s.length()-1;
       while (i<=j){
           if (s.charAt(i) == s.charAt(j)){
               i++;
               j--;
           }
           else return isPalindrome(s,i+1,j) || isPalindrome(s,i,j-1);
       }
        return true;
    }


    public static boolean isPalindrome(String s, int i, int j){
        while (i<=j){
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
