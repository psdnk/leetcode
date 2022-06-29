public class SortAnArray_912 {

    public static void main(String[] args) {
        SortAnArray_912 sortAnArray_912 = new SortAnArray_912();
        int [] nums = {-1,5,3,4,0};
        sortAnArray_912.sortArray(nums);
    }
    public int[] sortArray(int[] nums) {
        int len =nums.length;
        int [] aux = new int[len];
        sort(nums,aux,0,len-1);
        return nums;
    }

    public void sort(int [] nums,int [] aux, int low, int high){
        if (low<high) {
            int mid = low + (high - low) / 2;
            sort(nums,aux, low, mid);
            sort(nums, aux,mid + 1, high);
            merge(nums,aux,low,mid,high);
        }
    }

    public void merge(int [] nums,int []aux, int low, int mid , int high){
        for (int i=low;i<=high;i++)
            aux[i] = nums[i];
        int i=low;
        int j=mid+1;
        int k=low;

        while (i<=mid && j<=high){
            if (aux[i]<aux[j]){
                nums[k] = aux[i];
                i++;
            }else {
                nums[k] = aux[j];
                j++;
            }
            k++;
        }
        while (i<=mid){
            nums[k] = aux[i];
            i++;
            k++;
        }
        while (j<=high){
            nums[k] = aux[j];
            j++;
            k++;
        }
    }
}
