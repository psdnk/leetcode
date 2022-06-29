import java.util.Arrays;

public class MaximumProductOfWordLengths_318 {
    public static void main(String[] args) {
        String [] words = {"abcw","baz","foo","bar","xtfn","abcdef"};
        System.out.println(maxProduct(words));
    }
    public static int maxProduct(String[] words) {
        Arrays.sort(words, (a,b)->{ return b.length()-a.length();});

        

        System.out.println(Arrays.toString(words));

        return 0;
    }
}
