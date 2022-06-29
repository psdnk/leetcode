import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PalindromicSubstrings_647 {

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(countSubstrings(s));
    }

    public static int countSubstrings(String s) {
        int res = 0;
        for (int i=0;i<s.length();i++){
            res = res + calculatePalindrome(i,i,s);
            res = res + calculatePalindrome(i,i+1,s);
        }
        return res;
    }

    public static int calculatePalindrome(int l, int r, String s){
        int res = 0;
        while (l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            l--; r++; res++;
        }
        return res;
    }

    public static int countSubstringsv2(String s) {
        int [][] dp = new int[s.length()+1][s.length()+1];
        Set<String> set = new HashSet<>();
        for (int[] d : dp) Arrays.fill(d,-1);
        return helper(s,0,s.length()-1,dp,set);
    }

    public static int helper(String s ,int start, int end, int[][] dp,Set<String> set){
        if(start>end) return 0;
        if (isPalindrome(s,start,end)){
            System.out.println(s.substring(start,end+1));
            //set.add(s.substring(start,end+1));
            return 1;
        }
        if (dp[start][end] != -1) return dp[start][end];
        return dp[start][end] = helper(s,start+1,end,dp,set)+
                                helper(s,start,end-1,dp,set)+
                                helper(s,start+1,end-1,dp,set);
    }


    public static boolean isPalindrome(String s, int start, int end){
        while (start<=end){
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
