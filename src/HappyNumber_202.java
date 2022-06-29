import java.util.Arrays;
import java.util.HashMap;

public class HappyNumber_202 {


    public static void main(String[] args) {
        System.out.println(isHappy(191));
    }

    static HashMap<Integer,Integer> hm = new HashMap<>();
    public static boolean isHappy(int n) {
        if (n==1) return true;
        int val = helper(n);
        if (hm.containsKey(val)) return false;
        hm.put(val,1);
        return isHappy(val);

    }

    public static int helper(int n){
        int sum =0;
        while (n>0){
            int dig = n%10;
            sum = sum + dig*dig;
            n=n/10;
        }
        return sum;
    }
}
