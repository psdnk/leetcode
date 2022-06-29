import java.util.HashMap;

public class WordPattern {
    public static void main(String[] args) {
        String pattern = "abba";
        String s =  "dog dog dog dog";
        boolean ret = wordPattern(pattern,s);
        System.out.println(ret);
    }
    public static boolean wordPattern(String pattern, String s) {
        String [] arr = s.split(" ");
        if (arr.length != pattern.length()) return false;
//        HashMap<String,Character> hm= new HashMap<>();
        HashMap<Character,String> map= new HashMap<>();
        int index = 0;
//        for (String st : arr){
//            char ch = pattern.charAt(index);
//            if (!hm.containsKey(st)) hm.put(st, ch);
//            else if (hm.get(st) != ch) return false;
//            index++;
//        }
        for (int i=0;i<pattern.length();i++){
            String st = arr[i];
            char ch = pattern.charAt(i);
            if (!map.containsKey(ch) && map.containsValue(st)) return false;
//            else if (!map.containsKey(ch)) map.put(ch, st);
            else if (map.containsKey(ch) && !map.get(ch).equals(st)) return false;
            map.put(ch, st);
        }
//        for (int i=0;i<arr.length;i++){
//            char ch = pattern.charAt(i);
//            if (map.containsKey(ch)){
//                if (!arr[i].equals(map.get(ch))) return false;
//            }else {
//                if (map.containsKey())
//            }
//        }
        return true;

    }
}
