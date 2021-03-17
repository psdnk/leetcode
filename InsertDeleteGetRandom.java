import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

public class InsertDeleteGetRandom {
    HashMap<Integer, Integer> hashMap;
    ArrayList<Integer> arrayList;

    public InsertDeleteGetRandom(){
         hashMap = new HashMap<>();
         arrayList = new ArrayList<>();
    }

    public boolean insert(int val) {
        if ( hashMap.containsKey ( val ) ){
            return false;
        }else {
            hashMap.put ( val,1 );
            return true;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if ( hashMap.containsKey ( val ) ){
            hashMap.remove ( val );
            return true;
        }else {
            return false;
        }


    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random r = new Random();
        return (int)hashMap.keySet ().toArray ()[ r.nextInt ( hashMap.keySet ().size () ) ];
    }

}
