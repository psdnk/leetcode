import java.util.ArrayList;
import java.util.List;


public class FindLeavesOfBinaryTree_366 {
        /*
         * @param root: the root of binary tree
         * @return: collect and remove all leaves
         */
        static List<List<Integer>> ret;
        public static List<List<Integer>> findLeaves(TreeNode root) {
            ret = new ArrayList<>();
            TreeNode parent = new TreeNode(-1);
            parent.left = root;
            while(parent.left != null){
                List<Integer> list = new ArrayList<>();
                helper(root,parent,true, list);
                ret.add(list);
            }
            return ret;
            // write your code here
        }

        public static void helper(TreeNode root, TreeNode parent, boolean isLeft,List<Integer> list){

            if(root != null){
                if(root.left == null && root.right== null){
                    list.add(root.val);
                    if (isLeft)parent.left = null;
                    else
                        parent.right = null;
                }
                helper(root.left, root, true,list);
                helper(root.right, root, false,list);

            }

        }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        /*
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.left.left = new TreeNode(5);
         */

        List<List<Integer>> leaves = findLeaves(root);
        System.out.println(leaves);

    }
    }

