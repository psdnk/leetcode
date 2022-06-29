public class LongestCommonSubsequence_1143 {

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde","ace"));
    }
    public static int longestCommonSubsequence(String text1, String text2) {
        int [][] dp = new int[text1.length()+1][text2.length()+1];
         return helper(text1,text2,0,0);
    }


    public static int helper(String text1, String text2, int i, int j){
        if (i>=text1.length() || j>=text2.length()) return 0;
        if (text1.charAt(i) == text2.charAt(j)){
            return 1 + helper(text1,text2,i+1,j+1);
        }else {
            return Math.max(helper(text1,text2,i+1,j),helper(text1,text2,i,j+1));
        }
    }
}
