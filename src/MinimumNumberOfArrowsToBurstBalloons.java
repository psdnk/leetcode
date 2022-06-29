import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumNumberOfArrowsToBurstBalloons {
    public static void main(String[] args) {
        int [][] points = {{10,16},{2,8},{1,6},{7,12}};
        System.out.println(findMinArrowShots(points));
    }
    public static int findMinArrowShots(int[][] points) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        for (int []point : points){
            priorityQueue.add(point);
        }
        int count =0;
        if (priorityQueue.isEmpty()) return 0;
        while (!priorityQueue.isEmpty()){
            int [] x = priorityQueue.poll();
            while (!priorityQueue.isEmpty() && x[1]>=priorityQueue.peek()[0] && x[1]<=priorityQueue.peek()[1]){
                priorityQueue.poll();
            }
            count++;
//            System.out.println(Arrays.toString(priorityQueue.poll()));
        }
        return count;
    }
}
