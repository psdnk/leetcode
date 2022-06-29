import java.util.Arrays;
import java.util.HashSet;

public class LengthOfLongestSubstring_3 {

    public static void main(String[] args) {
        String s = "dvdf";
        int ret = lengthOfLongestSubstring(s);
        System.out.println(ret);

    }
    public static int lengthOfLongestSubstring(String s) {
        int [] dp = new int[s.length()];
        Arrays.fill(dp,-1);
        int max = 0;
        for (int i=0;i<s.length();i++){
            max = Math.max(max,helper(s,i,new HashSet<>(),0,dp));
        }
        return max;
    }

    public static int helper(String s, int i, HashSet<Character> set,int count, int[] dp){
        System.out.println(count);
        if (i==s.length()) return count;
        if (dp[i] !=-1) return dp[i];
        if (set.contains(s.charAt(i))) return dp[i] = count;
        else {
            set.add(s.charAt(i));
            return dp[i]=helper(s,i+1,set,count+1,dp);
        }
    }
}
