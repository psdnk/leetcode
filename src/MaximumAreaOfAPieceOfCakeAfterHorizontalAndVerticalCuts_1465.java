import java.util.Arrays;

public class MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts_1465 {

    public static void main(String[] args) {
        int h = 5;
        int w = 4;
        int []  horizontalCuts = {1,2,4};
        int []  verticalCuts = {1,3};
        System.out.println(maxArea(h,w,horizontalCuts,verticalCuts));
    }
    public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        int maxHeight = Math.max(horizontalCuts[0]-0, h-horizontalCuts[horizontalCuts.length-1]);
        for (int i=1;i<horizontalCuts.length;i++){
            int horizontalWidth = horizontalCuts[i] - horizontalCuts[i-1];
            maxHeight = Math.max(maxHeight,horizontalWidth);
        }

        int maxWidth = Math.max(verticalCuts[0]-0, w-verticalCuts[verticalCuts.length-1]);
        for (int i=1;i<verticalCuts.length;i++){
            int verticalHeights = verticalCuts[i] - verticalCuts[i-1];
            maxWidth = Math.max(maxWidth,verticalHeights);
        }

        long ans = (1L * maxHeight * maxWidth) % 1000000007;
        return (int) (ans);

    }
}
