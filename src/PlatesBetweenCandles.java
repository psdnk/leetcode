import java.util.Stack;

public class PlatesBetweenCandles {

    public static void main(String[] args) {
        String s = "**|**|***|";
        int [][] queries = {{2,5},{5,9}};
//        String s = "***|**|*****|**||**|*";
//        int [][] queries = {{1,17},{4,5},{14,17},{5,11},{15,16}};
        platesBetweenCandles(s,queries);
    }
    public static int[] platesBetweenCandles(String s, int[][] queries) {
        int [] ret = new int[queries.length];
        int index =0;
        for (int[] q : queries){
            ret[index++] = helper(s,q[0],q[1]);
        }
        return ret;
    }

    public static int helper(String s , int i, int j){
        String subStr = s.substring(i, j + 1);
        int count = 0;
        int start = 0;
        int end = 0;
        while (start !=-1 || end != -1){
            start = subStr.indexOf('|',start);
            end = subStr.indexOf('|',start+1);
//            System.out.println(subStr + " : " + start + " : " + end);
//            subStr.substring(end);
            if (start != -1 && end !=-1){
                while (start<=end){
                    if (subStr.charAt(start) == '*') count++;
                    start++;
                }
            }
            start=end;
        }
//        System.out.println(count);


        return count;
    }
}
