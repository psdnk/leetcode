import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class SumOfRootToLeafBinaryNumbers {
    int sum = 0;

    public static void main(String[] args) {
        SumOfRootToLeafBinaryNumbers s = new SumOfRootToLeafBinaryNumbers();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);

        System.out.println(s.sumRootToLeaf(root));
    }

    //    int sum = 0;
    public int sumRootToLeaf(TreeNode root) {
        helper(root, new ArrayList<>());
        return sum;

    }

    public void helper(TreeNode root, List<Integer> path) {
        if (root != null) {
            path.add(root.val);
            if (root.left == null && root.right == null) {
                for (int i = path.size() - 1; i >= 0; i--) {
                    sum = path.get(path.size() - i - 1) == 1 ? sum + (int) Math.pow(2, i) : sum;
                }
            }
                helper(root.left, path);
                helper(root.right, path);
                path.remove(path.size() - 1);
            }
        }
}
