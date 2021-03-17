public class CanPlaceFlowers {

    public static void main(String[] args) {
        int flowerbed [] = {0};
        int n = 1;
        System.out.println (canPlaceFlowers ( flowerbed, n ) );
    }
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
//        int [] dp = new int[flowerbed.length+1];
//        dp[0]=0;
//        for ( int i=0;i<flowerbed.length;i++ ){
//            if ( flowerbed[i] != 1 ){
//                if(i >0 && i<flowerbed.length-1){
//                    if(flowerbed[i-1] != 1 && flowerbed[i+1] != 1){
//                        dp[i+1] = dp[i] + 1;
//                        flowerbed[i] = 1;
//                    }else {
//                        dp[i+1] = dp[i];
//                    }
//                }else if ( i == 0 && i<flowerbed.length-1 && flowerbed[i+1] !=1 ){
//                    flowerbed[i] = 1;
//                    dp[i+1] = dp[i] +1;
//                }else if ( i== flowerbed.length-1 && i> 0 && flowerbed[i-1] !=1 ){
//                    flowerbed[i] = 1;
//                    dp[i+1] = dp[i] +1;
//                }
//                else {
//                    dp[i+1] = dp[i];
//                }
//            }else {
//                dp[i+1] = dp[i];
//            }
//        }
//        for ( int val : dp ){
//            System.out.println (val );
//        }
//
//        // System.out.println (dp[flowerbed.length] );
//        return dp[flowerbed.length] >= n ? true: false;


        int size = flowerbed.length;
        int freePosition = 0;
        for ( int i=0;i<size;i++ ){
            if ( flowerbed[i] ==0 && (i==0 || flowerbed[i-1] ==0) && (i== size-1 || flowerbed[i+1] == 0) ){
                freePosition++;
                flowerbed[i] = 1;
            }
        }
        return freePosition>= n ? true :false;

    }
}
