public class ExcelSheetColumnNumber {

    public static void main(String[] args) {
        System.out.println ( titleToNumber ( "ZY" ));
    }
    public static int titleToNumber(String s) {
        int num = 0;
        for ( int i=s.length ()-1;i>=0;i-- ){
            num = num +  (int) Math.pow ( 26,(s.length ()-1)-i ) *((s.charAt ( i )-'A') + 1);
        }
        return num;

    }
}
