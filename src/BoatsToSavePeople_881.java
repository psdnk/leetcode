import java.util.Arrays;

public class BoatsToSavePeople_881 {
    public static void main(String[] args) {
        int [] people = {3,2,2,1};
        int limit = 3;
        System.out.println(numRescueBoats(people,limit));
    }
    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length-1;
        int res = 0;
        while (left<=right){
            res++;
           if (people[right] > limit) continue;
           if (people[left] + people[right]<=limit) left++;
           right--;
        }
        return res;
    }
}
