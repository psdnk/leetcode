import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    List<List<Integer>> l = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        for (int i=0;i<nums.length;i++){

        }
        return null;
    }

    public void helper(int [] nums,int current ,  int start, int end){
        for (int i=start ;i<=end;i++){
            int temp = nums[current];
            nums[current] = nums[i];
            nums[i] = temp;

            helper(nums,current,i,end);
        }
    }
}
