public class StringShift {

    public static void main(String[] args) {
        int  shift [][] = {{1,1},{1,1},{0,2},{1,3}};
        String s = "abcdefg";
        System.out.println(stringShift(s,shift));
        System.out.println(1|2|3|4);
    }


    public static String stringShift(String s, int[][] shift) {

        int row = shift.length;
        int col = shift[0].length;
        String finalStr = s;
        for (int i=0;i<row;i++){
            int shiftType = shift[i][0];
            int shiftCount = shift[i][1];
            System.out.println(shiftType);
            System.out.println(shiftCount);
            switch (shiftType){
                case 0 : finalStr = leftShift(finalStr,shiftCount);break;
                case 1: finalStr = rightShift(finalStr,shiftCount);break;
                default:return finalStr;
            }
        }

        return finalStr;

    }

    public static String rightShift(String s,int shift){
        StringBuilder sb = new StringBuilder();
        if (shift > 0){
            char arr [] = s.toCharArray();
            sb.append(arr[arr.length-1]);
            for (int i=0;i<arr.length-1;i++){
                sb.append(arr[i]);
            }
            System.out.println("Right->  " + sb.toString());
            String temp = String.valueOf(s.charAt(s.length()-1)) + s.substring(0,s.length()-1);
            System.out.println("Temp -->" +temp);
            shift =shift -1;
            return rightShift(sb.toString(),shift);
        }else {
            return s;
        }
    }
    public static String leftShift(String s,int shift){
        if (shift > 0){
            StringBuilder sb = new StringBuilder();
            char arr [] = s.toCharArray();
            for (int i=1;i<arr.length;i++){
                sb.append(arr[i]);
            }
            sb.append(arr[0]);
            System.out.println("Left->  " + sb.toString());
            String temp =   s.substring(1) + String.valueOf(s.charAt(0));
            System.out.println("Temp -->" +temp);
            shift =shift -1;
            return leftShift(sb.toString(),shift);
        }else {
            return s;
        }
    }
}
