import java.util.Stack;

public class RemoveKdigits {

    public static void main(String[] args) {
        String num = "5337";
        int k =2;
        System.out.println("Min value "+removeKdigitsV1( num,k ));
    }
    public static String removeKdigits(String num, int k) {
        int min = Integer.MAX_VALUE;
        for ( int i=0;(i<num.length()) && ((i+k) <= num.length());i++ ){
            String temp = num.substring( i, i+k );
            String str1 = num.substring( 0, i );
            String str2 ="";
            if ( (i+k) < num.length() )
                str2 = num.substring( i+k, num.length() );
            String str3 = str1 + str2;
            if ( str3 != "" )
                min = Math.min( min, str3.length() > 0 ? Integer.parseInt( str3 ):min );

            System.out.println("str1 "+str1);
            System.out.println("temp "+temp);
            System.out.println("str2 "+str2);
            System.out.println("str3 "+ (str3.length() > 0 ? Integer.parseInt( str3 ):min));

        }
        return String.valueOf( min == Integer.MAX_VALUE ? 0 : min );
    }

    public static String removeKdigitsV1(String num, int k) {
        //1432219
        Stack<Character> tracker = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for ( char c : num.toCharArray() ){
            while (!tracker.isEmpty() && k>0 && tracker.peek() > c){
                tracker.pop();
                k=k-1;
            }
            if ( c != '0')
                tracker.push( c );
            if(k ==0 && !tracker.isEmpty()  && c == '0'){
                tracker.push( c );
            }
        }
        while (!tracker.isEmpty() && k>0){
            tracker.pop();
            k=k-1;
        }
        if ( tracker.isEmpty() ){
            return "0";
        }
        while (!tracker.isEmpty()){
            sb.append( tracker.pop() );
        }

        return sb.reverse().toString();

    }
}
