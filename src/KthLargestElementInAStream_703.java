import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;

public class KthLargestElementInAStream_703 {
    int k;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    public KthLargestElementInAStream_703(int k, int[] nums) {
        this.k = k;
        for (int num : nums) minHeap.add(num);
    }

    public int add(int val) {
        minHeap.add(val);
        while (minHeap.size()>k)minHeap.poll();
        return minHeap.peek();
    }
}
