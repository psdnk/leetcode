import javafx.util.Pair;

import java.util.List;
import java.util.ListIterator;

public class AmazonBST2ndRightElement {
    public static class  TreeNode{
        TreeNode left;
        TreeNode right;
        TreeNode secondRight;
        int element;
        public TreeNode(int element){
            this.element = element;
            left = null;
            right = null;
            secondRight = null;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode ( 5 );
        root.left = new TreeNode ( 3 );
        root.left.left = new TreeNode ( 1 );
        root.left.right = new TreeNode ( 4 );
        root.left.left.left = new TreeNode ( 0 );
        root.left.left.right = new TreeNode ( 2 );
        AmazonBST2ndRightElement amazonBST2ndRightElement = new AmazonBST2ndRightElement ();
        amazonBST2ndRightElement.print ( root );
    }

    public void print(TreeNode node){
        if ( node != null ){
            print ( node.left );
            Integer integer = node.secondRight != null ? node.secondRight.element : -1;
            System.out.println (node.element +" -> " + integer  );
            print ( node.right );

        }
    }

    public void link2ndRightElement(TreeNode parentNode , TreeNode node){
        if(node != null){
            parentNode = node;
            link2ndRightElement ( parentNode, node.left );
            node.secondRight = parentNode.right;

        }
    }

}

