public class SearchA2DMatrix_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int low  = 0;
        int high = row*col -1;

        while (low<=high){
            int mid = low + (high-low)/2;
            if (matrix[mid/col][mid%col] == target) return true;
            else if (target< matrix[mid/col][mid%col]) high = mid-1;
            else  low = mid+1;
        }
        return false;
    }
}
