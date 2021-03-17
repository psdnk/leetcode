package october;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        int [] candidates = {2,3,6,7};
        int target = 7;
        Arrays.sort ( candidates);
        List<List<Integer>> ret = combinationSum ( candidates,target );
        for ( List<Integer> r : ret ){
            System.out.println (r.toString () );
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        findCombination ( candidates,0,target,new ArrayList<> ( ),ret );
        return  ret;

    }

public  static void findCombination(int [] candidates, int index ,  int target , List<Integer> current, List<List<Integer>> ret) {
    if ( target == 0 ) {
        // System.out.println (current );
        ret.add ( new ArrayList<> ( current ) );
        return;
    }
    if ( target < 0 ){
        return;
    }
    for ( int i = index ; i < candidates.length ; i++ ) {
        if ( target - candidates[ i ] >= 0 ) {
            current.add ( candidates[ i ] );
            findCombination ( candidates , i  , target - candidates[ i ] , current , ret );
            current.remove ( current.size ( ) - 1 );
        }
    }
}
}
