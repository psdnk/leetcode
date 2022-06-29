public class CousinsInBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        CousinsInBinaryTree cb = new CousinsInBinaryTree();
        System.out.println(cb.isCousins(root,5,4));
    }
    int depthX = 0;
    int depthY = 0;
    TreeNode parentX= null;
    TreeNode parentY = null;
    public  boolean isCousins(TreeNode root, int x, int y) {
        find(root,x,y,0,root);
        return depthX==depthY && parentX!=parentY ? true : false;
    }

    public  void find(TreeNode root, int x,int y, int height,TreeNode parent){

        if (root == null) return;
            if (root.val == x) {
                depthX = height;
                parentX = parent;
            }
        if (root.val == y) {
            depthY = height;
            parentY = parent;
        }
        find(root.left,x,y,height+1,root);
        find(root.right,x,y,height+1,root);
    }
}
