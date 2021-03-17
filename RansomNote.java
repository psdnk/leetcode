import java.util.HashMap;

public class RansomNote {
    public static void main(String[] args) {
        String ransomNote = "fffbfg";
        String magazine = "effjfggbffjdgbjjhhdegh";
        System.out.println(canConstruct(ransomNote,magazine));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> hm = new HashMap();
        for (int i=0;i<magazine.length();i++){
            Character character = magazine.charAt(i);
            if (hm.containsKey(character)){
                hm.put(character,hm.get(character)+1);
            }else {
                hm.put(character,1);
            }
        }

        for (int i=0;i<ransomNote.length();i++){
            Character character = ransomNote.charAt(i);
            if (hm.containsKey(character)){
                if (hm.get(character) > 0){
                    hm.put(character,hm.get(character)-1);
                }else {
                    return false;
                }
            }else {
                return false;
            }
        }
        return true;
    }

}
