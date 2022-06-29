import java.util.AbstractMap;
import java.util.Map;
import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInStringII_1209 {
    public static void main(String[] args) {
        String s = "abcd";
        int k = 2;
        System.out.println(removeDuplicates(s,k));
    }
    public static String removeDuplicates(String s, int k) {
        Stack<Map.Entry<Character,Integer>> stack = new Stack<>();
        for (char c : s.toCharArray()){
            if (stack.isEmpty() || stack.peek().getKey() != c){
                stack.push(new AbstractMap.SimpleEntry<>(c,1));
            }else {
                Map.Entry<Character, Integer> top = stack.pop();
                stack.push(new AbstractMap.SimpleEntry<>(c, top.getValue()+1));
                if (stack.peek().getValue() == k) stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            Map.Entry<Character, Integer> top = stack.pop();
            int freq = top.getValue();
            while (freq>0){
                sb.insert(0,top.getKey());
                freq--;
            }
        }
        return sb.toString();
    }
}
