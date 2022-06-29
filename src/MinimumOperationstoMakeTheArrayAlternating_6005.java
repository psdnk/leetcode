public class MinimumOperationstoMakeTheArrayAlternating_6005 {

    public static void main(String[] args) {
        int [] nums = {69,91,47,74,75,94,22,100,43,50,82,47,40,51,90,27,98,85,47,14,55,82,52,9,65,90,86,45,52,52,95,40,85,3,46,77,16,59,32,22,41,87,89,78,59,78,34,26,71,9,82,68,80,74,100,6,10,53,84,80,7,87,3,82,26,26,14,37,26,58,96,73,41,2,79,43,56,74,30,71,6,100,72,93,83,40,28,79,24};
        System.out.println(minimumOperations(nums));
    }
    public static int minimumOperations(int[] nums) {
        int n = nums.length;
        int count =0;
        int prev = nums[1];
        int pprev = nums[0];

        for (int i=2;i<n;i++){
            int curr = nums[i];
            if (pprev != curr){
                count++;
                nums[i] = pprev;
            }
            if (prev == curr)count++;
            pprev = prev;
            prev = curr;
        }
        return count;

    }
}
