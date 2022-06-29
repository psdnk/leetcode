import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MergeIntervals_56 {


    public static void main(String[] args) {
        int [][] intervals = {{1,3},{8,10},{15,18},{2,6}};
        int[][] merge = merge(intervals);
        for (int [] m : merge) System.out.println(Arrays.toString(m));
    }
    public static int[][] merge(int[][] intervals) {
        List<int[]> ret = new ArrayList<>();
        Arrays.sort(intervals,(a,b)->{
            return a[0]-b[0];
        });
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int [] interval : intervals) {
            if (interval[0]<=end){
                end = Math.max(end, interval[1]);
            }else {
                ret.add(new int[]{start,end});
                start = interval[0];
                end = interval[1];
            }
        }
        ret.add(new int[]{start,end});
        return ret.toArray(new int[ret.size()][2]);
    }
}
