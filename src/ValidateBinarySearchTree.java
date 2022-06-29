public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if (root != null){
            isValidBST(root.left);
            isValidBST(root.right);
        }
        if(root == null) return true;
        if (root.left != null && root.right != null && root.val> root.left.val && root.val < root.right.val) return true;
        if (root.left != null && root.right == null && root.val> root.left.val) return true;
        if (root.left == null && root.right != null && root.val < root.right.val) return true;
        return false;
    }
}
