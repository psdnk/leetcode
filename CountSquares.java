public class CountSquares {

    public static void main(String[] args) {
        int [][] matrix = { {0 , 1 , 1 , 1},
                            {1 , 1 , 1 , 1},
                            {0 , 1 , 1 , 1}};
        System.out.println(countSquares( matrix ));
    }

    public static int countSquares(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int [][] count = new int[row+1][col+1];
        int sum = 0;
        for ( int i=0;i<row;i++ ){
            for ( int j=0;j<col;j++ ){
                if(matrix[i][j] == 1) {
                    count[ i + 1 ][ j + 1 ] = Math.min( Math.min( count[ i ][ j + 1 ] , count[ i + 1 ][ j ] ) , count[ i ][ j ] ) + matrix[ i ][ j ];
                    sum = sum + count[ i + 1 ][ j + 1 ];
                }
            }
        }
        return sum;

    }
}
