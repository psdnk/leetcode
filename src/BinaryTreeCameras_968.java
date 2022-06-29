import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BinaryTreeCameras_968 {

    int cam;
    Set<TreeNode> covered;
    public int minCameraCover(TreeNode root) {
        if (root == null) return 0;
        cam =0;
        covered = new HashSet<>();
        covered.add(null);
        helper(root,null);
        return cam;
    }


    public void helper(TreeNode root, TreeNode parent){
        if (root != null){
            helper(root.left,root);
            helper(root.right,root);

            if (parent == null && !covered.contains(root) || !covered.contains(root.left) || !covered.contains(root.right)){
                cam++;
                covered.add(root);
                covered.add(parent);
                covered.add(root.left);
                covered.add(root.right);
            }
        }
    }
}
