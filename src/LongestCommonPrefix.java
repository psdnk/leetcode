import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        LinkedHashMap<String,Integer> map =new LinkedHashMap<>();
        for (String str : strs){
            for (int i=0;i<str.length();i++){
                char c = str.charAt(i);
                map.put(c+"_" + i,map.getOrDefault(c+"_" + i,0)+1);
            }
        }
        System.out.println(map.toString());
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String,Integer> entry : map.entrySet()){
            if (entry.getValue() == strs.length){
                sb.append(entry.getKey().split("_")[0]);
            }else break;
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
//        String [] strs = {"flower","flow","flight"};
        String [] strs = {"dog","racecar","car"};
        System.out.println(longestCommonPrefix.longestCommonPrefix(strs));
    }

}
