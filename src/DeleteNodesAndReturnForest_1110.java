import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodesAndReturnForest_1110 {
    List<TreeNode> ret;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            ret = new ArrayList<>();
            Set<Integer> set = new LinkedHashSet<>();
            for (int del : to_delete)set.add(del);
            root = helper(root, set);
            if (root != null) ret.add(root);

        return ret;

    }

    public TreeNode helper(TreeNode root, Set<Integer> delete){
        if (root != null){
            root.left = helper(root.left,delete);
            root.right = helper(root.right,delete);
            if (delete.contains(root.val)){
                if (root.left != null) ret.add(root.left);
                if (root.right != null) ret.add(root.right);
                return null;
            }return root;
        }else return null;
    }
}
