import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    public static void main(String[] args) {
        String [] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> hm = new HashMap<>();
        for (int i=0;i<strs.length;i++){
             char arr [] = strs[i].toCharArray();
             Arrays.sort(arr);
             String key = String.valueOf(arr);
            List<String> val;
            if(hm.containsKey(key)){
                val = hm.get(key);
                val.add(strs[i]);
                hm.put(key,val);
            }else {
                val = new ArrayList<>();
                val.add(strs[i]);
                hm.put(key,val);
            }
        }
        List<List<String>> ret = new ArrayList<>();
        hm.keySet().forEach(k ->{
            ret.add(hm.get(k));
        });

        return ret;
    }

}
