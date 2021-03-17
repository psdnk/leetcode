import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

class FirstUnique {

    HashMap<Integer,Integer> hm;
    Set<Integer> set;
    public FirstUnique(int[] nums) {
        hm = new HashMap<>();
        set =new LinkedHashSet<>();
        for (int n : nums){
            if (hm.containsKey(n)){
                hm.put(n,hm.get(n)+1);
            }else {
                hm.put(n,1);
            }
            set.add(n);

        }

    }

    public int showFirstUnique() {
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            int key = iterator.next();
            if (hm.get(key) == 1){
                return key;
            }
        }
        return -1;
    }

    public void add(int value) {
        if (hm.containsKey(value)){
            hm.put(value,hm.get(value)+1);
        }else {
            hm.put(value,1);
        }
        set.add(value);

    }
}