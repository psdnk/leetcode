import com.sun.source.tree.Tree;

public class SumOfLeftLeaves {
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        helper(root,false);
        return sum;
    }
    public  void helper(TreeNode root,boolean isLeft){
        if (root != null){
            if (isLeft && root.left == null && root.right == null) sum = sum + root.val;
            if (root.left != null) helper(root.left,true);
            helper(root.right,false);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        SumOfLeftLeaves s = new SumOfLeftLeaves();
        System.out.println(s.sumOfLeftLeaves(root));
    }
}
