public class DiameterOfBinaryTree {


    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public int diameterOfBinaryTree(TreeNode root) {

//        int left = 0;
//        int right=0;
//        if (root.left){
//            left = getLength(root.left,0);
//        }
//        if (root.right != null){
//            left = getLength(root.right,0);
//        }

        if (root.left != null){
            return  1 + diameterOfBinaryTree(root.left);
        }else if (root.right != null){
            return  1 + diameterOfBinaryTree(root.right);
        }else {
            return 0;
        }


    }

    public  static  int getLength(TreeNode node , int length){
        if (node.left != null){
            return  getLength(node.left, length+1);
        }else if (node.right !=null){
            return getLength(node.right,length+1);
        }else {
            return length-1;
        }
    }
}
