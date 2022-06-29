import java.util.Arrays;
import java.util.HashMap;

public class ThreeSumWithMultiplicity_923 {
    public static void main(String[] args) {
        int [] arr = {1,1,2,2,3,3,4,4,5,5};
        int target = 8;
        System.out.println(threeSumMulti(arr,target));
    }
    public static int threeSumMulti(int[] arr, int target) {
        int mod = 1_000_000_007;
        long ret = 0;
        HashMap<Integer,Long> freqMap = new HashMap<>();
        for (int ele : arr)freqMap.put(ele,freqMap.getOrDefault(ele,0l)+1);
        for (Integer ele1 : freqMap.keySet()){
            for (Integer ele2 : freqMap.keySet()){
                int ele3 = target - ele1 - ele2;
                if (freqMap.containsKey(ele3)){
                    long freq1 = freqMap.get(ele1);
                    long freq2 = freqMap.get(ele2);
                    long freq3 = freqMap.get(ele3);
                    if (ele1 == ele2 && ele2== ele3){
                        ret += (freq1)*(freq1-1)*(freq1-2)/6;
                    }else if (ele1==ele2 && ele1!=ele3){
                        ret += (freq1)*(freq1-1)*freq3/2;
                    }else if (ele1<ele2 && ele2<ele3){
                        ret += (freq1)*freq2*freq3;
                    }
                }
                ret = ret%mod;
            }
        }

        return (int)ret;
    }
}
