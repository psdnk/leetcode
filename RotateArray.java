package october;

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5,6,7};
        int a = 1;
        double b = 2;
        float c= 3;
        long d =4;
        System.out.println ((a + d) * (c + b) );
        rotate ( nums,3 );

        try{
            method ();
            System.out.println ("A" );
        }catch (Exception e){
            System.out.println ("B" );
        }finally {
            System.out.println ("C" );
        }
        System.out.println ("D" );
    }
    public static void method(){}
    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        while (k>0 && len>0){
            int previousElement = nums[0];
            for ( int i=1;;i++ ){
                if ( i % len == 0 ){
                    k--;
                    nums[0] = previousElement;
                    System.out.println ( Arrays.toString ( nums ) );
                    break;
                }
                int currentElement = nums[i];
                nums[i] = previousElement;
                previousElement = currentElement;
            }
        }
    }
}
