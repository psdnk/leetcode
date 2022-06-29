import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;

public class LFUCache_460 {
    HashMap<Integer,Integer> map;
    TreeMap<Integer, LinkedList<Integer>> counterMap;
    HashMap<Integer,Integer> freqMap;
    int capacity;
    public LFUCache_460(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        counterMap = new TreeMap<>();
        freqMap = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        int val = map.get(key);
        update(key);
        return val;
    }

    public void put(int key, int value) {
        if (map.size()>=capacity){
            remove();
        }
        capacity++;
        map.put(key,value);
        update(key);
    }
    public void update(int key){
        int freq = -1;
       // if (freqMap.containsKey(key)){
            freq = freqMap.getOrDefault(key,0);
            freqMap.put(key,freq+1);
       // }
        //if (counterMap.containsKey(freq)){
            LinkedList<Integer> keys = counterMap.getOrDefault(freq, new LinkedList<>());
            if(keys.size() >0 && keys.indexOf(key)>=0){
                keys.remove(keys.indexOf(key));
                counterMap.put(freq,keys);
            }
            counterMap.computeIfAbsent(freq+1,k->new LinkedList<>()).add(key);
        //}
    }
    
    public void remove(){
        capacity--;
        if(counterMap.size()>0){
            LinkedList<Integer> keys = counterMap.get(counterMap.firstKey());
            Integer key = keys.removeFirst();
            map.remove(key);
            counterMap.remove(key);
        }

    }
}
