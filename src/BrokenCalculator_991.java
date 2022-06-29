import java.util.HashMap;

public class BrokenCalculator_991 {
    public static void main(String[] args) {
        System.out.println(brokenCalc(2,3));
    }
    public static int brokenCalc(int startValue, int target) {
        if (startValue>=target) return startValue-target;
        if (target%2 == 0) return 1 + brokenCalc(startValue,target/2);
        return 1 + brokenCalc(startValue,target+1);
    }


}
