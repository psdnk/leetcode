import java.util.*;

public class WordSearchII {

    List<String> ret = new ArrayList<>();
    Set<String > set =  new HashSet<>();
    public static void main(String[] args) {
//        char [][] board = {
//                {'o','a','a','n'},
//                {'e','t','a','e'},
//                {'i','h','k','r'},
//                {'i','f','l','v'}
//        };
//        char [][] board = {
//                {'a','b'},
//                {'a','a'}
//        };
        char [][] board = {{'s','e','e','n','e','w'},{'t','m','r','i','v','a'},{'o','b','s','i','b','d'},{'w','m','y','s','e','n'},{'l','t','s','n','s','a'},{'i','e','z','l','g','n'}};

//        char [][] board = {
//                {'a','a'}
//        };

//        String[] words = {"oath","pea","eat","rain"};

        String[] words = {"aba","baa","bab","aaab","aaa","aaaa","aaba"};


//        String[] words = {"aaa"};
        WordSearchII w = new WordSearchII ();
        List<String> words1 = w.findWords ( board , words );
        System.out.println (words1.toString ());

    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie ( );
        for ( String word : words ){
            trie.insert ( word,trie );
            //System.out.println (trie.search ( word,trie ));
            //System.out.println (trie.startsWith ( "aaaa",trie ));
        }
        //System.out.println (trie.search ( "aaa",trie ));
        boolean [][] visited = new boolean[board.length][board[0].length];
//        for ( int i=0;i<visited.length;i++ ){
//            Arrays.fill (visited[i],false);
//        }
        for ( int i=0;i<board.length;i++ ){
            for ( int j=0;j<board[i].length;j++ ){

                for ( int k=0;k<visited.length;k++ ){
                    Arrays.fill (visited[k],false);
                }
                    dfs ( board,trie,i,j,"",visited );

            }
        }

        ret.addAll(set);
        return ret;
    }


    public void dfs(char[][] board,Trie trie,int i,int j,String s,boolean[][] visited){
        if ( i<0 || i>=board.length || j< 0 || j>=board[i].length || visited[i][j]   ){
            return;
        }
        s = s + board[i][j];
        visited[i][j] = true;
        if ( trie.search ( s,trie ) ){
            set.add ( s );
            visited[i][j] = false;
            return;
        }
        if ( trie.startsWith ( s,trie ) ){

               dfs ( board,trie,i-1,j,s,visited );

                dfs ( board,trie,i+1,j,s,visited );

                dfs ( board,trie,i,j-1,s,visited );

                dfs ( board,trie,i,j+1,s,visited );
            //visited[i][j] = true;

        }
        visited[i][j] = false;
    }
    public class Trie{
        Trie [] node;
        char data;
        boolean isEnd;
        public Trie(char data){
            node = new Trie[26];
            this.data = data;
            this.isEnd = false;
        }
        public Trie(){
            node = new Trie[26];
            this.isEnd = false;
        }
        public void insert(String s,Trie trie){
            Trie  temp = trie;
            for ( char c : s.toCharArray () ){
                if ( temp.node[c-'a'] == null ){
                    temp.node[c-'a'] = new Trie ( c );
                }
                temp = temp.node[c-'a'];
            }
            temp.isEnd = true;
        }

        public boolean search(String s,Trie trie){
            Trie  temp = trie;
            for ( char c : s.toCharArray () ) {
                if ( temp.node[c-'a'] == null ){
                    return false;
                }
                temp = temp.node[c-'a'];
            }
            if ( temp.isEnd){
                temp.isEnd=false;
                return true;
            }
            return false;
        }

        public boolean startsWith(String s, Trie trie){
            Trie temp = trie;
            for ( char c : s.toCharArray () ) {
                if ( temp.node[c-'a'] == null ){
                    return false;
                }
                temp = temp.node[c-'a'];
            }
            return true;

        }

        
    }
}
