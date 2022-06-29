import java.util.Stack;

public class ScoreOfParentheses_856 {
    public static int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int score = 0;
        for (int i=0;i<s.length();i++){
            if (s.charAt(i) == '('){
                stack.push(score);
                score = 0;
            }else {
                score = stack.peek() + Math.max(2*score , 1);
                stack.pop();
            }
        }
        return score;
    }
}
