import java.util.PriorityQueue;

public class KthLargestElementInAnArray_215 {
    public static void main(String[] args) {
        int [] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(findKthLargest(nums,k));
    }
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> {
            return b.compareTo(a);
        });

        for(int num : nums)pq.add(num);
        System.out.println(pq);
        while (k>1){
            pq.poll();
            k--;
        }
        return pq.peek();
    }
}
