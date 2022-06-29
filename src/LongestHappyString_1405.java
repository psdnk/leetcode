import java.util.AbstractMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LongestHappyString_1405 {
    public static void main(String[] args) {
        System.out.println(longestDiverseString(1,1,7));
    }
    public static String longestDiverseString(int a, int b, int c) {
        StringBuilder ret = new StringBuilder();
        PriorityQueue<Map.Entry<Character,Integer>> maxHeap = new PriorityQueue<>((x,y)->{
            return Integer.compare(y.getValue(), x.getValue());
        });
        maxHeap.add(new AbstractMap.SimpleEntry<>('a',a));
        maxHeap.add(new AbstractMap.SimpleEntry<>('b',b));
        maxHeap.add(new AbstractMap.SimpleEntry<>('c',c));

        while (!maxHeap.isEmpty()){
            System.out.println(maxHeap + " : " + ret.toString() );
            Map.Entry<Character, Integer> poll = maxHeap.poll();
            if (ret.length()<2){
                ret.append(poll.getKey());
                //if (poll.getKey()!=1) maxHeap.add(new AbstractMap.SimpleEntry<>(poll.getKey(),poll.getValue()-1));
            }
            else if (ret.length()>=2 && ret.charAt(ret.length()-2)!= poll.getKey() && ret.charAt(ret.length()-1)!= poll.getKey()){
                ret.append(poll.getKey());
                //if (poll.getKey()!=1) maxHeap.add(new AbstractMap.SimpleEntry<>(poll.getKey(),poll.getValue()-1));
            }else if (ret.length()>=2 && ret.charAt(ret.length()-2)== poll.getKey() && ret.charAt(ret.length()-1)== poll.getKey()){
                    if (!maxHeap.isEmpty()){
                        Map.Entry<Character, Integer> second = maxHeap.poll();
                        ret.append(second.getKey());
                        if (second.getValue()!=1) maxHeap.add(new AbstractMap.SimpleEntry<>(second.getKey(),second.getValue()-1));
                    }
            }
            if (poll.getValue()!=1) maxHeap.add(new AbstractMap.SimpleEntry<>(poll.getKey(),poll.getValue()-1));


        }



        return ret.toString();

    }
}
