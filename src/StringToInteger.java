import java.util.Arrays;

public class StringToInteger {

    public static void main(String[] args) {
        String s = "4193 with words";
        System.out.println(myAtoi(s));
    }
    public static int myAtoi(String s) {
        // remove whitespaces
        // check for first character is sign
        // iterate through string until you find non digit character

        if (s.length()==0) return 0;
        int sign = 1;
        long num = 0;
        int i=0;
//        while (i<s.length() && s.charAt(i) == ' ')i++;
        s = s.trim();
        if (s.charAt(0) == '-') sign = -1;
        i = s.charAt(0) == '-' || s.charAt(0) == '+' ? 1 : 0;
        while (i<s.length()){
            char ch = s.charAt(i);
            if (!Character.isDigit(ch))break;
            num = num * 10 + ch-'0';
            if (num*sign<Integer.MIN_VALUE) return Integer.MIN_VALUE;
            if (num*sign>Integer.MAX_VALUE) return Integer.MAX_VALUE;
            i++;
        }
        return (int) num;
    }
}
