import java.util.HashMap;
import java.util.LinkedHashMap;

public class RemoveDuplicatesFromSortedArrayII_80 {
    public static void main(String[] args) {
        int [] nums = {0,0,1,1,1,1,2,3,3};
        System.out.println(removeDuplicates(nums));
    }
    public static int removeDuplicates(int[] nums) {
       int index = 0;
       for (int e : nums){
           if (index ==0 || index ==1  || nums[index-2] !=e){
               nums[index] = e;
               index++;
           }
       }
       return index;
    }
}
