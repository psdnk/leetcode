import java.util.AbstractMap;
import java.util.Map;
import java.util.Stack;

public class LargestRectangleInHistogram_84 {
    public static void main(String[] args) {
        int [] heights = {2,1,5,6,2,3};
        System.out.println(largestRectangleAreav1(heights));
    }
    public static int largestRectangleArea(int[] heights) {
        int len =heights.length;
        int max = Integer.MIN_VALUE;
        for (int i=0;i<len;i++){
            int count =0;
            int left = i-1;
            int right = i+1;
            while (left>=0 && heights[left]>=heights[i]){
                count++;
                left--;
            }
            while (right<len && heights[right]>=heights[i]){
                count++;
                right++;
            }
            count = count+1;
            max = Math.max(count*heights[i],max);
        }
        return max;
    }

    public static int largestRectangleAreav1(int[] heights) {
        Stack<Map.Entry<Integer,Integer>> stack = new Stack<Map.Entry<Integer, Integer>>();
        int max = Integer.MIN_VALUE;
        for (int i=0;i<heights.length;i++){
            int startIndex = i;
                while (!stack.isEmpty() && stack.peek().getValue()>heights[i]){
                    Map.Entry<Integer, Integer> ele = stack.pop();
                    startIndex = ele.getKey();
                    int height = ele.getValue();
                    max = Math.max(max, (i-startIndex)*height);
                }
                stack.add(Map.entry(startIndex,heights[i]));
        }
        while (!stack.isEmpty()){
            Map.Entry<Integer, Integer> ele = stack.pop();
            int startIndex = ele.getKey();
            int height = ele.getValue();
            max = Math.max(max, ((heights.length)-startIndex)*height);
        }
        return max;
    }
}
