import java.util.Stack;

public class CheckValidString {

    public static void main(String[] args) {
        String s = "(((******))";
//        String temp = s;
//        boolean t1= checkValidStringv1(temp.replace("*",""));
//        boolean t2 = checkValidStringv1(temp.replace("*","("));
//        boolean t3 = checkValidStringv1(temp.replace("*",")"));
////        System.out.println(checkValidString(s));
//        System.out.println(t1);
//        System.out.println(t2);
//        System.out.println(t3);
        // System.out.println(checkValidStringv1(s));

        System.out.println(checkValid(s,0,0,0));

    }

    public static boolean checkValidString(String s) {

        boolean valid = false;
        int i, j;
        int openP = 0;
        int closeP = 0;
        for (i = 0, j = s.length()-1; i <= j && j >= i && j >= 0 && i < s.length(); i++, j--) {
//            if (i==j && s.charAt(i) != '*'){
//                valid = false;
//                break;
//            }else {
//                valid = true;
//                break;
//            }
//            if (s.charAt(i) == '(' && (s.charAt(j) == ')' || s.charAt(j) == '*')){
//                i++;
//                j--;
//                valid =true;
//            }
//           else if (s.charAt(i) == '*' && s.charAt(j) == ')'){
//                i++;
//                j--;
//                valid =true;
//            }else {
//               valid =false;
//            }
//        }
//        return valid;

            char left = s.charAt(i);
            char right = s.charAt(j);
            if (i == j && (left == '*')) {
                openP = openP + 1;
                closeP = closeP + 1;
            }

            if ((left == '(' || left == '*') && (right == '*' || right == ')')) {
                openP = openP + 1;
                closeP = closeP + 1;
            }
//            if (right == ')' && (left == '*' || left == '(')) {
//                closeP = closeP + 1;
//                openP = openP + 1;
//            }
            if ((left == ')' || left == '*') && (right == '(' || right == '*')) {
                closeP = closeP + 1;
                openP = openP +1;
            }
            if (closeP > openP) {
                return false;
            }

        }
        if (openP == closeP){
            return true;
        }else {
            return false;
        }
    }


    public static boolean checkValidStringv1(String s){

        System.out.println(s);
        Stack<Character> stack= new Stack<>();
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            switch (c){
                //case  '*':
                case '(':stack.push(c);break;
                case ')':
                        if (stack.size() >0){
                            char t = stack.peek();
                            if (t == '(') {
                                stack.pop();
//                                System.out.println("Popped " + t);
                            }
//                            }else {
//                               stack.pop();
//                               System.out.println("Popped " +  t);
//                               t= stack.pop();
//                               System.out.println("Popped " +  t);
//
//                            }
                        }else {
                            return false;
                        }break;
                default:break;

            }
        }
        if (stack.size() > 0){
            return false;
        }
    return true;
    }


    public static boolean checkValid(String s,int i, int open,int close){
        if (open == close){
            return true;
        }
        if (s.length() == i)return true;
        if (close > open) return false;
        char c = s.charAt(i);
        switch (c){
            case '(': return checkValid(s,i+1,open+1,close);
            case  ')': return  checkValid(s,i+1,open,close+1);
            case  '*': return checkValid(s,i+1,open+1,close) || checkValid(s,i+1,open,close+1) ||checkValid(s,i+1,open+1,close+1);
        }

       return true;
    }

}
