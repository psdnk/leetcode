public class WordSearchLeetcode {


    int index=0;
    boolean exist=false;
    public boolean exist(char[][] board, String word) {


        if(word.length()==0){
            return true;
        }else{
            for(int i=0;i< board[0].length;i++){
                for (int j=0;j<board.length;j++){


                    /*
                    int row=i;
                    int col=j;
                    if(row >= 0 && row < board.length && col >= 0 && col < board[0].length && word.charAt(index)==board[row][col]){
                        index=index+1;
                        i=row;
                        j=col;
                        return exist(board,word.substring(index));
                    }
                     row=i;
                     col=j-1;
                    if(row >= 0 && row < board.length && col >=0 && col < board[0].length && word.charAt(index)==board[row][col]){
                        index=index+1;
                        i=row;
                        j=col;
                        return exist(board,word.substring(index));
                    }
                    row=i;
                    col=j+1;
                    if(row >= 0 && row < board.length && col >=0 && col < board[0].length && word.charAt(index)==board[row][col]){
                        index=index+1;
                        i=row;
                        j=col;
                        return exist(board,word.substring(index));
                    }
                    row=i+1;
                    col=j;
                    if(row >= 0 && row < board.length && col >=0 && col < board[0].length && word.charAt(index)==board[row][col]){
                        index=index+1;
                        i=row;
                        j=col;
                        return exist(board,word.substring(index));
                    }
                    row=i-1;
                    col=j;
                    if(row >= 0 && row < board.length && col >=0 && col < board[0].length && word.charAt(index)==board[row][col]){
                        index=index+1;
                        i=row;
                        j=col;
                        return exist(board,word.substring(index));
                    }
                    else {
                        index=index-1;
                    }

*/
                }
            }
        }

        return false;


    }

    public void dfs(char[][]board,int i,int j,boolean [][]visited,String word,int index){

        if(index == word.length()){
            exist=true;
        }

        if(i>=0 && i< board.length && j>=0 && j < board[0].length && word.charAt(index)==board[i][j]){
            visited[i][j]=true;
            dfs(board,i+1,j,visited,word,index +1);
            dfs(board,i,j+1,visited,word,index +1);
            dfs(board,i-1,j,visited,word,index +1);
            dfs(board,i,j-1,visited,word,index +1);
            visited[i][j]=false;
        }



    }

    public static void main(String[] args) {
        char board[][] = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };


        WordSearchLeetcode w=new WordSearchLeetcode();
        System.out.println(w.exist(board,"ABCCED"));


    }

}
