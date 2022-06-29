import java.util.*;

public class TopKFrequentElements_347 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k=3;
        int[] ret = topKFrequent(nums, k);
        System.out.println(Arrays.toString(ret));
    }
    static class Sort implements Comparator<Map.Entry<Integer,Integer>>{

        @Override
        public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
            return o2.getValue().compareTo(o1.getValue());
        }
    }
    public static int[] topKFrequent(int[] nums, int k) {
        int [] ret = new int[k];
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> map.get(b)-map.get(a));
        for (int num : nums)map.put(num,map.getOrDefault(num,0)+1);
        for (Map.Entry<Integer,Integer> entry : map.entrySet())maxHeap.add(entry.getKey());
        for (int index=0;index<k;index++)ret[index] = maxHeap.poll();
        return ret;
    }
}
