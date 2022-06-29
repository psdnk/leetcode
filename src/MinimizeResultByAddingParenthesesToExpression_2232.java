public class MinimizeResultByAddingParenthesesToExpression_2232 {
    public static void main(String[] args) {
        String expression = "247+38";
        minimizeResult(expression);
    }
    public static String minimizeResult(String expression) {
        int indexOfPlus = expression.indexOf('+');
        int leftEnd = indexOfPlus - 1;
        int rightStart = indexOfPlus + 1;
        int minimumSum = Integer.MAX_VALUE;
        int len  = expression.length();
        int expr1 = 1;
        int expr2 = 1;
        int expr3 = 1;
        int expr4 =1;
        for (int i=1;i<=leftEnd;i++){
            for (int j=rightStart;j<expression.length();j++){
//                System.out.println(expression.substring(0,i));
//                System.out.println(expression.substring(i,indexOfPlus));
//                System.out.println(expression.substring(rightStart,j));
//                System.out.println(expression.substring(j+1,len));
                expr1 = i==0 ?  1:  Integer.valueOf(expression.substring(0,i+1));
                expr2 = expression.substring(i,indexOfPlus).length() == 0 ? 1 : Integer.valueOf(expression.substring(i+1,indexOfPlus));
                expr3 = expression.substring(rightStart,j).length()==0 ? 1 : Integer.valueOf(expression.substring(indexOfPlus+1,j+1));
                expr4 = j==expression.length()-1 ? 1 : Integer.valueOf(expression.substring(j+1,len));
                System.out.println(expr1 + "(" + expr2 + " + " + expr3 + " ) "+ expr4);
            }
        }
        return "";
    }
}
