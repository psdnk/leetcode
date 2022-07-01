import java.util.Arrays;

public class MaximumUnitsOnATruck_1710 {
    public static void main(String[] args) {
        int[][] boxTypes = {{1,3},{2,2},{3,1}};
        int truckSize = 4;
        System.out.println(maximumUnits(boxTypes,truckSize));
    }
    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        int units =0;
        Arrays.sort(boxTypes,(a,b)-> Integer.compare(b[1],a[1]));
        for (int i=0;i<boxTypes.length && truckSize>0;i++){
            if (truckSize>=boxTypes[i][0]){
                units = units + boxTypes[i][0] * boxTypes[i][1];
                truckSize = truckSize - boxTypes[i][0];
            }else {
                units = units + truckSize * boxTypes[i][1];
                truckSize = 0;
            }
        }
        return units;
    }
}
