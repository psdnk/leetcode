public class ReverseWordsInAString {
    public static void main(String[] args) {
        String s = "  hello      world  ";
        System.out.println(reverseWords(s));
    }
    public static String reverseWords(String s) {
        s = s.trim();
        s = s.replaceAll("\\s+", " ");
        String[] arr = s.split(" ");
        s = "";
        for (int i= arr.length-1;i>=0;i--) s=s + arr[i] + " ";
        s = s.trim();
        return s;
    }
}
