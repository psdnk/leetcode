import java.util.Arrays;

public class FloodFill {

    public static void main(String[] args) {
        int [][] image = {{1,1,1},{1,1,0},{1,0,1}};
        floodFill( image,1,1,2 );
        for ( int i=0;i<image.length;i++ ){
            for ( int j=0;j<image[0].length;j++ ){
                System.out.print(image[i][j]);
            }
            System.out.println();
        }
    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int row = image.length;
        int col = image[0].length;
        int [][] visited = new int[row][col];
        for ( int i= 0 ;i<row;i++ ){
            Arrays.fill( visited[i],0 );
        }
        int oldColor= image[sr][sc];
        dfs( image,sr,sc,newColor,oldColor,visited,row,col );
//        System.out.println(image.toString());
        return image;
    }

    public static void dfs(int[][] image, int sr, int sc, int newColor,int oldColor,int[][] visited,int row,int col){
        if ( sr < 0 || sc < 0 || sr >=row || sc >= col ){
            return;
        }
        if ( visited[ sr ][ sc ] != 1 && image[sr][sc] == oldColor) {
            image[sr][sc] = newColor;
            visited[sr][sc] = 1;
            dfs( image,sr+1,sc,newColor,oldColor,visited,row,col );
            dfs( image,sr-1,sc,newColor,oldColor,visited,row,col );
            dfs( image,sr,sc+1,newColor,oldColor,visited,row,col );
            dfs( image,sr,sc-1,newColor,oldColor,visited,row,col );
        }
    }
}
