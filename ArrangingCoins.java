public class ArrangingCoins {

    public static void main(String[] args) {
//        int temp = n;
//        if(n == 1){
//            return 1;
//        }
//        for(int i=1;i<=n;i++){
//            temp = temp-i;
//            if(temp < 0){
//                return i-1;
//            }
//        }
//        return 0;
        System.out.println (arrangeCoins ( 2 ));
    }
    public  static int arrangeCoins(int n) {
        int low = 1;
        int high = n;

        while (low<high){
            int mid = low + (high-low)/2;
            int sum = mid * (mid+1)/2;
            if ( sum == n ) return mid;
            if ( n - sum < 0 ){
                high = mid-1;
            }else {
                low = mid +1;
            }
        }
        return high;
    }
}
