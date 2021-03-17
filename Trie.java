class Trie {


    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert( "apple" );
        t.insert( "applebook" );
        System.out.println(t.search( "applebook" ));
        System.out.println(t.startsWith( "app" ));
    }
    /** Initialize your data structure here. */
    TrieNode t;
    static  class  TrieNode{
        TrieNode [] children = new TrieNode[26];
        char data;
        boolean isEnd;
    }

    public Trie() {
         t = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode temp = t;
        for ( Character c : word.toCharArray() ){
            if ( temp.children[c-'a'] == null ){
                temp.children[c-'a'] = new TrieNode();
                temp.children[c-'a'].data = c;
                temp.children[c-'a'].isEnd = false;
                temp =  temp.children[c-'a'];
            }else {
                temp = temp.children[c-'a'];
            }
        }
        temp.isEnd=true;

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode temp = t;
        for ( Character c: word.toCharArray() ){
            if ( temp.children[c-'a'] != null ){
                temp =temp.children[c-'a'];
            }else {
                return false;
            }
        }
        if ( temp.isEnd ){
            return true;
        }
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode temp = t;
        for ( Character c: prefix.toCharArray() ){
            if ( temp.children[c-'a'] != null ){
                temp =temp.children[c-'a'];
            }else {
                return false;
            }
        }
        return true;
    }
}