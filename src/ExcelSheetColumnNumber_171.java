public class ExcelSheetColumnNumber_171 {

    public static void main(String[] args) {
        System.out.println(titleToNumber("ZY"));
    }
    public static int titleToNumber(String columnTitle) {
        int len  = columnTitle.length()-1;
        int sum = 0;
        for(int i=0;i<columnTitle.length();i++){
            int val =  columnTitle.charAt(len-i)-'A'+1;
            System.out.println(val);
            sum  = sum + (int) Math.pow(26, i) * val;
        }
        return sum;

    }
}
