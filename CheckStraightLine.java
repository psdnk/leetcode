public class CheckStraightLine {

    public boolean checkStraightLine(int[][] coordinates) {
        int row = coordinates.length;
        int col = coordinates[ 0 ].length;
        boolean pass = true;

        if ( row <= 2 ) {
            return true;
        }
        int x1 = coordinates[ 0 ][ 0 ];
        int y1 = coordinates[ 0 ][ 1 ];
        int x2 = coordinates[ 1 ][ 0 ];
        int y2 = coordinates[ 1 ][ 1 ];
        int m;
        if ( x2 - x1 == 0 ) {
            for ( int i = 2 ; i < row ; i++ ) {
                int x = coordinates[ i ][ 0 ];
                int y = coordinates[ i ][ 1 ];
                if ( x1 != x ) {
                    pass = false;
                    break;
                }
            }
        }
        else {
            m = ( y2 - y1 ) / ( x2 - x1 );
            int c = y1 - ( m * x1 );
            for ( int i = 2 ; i < row ; i++ ) {
                int x = coordinates[ i ][ 0 ];
                int y = coordinates[ i ][ 1 ];
                if ( y != ( ( m * x ) + c ) ) {
                    pass = false;
                    break;
                }
            }
            return pass;

        }
        return pass;
    }

    public boolean checkStraightLineV1(int[][] coordinates) {
        int row = coordinates.length;
        if ( row <=2 ){
            return true;
        }
        // y2-y1/x2-x1 = y-y1/x-x1
        int x1 = coordinates[ 0 ][ 0 ];
        int y1 = coordinates[ 0 ][ 1 ];
        int x2 = coordinates[ 1 ][ 0 ];
        int y2 = coordinates[ 1 ][ 1 ];
        int dy = y2-y1;
        int dx = x2-x1;
        for ( int i=0;i<row;i++ ){
            int x = coordinates[i][0];
            int y = coordinates[i][1];
            int ddy = y-y1;
            int ddx = x-x1;
            if ( ddy*dx != dy*ddx ){
                return false;
            }
        }
        return true;


    }

}
