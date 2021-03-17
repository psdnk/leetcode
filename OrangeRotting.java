public class OrangeRotting {

    public static void main(String[] args) {
//        int [][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        int [][] grid = {{1,2}};
        System.out.println(orangesRotting(grid));
    }

    public static int orangesRotting(int[][] grid) {


        int col= grid[0].length;
        int row = grid.length;
        System.out.println(row);
        System.out.println(col);
        boolean changed = false;
        int count =0;
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){

                if (grid[i][j]== 2){
                    if (i-1>=0 && grid[i-1][j] != 0 && grid[i-1][j] == 1){
                        grid[i-1][j] =2;
//                        count =count +1;
                        changed = true;
                    }
                    if (i+1<row && grid[i+1][j] != 0 && grid[i+1][j] == 1){
                        grid[i+1][j] =2;
//                        count =count +1;
                        changed = true;
                    }
                    if (j-1>=0 && grid[i][j-1] != 0 && grid[i][j-1] == 1){
                        grid[i][j-1] =2;
//                        count =count +1;
                        changed = true;
                    }
                    if (j+1<col && grid[i][j+1] != 0 && grid[i][j+1] == 1){
                        grid[i][j+1] =2;
//                        count =count +1;
                        changed = true;
                    }
                    if (changed){
                        count =count +1;
                        changed =false;
                    }
                }
            }
        }

        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                if (grid[i][j]==1){
                    return -1;
                }
            }
//            System.out.println();
        }

        return count;
    }

}
