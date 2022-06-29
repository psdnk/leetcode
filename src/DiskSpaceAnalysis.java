import java.util.*;

public class DiskSpaceAnalysis {

    public static void main(String[] args) {
        int x = 1;
        List<Integer> space = Arrays.asList(1,2,3,1,2);
        System.out.println(segment(x,space));
    }
    public static int segment(int x, List<Integer> space) {
        final int[] min_left = new int[space.size()];
        final int[] min_right = new int[space.size()];

        min_left[0] = space.get(0);
        min_right[space.size() - 1] = space.get(space.size() - 1);

        for (int i = 1; i < space.size(); i++) {
            min_left[i] = (i % x == 0) ? space.get(i) : Math.min(min_left[i - 1], space.get(i));

            final int j = space.size() - i - 1;
            min_right[j] = (j % x == 0) ? space.get(j) : Math.min(min_right[j + 1], space.get(j));
        }

        final int[] sliding_min = new int[space.size() - x + 1];
        for (int i = 0, j = 0; i + x <= space.size(); i++) {
            sliding_min[j++] = Math.min(min_right[i], min_left[i + x - 1]);
        }
        int max = 0;
        for (int v : sliding_min)max = Math.max(v,max);
        return max;
    }
}
