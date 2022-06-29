import java.util.PriorityQueue;

public class LastStoneWeight_1046 {
    public static void main(String[] args) {
        int [] stones = {2,2};
        System.out.println(lastStoneWeight(stones));
    }
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->{
            return b.compareTo(a);
        });
        for (int stone : stones)maxHeap.add(stone);
        while (maxHeap.size()>1){
            System.out.println(maxHeap);
            int first = maxHeap.poll();
            int second = maxHeap.poll();
            if (first != second)maxHeap.add(Math.abs(first-second));
        }
        return maxHeap.size()==1 ? maxHeap.poll() : 0;
    }
}
