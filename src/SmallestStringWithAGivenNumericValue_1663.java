import java.util.Arrays;

public class SmallestStringWithAGivenNumericValue_1663 {

    public static void main(String[] args) {
        getSmallestString(3,27);
    }
    public static String getSmallestString(int n, int k) {
//        StringBuilder sb = new StringBuilder();
//        int [] arr = new int[n];
//        Arrays.fill(arr,1);
//        k = k-n;
//        for (int i=n-1;i>=0&&k>=0;i--){
//            while (arr[i]<26 && k>0){
//                arr[i]++;
//                k--;
//            }
//        }
//        char c = 'a';
//        for (int val : arr)sb.append((char) (96+val));
//        return sb.toString();

        char [] arr = new char[n];
        Arrays.fill(arr,'a');
        k = k-n;
        while (k>0){
            arr[n] += Math.min(25,k);
            k -= Math.min(25,k);
            n--;
        }

        return Arrays.toString(arr);
    }
}
