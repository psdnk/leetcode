import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PartitionLabels_763 {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ret = new ArrayList<>();
        HashMap<Character,Integer> hm = new HashMap<>();
        for (int i=0;i<s.length();i++)hm.put(s.charAt(i),i);
        int prev = -1;
        int maxi = 0;
        for (int i=0;i<s.length();i++){
            maxi = Math.max(maxi , hm.get(s.charAt(i)));
            if (maxi == i){
                ret.add(maxi-prev);
                prev = maxi;
            }
        }
        return ret;
    }
}
