import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class FindJudge {
    public int findJudge(int N, int[][] trust) {
        int row = trust.length;
        HashMap<Integer, Set<Integer>> hm = new HashMap<>();
        for ( int i=0;i<row;i++ ){
            int key = trust[i][0];
            int val = trust[i][1];
            if ( hm.containsKey( key ) ){
                Set<Integer> values = hm.get( key );
                values.add( val );
                hm.put( key,values );
            }else {
                Set<Integer> values = new HashSet<>();
                values.add( val );
                hm.put( key,values );
            }
        }
       Set<Integer> finalSet = new HashSet<>();
        Iterator<Integer> iterator = hm.keySet().iterator();
        if ( iterator.hasNext() ){
            finalSet = hm.get( iterator.next());
        }
        while (iterator.hasNext()){
            finalSet.retainAll( hm.get( iterator.next() ) );
        }
        System.out.println(finalSet.toString());
         return finalSet.isEmpty() ? -1 : finalSet.iterator().next();

    }

    public int findJudgeV1(int N, int[][] trust) {
        // 2d array to track number of turst and trusters
        int row = trust.length;
        int[][] tracker = new int[ 1 + N ][2];
        tracker[0][0] = 0;
        tracker[0][1] =0;
        for ( int i=0;i<row;i++ ) {
            int key = trust[ i ][ 0 ];
            int val = trust[ i ][ 1 ];
            tracker[key][0] = tracker[key][0] +1;
            tracker[val][1] = tracker[val][1] +1;
        }
        for ( int i=1;i<=N;i++ ){
            if(tracker[i][0] == 0 && tracker[i][1] == N-1){
                return  i;
            }
        }
        return -1;
    }
}
