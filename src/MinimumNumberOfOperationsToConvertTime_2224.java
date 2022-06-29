public class MinimumNumberOfOperationsToConvertTime_2224 {
    public static void main(String[] args) {
        String current = "09:41";
        String correct = "10:34";
        System.out.println(convertTime(current,correct));
    }
    public static int convertTime(String current, String correct) {
        int currHr = Integer.parseInt(current.split(":")[0]);
        int currMin = Integer.parseInt(current.split(":")[1]);
        int corrHr = Integer.parseInt(correct.split(":")[0]);
        int corrMin = Integer.parseInt(correct.split(":")[1]);
        int count = 0;
        count = Math.abs(currHr-corrHr);
        int diff = Math.abs(corrMin-currMin);
        while (diff>0){
            while (diff>=15){
                count = count + diff/15;
                diff = diff%15;
            }
            while (diff>=5){
                count = count + diff/5;
                diff = diff%5;
            }
            while (diff>=1){
                count = count + diff/1;
                diff = diff%1;
            }
        }
        return count;
    }
}
