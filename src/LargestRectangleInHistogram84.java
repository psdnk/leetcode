import java.util.Deque;
import java.util.Stack;

public class LargestRectangleInHistogram84 {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i=0;i<heights.length;i++){
            stack.add(heights[i]);
        }
        return 0;
    }
}
