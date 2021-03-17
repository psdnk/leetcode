public class PathSumIII {

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
    int count = 0;
    public int pathSum(TreeNode root, int sum) {

        if ( root == null ){
            return 0;
        }
        helper ( root,sum,0 );
        pathSum ( root.left,sum );
        pathSum ( root.right,sum );
        return count;
    }

    public void helper(TreeNode node,int sum,int currentSum){
//        if ( sum == currentSum ){
//            return 1;
//        }
//        if ( node == null ){
//            return 0;
//        }
//        return helper ( node.left,sum,currentSum+node.val ) + helper ( node.right,sum,currentSum+node.val );
        if ( node == null ){
            return;
        }
        currentSum += node.val;
        if ( currentSum == sum ){
            count++;
        }
        helper ( node.left,sum,currentSum );
        helper ( node.right,sum,currentSum );
    }
}
