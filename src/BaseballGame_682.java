import java.util.Stack;

public class BaseballGame_682 {
    public static void main(String[] args) {
        String [] ops = {"5","2","C","D","+"};
        System.out.println(calPoints(ops));
    }
    public static int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (String op : ops){
            if (op.equals("C")){
                stack.pop();
            }else if (op == "D"){
                stack.push(stack.peek()*2);
            }else if (op == "+"){
                int o2 = stack.pop();
                int o1 = stack.pop();
                int o3 = o1 + o2;
                stack.push(o1);
                stack.push(o2);
                stack.push(o3);
            }else {
                stack.push(Integer.valueOf(op));
            }
        }
        int ret = 0;
        while (!stack.isEmpty()){
            ret = ret + stack.pop();
        }
        return ret;
    }
}
