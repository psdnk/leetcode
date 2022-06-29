import java.util.*;

public class VerticalOrderTraversalOfABinaryTree_987 {

    class Node{
        int row;
        int col;
        int level;
        int val;

        public Node(int row, int col, int level, int val) {
            this.row = row;
            this.col = col;
            this.level = level;
            this.val = val;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        SortedMap<Integer,PriorityQueue<Node>> hm = new TreeMap<>();
        helper(root,0,0,0,hm);
        System.out.println(hm);
        for (Map.Entry<Integer,PriorityQueue<Node>> entry : hm.entrySet()){

        }
        return ret;
    }

    public void helper(TreeNode root, int level,int row, int col, SortedMap<Integer,PriorityQueue<Node>> hm){
        if (root != null){
            helper(root.left,level-1,row+1,col-1,hm);
            hm.computeIfAbsent(level,k->new PriorityQueue<Node>((a,b)->{
                if (a.col == b.col) return a.val-b.val;
                else return 0;
                    })).add(new Node(row,col,level,root.val));
            helper(root.right,level+1,row+1,col+1,hm);
        }
    }
}
