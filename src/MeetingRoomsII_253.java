import java.util.Arrays;
import java.util.PriorityQueue;

/*
Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.



Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2
Example 2:

Input: intervals = [[7,10],[2,4]]
Output: 1


Constraints:

1 <= intervals.length <= 104
0 <= starti < endi <= 106
 */
public class MeetingRoomsII_253 {

    public static void main(String[] args) {
        int [][] intervals = {{0,30},{5,10},{15,20}};
        System.out.println(minMeetingRooms(intervals));
    }
    public static int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[1]-b[1]); // the top element will have meeting that is ending
        for (int [] interval : intervals){
            if (!minHeap.isEmpty() && minHeap.peek()[1]<=interval[0]){
                minHeap.poll();
            }
            minHeap.add(interval);
        }
        return minHeap.size();
    }

}
