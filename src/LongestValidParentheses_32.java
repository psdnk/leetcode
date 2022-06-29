public class LongestValidParentheses_32 {

    public static void main(String[] args) {
        String s = "()(()";
        System.out.println(longestValidParentheses(s));
    }
    public static int longestValidParentheses(String s) {
        int open = 0, close = 0, max = 0;
        for (int i=0;i<s.length();i++){
            open = s.charAt(i) == '(' ? open+1 : open;
            close = s.charAt(i) == ')' ? close+1 : close;
            if (open == close) max = Math.max(max,open+close);
            if (close>open)close =0;open= 0;
        }
        open = 0; close=0;
        for (int i=s.length()-1;i>=0;i--){
            open = s.charAt(i) == '(' ? open+1 : open;
            close = s.charAt(i) == ')' ? close+1 : close;
            if (open == close) max = Math.max(max,open+close);
            if (open>close)close =0;open= 0;
        }

        return max;

//        return helper(s,0,0,0);
    }


    public static int helper(String s, int index, int open, int close){
        System.out.println(open + " : " + close);
        if (index == s.length()){
            if (open == close) return open+close;
            else return 0;
        }
        if ( index>=s.length()){
            return 0;
        }

        if (close>open){
            open=0;close=0;
        }
            return Math.max(helper(s,index+1,open,close),
                    helper(s,index+1,s.charAt(index)=='(' ? open+1:open, s.charAt(index)==')' ? close+1:close ));

        //open =s.charAt(index)=='(' ? open+1:open;


    }
}
