import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IntersectionofTwoArraysII_350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        HashMap<Integer,Integer> hm = new HashMap<>();
        return len1>=len2 ? helper(nums1,nums2,hm) : helper(nums2,nums1,hm);
    }

    public int[] helper(int [] nums1, int [] nums2, HashMap<Integer,Integer> hm){
        List<Integer> list = new ArrayList<>();
        for(int num : nums1)hm.put(num,hm.getOrDefault(num,0)+1);
        for(int num : nums2){
            if(hm.containsKey(num) && hm.get(num)>0){
                list.add(num);
                hm.put(num,hm.get(num)-1);
            }
        }
        int index = 0;
        int [] ret = new int[list.size()];
        for (int l : list)ret[index++] = l;
        return ret;
    }
}
