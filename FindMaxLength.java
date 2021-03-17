import java.util.Arrays;
import java.util.HashMap;

public class FindMaxLength {


    public static void main(String[] args) {
        int nums [] = {0,1,0,1};
        System.out.println(findMaxLengthv1(nums));
    }


    public static int findMaxLength(int[] nums) {
        System.out.println(Arrays.toString(nums));
        HashMap<Integer, Integer> counts = new HashMap<>();
        int count = 0;
        int maxSize = Integer.MIN_VALUE;
        counts.put(0,-1);
        for (int i = 0; i < nums.length; i++) {

            count = nums[i] == 0 ? count - 1 : count + 1;
            if (counts.containsKey(count)) {
                maxSize = Math.max(maxSize, i - counts.get(count));
                //counts.put(count, maxSize);
            } else {
                counts.put(count, i);
            }
            // if(nums[i]==1){
            //     ones++;
            //     subMax++;
            // }
            // if(nums[i]==0){
            //     zeros++;
            //     subMax++;
            // }
            // if(ones == zeros){
            //     maxSize = Math.max(maxSize,subMax);
            // }else{
            //     subMax = 0;
            // }
        }
        System.out.println(counts.toString());
        return maxSize;
    }

    public static int findMaxLengthv1(int[] nums) {
        int count =0;
        int lastIndex = 0;
        for ( int i=0;i<nums.length;i++ ){
            if ( nums[i] == 0 ){
                count=count+1;
            }else {
                count=count-1;
            }
            if ( count ==0 ){
                lastIndex = i;
            }
        }
        return lastIndex+1;

    }

}

