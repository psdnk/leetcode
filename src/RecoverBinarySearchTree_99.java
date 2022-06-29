import com.sun.source.tree.Tree;

public class RecoverBinarySearchTree_99 {
    TreeNode prev;
    TreeNode first;
    TreeNode middle;
    TreeNode last;
    public  void recoverTree(TreeNode root) {
        first = middle = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        if (first!= null && last != null){
            TreeNode temp = first;
            first = last;
            last = temp;
        }else if (first != null && middle != null){
            TreeNode temp = first;
            first = middle;
            middle = temp;
        }
    }

    public void inorder(TreeNode root){
        if (root == null) return;
        inorder(root.left);
        if (prev != null && prev.val> root.val){
            if (first== null){
                first = prev;
                middle = root;
            }else last = root;
        }
        prev = root;
        inorder(root.right);
    }

    public static TreeNode getMin(TreeNode root,TreeNode node){
        if(root != null){
            node = node.val > root.val ? root : node;
            TreeNode left = getMin(root.left,node);
            TreeNode right = getMin(root.right,node);
            return left.val < right.val ? left : right;
        }
        else return node;
    }

    public static TreeNode getMax(TreeNode root,TreeNode node){
        if(root != null){
            node = node.val < root.val ? root : node;
            TreeNode left = getMax(root.left,node);
            TreeNode right = getMax(root.right,node);
            return left.val > right.val ? left : right;
        }
        else return node;
    }
}
