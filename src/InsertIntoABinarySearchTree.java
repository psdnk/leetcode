public class InsertIntoABinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        preorder(insertIntoBST(root,5));
        preorder(root);

    }
    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode curr = root;
        while (true){
            if (curr.val <= val){
                if (curr.right != null) curr = curr.right;
                else{ curr.right = new TreeNode(val); break;}
            }else {
                if (curr.left != null) curr = curr.left;
                else{ curr.left = new TreeNode(val); break;}
            }
        }
        return root;

    }

    public  static void  preorder(TreeNode root){
        if (root != null){
            System.out.print(root.val + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }
}
