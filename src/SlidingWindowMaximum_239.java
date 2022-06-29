import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum_239 {

    public static void main(String[] args) {
        int [] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] ret = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(ret));
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int [] ret = new int[len-k+1];
        int index = 0;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i=0;i<len;i++){
            // removing out of range
            if (!q.isEmpty() && q.peek() == i-k)q.poll();
            //removing elements less than current
            while (!q.isEmpty() && nums[q.peekLast()]<nums[i]) q.pollLast();
            q.offer(i);
            if (i>=k-1)ret[index++] = nums[q.peek()];
        }
        return ret;

    }
}
