import java.util.Arrays;

public class MaximizeDistanceToClosestPerson {
    public static void main(String[] args) {
        int [] seats = {0,1};
        int ret = maxDistToClosest(seats);
        System.out.println(ret);
    }
    public static int maxDistToClosest(int[] seats) {
        int len  = seats.length;
        int max = 0;
        int [] arr = new int[len];
        Arrays.fill(arr,Integer.MAX_VALUE);
        int index = -1;
        for (int i=0;i<len;i++){
            if (seats[i] == 1) index = i;
            if (index != -1 && seats[i] == 0)arr[i] = Math.min(arr[i],Math.abs(index-i));
        }
        index=-1;
        for (int i=len-1;i>=0;i--){
            if (seats[i] == 1) index = i;
            if (index != -1 && seats[i] == 0)arr[i] = Math.min(arr[i],Math.abs(index-i));
        }
        for (int i=0;i<len;i++)max = arr[i] != Integer.MAX_VALUE ? Math.max(arr[i],max) : max;

        System.out.println(Arrays.toString(arr));

        return max;

    }
}
