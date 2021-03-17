import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class PrintVertically {
    public static void main(String[] args) {
        String s = "TO BE OR NOT TO BE";
        List<String> strings = printVertically( s );
        for ( int i = 0 ; i < strings.size() ; i++ ) {
            String s2 = strings.get( i );
            System.out.println( s2 );

        }
    }

    public static List<String> printVertically(String s) {
        String[] s1 = s.split( " " );
        int col = 0;
        int row = s1.length;
        for ( String value : s1 ) {
            col = Math.max( value.length(), col );
        }
        String[][] arr = new String[ row ][ col ];
        for ( int i = 0 ; i < row ; i++ ) {
            Arrays.fill( arr[ i ], " " );
        }
        for ( int i = 0 ; i < row ; i++ ) {
            for ( int j = 0 ; j < col ; j++ ) {
                if ( j < s1[ i ].length() )
                    arr[ i ][ j ] = String.valueOf( s1[ i ].charAt( j ) );
            }
        }

        String regex = "\\s+$";
        List<String> ret = new ArrayList<>();
        for ( int j = 0 ; j < col ; j++ ) {
            StringBuilder sb = new StringBuilder();
            for ( int i = 0 ; i < row ; i++ ) {
//                System.out.print(arr[i][j] + " ");
               // if ( ! Objects.equals( arr[ i ][ j ], " " ) ) {
                    sb.append( arr[ i ][ j ] );
//                } else {
//                    if ( Objects.equals( arr[ i ][ j ], " " ) && sb.length() == 0 ) {
//                        sb.append( " " );
//                    }
//                }
            }
            ret.add( sb.toString().replaceAll( regex,"" ) );
        }

//        for ( int i=0;i<row;i++ ){
//            for ( int j=0;j<col;j++ ){
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }
//        for ( int i=0;i<row;i++ ) System.out.println( arr[ i ][0] );

        return ret;
    }

}
