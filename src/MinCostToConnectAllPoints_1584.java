import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class MinCostToConnectAllPoints_1584 {
    public static void main(String[] args) {
        int [][] points = {{3,12},{-2,5},{-4,1}};
        System.out.println(minCostConnectPoints(points));
    }
    public static int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> (a[2] - b[2]));

        int cost = 0;

        // StartId, EndId, DistanceBetweenStartToEnd
        pq.offer(new int[] {0, 0, 0});

        Set<Integer> visited = new HashSet<Integer>();

        int num = points.length;
        while(!pq.isEmpty() && visited.size() < num ) {
            int[] curr = pq.poll();
            int endId = curr[1];
            int currCost = curr[2];
            if (visited.contains(curr[1])) continue;


            cost += currCost;
            visited.add(endId);
            for (int i = 0 ; i < num ; i++) {
                if (!visited.contains(i)) {
                    pq.offer(new int[] {endId, i, distance(points, endId, i)});
                }
            }
        }

        return cost;

    }
    private static int distance(int[][] points, int i, int j) {
        return Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
    }
}
