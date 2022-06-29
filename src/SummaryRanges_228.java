import java.util.ArrayList;
import java.util.List;

public class SummaryRanges_228 {
    public static void main(String[] args) {
        int [] nums = {0,1,2,4,5,7};
        List<String> ret = summaryRanges(nums);
        System.out.println(ret.toString());
    }
    public static List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList<>();
        int len = nums.length;
        for (int i=0;i<len;){
            int j = i+1;
            while (j<len && nums[j]-nums[j-1]==1){
                j++;
            }
            if (i !=j-1)ret.add(nums[i] + "->" + nums[j-1]);
            else ret.add(nums[i] + "");
            i=j;
        }
        return ret;

    }
}
