import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MinimumDeletionsToMakeCharacterFrequenciesUnique_1647 {
    public int minDeletions(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        int count=0;
        for (char c : s.toCharArray())map.put(c,map.getOrDefault(c,0)+1);

        for (char c : map.keySet()){
            int freq = map.get(c);
            if (!set.contains(freq))set.add(freq);
            else {
                while (freq>0 && set.contains(freq)){
                    freq--;
                    count++;
                }
                if (freq>0)set.add(freq);
            }
        }
        return count;
    }
}
