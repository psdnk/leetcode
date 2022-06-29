import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNode {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root ==  null) return null;
        queue.add(root);
        int currLevelSize = queue.size();
        int nextLevelSize = 0;
        while (queue.size()> 0) {
            while (currLevelSize > 0){
                Node curr= queue.poll();
                if (curr.left != null){
                    queue.add(curr.left);
                    nextLevelSize++;
                }
                if (curr.right != null){
                    queue.add(curr.right);
                    nextLevelSize++;
                }
                if (currLevelSize == 1) curr.next = null;
                else curr.next = queue.peek();
                currLevelSize--;
            }
            currLevelSize = nextLevelSize;
            nextLevelSize = 0;
        }
        return root;
    }
}
