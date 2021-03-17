import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class PossibleBipartition {

    public static void main(String[] args) {
    int [][] dislikes = {{1,2},{1,3},{2,3}};
        System.out.println(possibleBipartitionV1( 4,dislikes ));
    }


    public  static boolean possibleBipartitionV1(int N, int[][] dislikes) {

        ArrayList [] adjList = new ArrayList[N+1];
        for ( int i=0;i<=N;i++ ){
            adjList[i] = new ArrayList<Integer>();
        }
        //Arrays.fill( adjList, new ArrayList<Integer>() );
        for ( int i=0;i<dislikes.length;i++ ){
            int source = dislikes[i][0];
            int dest = dislikes[i][1];
            System.out.println(source + " : " + dest);
             adjList[dislikes[i][0]].add( dislikes[i][1] );
             adjList[dislikes[i][1]].add( dislikes[i][0] );
//            System.out.println(Arrays.toString(adjList));
        }
        int [] color = new int[N+1];
        Arrays.fill( color,-1 );
        int prevColor = 0;
        Queue<Integer> q = new LinkedList<>();
        for ( int i=1;i<=N;i++ ){
            if ( color[i] == -1 ){
                q.add( i );
                while (!q.isEmpty()){
                    int val = q.poll();
                    int curr = val;
                    if ( color[val] == -1 ) {
                        color[ val ] = prevColor;
                    }
                        ArrayList list = adjList[ val ];
                        for ( int j = 0 ;j<list.size();j++ ){
                            if ( color[(int)list.get( j )] == color[curr] ){
                                return false;
                            }
                            if ( color[(int)list.get( j )] == -1 ){

                                color[(int)list.get( j )] = 1-color[curr];
                                q.add( (int)list.get( j ) );
                            }
                        }
//                        prevColor = 1-prevColor;
//                        q.addAll( list );
                   // }
                }
            }
        }
        return true;

    }



    public  static boolean possibleBipartition(int N, int[][] dislikes) {


        Set<Integer> d1 = new HashSet<>();
        Set<Integer> d2 = new HashSet<>();

         for ( int i=0;i<dislikes.length;i++ ){
            int key = dislikes[i][0];
            int val = dislikes[i][1];
            if ( (d1.contains( key ) && d1.contains( val )) || (d2.contains( key ) && d2.contains( val )) ){
                return false;
            }
            else if ( d1.contains( key ) && !d2.contains( val ) ){
                d2.add( val );
            }
             else  if ( d2.contains( key ) && !d1.contains( val ) ){
                 d1.add( val );
             } else if ( d1.contains( val ) && !d2.contains( key ) ){
                d2.add( key );
            }
            else  if ( d2.contains( val ) && !d1.contains( key ) ){
                d1.add( key );
            }
             else {
                 d1.add( val );
                 d2.add( key );
            }
        }

         return true;



    }
}
