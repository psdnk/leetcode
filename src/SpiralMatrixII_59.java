import java.util.Arrays;

public class SpiralMatrixII_59 {
    public static void main(String[] args) {
        int n  = 3;
        int[][] ret = generateMatrix(n);
        for (int []r : ret) System.out.println(Arrays.toString(r));
    }
    public static int[][] generateMatrix(int n) {
        int top = 0, bottom = n-1 , left = 0, right = n-1 ,index = 1;
        int [][] matrix = new int[n][n];
        while (top<=bottom && left<=right){
             for (int i=left;i<=right;i++) matrix[top][i] = index++;
             top++;
             for (int i=top;i<=bottom;i++) matrix[i][right] = index++;
             right--;
             for (int i=right;i>=left;i--) matrix[bottom][i]=index++;
             bottom--;
             for (int i=bottom;i>=top;i--) matrix[i][left]=index++;
             left++;
        }
        return matrix;
    }
}
