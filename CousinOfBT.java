import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CousinOfBT {

    public static void main(String[] args) {
        TreeNode  root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.right =new TreeNode(5);

//        System.out.println(isCousins( root,2,3 ));
        System.out.println(isCousinsV1( root,5,4 ));
    }

    public static boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> parents = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode t = root;
        int height = 0;
        boolean foundX= false;
        boolean foundY = false;
        TreeNode parentX = root;
        TreeNode parentY = root;
        TreeNode parent = root;
        int heightX = 0;
        int heightY = 0;
        int currentLevelchildCount =1;
        int nextLevelChildCount = 0;
        while (!queue.isEmpty()){
            parents.add(t);
            if (t.val == x ){
                foundX = true;
                heightX = height;
                parentX = parent;
                System.out.println("Found X at : " + height);
            }
            if (t.val == y ){
                foundY = true;
                heightY = height;
                parentY = parent;
                System.out.println("Found Y at : " + height);
            }
            if (foundX &&  foundY){
                break;
            }
            if (t.left != null){
                nextLevelChildCount = nextLevelChildCount +1;
//                parentX = t;
                parents.add(t);
                queue.add(t.left);
            }
            if (t.right != null){
                nextLevelChildCount = nextLevelChildCount +1;
//                parentY= t;
                parents.add(t);
                queue.add(t.right);
            }
             TreeNode popped = queue.poll();
//            parentY = parentX;
            t= queue.peek();
            
            currentLevelchildCount = currentLevelchildCount -1;
            if (currentLevelchildCount == 0 ){
                parent  = popped;
                currentLevelchildCount = nextLevelChildCount;
                nextLevelChildCount = 0;
                height = height + 1;
            }
        }
        if (heightX == heightY && parentX != parentY){
            System.out.println("parentX " + parentX.val);
            System.out.println("parentY " + parentY.val);
            return true;
        }else {
            System.out.println("parentX " + parentX.val);
            System.out.println("parentY " + parentY.val);
            return false;
        }

    }

    static int parentX = -1;
    static int parentY = -1;
    static int heightX = -1;
    static int heightY = -1;
    public static boolean isCousinsV1(TreeNode root, int x, int y){

        checkCousin(root,x,y,0,root);
        if ((heightX == heightY) && (parentX !=parentY)){
            return true;
        }else {
            return false;
        }
    }
    public static boolean checkCousin(TreeNode root,int x,int y,int height,TreeNode parent){
        if (root == null){
            return false;
        }
        if (root.val == x){
            parentX = parent.val;
            heightX = height;
        }
        if (root.val == y){
            parentY = parent.val;
            heightY = height;
        }

        if (parentX != -1 && parentY != -1){
            return false;
        }

        return (checkCousin( root.left,x,y,height+1,root ) || checkCousin( root.right,x,y,height+1,root ));
    }

    public static  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
