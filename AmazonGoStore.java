import java.util.List;

public class AmazonGoStore {

    int count=0;
    public static void main(String[] args) {

    }


    int numberAmazonGoStores(int rows, int column, List<List<Integer>> grid)
    {
        // WRITE YOUR CODE HERE




        for (int i=0;i<rows;i++){
            for (int j=0;j<column;j++){
                if (grid.get(i).get(j) == 1){
                    count =count +1;
                    dfs(i,j,grid,rows,column);
                }

            }
        }
        return count;
    }


    void dfs(int i,int j,List<List<Integer>> grid,int rows,int column){

        if (i<0 || i>=rows || j<0 || j>=column || grid.get(i).get(j) == 0){
            return;
        }
        grid.get(i).set(j,0);
        dfs(i+1,j,grid,rows,column);
        dfs(i-1,j,grid,rows,column);
        dfs(i,j+1,grid,rows,column);
        dfs(i,j-1,grid,rows,column);

    }
}
