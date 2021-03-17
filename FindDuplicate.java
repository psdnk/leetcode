import java.util.Stack;

public class FindDuplicate {

    public static void main(String[] args) {
        int [] nums = {1,3,4,4,2};
        Stack<Integer> s= new Stack<> ();
        s.push ( 3 );
        System.out.println (s.toString ());
        System.out.println (findDuplicate ( nums ));
    }
    public static int findDuplicate(int [] nums){
        int slow = nums[0];
        int fast = nums[0];

        do{
             slow = nums[slow];
             fast = nums[nums[fast]];
        }while(slow != fast);

        fast = nums[0];
        while (fast!= slow){
            slow = nums[slow];
            fast = nums[fast];
        }

        return fast;

    }
}
