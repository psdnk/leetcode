import java.util.HashMap;

public class DeepestLeavesSum_1302 {

    int maxHeight = Integer.MIN_VALUE;
    int sum = 0 ;
    public int deepestLeavesSum(TreeNode root) {
        helper(root,0);
        return sum;
    }

    public void helper(TreeNode root, int height){
        if (root != null){
            helper(root.left,height+1);
            if (root.left == null && root.right == null && height == maxHeight)sum +=  root.val;
            else if (root.left == null && root.right == null && height > maxHeight){
                sum = root.val;
                maxHeight = height;
            }
            helper(root.right,height+1);
        }
    }
}
