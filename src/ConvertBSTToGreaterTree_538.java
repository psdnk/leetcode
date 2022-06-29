public class ConvertBSTToGreaterTree_538 {
        int sum = 0;
        public TreeNode convertBST(TreeNode root) {
            helper(root);
            return root;
        }
        public void helper(TreeNode root){
            if (root != null){
                helper(root.right);
                sum = sum + root.val;
                root.val = sum;
                helper(root.left);
            }
        }
}
