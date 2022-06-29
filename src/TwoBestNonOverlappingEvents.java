import java.util.Arrays;

public class TwoBestNonOverlappingEvents {

    public static void main(String[] args) {
//        int [][] events = {{1,3,2},{4,5,2},{2,4,3}};
        int [][] events = {{1,3,2},{4,5,2},{1,5,5}};
        maxTwoEvents(events);
    }
    public static int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> {
            if(a[0] == b[0])return a[1]-b[1];
            return a[0]-b[0];
        });
        int prev = 0;
        int max= 0;
        for (int [] e : events){
            if (e[0] > prev && e[2]> max){
                max = e[2];
                prev = e[1];
            }
            if (e[0] > prev) {
                max = max + e[2];
                prev = e[1];
            }
            System.out.println(Arrays.toString(e));
        }
        System.out.println(max);
        return max;
    }
}
