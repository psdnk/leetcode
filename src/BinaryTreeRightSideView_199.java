//    import java.util.ArrayList;
//    import java.util.HashMap;
//    import java.util.List;
//    import java.util.Map;
//
//    public class BinaryTreeRightSideView_199 {
//    public List<Integer> rightSideView(TreeNode root) {
//        HashMap<Integer, List<Integer>> hm = new HashMap<>();
//        hm.
//        helper();
//    }
//
//    public static ArrayList<Integer> bottomView(BinaryTreeNode root) {
//        // Write your code here
//        ArrayList<Integer> ret = new ArrayList<>();
//        for(Map.Entry<Integer,Integer> entry : hm.entrySet())ret.add(entry.getValue());
//
//        return ret;
//    }
//
//    public static void helper(BinaryTree root,int level, HashMap<Integer,Integer> hm){
//        if(root != null){
//            helper(root.left,level-1,hm);
//            helper(root.right,level+1,hm);
//            hm.put(level,root.val);
//        }
//    }
//
//    public void helper(TreeNode root,int level,HashMap<Integer, List<Integer>> hm){
//        if (root != null){
//            helper(root.left,level-1,hm);
//            hm.computeIfAbsent(level,k->new ArrayList<>()).add(root.val);
//            helper(root.right,level+1,hm);
//        }
//
//    }
//}
