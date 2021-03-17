import java.util.Arrays;
import java.util.Scanner;

public class SetMatrixZeroesLeetcode {


    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        System.out.println("Enter row : - ");
        int row= s.nextInt();
        System.out.println("Enter col : - ");
        int col= s.nextInt();
        int matrix[][]=new int[row][col];
        for(int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                matrix[i][j]=s.nextInt();
            }
        }

        //SetMatrixZeroesLeetcode setMatrixZeroesLeetcode= new SetMatrixZeroesLeetcode();
      setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));

    }

    public static  void  setZeroes(int[][] matrix) {
        Scanner s= new Scanner(System.in);
        int row=matrix.length;
        int col=matrix[0].length;
        int tempMatrix[][]=new int[row][col];
       for (int temp[] : tempMatrix){
           Arrays.fill(temp,-1);
       }
//        Arrays.fill(tempMatrix,-1);
        for(int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                if(matrix[i][j] != 0 && tempMatrix[i][j] !=0){
                    tempMatrix[i][j]=matrix[i][j];
                }else if( matrix[i][j] == 0) {
                    //Arrays.fill(tempMatrix[i],0,matrix[0].length,0);
                    //Arrays.fill(tempMatrix[i][],0,matrix[0].length,0);
                    for (int k=0;k<col;k++)
                        tempMatrix[i][k]=0;
                    for (int k=0;k<row;k++)
                        tempMatrix[k][j]=0;
                }
            }
        }

       /* for(int i=0;i<row;i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(tempMatrix[i][j] + " ");
            }
            System.out.println();
        }*/
        //System.out.println(Arrays.deepToString(tempMatrix));
        //matrix=tempMatrix.clone();
        //System.out.println(Arrays.deepToString(matrix));

        for(int i=0;i<row;i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = tempMatrix[i][j];
            }
        }


    }
}
