import com.sun.source.tree.Tree;

public class SumRootToLeafNumbers {
//    StringBuilder sb = new StringBuilder();
//    int sum = 0;
    public int sumNumbers(TreeNode root) {
       return helper(root,0);
    }

    public  int helper(TreeNode root, int sum){
        if (root == null) return  0;
        sum = sum*10 + root.val;
        if (root.left == null && root.right == null) return  sum;
        return helper(root.left,sum) + helper(root.right,sum);
    }
    public static void main(String[] args) {
        SumRootToLeafNumbers sumRootToLeafNumbers = new SumRootToLeafNumbers();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
//        root.right.right = new TreeNode(12);
        System.out.println(sumRootToLeafNumbers.sumNumbers(root));
        
    }
}
