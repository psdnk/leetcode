public class ContainerWithMostWater_11 {
    int max = 0;
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        while (left<right){
            max = Math.max(max,Math.min(height[left],height[right])*(right-left));
            if (height[left]<height[right])left++;
            else right--;
        }
        return max;
    }
}
