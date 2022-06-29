import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SequentialDigits {

    public static void main(String[] args) {
        int low = 10;
        int high = 13000;
        sequentialDigits(low,high);
    }
    public static List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ret =  new ArrayList<>();
        for (int i=1;i<=9;i++) helper(0,low,high,i,ret);
        Collections.sort(ret);
        return ret;
    }
    public static void helper(int num, int low, int high, int digit,List<Integer> ret){
        num = num*10 + digit;
        if (num>high) return;
        if (num>=low) ret.add(num);
        if (digit+1<=9) helper(num,low,high,digit+1,ret);
    }
}
