import java.util.ArrayList;
import java.util.Arrays;

public class IntervalIntersection {

    public static void main(String[] args) {
        int [][] A = {{0,2},{5,10},{13,23},{24,25}};
        int [][] B = {{1,5},{8,12},{15,24},{25,26}};
        int [][] C = intervalIntersection( A,B );
        for ( int i=0;i<C.length;i++ ){
            System.out.println(Arrays.toString(C[i]));
        }

    }
    public static int[][] intervalIntersection(int[][] A, int[][] B) {

        int rowA = A.length;
        int rowB = B.length;


        int i =0 ;
        int j = 0;
        int k=0;
        ArrayList<int[]> list = new ArrayList<>();
        while (i< rowA && j< rowB){
            System.out.println(i);
            int s1 = A[i][0];
            int e1 = A[i][1];
            int s2 = B[j][0];
            int e2 = B[j][1];
            if ( (s2 <= e1 && s1<=e2) && (s1<=e2 && s2<=e1)) {
                int [] C = new int[2];
                C[ 0 ] = Math.max( s1 , s2 );
                C[ 1 ] = Math.min( e1 , e2 );
                list.add( C );
            }
            if ( e1 > e2 ){
                j++;
            }else {
                i++;
            }
//                k=k+1;
//                i=i+1;
//            } else if ((s1<=e2 && s2<=e1) ){
//                C[0] = Math.max( s1,s2 );
//                C[1] = Math.min( e1,e2 );
//                list.add( C );
//                k=k+1;
//                j=j+1;
//            }else {
//                i=i+1;
//                j=j+1;
//            }

        }
        int ret [][] = new int [list.size()][2];
        for ( int ii=0;ii<list.size();ii++ ){
            ret[ii] = list.get( ii );
        }
        return ret;

    }
}
