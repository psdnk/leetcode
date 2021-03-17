import java.util.HashSet;

public class OrangesRotting {

    public static void main(String[] args) {

        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(grid));

    }

    public static int count = 0;
    public static int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
//        boolean[][] visited = new boolean[row][col];
//
////        for ( int i=0;i<row;i++ ){
////            for ( int j=0;j<col;j++ ){
////                if ( grid[i][j] == 2 ){
////                    dfs( grid,visited,i,j,count+1 );
////                }
////            }
////        }
//        dfs( grid,visited,0,0,0 );
//
//        return count;
        int minutes = 0;
        HashSet<String> rotten = new HashSet<>();
        HashSet<String> fresh = new HashSet<>();
        for ( int i=0;i<row;i++ ){
            for ( int j=0;j<col ;j++){
                if ( grid[i][j] == 1 ){
                    fresh.add ( ""+i + j );
                }
                if ( grid[i][j] == 2 ){
                    rotten.add ( ""+i + j );
                }
            }
        }
        int [][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        while (fresh.size () > 0){
            HashSet<String> nextInfected = new HashSet<>();
            for ( String r : rotten ){
                int i= r.charAt ( 0 ) - '0';
                int j = r.charAt ( 1 ) - '0';


                for ( int [] direction : directions ){
                    int nexti = i + direction[0];
                    int nextj = j + direction[1];
                    if ( fresh.contains ( "" + nexti + nextj ) ){
                        fresh.remove ( "" + nexti + nextj );
                        nextInfected.add ( "" + nexti + nextj );
                    }
                }
            }
            if ( nextInfected.size () == 0 ){
                return -1;
            }
            rotten.addAll(nextInfected);
            minutes++;
        }
        return minutes;

    }

    public static void dfs(int [][]grid,boolean [][]visited,int i,int j,int count){
        if ( i<0 || i>= grid.length || j<0 || j>= grid[0].length || visited[i][j] ){
            return;
        }
        if ( grid[i][j] == 1 || grid[i][j]==2) {
            grid[ i ][ j ] = 2;
            visited[ i ][ j ] = true;
            dfs( grid , visited , i - 1 , j , count + 1 );
            dfs( grid , visited , i + 1 , j , count + 1 );
            dfs( grid , visited , i , j - 1 , count + 1 );
            dfs( grid , visited , i , j + 1 , count + 1 );
        }
        System.out.println(count);
    }

}
