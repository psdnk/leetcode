import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordSearch2 {

    public static void main(String[] args) {
//        char [][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
//        String [] words = {"oath","pea","eat","rain"};
        char [][] board = {{'o','a','b','n'},{'o','t','a','e'},{'a','h','k','r'},{'a','f','l','v'}};
        String [] words = {"oa","oaa"};
        List<String> res = findWords(board, words);
        System.out.println(res.toString());
    }
    public static List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        int n = board[0].length;
        List<String> result = new ArrayList<>();
       for (String word : words){
           boolean found = false;
           for (int i=0;i<m && !found;i++){
               for (int j=0;j<n && !found;j++){
                   if (word.charAt(0) == board[i][j] && !found){
                       if (dfs(i,j,board,word,0,m,n)){
                            result.add(word);
                            found = true;
                       }
                   }
               }
           }
       }
       return result;

    }

    private static boolean dfs(int i, int j, char[][] board, String word,int index, int m, int n) {
        if (index >= word.length()) return true;
        if (i<0 || i>=m || j<0 || j>=n)return false;
        if (board[i][j] == word.charAt(index)){
            char temp = board[i][j];
            board[i][j] = ' ';
            boolean ret = dfs(i-1,j,board,word,index+1,m,n) ||
                          dfs(i+1,j,board,word,index+1,m,n) ||
                          dfs(i,j-1,board,word,index+1,m,n) ||
                          dfs(i,j+1,board,word,index+1,m,n);
            board[i][j] = temp;
            return ret;
        }else {
            return false;
        }
    }
}
