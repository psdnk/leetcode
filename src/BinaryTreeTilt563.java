public class BinaryTreeTilt563 {
    public int findTilt(TreeNode root) {
        if (root != null){
            int left= root.val + findTilt(root.left);
            int right = root.val + findTilt(root.right);
            root.val = Math.abs(left-right);
        }
        return 0;

    }
}
