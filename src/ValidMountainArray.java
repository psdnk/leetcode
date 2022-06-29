public class ValidMountainArray {
    public static void main(String[] args) {
        int [] arr = {0,2,3,3,5,2,1,0};
//        int [] arr = {3,5,5};
        boolean ret = validMountainArray(arr);
        System.out.println(ret);
    }
    public static boolean validMountainArray(int[] arr) {
        int len = arr.length;
        if (len==1) return false;
        boolean down = false;
        boolean up = false;
        for (int i=1;i<len;i++){
            if (arr[i-1]<arr[i] && !down) up = true;
            if (arr[i-1]>arr[i] && !down)down = true;
            if (arr[i-1]<arr[i] && down) return false;
            if (arr[i-1] == arr[i]) return false;
        }
        return up==true && down == true ? true : false;
    }
}
