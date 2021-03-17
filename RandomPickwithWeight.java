import java.util.Arrays;
import java.util.Random;

public class RandomPickwithWeight {

    int [] cumW;
    int sum = 0;
    Random random;
    public RandomPickwithWeight(int[] w) {
        random = new Random();
        cumW = new int[w.length];
        for ( int i = 0 ;i<w.length;i++ ){
            cumW[i] = sum + w[i];
            sum = sum + w[i];
        }
    }

    public int pickIndex() {
        System.out.println(sum);
        int randWt = random.nextInt(sum);
        System.out.println(randWt);

        int l = 0 ;
        int r = cumW.length-1;
        while (l+1<r){
            int mid = l + (r-l)/2;
            if ( cumW[mid] <= randWt ){
                l= mid;
            }else {
                r = mid;
            }
        }
        if ( randWt < cumW[l] )
            return l;
        return r;
        //return l;

       // return bs( randWt );
    }

    public int bs(int val){
        int l = 0 ;
        int r = cumW.length-1;
        while (l<r){
            int mid = l + (r-l)/2;
            if ( cumW[mid] < val ){
                l= mid+1;
            }else {
                r = mid-1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int [] w = {1,2,3};
        RandomPickwithWeight rr = new RandomPickwithWeight( w );
        System.out.println(rr.pickIndex());
    }
}
