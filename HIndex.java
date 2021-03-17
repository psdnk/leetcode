import java.util.Scanner;

public class HIndex {

    Scanner s = new Scanner ( System.in );
    public int hIndex(int[] citations) {

        int high = citations.length-1;
        int low= 0;
        int n = citations.length;
        while (low<=high){
            int mid = low + (high-low)/2;
            //int diff = (h-mid)+1; //a[2] = 3
            if(citations[mid] == (n-mid)){
                return citations[mid];
            }
            else if(citations[mid] > (n-mid)){
                high = mid-1;
            }else {
                low = mid+1;
            }
        }
        return n-low;


    }
}
