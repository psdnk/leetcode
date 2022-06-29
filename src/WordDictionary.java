import java.util.Arrays;

public class WordDictionary {
    TrieNode root;
    class TrieNode{
        TrieNode [] next;
        char val;
        boolean isEOW;
        public TrieNode(){
            next = new TrieNode[27];
            Arrays.fill(next,null);
            isEOW = false;
        }
    }

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if (curr.next[c-'a'] == null){
                curr.next[c-'a'] = new TrieNode();
            }
            if (i == word.length()-1)curr.next[c-'a'].isEOW = true;
            curr =curr.next[c-'a'];
        }
    }

    public boolean search(String word) {
       return helper(word,0,root);
    }


    public boolean helper(String word , int index ,  TrieNode node){
       char c = word.charAt(index);
       if (word.length()-1 == index){
           if (c == '.'){
               for (int i=0;i<26;i++){
                   if (node.next[i] != null && node.next[i].isEOW) return true;
               }
               return false;
           }
           else if (node.next[c-'a'] ==  null) return false;
           else if (node.next[c-'a'] != null && node.next[c-'a'].isEOW) return true;
           else return false;
       }

       if (c == '.'){
           boolean check = false;
           for (int i=0;i<26;i++){
               if (node.next[i] != null){
                   check = helper(word,index+1,node.next[i]);
               }
               if (check)break;
           }
           return check;
       }
       else if (node.next[c-'a']== null) return false;
       else return helper(word,index+1,node.next[c-'a']);
    }


    public static void main(String[] args) {

        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        wordDictionary.addWord("pad");
        wordDictionary.addWord("bad");
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("b.."));
        System.out.println(wordDictionary.search("madddd"));

    }
}
