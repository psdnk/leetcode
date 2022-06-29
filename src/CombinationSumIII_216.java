import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII_216 {

    public static void main(String[] args) {
        int k = 3,n=9;

        List<List<Integer>> ret = combinationSum3(k, n);
        for (List<Integer> r: ret) System.out.println(r.toString());
    }
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ret = new ArrayList<>();
        int [] num = new int[]{1,2,3,4,5,6,7,8,9};
        helper(num,0,k,n,0,new ArrayList<>(),ret);
        return ret;
    }


    public static void helper(int[] num, int index, int k , int n , int val,List<Integer> list, List<List<Integer>> ret){
        if (index == num.length){
            if (k==0 && val == n) ret.add(new ArrayList<>(list));
            return;
        }
        list.add(num[index]);
        helper(num,index+1,k-1,n,val+num[index],list,ret);
        list.remove(list.size()-1);
        helper(num,index+1,k,n,val,list,ret);
    }
}
