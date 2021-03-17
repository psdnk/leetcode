import java.util.Arrays;
import java.util.Comparator;

public class EraseOverlapIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        if ( intervals.length == 0 ){
            return 0;
        }
        Arrays.sort ( intervals , new Comparator<int[]> ( ) {
            @Override
            public int compare(int[] o1 , int[] o2) {
                return o1[0]-o2[0];
            }
        } );

        int result = 0;
        int prevEnd = intervals[0][1];
        for ( int i=1;i<intervals.length;i++ ){
            if ( prevEnd <=intervals[i][0] ){
                prevEnd = intervals[i][1];
            }else if ( prevEnd > intervals[i][0] && prevEnd >= intervals[i][1] ){
                result++;
                prevEnd = intervals[i][1];
            }else {
                result++;
            }
        }
        return result;
    }
}
