import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SmallestValueOfTheRearrangedNumber_2165 {

    public static void main(String[] args) {
        System.out.println(smallestNumber(0));
    }
    public static long smallestNumber(long num) {
        List<Long> list = new ArrayList<>();
        boolean isNegative = false;
        if (num<0) isNegative = true;

        num = Math.abs(num);
        while (num>0){
            list.add(num%10);
            num = num/10;
        }
        if (!isNegative) {
            Collections.sort(list);
            if (list.size()>=2 && list.get(0)==0){
                int index = 0;
                while (index<list.size() && list.get(index)==0)index++;
                long val = list.get(index);
                long first = list.get(0);
                list.set(0,val);
                list.set(index,first);
                System.out.println(list);
            }
        }
        else Collections.sort(list,Collections.reverseOrder());
        System.out.println(list);
        long res = helper(list);
        return  isNegative==true ? -1*res : res;
    }

    public static long helper(List<Long> list){
        long ret = 0;
        for (int i=0;i<list.size();i++){
            ret = ret*10 + list.get(i);
        }
        return ret;
    }
}
