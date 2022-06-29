import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses_1249 {

    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
    }
    public static String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        char [] arr = s.toCharArray();
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if (c == '(')stack.push(i);
            else if (c == ')'){
                if (stack.isEmpty()) arr[i] = '#';
                else stack.pop();
            }
        }

        while (!stack.isEmpty()){
            arr[stack.peek()] = '#';
            stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<arr.length;i++)if (arr[i] != '#')sb.append(arr[i]);
        return sb.toString();
    }

    public static boolean helper(String s , int index , int count,StringBuilder sb){
        if(index == s.length() && count==0) return true;
        else if (count<0) return false;
        else if (s.charAt(index) == '('){

                    boolean left = helper(s,index+1,count+1,sb.append(s.charAt(index)));
                    boolean right = helper(s,index+1,count,sb);
                    if (!left)sb.deleteCharAt(index);
                    return left&&right;
        }
        else if (s.charAt(index) == ')'){
            return helper(s,index+1,count-1,sb.append(s.charAt(index)))||
                    helper(s,index+1,count,sb);
        }else return helper(s,index+1,count,sb.append(s.charAt(index)));
    }
}
