public class DetectCapitalUse {
    public boolean detectCapitalUse(String word) {
    int bigCase = 0;
    int smallCase = 0;
    boolean ret = false;
    for(char c : word.toCharArray()){
        if(Character.isLowerCase(c))smallCase++;
        else bigCase++;
    }
    if (bigCase==1 && Character.isUpperCase(word.charAt(0))) ret = true;
    if (smallCase == word.length() || bigCase== word.length()) ret = true;
    return ret;
}
}
