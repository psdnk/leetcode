public class BSTFromPreorder {
    
      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(5);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(12);

//        preorder(root);

        int [] preorder = {8,5,1,7,10,12};
        TreeNode ret = bstFromPreorder(preorder);
        preorder(ret);

    }
    public static TreeNode bstFromPreorder(int[] preorder) {
          TreeNode root = new TreeNode(preorder[0]);
          TreeNode current = root;
          return bst(root,preorder,1,current);
    }

    public static TreeNode bst(TreeNode root,int [] preorder,int index,TreeNode current){
          if (index >= preorder.length) return root;
          if (preorder[index] > current.val) {
              System.out.println("Right -- " +current.val + "--" +  preorder[index]);
              current.right = new TreeNode(preorder[index]);
              return bst(root,preorder,index+1,current.right);
          }else {
              System.out.println("Left -- " +  preorder[index] +"--" + current.val);
              current.left = new TreeNode(preorder[index]);
              return bst(root,preorder,index+1,current.left);
          }
    }

    public static void preorder(TreeNode root){
          if (root != null){
              System.out.print(root.val + " ");
              preorder(root.left);
              preorder(root.right);
          }
    }
}
