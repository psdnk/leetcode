import com.sun.source.tree.BreakTree;

import java.util.Arrays;

public class MaximumSwap {
    public static void main(String[] args) {
        System.out.println(maximumSwap(9973));
    }
    public static int maximumSwap(int num) {
        String numStr = Integer.toString(num);
        int len = numStr.length();
        int [] nums = new int[len];
        int index=len-1;
        int max = num;
        while (num>0){
            nums[index--]= num%10;
            num=num/10;
        }
        for (int i =0;i<len;i++) {
            int val =  nextMax(nums, i,max);
            max = max < val ? val : max;
        }


        return max;
    }

    private static int nextMax(int[] nums, int i,int max) {
        int currentVal = nums[i];
        int val = max;
        for (int j=i+1 ;j<nums.length;j++){
            if (nums[j] > currentVal){
                swap(nums,i,j);
                int v= toNum(nums);
                val = val < v ? v : val;
                swap(nums,i,j);
            }
        }
        return val;
    }
    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static int toNum(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int n : nums)sb.append(n);
        return Integer.parseInt(sb.toString());
    }


}
