import java.util.*;

public class MaximumWidthOfBinaryTree_662 {


    public static void main(String[] args) {
        TreeNode root = new TreeNode();
    }
    public static int widthOfBinaryTree(TreeNode root) {
        int max = 0;
        Queue<Map.Entry<TreeNode,Integer>> queue = new LinkedList<>();
        queue.add(new AbstractMap.SimpleEntry<TreeNode,Integer>(root,0));
        while (!queue.isEmpty()){
            int size = queue.size();
            int start = queue.peek().getValue();
            int end = start;
            while (size-->0){
                TreeNode node = queue.peek().getKey();
                end  = queue.poll().getValue();
                if (node.left != null)queue.add(new AbstractMap.SimpleEntry<>(node.left,2*end));
                if (node.right != null)queue.add(new AbstractMap.SimpleEntry<>(node.right,2*end+1));
            }
            max = Math.max(max,end-start +1);
        }
        return max;
    }
}
