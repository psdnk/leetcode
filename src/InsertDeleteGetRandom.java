import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class InsertDeleteGetRandom {

//    int index;
    List<Integer> arr;
    HashMap<Integer,Integer> hm;
    Random random;
    public InsertDeleteGetRandom() {
//        index = 0;
        arr = new ArrayList<>();
        hm=new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (hm.containsKey(val)) return false;
        arr.add(val);
        hm.put(val,arr.size()-1);
//        index++;
        return true;
    }

    public boolean remove(int val) {
        if (!hm.containsKey(val)) return false;
        int idx = hm.get(val);
        int lastVal = arr.get(arr.size()-1);
        arr.set(idx,lastVal);
        arr.remove(idx);
        hm.remove(val);
        arr.remove(arr.size()-1);
        hm.put(lastVal,idx);
        return true;
    }

    public int getRandom() {
        int rIdx = random.nextInt(arr.size()-1);
        return arr.get(rIdx);
    }

    public static void main(String[] args) {
        InsertDeleteGetRandom obj = new InsertDeleteGetRandom();
        System.out.println(obj.insert(1));
    }
}
