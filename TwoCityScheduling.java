import javafx.util.Pair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TwoCityScheduling {


    public static void main(String[] args) {
        int[][] costs= {{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}};
        System.out.println(twoCitySchedCost( costs ));

    }
    public static int twoCitySchedCost(int[][] costs) {
        PriorityQueue<Pair<Integer, Integer >> minHeap1 = new PriorityQueue<>( new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1 , Pair<Integer, Integer> o2) {
                return (o1.getKey()-o1.getValue()) -(o2.getKey()-o2.getValue());
            }
        } );
        for(int i=0;i<costs.length;i++){
            Pair<Integer, Integer> p = new Pair<>( costs[i][0],costs[i][1] );
            minHeap1.add(p);
        }
        int N = costs.length;
        int k=1;
        int minCost = 0;
        while (!minHeap1.isEmpty()){
            if ( k<= N/2 ){
                minCost = minCost + minHeap1.poll().getKey();
            }else {
                minCost = minCost + minHeap1.poll().getValue();
            }
            k++;
        }
        

        return minCost;
    }
}
