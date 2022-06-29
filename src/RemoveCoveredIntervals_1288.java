import java.util.Arrays;
import java.util.PriorityQueue;

public class RemoveCoveredIntervals_1288 {

    public static void main(String[] args) {
        int [][] intervals = {{1,2},{1,4},{3,4}};
        System.out.println(removeCoveredIntervals(intervals));
    }
    public static int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)-> a[0] != b[0] ? a[0]-b[0] : a[1]-b[1]);
        int res = 0;
        int right = 0;
        for (int [] interval : intervals){
            if (interval[1]> right)res++;
            right=interval[1];
        }
        return res;
//        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>((a,b) -> {
//            if(a[1] < b[1]) return 1;
//            else if (a[1]> b[1]) return -1;
//            else return 0;
//        });
//        for (int []  interval : intervals){
//            priorityQueue.add(interval);
//        }
////        while (!priorityQueue.isEmpty()) System.out.println(Arrays.toString(priorityQueue.poll()));
//        int size = priorityQueue.size();
//        int [] prev = priorityQueue.poll();
//        int count = 0;
//        while (!priorityQueue.isEmpty()){
////            System.out.println(Arrays.toString(prev));
//            int [] curr = priorityQueue.poll();
//            if (prev[0] <= curr[0] && prev[1] >= curr[1])count++;
//            else prev = curr;
//        }
//        return size-count;
    }
}
