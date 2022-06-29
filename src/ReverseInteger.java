import java.util.Stack;

public class ReverseInteger {

    public static void main(String[] args) {
        int res = reverse(1534236469);
        System.out.println(res);
    }
    public static int reverse(int x) {
        int sign = x<0 ? -1 : 1;
        x = Math.abs(x);
        int ret = 0;
        while (x>0){
//            System.out.println(x + " : " + ret);
            if(ret<Integer.MIN_VALUE/10 || ret>Integer.MAX_VALUE/10) return 0;
            ret = ret*10 + x%10;
            x=x/10;
        }
        return ret*sign ;
    }
}
