public class KthSmallestNumberInMultiplicationTable {
    public int findKthNumber(int m, int n, int k) {
        int low = 1;
        int high = m*n;
        while (low<high){
            int mid = low + (high - low)/2;
            if (!(enough(m,n,mid) >= k)){
                low = mid + 1;
            }else high = mid-1;
        }
        return low;
    }

    private int enough(int m, int n, int mid) {
        int count = 0;
        for (int i=1;i<=m;i++){
            count = count + Math.min(mid/i,n);
        }
        return count;
    }
}
