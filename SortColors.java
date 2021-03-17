import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int []nums = {2,0,2,1,1,0};
        sortColors (nums);
    }
    public static void sortColors(int[] nums) {

        int zeros = 0;
        int ones=0;
        int twos = 0;
        for ( int i:nums ){
            if ( i==0 )zeros++;
            else if ( i==1 )ones++;
            else if ( i==2 )twos++;
        }
        int j=0;
        while (zeros>0){
            nums[j++] = 0;
            zeros--;
        }
        while (ones>0){
            nums[j++] = 1;
            ones--;
        }
        while (twos>0){
            nums[j++] = 2;
            twos--;
        }
        System.out.println ( Arrays.toString (nums));



    }
}
