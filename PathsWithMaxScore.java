import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class PathsWithMaxScore {

    public static void main(String[] args) {
        List<String> board = Arrays.asList("E23","2X2","12S");
//        List<String> board = Arrays.asList("E12","1X1","21S");
//        List<String> board = Arrays.asList("E11","XXX","11S");
//        List<String> board = Arrays.asList("E5","XS");
//        List<String> board = Arrays.asList("E713399729","X151558988","5545833573","4366595255","23493768X9","8X24154768","1357922244","8921993297","8699512769","214631X17S");

        //pathsWithMaxScore(board);
        System.out.println(Arrays.toString(pathsWithMaxScoreV1(board)));
//        int row = board.size();
//        int col = board.get(0).length();
//        char [][] arr = new char[row][col];
//        boolean [][] visited = new boolean[row][col];
//        for (int i=0;i<board.size();i++){
//            arr[i] = board.get(i).toCharArray();
//        }
//        System.out.println(maxSum(arr,0,0));
//        System.out.println(max);

//        System.out.println(Arrays.toString(pathsWithMaxScore(board)));

    }

    public static int MAX = 0;
    public static int COUNT = 0;
    public static int MOD = 1000000007;

    static int max = 0;
    public  static  int maxSum(char[][] board,int i,int j){
        if (i < board.length && j< board[0].length){
//            if (Character.isDigit(board[i][j])){
            int s =0;
            if (Character.isDigit(board[i][j])) {
                s = Integer.parseInt(String.valueOf(board[i][j]));
            }


//                int a = s +maxSum(board,i+1,j+1) + maxSum(board,i,j+1) + maxSum(board,i+1,j);
//            max = max + s;
            int a = maxSum(board,i+1,j+1);
                int b=  maxSum(board,i,j+1);
                int c= maxSum(board,i+1,j);
                System.out.println(a);
                System.out.println(b);
                System.out.println(c);
             max = max < Math.max(a,Math.max(b,c))+s ? Math.max(a,Math.max(b,c))+s : max;
                //max =  Math.max(a,max);

//            }else {
//                return 0;
//            }
        }else if (i == board.length-1 && j== board[0].length-1 && board[i][j] != 'S'){
//            board[i][j] != 'X' || board[i][j] != 'E' || board[i][j] != 'S'
            return 0;
        }
        return 0;
    }
    public static int[] pathsWithMaxScore(List<String> board) {
        int row = board.size();
        int col = board.get(0).length();
        char [][] arr = new char[row][col];
        for (int i=0;i<board.size();i++){
            arr[i] = board.get(i).toCharArray();
        }
//        int r1= routeSum(arr,row-1,col-1,0,true,false,false);
//        System.out.println(r1);
//        int r2 = routeSum(arr,row-1,col-1,0,false,true,false);
//        System.out.println(r2);
//        int r3= routeSum(arr,row-1,col-1,0,false,false,true);
//        System.out.println(r2);
//        int max = Math.max(Math.max(r1,r2),r3);
//        int count = 0;
//        int [] ret = new int[2];
//        if(max == 0){
//            ret[0]=0;
//            ret[1]=0;
//        }else {
//            if(max == r1){
//                count =count +1;
//            }
//            if (max == r2){
//                count = count +1;
//            }
//            if (max == r3){
//                count =count +1;
//            }
//            ret[0]=max;
//            ret[1]=count;
//        }
//        return ret;

        dfs( arr,row-1,col-1,0 );
        System.out.println(MAX);
        System.out.println(COUNT);
        int [] ret = {MAX,COUNT};
        return ret;
    }


    public static int routeSum(char [][] box,int i,int j, int sum, boolean up, boolean left , boolean upLeft){
        List<Character> l = Arrays.asList('1','2','3','4','5','6','7','8','9');
        System.out.print(box[i][j]);
//        if ((j-1 >= 0 && box[i][j-1] != 'E') && (i-1 >= 0 && box[i-1][j] != 'E') || (j-1 >= 0 && i-1 >= 0 && box[i-1][j-1] == 'E')){
//            return  sum;
//        }else if ((j-1 >= 0 && box[i][j-1] == 'E') || (i-1 >= 0 && box[i-1][j] != 'E') || (j-1 >= 0 && i-1 >= 0 && box[i-1][j-1] != 'E')){
//            return  sum;
//        }else if ((j-1 >= 0 && box[i][j-1] != 'E') || (i-1 >= 0 && box[i-1][j] == 'E') || (j-1 >= 0 && i-1 >= 0 && box[i-1][j-1] != 'E')){
//            return  sum;
//        }
//        if (((j-1 >= 0 && box[i][j-1] == 'E') || (j-1 >= 0 && box[i][j-1] == 'X'))
//        && ((i-1 >= 0 && box[i-1][j] == 'E') || (i-1 >= 0 && box[i-1][j] == 'X'))
//        && ((j-1 >= 0 && i-1 >= 0 && box[i-1][j-1] == 'E') || (j-1 >= 0 && i-1 >= 0 && box[i-1][j-1] == 'X'))){
//            return  sum;
//        }
//        if ((j-1 >= 0 && box[i][j-1] == 'E') || (i-1 >= 0 && box[i-1][j] == 'E') || (j-1 >= 0 && i-1 >= 0 && box[i-1][j-1] == 'E')){
//            return  sum;
//        }
        System.out.println(l.contains('1'));
        if ((j-1 >= 0 && !l.contains(box[i][j-1])) && (i-1 >= 0 && box[i-1][j] != 'X') && (j-1 >= 0 && i-1 >= 0 && box[i-1][j-1] == 'E')){
            return  sum;
        }else if ((j-1 >= 0 && box[i][j-1] == 'E') && (i-1 >= 0 && !l.contains(box[i-1][j])) && (j-1 >= 0 && i-1 >= 0 && box[i-1][j-1] != 'X')){
            return  sum;
        }else if ((j-1 >= 0 && box[i][j-1] != 'X') && (i-1 >= 0 && box[i-1][j] == 'E') && (j-1 >= 0 && i-1 >= 0 && !l.contains(box[i-1][j-1]))){
            return  sum;
        }
        else {
            if (i-1 >= 0 && box[i-1][j] != 'X' && up){
                return routeSum(box,i-1,j,sum + Character.getNumericValue(box[i-1][j]),true,true,true);
            } else if(j-1 >= 0 && box[i][j-1] != 'X' && left){
              return routeSum(box,i,j-1,sum + Character.getNumericValue(box[i][j-1]),true,true,true);
            }else if ((j-1 >= 0 && i-1 >= 0 && box[i-1][j-1] != 'X' && upLeft)){
                return routeSum(box,i-1,j-1,sum + Character.getNumericValue(box[i-1][j-1]),true,true,true);
            }else {
                return 0;
            }
        }

    }

    public static void dfs(char[][]arr,int i,int j , int sum){
        if ( i> arr.length || j > arr[0].length || i< 0 || j<0 ){
            return;
        }
        System.out.println("sum - " +sum);
        char c = arr[i][j];
        System.out.println("c - " +c);
        if ( c == 'X' ){
            return;
        }
        if ( c == 'E' ){
            if ( MAX < sum ){
                MAX = sum;
                COUNT = 1;
            }else {
                if ( MAX == sum ) {
                    COUNT = COUNT + 1;
                }
            }
            return;
        }
        int num;
        if(c == 'S'){
            num = 0;
        }else {
            num = Integer.parseInt( ""+c+"" );
        }
        dfs( arr,i,j-1,(sum + num)%MOD );
        dfs( arr,i-1,j,(sum + num)%MOD );
        dfs( arr,i-1,j-1,(sum + num)%MOD );
    }


    public static int[] pathsWithMaxScoreV1(List<String> board) {
        int row = board.size();
        int col = board.get( 0 ).length();
        int MOD= (int)(1e9 +7);
        char[][] arr = new char[ row ][ col ];
        for ( int i = 0 ; i < board.size() ; i++ ) {
            arr[ i ] = board.get( i ).toCharArray();
        }
        int dp[][] = new int[row+1][col+1];
        int count[][] = new int[row+1][col+1];
        count[row-1][col-1] = 1;
        for ( int i=row-1;i>=0;i-- ){
            for ( int j=col-1;j>=0;j-- ){
                char c = arr[i][j];
                int num = 0;
                if ( c != 'X' ){
                    int max = Math.max( dp[i+1][j+1], Math.max( dp[i+1][j],dp[i][j+1] ) );
                    if ( c != 'E'  && c !='S' ){
                        num = Integer.parseInt( ""+c + "" );
                    }
//                    System.out.println(" i, j ,max , num :" + i +" , "+ j +" , "+ max +" , "+ num);
                    dp[i][j] = num + max;

                    if ( dp[i+1][j+1] == max ){
                        count[i][j] = (count[i][j] + count [i+1][j+1])%MOD;
                    }
                    if ( dp[i+1][j] == max ){
                        count[i][j] = (count[i][j] + count [i+1][j])%MOD;
                    }
                    if ( dp[i][j+1] == max ){
                        count[i][j] = (count[i][j] + count [i][j+1])%MOD;
                    }

                }

            }
        }

//        for ( int i = 0;i<=row;i++ ){
//            for ( int j = 0;j<=col;j++ ){
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
        return  count[0][0] > 0 ? new int[] {dp[0][0],count[0][0]} : new int[] {0,0};
        //return dp[0][0];
    }
}
