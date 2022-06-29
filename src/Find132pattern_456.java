import java.util.Stack;

public class Find132pattern_456 {


    public boolean find132pattern(int[] nums) {
        int secondMax = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();

        for (int i= nums.length-1;i>=0;i--){
            if (nums[i]<secondMax) return true;
            while (!stack.isEmpty() && nums[i]>stack.peek()){
                secondMax = Math.max(secondMax,stack.pop());
            }
            stack.push(nums[i]);
        }
        return false;
    }
}
