import java.util.ArrayList;
import java.util.List;

public class TextJustification_68 {

    public static void main(String[] args) {
        String [] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        fullJustify(words,maxWidth);
    }
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ret = new ArrayList<>();
        for (int i=0;i<words.length;){
            StringBuilder sb = new StringBuilder();
            while ((i<words.length) && (words[i].length() + sb.length())<maxWidth){
                sb.append(words[i++]);
                sb.append("*");
            }
            sb.deleteCharAt(sb.length()-1);
            int count =0;
            for (int j=0;j<sb.length();j++)if (sb.charAt(j) == '*')count++;
            int offset = 16-sb.length()+count;
            while (offset>0){
                while (count >0 && sb.indexOf("*") != -1){
                    int c = offset/count + offset%count;
                    offset = offset-c;
//                    System.out.println(c);
                    StringBuilder s = new StringBuilder();
                    while (c>0){
                        s.append(" ");
                        c--;
                    }
                    int index = sb.indexOf("*");
                    sb.replace(index,index,s.toString());
                    count--;
                }

            }
//            System.out.println("Offset - " + (16-sb.length()));
            System.out.println(sb.toString());
        }
        return ret;
    }
}
