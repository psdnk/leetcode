import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class KClosest {

    public static void main(String[] args) {

//        int [][] points = {{3,3},{5,-1},{-2,4}};
        int [][] points = {{0,1},{1,0}};
        int K = 2;
        int[][] ints = kClosest( points , K );
        for ( int i=0;i<ints.length;i++ ){
            System.out.println(Arrays.toString(ints[i]));
        }

    }

    public static int[][] kClosest(int[][] points, int K) {

        TreeMap<Double,Integer> lhm = new TreeMap<>();
        ArrayList<Pair<Double, Pair<Integer, Integer>>> lll = new ArrayList<>();
//        ArrayList<Pair> list = new ArrayList<Pair>();
        for(int i=0;i<points.length;i++){
            int x = points[i][0];
            int y = points[i][1];
            double sqrt = Math.sqrt( x * x + y * y );
            Pair<Double, Pair<Integer, Integer>> doublePairPair = new Pair<Double, Pair<Integer, Integer>>( sqrt , new Pair<>( x , y ) );
            lll.add(doublePairPair);
            lhm.put( sqrt,i );
//            list.add(new Pair<Double,Integer>( sqrt,i ));
        }
        Arrays.sort( new List[]{Arrays.asList( lll )} );
        
        int [][] list = new int[K][2];
        ArrayList<ArrayList> l = new ArrayList<>();
        TreeMap<Double, Integer> collect = lhm.entrySet().stream().sorted( Map.Entry.comparingByValue() ).collect( Collectors.toMap( Map.Entry::getKey , Map.Entry::getValue , (e1 , e2) -> e1 , TreeMap::new ) );
        Iterator<Double> iterator = collect.keySet().iterator();
        int t = K-1;
        while (iterator.hasNext() && t >=0){
            Integer i = lhm.get( iterator.next() );
            list[t][0]  = points[i][0];
            list[t][1] = points[i][1];
            ArrayList<Integer> ll = new ArrayList<>();
            ll.add(points[i][0]);
            ll.add(points[i][1]);
            l.add(ll);
            t--;


        }
        return list;



    }
}
