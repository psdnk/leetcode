public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        int len1= haystack.length();
        int len2 = needle.length();
        if (len1==0 || len2 == 0) return 0;
        boolean pass = false;
        for (int i=0;i<len1;i++){
            int index = i;
             for (int j=0;j<len2;j++){
                 if (haystack.charAt(index) == needle.charAt(j)){
                     pass=true;
                     index++;
                 }
                 else {
                     pass=false;
                     break;
                 }
             }
             if (pass) return i;
        }
        return -1;


    }
}
