import java.util.LinkedHashMap;

class LRUCache {

    LinkedHashMap<Integer,Integer> hm;
    int capacity;
    public LRUCache(int capacity) {
        hm = new LinkedHashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        if(hm.containsKey(key)){
            int val = hm.get(key);
            makeRecent(key,val);
            return val;
        }
        return -1;

    }

    public void put(int key, int value) {
        if (hm.size()>=capacity){
            hm.remove(0);
            hm.put(key,value);
        }else{
            makeRecent(key,value);
        }

    }

    public void makeRecent(int key, int val){
        hm.remove(key);
        hm.put(key,val);
    }
}
