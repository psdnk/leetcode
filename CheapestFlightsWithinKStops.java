import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CheapestFlightsWithinKStops {


    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        LinkedList[] adjList = new LinkedList[n];
        for ( int i=0;i<n;i++ ){
            adjList[i] = new LinkedList<Integer>();
        }
        for ( int i=0;i<flights.length;i++ ){
            int src1 = flights[ i ][ 0 ];
            int dest1 = flights[i][1];
            int cost1 = flights[i][2];
            adjList[src1].add ( dest1 );
;        }
        return 0;
    }
}
