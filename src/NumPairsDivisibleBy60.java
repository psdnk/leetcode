import java.util.Arrays;
import java.util.HashMap;

public class NumPairsDivisibleBy60 {
    public static void main(String[] args) {
        int [] time = {30,20,150,100,40};
        System.out.println(numPairsDivisibleBy60(time));
    }
    public static int numPairsDivisibleBy60(int[] times) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int res = 0;
        int K = 60;
        for (int i=0;i<times.length;i++){
            int time = times[i] % K;
            int rem = (K-time) % K;
            res = res + map.getOrDefault(rem,0);
            map.put(time,map.getOrDefault(time,0)+1);
        }
        return res;
    }
}
