import java.util.*;
import java.util.stream.Collectors;

public class Subsets_78 {


    public static void main(String[] args) {
        Subsets_78 subsets_78 = new Subsets_78();
        int [] nums = {1,2,3};
        List<List<Integer>> subsets = subsets_78.subsets(nums);
        for (List<Integer> list : subsets) System.out.println(list.toString());
    }
    public List<List<Integer>> subsets(int[] nums) {
        Set<List<Integer>> ret = new LinkedHashSet<>();
        List<Integer> list = new ArrayList<Integer>();
        ret.add(list);
        for (int i=0;i<nums.length;i++){
            helper(i,nums, list,ret);
        }
        return ret.stream().collect(Collectors.toList());
    }

    public void helper(int i, int[] nums, List<Integer> list, Set<List<Integer>> ret){
        if (i == nums.length) return;
        list.add(nums[i]);
        ret.add(new ArrayList<>(list));
        helper(i+1,nums,list,ret);
        list.remove(list.size()-1);
        helper(i+1,nums,list,ret);
    }
}
