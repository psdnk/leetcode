public class SingleNumberII {
    public static void main(String[] args) {
        int [] nums = {2,2,3,2};
        System.out.println (singleNumber ( nums ));
    }
    public static int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;
        for ( int ele :nums ){
            ones = (ones^ele) &(~twos);
            twos = (twos^ele) &(~ones);
        }
        return ones;


    }
}
