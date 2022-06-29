import java.util.Arrays;
import java.util.HashMap;

public class LongestPalindromicSubstring {
    static int maxi = 0;
    static int maxj = 0;
    static int max = 0;
    public static void main(String[] args) {
//        String str = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        String str = "bb";
//        System.out.println(longestPalindrome(str));
        int [][] dp = new int[str.length()+1][str.length()+1];
        for (int []d : dp) Arrays.fill(d,-1);
        helper(str,0,str.length()-1,str.length(),dp);
        System.out.println(str.substring(maxi,maxj+1));
    }
    public static String longestPalindrome(String s) {
        int len = s.length();
        int ii=0;
        int jj=0;
        int max = 0;
        for (int i=0;i<len-1;i++){
            for (int j=len-1;j>=i+1;j--){
                String str = s.substring(i,j+1);
                if (str.length()> max && isPalindrome(str)){
                    if (max < str.length()) {
                        max = str.length();
                        ii = i;
                        jj = j;
                    }
                }
            }
        }
        return s.substring(ii,jj+1);

    }

    public static boolean isPalindrome(String s){
        int i=0;
        int j= s.length()-1;
        while (i<j){
            if (s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }else {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromev2(String s, int r, int c,HashMap<String,Boolean> hm){
        String key = r+":"+c;
        if (hm.containsKey(key)) return hm.get(key);
        int i=0;
        int j= s.length()-1;
        while (i<j){
            if (s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }else {
                hm.put(key,false);
                return false;
            }
        }
        hm.put(key,true);
        return true;
    }


    public  static int  helper(String s , int start, int end, int len, int [][] dp){
        if (start>=end || start>len || end<0) return 0;
        if (max<dp[start][end]){
            maxi=start;
            maxj =end;
        }
        if (dp[start][end] !=-1) return dp[start][end];
        if (s.charAt(start) == s.charAt(end)) return dp[start][end] = 1+helper(s,start+1,end-1,len,dp);
        else {
            return dp[start][end] = Math.max(helper(s,start+1,end,len,dp),helper(s,start,end-1,len,dp));
        }

    }
}
