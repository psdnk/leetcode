import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber_179 {

    public static void main(String[] args) {
        int [] nums = {0,0};
        System.out.println(largestNumber(nums));
    }
    static class StringSort implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            String n1 = o1 + o2;
            String n2 = o2 + o1;
            return n2.compareTo(n1);
        }
    }
    public static String largestNumber(int[] nums) {
        String [] strNums = new String[nums.length];
        for (int i=0;i<nums.length;i++){
            strNums[i] = "" + nums[i];
        }
        Arrays.sort(strNums,new StringSort());
        if (strNums[0].equals("0")) return "0";
        StringBuilder ret = new StringBuilder();
        for (String str : strNums)ret.append(str);
        return ret.toString();
    }
}
