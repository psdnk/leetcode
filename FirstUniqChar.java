import java.util.*;

public class FirstUniqChar {

    public static void main(String[] args) {
        System.out.println(firstUniqCharV1("loveleetcode"));
    }

    public static  int firstUniqChar(String s) {
        HashMap<Character, Integer> hm  = new LinkedHashMap<>();
        HashMap<Character, Integer> hmVsIndex  = new LinkedHashMap<>();

        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            hm.put(c,hm.getOrDefault(c,0)+1);
            hmVsIndex.put(c,i);
        }
        Iterator<Character> iterator = hm.keySet().iterator();
        while (iterator.hasNext()){
            char key = iterator.next();
            if (hm.get(key) == 1){
                return hmVsIndex.get(key);
            }
        }
        return -1;

    }

    public static  int firstUniqCharV1(String s) {
        int index = -1;
        int [] arr =new int [26];
        Arrays.fill(arr,0);
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            arr[c-'a'] = arr[c-'a'] + 1;
        }
        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if ((arr[c - 'a'] == 1)) {
                index = i;
                break;
            }
            }
        return index;

    }
}
