import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Set;

public class KthDistinctStringInAnArray {
    public String kthDistinct(String[] arr, int k) {
        LinkedHashMap<String,Integer> hm = new LinkedHashMap<>();
        for(String s : arr){
            hm.put(s,hm.getOrDefault(s,0)+1);
        }
        for (String key : hm.keySet()){
            if (hm.get(key) == 1){
                k--;
                if (k == 0 ) return key;
            }
        }
        return "";

    }
}
