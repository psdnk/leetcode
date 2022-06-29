import java.util.*;

public class MaximumFrequencyStack_895 {
    HashMap<Integer,Integer> count;
    int max;
    HashMap<Integer, List<Integer>> stack;

    public MaximumFrequencyStack_895(){
        count = new HashMap<>();
        stack = new HashMap<>();
        max = 0;
    }
    public void push(int val) {
        count.put(val,count.getOrDefault(val,0)+1);
        int c = count.get(val);
        max = max<c?c: max;
        stack.computeIfAbsent(c,k->new ArrayList<>()).add(val);
    }

    public int pop() {
        int res = stack.get(max).remove(stack.get(max).size()-1);
        count.put(res,count.get(res)-1);
        max = stack.get(max).size()==0 ? max-1 : max;
        return res;
    }
}
