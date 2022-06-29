public class CalculateDigitSumOfAString_2243 {
    public static void main(String[] args) {
        String s = "742190887044879874008";
        int k = 20;
        System.out.println(digitSum(s,k));
    }
    public static String digitSum(String s, int k) {
        if (s.length()<= k) return s;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0;i<s.length();i=i+k){
            stringBuilder.append(sum(s.substring(i,i+k>s.length()?s.length() : i+k)));
        }
        return digitSum(stringBuilder.toString(),k);
    }

    public static String sum(String num){
        int val = 0;
        System.out.println("..." +num);
        for (char c : num.toCharArray()){
            val = val + Integer.parseInt(""+c+"");
        }
        return String.valueOf(val);
    }
}
