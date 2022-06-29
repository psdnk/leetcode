import java.util.*;

public class Test2 {

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
//        nodes.add(Arrays.asList(7,3,-1));
//        nodes.add(Arrays.asList(5,3,7));
//        nodes.add(Arrays.asList(3,-1,-1));
        nodes.add(Arrays.asList(75, 90, -1));
        nodes.add(Arrays.asList(5, 61, -1));
        nodes.add(Arrays.asList(94, 88, -1));
        nodes.add(Arrays.asList(3, 20, -1));
        nodes.add(Arrays.asList(92, 29, -1));
        nodes.add(Arrays.asList(37, 10, -1));
        nodes.add(Arrays.asList(66, 53, -1));
        nodes.add(Arrays.asList(27, 72, -1));
        nodes.add(Arrays.asList(53, 17, -1));
        nodes.add(Arrays.asList(63, 47, -1));
        nodes.add(Arrays.asList(36, 4, -1));
        nodes.add(Arrays.asList(48, 18, -1));
        nodes.add(Arrays.asList(42, 80, -1));
        nodes.add(Arrays.asList(31, 26, -1));
        nodes.add(Arrays.asList(29, 24, -1));
        nodes.add(Arrays.asList(83, 73, -1));
        nodes.add(Arrays.asList(71, 54, -1));
        nodes.add(Arrays.asList(41, 64, -1));
        nodes.add(Arrays.asList(93, 19, -1));
        nodes.add(Arrays.asList(72, 46, -1));
        nodes.add(Arrays.asList(19, 58, -1));
        nodes.add(Arrays.asList(67, 11, -1));
        nodes.add(Arrays.asList(62, 9, -1));
        nodes.add(Arrays.asList(91, 63, -1));
        nodes.add(Arrays.asList(44, 99, -1));
        nodes.add(Arrays.asList(70, 69, -1));
        nodes.add(Arrays.asList(49, 81, -1));
        nodes.add(Arrays.asList(89, 52, -1));
        nodes.add(Arrays.asList(21, 27, -1));
        nodes.add(Arrays.asList(73, 89, -1));
        nodes.add(Arrays.asList(80, 0, -1));
        nodes.add(Arrays.asList(77, 57, -1));
        nodes.add(Arrays.asList(54, 66, -1));
        nodes.add(Arrays.asList(52, 56, -1));
        nodes.add(Arrays.asList(43, 45, -1));
        nodes.add(Arrays.asList(40, 71, -1));
        nodes.add(Arrays.asList(45, -1, 37));
        nodes.add(Arrays.asList(25, 87, -1));
        nodes.add(Arrays.asList(64, 39, -1));
        nodes.add(Arrays.asList(50, 1, -1));
        nodes.add(Arrays.asList(58, 94, -1));
        nodes.add(Arrays.asList(98, 6, -1));
        nodes.add(Arrays.asList(74, 38, -1));
        nodes.add(Arrays.asList(88, 3, -1));
        nodes.add(Arrays.asList(0, 55, -1));
        nodes.add(Arrays.asList(13, 40, -1));
        nodes.add(Arrays.asList(18, 83, -1));
        nodes.add(Arrays.asList(39, 68, -1));
        nodes.add(Arrays.asList(8, 51, -1));
        nodes.add(Arrays.asList(97, 93, -1));
        nodes.add(Arrays.asList(17, 12, -1));
        nodes.add(Arrays.asList(68, 21, -1));
        nodes.add(Arrays.asList(84, 78, -1));
        nodes.add(Arrays.asList(14, 7, -1));
        nodes.add(Arrays.asList(38, 59, -1));
        nodes.add(Arrays.asList(65, 70, -1));
        nodes.add(Arrays.asList(90, 97, -1));
        nodes.add(Arrays.asList(60, 98, -1));
        nodes.add(Arrays.asList(86, 13, -1));
        nodes.add(Arrays.asList(26, 82, -1));
        nodes.add(Arrays.asList(85, 15, -1));
        nodes.add(Arrays.asList(6, 30, -1));
        nodes.add(Arrays.asList(4, 43, -1));
        nodes.add(Arrays.asList(59, 79, -1));
        nodes.add(Arrays.asList(51, 85, -1));
        nodes.add(Arrays.asList(99, 5, -1));
        nodes.add(Arrays.asList(16, 67, -1));
        nodes.add(Arrays.asList(34, 77, -1));
        nodes.add(Arrays.asList(79, 95, -1));
        nodes.add(Arrays.asList(95, 22, -1));
        nodes.add(Arrays.asList(35, 23, -1));
        nodes.add(Arrays.asList(81, 91, -1));
        nodes.add(Arrays.asList(87, 86, -1));
        nodes.add(Arrays.asList(11, 44, -1));
        nodes.add(Arrays.asList(22, 84, -1));
        nodes.add(Arrays.asList(7, 96, -1));
        nodes.add(Arrays.asList(78, 62, -1));
        nodes.add(Arrays.asList(57, 14, -1));
        nodes.add(Arrays.asList(30, 28, -1));
        nodes.add(Arrays.asList(2, 76, -1));
        nodes.add(Arrays.asList(12, 49, -1));
        nodes.add(Arrays.asList(47, 92, -1));
        nodes.add(Arrays.asList(96, 48, -1));
        nodes.add(Arrays.asList(46, 25, -1));
        nodes.add(Arrays.asList(15, 60, -1));
        nodes.add(Arrays.asList(20, 65, -1));
        nodes.add(Arrays.asList(61, 34, -1));
        nodes.add(Arrays.asList(76, 32, -1));
        nodes.add(Arrays.asList(56, 2, -1));
        nodes.add(Arrays.asList(10, 16, -1));
        nodes.add(Arrays.asList(33, 75, -1));
        nodes.add(Arrays.asList(32, 42, -1));
        nodes.add(Arrays.asList(23, 50, -1));
        nodes.add(Arrays.asList(24, 31, -1));
        nodes.add(Arrays.asList(28, 33, -1));
        nodes.add(Arrays.asList(82, 36, -1));
        nodes.add(Arrays.asList(1, 74, -1));
        nodes.add(Arrays.asList(9, 8, -1));
        nodes.add(Arrays.asList(55, 35, -1));
        nodes.add(Arrays.asList(69, 41, -1));
        nodes.add(Arrays.asList(512, -1, 513));
        nodes.add(Arrays.asList(513, -1, -1));
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

    static class BSTNode{
        public int value;
        public BSTNode left;
        public BSTNode right;

        public BSTNode(int value, BSTNode left, BSTNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
