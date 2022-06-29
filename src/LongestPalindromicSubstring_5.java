public class LongestPalindromicSubstring_5 {

    int maxi = Integer.MIN_VALUE;
    int maxj = Integer.MIN_VALUE;
    public String longestPalindrome(String s) {
        for (int i=1;i<=s.length();i++){
            int ret = helper(s,0,i);
        }
        return "";
    }

    public int helper(String s,int i,int j){
        if (i==j || i==s.length()) return 0;
        String substr = s.substring(i,j);
        if (isPalindrome(substr)){
            return j-i;
        }
        int left = helper(s,i,i+1);
        int right = helper(s,i+1,j);

        return Math.max(left,right);
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
}
