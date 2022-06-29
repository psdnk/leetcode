import java.util.HashMap;

public class FindTheDifference {

    public char findTheDifference(String s, String t) {
        char c = 0;
        for (char ch : t.toCharArray())c^=ch;
        for (char ch : s.toCharArray())c^=ch;
        return c;
    }
}
