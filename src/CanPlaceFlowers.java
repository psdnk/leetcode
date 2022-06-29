public class CanPlaceFlowers {
    public static void main(String[] args) {
        int [] flowerbed = {1,0,0,0,1};
        int n = 2;
        System.out.println(canPlaceFlowers(flowerbed,n));
    }
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n==0) return true;
        int freePosition = 0;
        int len = flowerbed.length;
        for (int i=0;i<len;i++){
            if (flowerbed[i] == 0 && ((i-1>=0 && flowerbed[i-1] != 1) || (i+1<len && flowerbed[i+1] !=1))){
                freePosition++;
                flowerbed[i] = 1;
            }
        }
        return freePosition>=n ? true : false;
    }

    private static boolean helper(int[] flowerbed, int i,  int n, int len) {
        if (i>n) return true;
        if (flowerbed[i] == 1) return false;
        int left = i-1;
        int right = i+1;
        if ((left>=0 && left<len && flowerbed[left]!=1)||(right>=0 && right<len && flowerbed[right]!=1)){
            return helper(flowerbed,i+1,n,len);
        }else return false;




    }
}
