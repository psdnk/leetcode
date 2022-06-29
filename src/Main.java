import java.util.*;

public class Main {

    public static void main(String[] args) {
        var output1 = findRoot(getInput1());
        System.out.println(output1);

        var output2 = findRoot(getInput2());
        System.out.println(output2);

        var output3 = findRoot(getInput3());
        System.out.println(output3);

        var output4 = findRoot(getInput4());
        System.out.println(output4);
    }


    private static List<List<Integer>> getInput1(){
        List<List<Integer>> nodes =  new ArrayList<>();
        nodes.add(Arrays.asList(17,-1,-1));
        nodes.add(Arrays.asList(15,13,17));
        nodes.add(Arrays.asList(7,-1,-1));
        nodes.add(Arrays.asList(13,-1,-1));
        nodes.add(Arrays.asList(5,3,7));
        nodes.add(Arrays.asList(3,-1,-1));
        nodes.add(Arrays.asList(10,5,15));
        return  nodes;
    }
    private static List<List<Integer>> getInput2(){
        List<List<Integer>> nodes =  new ArrayList<>();
        nodes.add(Arrays.asList(17,-1,-1));
        nodes.add(Arrays.asList(15,13,17));
        nodes.add(Arrays.asList(7,-1,-1));
        nodes.add(Arrays.asList(13,-1,-1));
        nodes.add(Arrays.asList(5,3,7));
        nodes.add(Arrays.asList(3,-1,-1));
        return  nodes;
    }

    private static List<List<Integer>> getInput3(){
        List<List<Integer>> nodes =  new ArrayList<>();
        nodes.add(Arrays.asList(17,-1,-1));
        nodes.add(Arrays.asList(15,13,17));
        nodes.add(Arrays.asList(7,-1,-1));
        nodes.add(Arrays.asList(13,-1,-1));
        nodes.add(Arrays.asList(5,3,7));
        nodes.add(Arrays.asList(3,4,-1));
        nodes.add(Arrays.asList(10,5,15));
        return  nodes;
    }

    private static List<List<Integer>> getInput4(){
        List<List<Integer>> nodes =  new ArrayList<>();
        nodes.add(Arrays.asList(7,3,-1));
        nodes.add(Arrays.asList(5,3,7));
        nodes.add(Arrays.asList(3,-1,-1));
        return  nodes;
    }
    public static int findRoot(List<List<Integer>> nodes){
        boolean isValidTree = checkValidTree(nodes);
        if(!isValidTree){
            System.out.println("Invalid tree");
            return -1;
        }
        Map<Integer, BSTNode> valueToNodeMap =  new HashMap<>();
        Set<Integer> children = new HashSet<>();
        Set<Integer> allNodes =  new HashSet<>();
        Set<Integer> parentNodesDefinedInList = new HashSet<>();
        nodes.forEach(x -> {
            int value = x.get(0);
            int left = x.get(1);
            int right = x.get(2);
            allNodes.add(value);
            parentNodesDefinedInList.add(value);
            BSTNode bstNode;
            if(valueToNodeMap.containsKey(value)){
                bstNode = valueToNodeMap.get(value);
            }
            else {
                bstNode =  new BSTNode(value, null, null);
            }
            if(left == -1){
                bstNode.left = null;
            }
            else if(valueToNodeMap.containsKey(left)){
                bstNode.left = valueToNodeMap.get(left);
                children.add(left);
                allNodes.add(value);
            }
            else{
                bstNode.left = new BSTNode(left, null, null);
                children.add(left);
                allNodes.add(value);
            }
            if(right ==-1){
                bstNode.right =null;
            }
            else if(valueToNodeMap.containsKey(right)){
                bstNode.right = valueToNodeMap.get(right);
                children.add(right);
                allNodes.add(value);
            }
            else{
                bstNode.right =new BSTNode(right, null, null);
                children.add(right);
                allNodes.add(value);
            }
        });

        var roots = getRootElements(parentNodesDefinedInList, children);
        if(roots.size()>1){
            System.out.println("root size more");
            return  -1;
        }
        boolean isBstAndNonCycle =  checkBstAndCycle(valueToNodeMap.get(roots.get(0)), Integer.MAX_VALUE, Integer.MIN_VALUE, new HashSet<>());
        if(!isBstAndNonCycle){
            System.out.println("non bst or cycle found");
            return -1;
        }
        boolean IfNodeExistsInInput = checkIfNodeExistsInInput(nodes, parentNodesDefinedInList);
        if(IfNodeExistsInInput){
            return roots.get(0);
        }
        System.out.println("all nodes do exist in input");
        return -1;
    }

    private static boolean checkValidTree(List<List<Integer>> nodes){
        Set<Integer>children = new HashSet<>();
        for(List<Integer> x: nodes){
            if(x.get(1) !=-1 && children.contains(x.get(1))){
                return false;
            }
            children.add(x.get(1));

            if(x.get(2) !=-1 && children.contains(x.get(2))){
                return false;
            }
            children.add(x.get(2));
        }
        return true;
    }

    private static boolean checkIfNodeExistsInInput(List<List<Integer>> nodes, Set<Integer> parentNodes){
        boolean ans= true;
        for (List<Integer> x : nodes) {
            if(ans) {
                boolean isLeftNodeInParent = x.get(1) == -1 || parentNodes.contains(x.get(1)) ? true : false;
                boolean isRightNodeInParent = x.get(2) == -1 || parentNodes.contains(x.get(2)) ? true : false;
                ans = ans && isLeftNodeInParent && isRightNodeInParent;
            }
        }
        return ans;
    }
    private static boolean checkBstAndCycle(BSTNode bstNode, int maxAllowed, int minAllowed, Set<Integer> visited){
        if(bstNode == null){
            return true;
        }
        if(visited.contains(bstNode.value)){
            return false;
        }
        if(bstNode.value>maxAllowed || bstNode.value<minAllowed){
            return false;
        }
        visited.add(bstNode.value);
        if(bstNode.right != null && bstNode.right.value < bstNode.value){
            return  false;
        }
        if(bstNode.left !=null && bstNode.left.value > bstNode.value){
            return false;
        }
        boolean isLeftValidBst = checkBstAndCycle(bstNode.left, bstNode.value, minAllowed, visited);
        boolean isRightValidBst = checkBstAndCycle(bstNode.right, maxAllowed, bstNode.value, visited);

        return  isLeftValidBst && isRightValidBst;

    }

    private static List<Integer> getRootElements(Set<Integer> allElements, Set<Integer> children){
        List<Integer> rootElements =  new ArrayList<>();
        allElements.forEach(x -> {
            if(!children.contains(x)){
                rootElements.add(x);
            }
        });

        return  rootElements;
    }
}
class BSTNode{
    public int value;
    public BSTNode left;
    public BSTNode right;

    public BSTNode(int value, BSTNode left, BSTNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}