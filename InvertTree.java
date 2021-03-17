import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InvertTree {

    public static  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode invertTree(TreeNode root) {


        if(root!= null){
            invertTree( root.left );
            invertTree( root.right );
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        return root;

//        TreeNode ret = root;
//        Queue<TreeNode> queue = new LinkedList<>();
//
//        if ( root != null ){
//            queue.add(root);
//        }
//        while (!queue.isEmpty()){
//            TreeNode temp = queue.poll();
//            if ( temp.right != null ){
//                ret.left = temp.right;
//                queue.add(temp.right);
//            }
//            if ( temp.left != null ){
//                ret.right = temp.left;
//                queue.add(temp.left);
//            }
//        }
//        return ret;

    }
}
