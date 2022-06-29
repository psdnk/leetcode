import java.util.ArrayList;
import java.util.List;

public class SubsetsII_90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        helper(nums,0,new ArrayList<Integer>(),ret);
        return ret;

    }

    public void helper(int [] nums , int index , List<Integer> list , List<List<Integer>> ret){
        ret.add(new ArrayList<>(list));
        for (int i= index ;i<nums.length;i++){
            if (i==index || nums[i-1] != nums[i]){
                list.add(nums[i]);
                helper(nums,i+1,list,ret);
                list.remove(list.size()-1);
            }
        }
    }
}
