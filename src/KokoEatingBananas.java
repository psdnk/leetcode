public class KokoEatingBananas {
    public static void main(String[] args) {
        int [] piles = {3,6,7,11};
        int h = 8;
        int ret = minEatingSpeed(piles,h);
        System.out.println(ret);


    }
    public static int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for (int pile : piles) max = max < pile ? pile : max;
        return helper(piles,h,1,max);
    }

    public static int helper(int [] piles, int h , int low, int high){
        while (low<high){
            int mid = low + (high-low)/2;
            int timeTaken = timeTaken(piles,mid);
            if (timeTaken<=h) high=mid-1;
            else low = mid+1;
        }
        return low;
    }

    public static  int timeTaken(int[]piles,int mid){
        int count = 0;
        for (int pile : piles){
            int div = pile/mid;
            int rem = pile%mid;
            count = count + div;
            if (rem!=0) count = count + 1;
        }
        return count;
    }
}
