import java.util.HashSet;

public class DistinctEchoSubString {

    static HashSet<String> hs=new HashSet<String>();
    public static void main(String[] args) {
        System.out.println(distinctEchoSubstrings("tiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtiduxtidux"));
    }
    public static int distinctEchoSubstrings(String text) {
        int strLength = text.length();
        int count = 0;
        for (int i=0;i<strLength;i++){

            getEchoSubStrings(text.substring(i,strLength));
        }
return hs.size();
    }


    public  static void getEchoSubStrings(String s){
        System.out.println("S: "+s);
//        int count =0;
        for (int i=1;i<s.length()-1;i++){
            int len = i+s.substring(0,i).length();
            //System.out.println("S1: "+ s.substring(0,i));
            //System.out.println("S2: "+ s.substring(i,i+s.substring(0,i).length()));
            if ((len <= s.length()) && (s.substring(0,i).equals(s.substring(i,len)))){
//                count =count + 1;
                hs.add(s.substring(0,i));
                System.out.println("S1: "+ s.substring(0,i));
                System.out.println("S2: "+ s.substring(i,i+s.substring(0,i).length()));
                System.out.println("Match: "+ s.substring(0,i));
            }
        }
    }
}
