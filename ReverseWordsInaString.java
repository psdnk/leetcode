import java.util.*;

public class ReverseWordsInaString {

    public static void main(String[] args) {
        String s ="a good      example";
        System.out.println (reverseWords (s));
    }
    public static String reverseWords(String s) {
        String ret = "";
        String[] split =s.split ( "\\s+" );
        for ( int i=split.length-1;i>=0;i-- ){
            ret = ret + split[i] + " ";
        }
        return ret.trim ();




    }
}
