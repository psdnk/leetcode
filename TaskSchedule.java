import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TaskSchedule {

    public static void main(String[] args) {
        char[] tasks = {'A','A','A','A','A','A','B','C','D','E','F','G'};
        int n = 2;
        System.out.println (leastInterval ( tasks,n ) );
    }

    public static int leastInterval(char[] tasks, int n) {

        HashMap<Character, Integer> map = new HashMap<>();
        for ( char t : tasks ){
            map.put ( t,map.getOrDefault ( t,0 ) +1 );
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<> ((a,b)->(b-a));
        maxHeap.addAll ( map.values () );

        int cycles = 0;
        while (!maxHeap.isEmpty ()){
            List<Integer> temp = new ArrayList<>();
            for ( int i=0;i<n+1;i++ ){
                if ( !maxHeap.isEmpty () ) {
                    temp.add ( maxHeap.remove ( ) );
                }
            }
            for ( int i:temp ){
                if ( --i > 0 ){
                    maxHeap.add ( i );
                }
            }
            cycles += maxHeap.isEmpty ()? temp.size () : n+1;
        }
        return cycles;

    }
}
