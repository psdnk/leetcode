import java.util.Arrays;
import java.util.HashSet;

public class PrisonCellsAfterNDays {

    HashSet<String> set = new HashSet<>();
    int size = 0;


    public static void main(String[] args) {
        int [] cells = {0,1,0,1,1,0,0,1};
        int N = 7;
        PrisonCellsAfterNDays p = new PrisonCellsAfterNDays ();
        int[] ret = p.prisonAfterNDays ( cells , N );
        System.out.println (Arrays.toString(ret));
    }
    public  int[] prisonAfterNDays(int[] cells, int N) {
        boolean found = false;
        int [] nextState = new int [8];
        for ( int i=0;i<N;i++ ){
            for ( int j = 1;j<7;j++ ){
                nextState[j] = cells[j-1] == cells[j+1] ? 1 : 0;
            }
            String s = Arrays.toString ( nextState );
            cells = nextState;
            if ( set.contains ( s ) ){
                found = true;
                N = N %size;
                prisonAfterNDays ( cells,N );
            }else {
                size++;
                set.add ( s );
            }
        }
        return cells;

    }
}
