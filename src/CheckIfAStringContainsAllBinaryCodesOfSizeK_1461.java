import java.util.HashSet;

public class CheckIfAStringContainsAllBinaryCodesOfSizeK_1461 {
    public static void main(String[] args) {
        String s  = "00110";
        int k = 2;
        hasAllCodes(s,k);
    }
    public static boolean hasAllCodes(String s, int k) {
        HashSet<String> set = new HashSet<>();
        for (int i=0;i<=s.length()-k;i++) set.add(s.substring(i,i+k));
        System.out.println(set);
        return Math.pow(2,k) == set.size();
    }
}
