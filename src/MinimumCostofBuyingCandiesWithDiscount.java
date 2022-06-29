import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumCostofBuyingCandiesWithDiscount {
    public static void main(String[] args) {
//        int [] cost = {6,5,7,9,2,2};
        int [] cost = {3,3,3,1};
//        int [] cost = {1,2,3};
        System.out.println(minimumCost(cost));
    }
    public static int minimumCost(int[] cost) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) -> b-a);
        for (int c : cost) pq.add(c);
        int val = 0;
        while (!pq.isEmpty()){
            int e1 = !pq.isEmpty() ? pq.poll() : 0;
            int e2 = !pq.isEmpty() ? pq.poll() : 0;
            int e3 = !pq.isEmpty() ? pq.poll() : 0;
            val = val + e1 + e2;
        }
        int len = cost.length;
        if (len==1) return cost[0];
        if (len == 2) return cost[0] + cost[1];
        int minCost = 0;
        Arrays.sort(cost);
        for (int i=len-1;i>=0;i--){
            if (i%3!=0)minCost = minCost +  cost[i];
        }
        return val;

    }
}
