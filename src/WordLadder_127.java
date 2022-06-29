import java.util.*;
;

public class WordLadder_127 {

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"});
        System.out.println(ladderLength(beginWord,endWord,wordList));
    }
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wl = new HashSet<>(wordList);
        Queue<Map.Entry<String,Integer>> queue = new LinkedList<>();
        queue.add(Map.entry(beginWord,1));
        
        while (!queue.isEmpty()){
            Map.Entry<String, Integer> word = queue.poll();
            char[] w = word.getKey().toCharArray();
            int val =word.getValue();
            if (word.getKey().equals(endWord)) return val;
            wl.remove(word.getKey());
            for (int i=0;i<w.length;i++){
                char c = w[i];
                for (int j=0;j<26;j++){
                    w[i] = (char) ('a' + j);
                    String s = String.valueOf(w);
                    if (wl.contains(s)){
                        queue.add(Map.entry(s,val+1));
                        System.out.println(s);
                    }
                }
                w[i]=c;
            }
        }
        return 0;

    }
}
