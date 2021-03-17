public class CheckStringValidSequence {
    public boolean isValidSequence(TreeNode root, int[] arr) {
        if(root == null){
            return false;
        }
        int i=0;
        TreeNode node = root;
        while(i<arr.length){
            int data = node.val;
            if(data == arr[i])
            if(node.left != null){
                int left = node.left.val;
                if(left == arr[i]){
                    node = node.left;
                    i++;
                }
            }
            if(node.right != null){
                int right = node.right.val;
                if(right == arr[i]){
                    node = node.right;
                    i++;
                }
            }
        }
        if(node == null){
            return true;
        }
        return false;

    }

    public  boolean check(TreeNode node, int [] arr, int pos){
        if (arr[pos] != node.val){
            return false;
        }
        if (node == null && pos < arr.length-1){
            return false;
        }
        if (node == null && pos == arr.length-1){
            return true;
        }
        if(node.left != null && check(node.left, arr, pos+1)){
            return true;
        }
        if(node.right != null && check(node.right, arr, pos+1)){
            return true;
        }
        return false;
    }
}




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

