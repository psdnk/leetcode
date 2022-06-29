import java.util.Arrays;

public class TwoSumIIInputArrayIsSorted_167 {

    public static void main(String[] args) {
        int [] numbers = {2,7,11,15};
        int target = 9;
        int [] ret = twoSum(numbers,target);
        System.out.println(Arrays.toString(ret));
    }
    public static int[] twoSum(int[] numbers, int target) {
        int i = 0 , j= numbers.length-1;
        int [] ret = new int[2];
        while (i<j){
            int sum  = numbers[i] + numbers[j];
            if (sum == target){
                ret[0] = i+1;
                ret[1] = j+1;
                break;
            }
            else if (sum > target) j--;
            else i++;
        }
        return ret;
    }
}
