import java.util.HashMap;


public class WordPatternLeetCode {

    public static boolean isWordPattern(String pattern,String[] wordList){

        HashMap<String,Character> map=new HashMap<>();
        for(int i=0;i<pattern.length();i++){
            map.put(wordList[i],pattern.charAt(i));
        }

        StringBuilder sb=new StringBuilder();

        for (int i=0;i<wordList.length;i++){
            sb.append(map.get(wordList[i]));
        }
        if(sb.toString().equals(pattern)){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        String [] wordList={"dog", "cat" ,"cat", "dog1"};
        System.out.println(isWordPattern("abba",wordList));

    }
}
