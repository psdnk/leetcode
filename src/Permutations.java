import java.util.*;
import java.util.stream.Collectors;

public class Permutations {
    Set<List<Integer>> ret;
    public List<List<Integer>> permute(int[] nums) {
        ret = new LinkedHashSet<>();
        int len = nums.length;
        helper(nums,0,nums.length-1);
        System.out.println(ret);
        return ret.stream().collect(Collectors.toList());
    }

    private void helper(int[] nums , int left, int size) {
        if (left == size){
            ArrayList<Integer> list = new ArrayList<>();
            for (int num : nums) list.add(num);
            ret.add(list);
            return;
        }else{
            for (int i=left;i<=size;i++){
                swap(nums,left,i);
                helper(nums,left+1,size);
                swap(nums,i,left);
            }
        }

    }

    private void  swap(int [] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        int [] nums = { 1,2,3};
        permutations.permute(nums);
    }
}
