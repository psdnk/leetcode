import java.util.*;

public class BinaryTreeLevelOrderTraversalII {



    public static void main(String[] args) {
        TreeNode root = new TreeNode (3);
        root.left = new TreeNode (9);
        root.right = new TreeNode (20);
        root.right.left =new TreeNode (15);
        root.right.right =new TreeNode (7);
        System.out.println (levelOrderBottom ( root ));


    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {

        if ( root == null ){
            return null;
        }
        Queue<TreeNode> q =new LinkedList<> ();
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> bucket = new ArrayList<>();
        int currentLevel = 1;
        int nextLevel = 0;

        q.add ( root );

        while (!q.isEmpty ()) {
            TreeNode curr = q.poll ();
            currentLevel--;
            bucket.add ( curr.val );
            if ( curr.left != null ) {
                q.add ( curr.left );
                nextLevel++;
            }
            if ( curr.right != null ) {
                q.add ( curr.right );
                nextLevel++;
            }
            if ( currentLevel == 0 ) {
                ret.add ( bucket );
                bucket = new ArrayList<> ();
                currentLevel = nextLevel;
                nextLevel = 0;
            }
        }
         Collections.reverse (ret);
        return ret;


    }

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
}
