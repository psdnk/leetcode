public class JumpGame {

    public static void main(String[] args) {
        int [] nums = {3,2,1,0,4};
        System.out.println(canJump(nums));
    }
    public static  boolean canJump(int [] nums){

        int maxReachable = 0;
        for (int i=0;i<nums.length;i++){
            if (maxReachable < i){
                return false;
            }
            maxReachable = Math.max(i+nums[i] , maxReachable);
        }
        if (maxReachable >= nums.length-1)return true;
        else return false;

    }
}
