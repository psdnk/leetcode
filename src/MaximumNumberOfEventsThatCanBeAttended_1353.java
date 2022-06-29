import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumNumberOfEventsThatCanBeAttended_1353 {
    static PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b) -> {
        if (a[0]>b[0]) return 1;
        else if (a[0]==b[0]){
            if (a[1]<b[1]) return 1;
            else return -1;
        }else return -1;
    });

    public static void main(String[] args) {
        int [][] events = {{1,2},{2,3},{3,4},{1,2}};
        System.out.println(maxEvents(events));
    }
    public static int maxEvents(int[][] events) {
        for (int [] event :events){
            priorityQueue.add(event);
        }

        int count = 0;
        while (!priorityQueue.isEmpty()){
            int [] val = priorityQueue.poll();
            int end  = val[1];
            while (!priorityQueue.isEmpty() && end>=priorityQueue.peek()[1]){
                System.out.println(Arrays.toString(priorityQueue.poll()));
            }
            ++count;
        }
        return count;
    }
}
