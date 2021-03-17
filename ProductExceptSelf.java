public class ProductExceptSelf {


    public int[] productExceptSelf(int[] nums) {

        int product = 1;
        for (int num : nums){
            product = product * num;
        }
        for (int i=0;i<nums.length;i++){
            nums[i] = nums[i] ^ product;
        }
        return nums;

    }
}
