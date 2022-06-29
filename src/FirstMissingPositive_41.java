import java.util.PriorityQueue;

public class FirstMissingPositive_41 {
    public static void main(String[] args) {
        int [] nums = {3,4,-1,1};
        System.out.println(firstMissingPositive(nums));
    }
    public static int firstMissingPositive(int[] nums) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int num : nums) priorityQueue.add(num);
        while (!priorityQueue.isEmpty() && priorityQueue.peek()<=0)priorityQueue.poll();
        int index = 1;
        while (!priorityQueue.isEmpty() && priorityQueue.peek().equals(index)){
            while (!priorityQueue.isEmpty() && priorityQueue.peek().equals(index))priorityQueue.poll();
            index++;
        }
        return index;
    }
}
