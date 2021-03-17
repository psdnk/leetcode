import java.util.Arrays;

public class SurroundedRegions {

    public static void main(String[] args) {
//        char[][] board = {
//                {'X' , 'X' , 'X' , 'X'} ,
//                {'X' , 'O' , 'O' , 'X'} ,
//                {'X' , 'X' , 'O' , 'X'} ,
//                {'X' , 'O' , 'X' , 'X'}
//        };
//        char[][] board = {
//                {'X' , 'X' } ,
//                {'X' , 'O' }
//        };
//        char[][] board = {{'O','X','X','O','X'},{'X','O','O','X','O'},{'X','O','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}};

        char [][] board = {{'O','X','O','O','O','X'},{'O','O','X','X','X','O'},{'X','X','X','X','X','O'},{'O','O','O','O','X','X'},{'X','X','O','O','X','O'},{'O','O','X','X','X','X'}};

        for ( int i=0;i<board.length;i++ ){
            System.out.println ( Arrays.toString (board[i]));
        }
        System.out.println ();
       //solve ( board );
        solveV1(board);
    }

    public static void solve(char[][] board) {
        int row = board.length;
        if ( row <=0  ){
            return;
        }
        int col = board[0].length;
        boolean [][] visited = new boolean[row][col];
//        for ( int i=0;i<row;i++ ){
//            Arrays.fill ( visited[i],false );
//        }

        for ( int i=0;i<row;i++ ){
            for ( int j=0;j<col;j++ ){
                if ( board[i][j]=='O' && !visited[i][j]){
                    visited[i][j] = true;
                    board[i][j] = 'X';
                    if ( ! dfs(board,i,j,visited)){
                        board[i][j] = 'O';
                    }
                    //visited[i][j] = true;
                }
            }
        }
        for ( int i=0;i<row;i++ ){
            System.out.println ( Arrays.toString (board[i]));
        }

    }

    public static boolean dfs(char[][] board,int i,int j,boolean[][]visited){
        System.out.println (i + " : " +  j);
        for ( int k=0;k<board.length;k++ ){
            System.out.println ( Arrays.toString (board[k]));
            System.out.println ( Arrays.toString (visited[k]));
        }
        System.out.println ("--------------------");
        if ( i<1 || i>=board.length-1 || j<1 || j>=board[0].length-1){
            return false;
        }
//        if(board[i][j] == 'X' && !visited[i][j]){
//            return false;
//        }
        if ( board[i][j] == 'O' ) {
            board[ i ][ j ] = 'X';
        }
        visited[i][j] = true;


        if (( board[ i - 1 ][ j ] == 'X' || dfs ( board , i - 1 , j,visited )) &&
                ( board[ i + 1 ][ j ] == 'X' || dfs ( board , i + 1 , j,visited )) &&
                ( board[ i ][ j - 1 ] == 'X' || dfs ( board , i , j - 1 ,visited)) &&
                ( board[ i ][ j + 1 ] == 'X' || dfs ( board , i , j + 1,visited ))){
            return true;
        }else{
            board[i][j] = 'O';
//            visited[i][j] = false;
            return false;
        }
    }


    public static void dfsV1(char[][]board,int i,int j){

            if ( board[ i ][ j ] == 'O' ) {
                board[ i ][ j ] = '1';
                if(i>1)dfsV1 ( board , i - 1 , j );
                if(i+1 < board.length)dfsV1 ( board , i + 1 , j );
                if(j>1)dfsV1 ( board , i , j - 1 );
                if(j+1 < board.length)dfsV1 ( board , i , j + 1 );
            }

    }

    public static void solveV1(char[][] board) {

        //mark boundary
        int row = board.length;
        if ( row <=0 ){
            return;
        }
        int col = board[0].length;

        for ( int i=0;i<row;i++ ){
            dfsV1 ( board,i,0 );
            dfsV1 ( board,i,col-1 );
        }
        for ( int j = 1;j<col-1;j++ ){
            dfsV1 ( board,0,j );
            dfsV1 ( board,row-1,j );
        }
        for ( int i =0;i<row;i++ ){
            for ( int j=0;j<col;j++ ){
                if ( board[i][j] == 'O' )board[i][j] = 'X';
                if ( board[i][j] == '1' )board[i][j] = 'O';
            }
        }

        for ( int i=0;i<row;i++ ){
            System.out.println ( Arrays.toString (board[i]));
        }


    }
}
