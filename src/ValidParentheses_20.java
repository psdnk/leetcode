public class ValidParentheses_20 {
    public boolean isValid(String s) {
        int b1=0,b2=0,b3=0;
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if (c == '(')b1++;
            else if (c== ')'){
                if (b1==0) return false;
                else b1--;
            }
            if (c == '[')b2++;
            else if (c== ']'){
                if (b2==0) return false;
                else b2--;
            }
            if (c == '{')b3++;
            else if (c== '}'){
                if (b3==0) return false;
                else b3--;
            }
        }
        return b1==0&&b2==0&&b3==0 ? true : false;

    }
}
