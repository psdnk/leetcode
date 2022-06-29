public class AreNumbersAscending {
    public static boolean areNumbersAscending(String s) {
        String[] tokens = s.split(" ");
        int prev = Integer.MIN_VALUE;
        for (String token:tokens){
            if (isNumeric(token)){
                int val = Integer.valueOf(token);
                if (prev>=val) return false;
                prev = val;
            }
        }
        return true;
    }

    public static boolean isNumeric(String t){
        for (char c: t.toCharArray()){
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "1 box has 3 blue 4 red 6 green and 12 yellow marbles";
        System.out.println(areNumbersAscending(s));
    }
}
