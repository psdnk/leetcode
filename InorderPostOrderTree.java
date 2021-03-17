import java.util.TreeMap;

public class InorderPostOrderTree {

    class TreeNode {
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

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        return constructTreeFromInorderandPostOrder ( inorder,postorder,0,inorder.length-1,postorder.length-1 );

    }

    private TreeNode constructTreeFromInorderandPostOrder(int[] inorder,int [] postorder,int start,int end, int index ){
        if ( start> end )return null;
        TreeNode root = new TreeNode (postorder[index]);
        int inorderRootIndex = start;
        while (postorder[index] != inorder[inorderRootIndex])inorderRootIndex++;
        root.right = constructTreeFromInorderandPostOrder ( inorder,postorder,inorderRootIndex+1,end,index-1 );
        root.left = constructTreeFromInorderandPostOrder ( inorder,postorder,start,inorderRootIndex-1,index-(end-inorderRootIndex)-1 );

        return root;

    }
}



