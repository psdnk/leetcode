public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int [] tracker = new int[101];
        for (int i=0;i<temperatures.length;i++){
            tracker[temperatures[i]] = i;
        }
        return null;
    }
}
