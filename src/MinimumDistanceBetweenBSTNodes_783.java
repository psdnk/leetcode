import java.util.PriorityQueue;

public class MinimumDistanceBetweenBSTNodes_783 {
    public int minDiffInBST(TreeNode root) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        helper(root,minHeap);
        return Math.abs(minHeap.poll() - minHeap.poll());
    }

    public void helper(TreeNode root, PriorityQueue<Integer> minHeap){
        if (root != null){
            minHeap.add(root.val);
            helper(root.left,minHeap);
            helper(root.right,minHeap);
        }
    }
}
