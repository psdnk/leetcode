public class NonDecreasingArray_665 {

    public boolean checkPossibility(int[] nums) {

        int len  = nums.length;
        if (len==1) return true;
        boolean modified = false;
        for (int i=1;i<len;i++){
            if (nums[i-1]>nums[i]){
                if (modified) return false;
                modified = true;
                nums[i-1] = nums[i];
            }
        }
        return true;



    }
}
