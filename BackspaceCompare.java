import java.util.Arrays;
import java.util.Stack;

public class BackspaceCompare {
    public static void main(String[] args) {
        backspaceCompare("a##c","#a#c");
    }
    public static boolean backspaceCompare(String S, String T) {

        Stack<Character> s = new Stack<>();
        Stack<Character> t= new Stack<>();
        for (int i=0 ;i <S.length();i++){
            char curr = S.charAt(i);
            if (curr != '#'){
                s.push(curr);
            }else {
                if (s.size()>0)
                    s.pop();
            }
        }
        System.out.println(Arrays.toString(s.toArray()));
        for (int i=0 ;i <T.length();i++){
            char curr = T.charAt(i);
            if (curr != '#'){
                t.push(curr);
            }else {
                if (t.size()>0)
                    t.pop();
            }
        }
        System.out.println(Arrays.toString(t.toArray()));
        if (Arrays.toString(s.toArray()).equals(Arrays.toString(t.toArray()))){
            return true;
        }

        return false;
    }


}
