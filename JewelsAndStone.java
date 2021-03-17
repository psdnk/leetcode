import java.util.HashMap;

public class JewelsAndStone {


    public static void main(String[] args) {
        String J = "aA";
        String S = "aAAbbbb";
        System.out.println(numJewelsInStones(J,S));

    }
    public static  int numJewelsInStones(String J, String S) {
        int count = 0;
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for (int i=0;i<S.length();i++){
            if (hashMap.containsKey(S.charAt(i))) {
                hashMap.put(S.charAt(i), hashMap.get(S.charAt(i)) + 1);
            }else {
                hashMap.put(S.charAt(i),1);
            }
        }
        for (int i=0;i<J.length();i++){
            if (hashMap.containsKey(J.charAt(i))){
                count = count + hashMap.get(J.charAt(i));
                hashMap.remove(J.charAt(i));
            }
        }

        return count;

    }
}
