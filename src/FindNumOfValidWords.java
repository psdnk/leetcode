import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class FindNumOfValidWords {
    public static void main(String[] args) {
//        String [] words = {"aaaa","asas","able","ability","actt","actor","access"};
//        String [] puzzles = {"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"};
        String [] words = {"apple","pleas","please"};
        String [] puzzles = {"aelwxyz","aelpxyz","aelpsxy","saelpxy","xaelpsy"};

        findNumOfValidWords(words,puzzles);
    }
    public static List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        List<Integer> ret = new ArrayList<>();

        for (String puzzle :puzzles){
            int count=0;
            LinkedHashSet<Character> set = new LinkedHashSet<>();
            System.out.println(puzzle);
            for (char c : puzzle.toCharArray())set.add(c);
            for (String word:words){
                boolean pass = true;
                if (!word.contains("" + set.iterator().next() + "")){
                    pass = false;
                }else {
                    for (int i = 0; i < word.length(); i++) {
//                    if (i==0){
//                        while (set.iterator().next() != word.charAt(i)){
//                            pass=false;
//                            break;
//                        }
//                    }
                        if (!set.contains(word.charAt(i))) {
                            pass = false;
                            break;
                        }
                    }
                }
                if (pass){
                    System.out.print(word + " - ");
                    count ++;
                }else {
                    System.out.print(word + " ? ");
                }
            }
            System.out.println();
            ret.add(count);
        }
        System.out.println(ret.toString());
        return ret;
    }
}
