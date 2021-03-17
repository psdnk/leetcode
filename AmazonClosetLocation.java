import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class AmazonClosetLocation {


    class PairInt {
        int first, second;
        PairInt(){};
        PairInt(int first,int second){
            this.first=first;
            this.second = second;
        }
    }
    List<PairInt> closestLocations(int totalCrates,
                                   List<PairInt> allLocations,
                                   int truckCapacity)
    {
        // WRITE YOUR CODE HERE
        PriorityQueue<Double> queue = new PriorityQueue<> ();
        HashMap<Double,PairInt> hm  = new HashMap<Double , PairInt> ();
//       for ( int i=0;i<allLocations.;i++ ){
//           PairInt p
//       }
        for ( PairInt p : allLocations ){
            double sqrt = Math.sqrt ( Math.pow ( p.first , 2 ) + Math.pow ( p.second , 2 ) );
            if ( hm.containsKey ( sqrt ) ){
                sqrt = sqrt + 0.0000000000001;
            }
            hm.put ( sqrt,p );
            queue.add ( sqrt );
        }
        List<PairInt> ret = new ArrayList<>();
        while (truckCapacity>0 && !queue.isEmpty ()){
            ret.add ( hm.get ( queue.poll ()) );
            truckCapacity--;

        }
        return ret;
    }

}
