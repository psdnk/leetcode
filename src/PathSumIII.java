public class PathSumIII {
    public static int count =0;
    public static int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        helper(root,targetSum,0);
        pathSum(root.left,targetSum);
        pathSum(root.right,targetSum);
        return count;
    }

    public static void helper(TreeNode root,int targetSum,int currentSum){
        if(root == null) return;
        currentSum = currentSum + root.val;
        if(currentSum == targetSum) count++;
        helper(root.left,targetSum, currentSum);
        helper(root.right,targetSum, currentSum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        System.out.println(pathSum(root,8));

    }
}
