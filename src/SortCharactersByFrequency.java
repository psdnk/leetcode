import java.util.*;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        String s = "tree";
        System.out.println(frequencySort(s));
    }
    public static String frequencySort(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        for (char c: s.toCharArray())hm.put(c,hm.getOrDefault(c,0)+1);
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b) -> {
            return hm.get(b)-hm.get(a);
        });
        pq.addAll(hm.keySet());
        StringBuilder sb= new StringBuilder();
        while (!pq.isEmpty()){
            char c =pq.poll();
            for (int i=0;i<hm.get(c);i++)sb.append(c);
        }
        return sb.toString();

    }
}
