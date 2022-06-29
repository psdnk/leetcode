import java.util.Arrays;

class TrieNode{
    TrieNode [] next;
    public TrieNode(){
        next = new TrieNode[2];
        Arrays.fill(next,null);
    }
}
public class MaximumXOROfTwoNumbersInAnArray421 {
    TrieNode root = new TrieNode();
    int max = Integer.MIN_VALUE;
    public int findMaximumXOR(int[] nums) {
        for (int num : nums){
            insert(num,root);
//            int val = maxXor(num,root);
//            System.out.println(val);
            max = Math.max(max,maxXor(num,root));
        }
        return max;
    }

    public void insert(int num , TrieNode root){
        TrieNode curr = root;
        for (int i=31;i>=0;i--){
            int bit = (num >> i) & 1;
            if (curr.next[bit] == null){
                curr.next[bit] = new TrieNode();
            }
            curr = curr.next[bit];
        }
    }

    public int maxXor(int num , TrieNode root){
        TrieNode curr = root;
        int ans = 0;
        for (int i=31;i>=0;i--){
            int bit = (num>>i)&1; // right shift will move MSB to LSB ex: [1]00 >>2 -> 00[1] and and operation will tell if the high(1) or low(0)
            if (curr.next[bit ==0 ? 1 : 0] != null) { //this condition checks if bit is zero, then we need 1 to set it . so we will cheeck if next[1] exist and add it to ans variable
                ans = ans + (1 << i);
                curr = curr.next[bit ==0 ? 1 : 0];
            }else {
                curr = curr.next[bit ==0 ? 0 : 1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximumXOROfTwoNumbersInAnArray421 maxXor = new MaximumXOROfTwoNumbersInAnArray421();
        int [] nums = {3,10,5,25,2,8};
        int maximumXOR = maxXor.findMaximumXOR(nums);
        System.out.println(maximumXOR);
    }
}

