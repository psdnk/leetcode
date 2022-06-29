import java.util.*;
import java.util.stream.Collectors;

public class PermutationsII_47 {

    public static void main(String[] args) {
        int [] nums = {1,1,2};
        List<List<Integer>> ret = permuteUnique(nums);
        System.out.println(ret);
//        for (List<Integer> r : ret) System.out.println(r.toString());
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> ret = new HashSet<>();
        //for (int i=0;i<nums.length;i++){
            permute(nums,0,ret);
       // }
        return ret.stream().collect(Collectors.toList());
    }

    private static void permute(int[] nums, int index, Set<List<Integer>> ret) {
        if (index >= nums.length-1){
            List<Integer> list = new ArrayList<>();
            for (int num : nums){
                list.add(num);
            }
            ret.add(list);
//            return;
        }else {
            for (int i=index+1;i<nums.length;i++){
                swap(nums,index,i);
                permute(nums,index+1,ret);
                swap(nums,i,index);
            }
        }
    }

    private static void swap(int [] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
