
import java.util.HashSet;

public class CountElements {

    public static void main(String[] args) {
//        int arr [] = {1,1,2};
//        int arr [] = {3,4,5,2};
        int arr [] = {10,2,5,2};
        //System.out.println(countElements(arr));
        System.out.println(maxProduct( arr ));

    }


    public static int maxProduct(int[] nums) {

        int i = 0;
        int j = 0;
        int maxi = Integer.MIN_VALUE;
        int maxj = Integer.MIN_VALUE;
        for(int k=0;k<nums.length;k++){
            if(maxi < nums[k]){
                maxi = nums[k];
                i=k;
            }
        }
        for(int k=0;k<nums.length;k++){
            if(maxj < nums[k] && k != i){
                maxj = nums[k];
                j=k;
            }
        }

        return (nums[i]-1)*(nums[j]-1);

    }

    public static int countElements(int[] arr) {
        HashSet<Integer> hm= new HashSet<>();
        for (int i=0;i<arr.length;i++){
        hm.add(arr[i]);
    }
    int count =0;
    for (int i=0;i<arr.length;i++){
        if (hm.contains(arr[i]+1)){
            count =count + 1;
        }
    }
    return count;
}

}
