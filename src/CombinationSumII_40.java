import java.util.*;
import java.util.stream.Collectors;

public class CombinationSumII_40 {
    public static void main(String[] args) {
        int [] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        combinationSum2(candidates,target);
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Set<List<Integer>> set = new LinkedHashSet<>();
            helper(candidates,0,target,new ArrayList<Integer>(),set);
            return set.stream().collect(Collectors.toList());
    }

    public static void helper(int[] candidates, int index, int target, List<Integer>list, Set<List<Integer>> set){
        if (candidates.length == index || target == 0){
            if (target == 0){
                System.out.println(list.toString());
                set.add(new ArrayList<>(list));
            }
        }else {
            list.add(candidates[index]);
            helper(candidates,index+1,target-candidates[index],list,set);
            list.remove(list.size()-1);
        }
    }
}
