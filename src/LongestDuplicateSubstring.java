import java.util.HashMap;

public class LongestDuplicateSubstring {
    public static void main(String[] args) {
        LongestDuplicateSubstring lds = new LongestDuplicateSubstring();
        String s = "pmyiaxmicpmvqywlkisfzzutlxxjipitwcfxgqqfnxizowkqfmzsvkxryknasyvthozahbmapwqocupxcktmmtddxgatzftamrsvtddjpbnrojcqonmzxmknashplmykdbadiiccdkbyyzifqxvqfwgwihxgnrhqlmqprnjawuzcotutbkgnykuuwtzzzppmoyfmplhpznpnlwwbndekakpsmehzmbcfoyudgwsvehzgsfwqdkihiiwxfskicrbmoevxvpmmymihlkmgnuyohcofzfkehccwxezxypnnvqzrilr";
        System.out.println(lds.longestDupSubstring(s));

    }
    public String longestDupSubstring(String s) {
        int len  = s.length();
        HashMap<String,Integer> hm= new HashMap<>();
        int max = Integer.MIN_VALUE;
        String maxStr = "";
        for (int i=0;i<len;i++){
            for (int j=i+1;j<=len;j++){
                String subStr = s.substring(i,j);
                int val = hm.getOrDefault(subStr,0)+1;
//                System.out.println(subStr + ":" + val);
                if (maxStr.length()<=subStr.length() && val>=max &&val>=2){
                    maxStr = subStr;
                    max = subStr.length();
                }
                hm.put(subStr,val);
            }
        }
        return maxStr;
    }
}
