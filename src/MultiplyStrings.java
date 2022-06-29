import java.util.Arrays;

public class MultiplyStrings {

    public static void main(String[] args) {
        System.out.println(multiply("123","456"));
    }
    public static String multiply(String num1, String num2) {
         int m = num1.length();
         int n = num2.length();
         if (m==0 || n==0 || num1.equals("0") || num2.equals("0")) return "0";
         if (num1.equals("1")) return num2;
         if (num2.equals("1")) return num1;
//         if (m==1 && n==1) return String.valueOf(Integer.valueOf(num1)*Integer.valueOf(num2));
         int [] ret = new int[m+n];

         for (int i=m-1;i>=0;i--){
             for (int j=n-1;j>=0;j--){
                 int product = (num1.charAt(i)-'0') * (num2.charAt(j)-'0') + ret[i+j+1];
                 ret[i+j+1] = product%10;
                 ret[i+j] += product/10;
                 System.out.println(Arrays.toString(ret));
             }
         }
         StringBuilder sb = new StringBuilder();
         for (int val : ret){
             if (sb.length() == 0 && val == 0) continue;
             sb.append(val);

         }

         return sb.toString();

    }
}
