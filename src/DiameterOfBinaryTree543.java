public class DiameterOfBinaryTree543 {

      public class TreeNode {
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
      int max = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
          if (root == null) return -1;
          int left = diameterOfBinaryTree(root.left);
          int right = diameterOfBinaryTree(root.right);
          max = max< (left+right + 2) ? left+right+2 : max;
          return Math.max(left,right)+1;


    }
}
