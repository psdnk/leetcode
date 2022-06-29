import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumDominoRotationsForEqualRow_1007 {
    public static void main(String[] args) {
        int [] tops = {1,2,1,1,1,2,2,2};
        int [] bottoms = {2,1,2,2,2,2,2,2};
        System.out.println(minDominoRotations(tops,bottoms));
    }
    public static int minDominoRotations(int[] A, int[] B) {
        int[] countA = new int[7], countB = new int[7], countSame = new int[7];
        int n = A.length;
        for (int i = 0; i < n; i++) {
            int a = A[i], b = B[i];
            countA[a] += 1;
            countB[b] += 1;
            if (a == b) countSame[a] += 1;
        }
        int ans = n;
        for (int v = 1; v <= 6; v++) {
            if (countA[v] + countB[v] - countSame[v] == n) {
                int minSwap = Math.min(countA[v], countB[v]) - countSame[v];
                ans = Math.min(ans, minSwap);
            }
        }
        return ans == n ? -1 : ans;
    }
}
