import java.util.Arrays;
import java.util.PriorityQueue;

public class CarPooling {

    public static void main(String[] args) {
        int [][] trips = {{2,1,5},{3,3,7}};
        int capacity = 5;
        carPooling(trips,capacity);
    }
    public static boolean carPooling(int[][] trips, int capacity) {
        int [] arr = new int[1005];
        for (int [] trip : trips){
            arr[trip[1]] = trip[0];
            arr[trip[2]] = -trip[0];
        }
        int sum = 0;
        for (int i=1;i<1001;i++){
            if (sum > capacity || sum<0) return false;
            sum = sum + arr[i];
        }
        return true;


    }
}
