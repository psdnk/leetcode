import java.util.*;

public class Main2 {

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
        if(!isValidTree) return -1;
        Map<Integer, Node> map =  new HashMap<>();
        Set<Integer> children = new HashSet<>();
        Set<Integer> allNodes =  new HashSet<>();
        Set<Integer> list = new HashSet<>();
        nodes.forEach(x -> {
            int value = x.get(0);
            int left = x.get(1);
            int right = x.get(2);
            allNodes.add(value);
            list.add(value);
            Node node;
            if(map.containsKey(value)) node = map.get(value);
            else node =  new Node(value, null, null);
            if(left == -1) node.left = null;
            else if(map.containsKey(left)){
                node.left = map.get(left);
                children.add(left);
                allNodes.add(value);
            }
            else{
                node.left = new Node(left, null, null);
                children.add(left);
                allNodes.add(value);
            }
            if(right ==-1) node.right =null;
            else if(map.containsKey(right)){
                node.right = map.get(right);
                children.add(right);
                allNodes.add(value);
            }
            else{
                node.right =new Node(right, null, null);
                children.add(right);
                allNodes.add(value);
            }
        });

        List<Integer> rootNodes = getRootNodes(list, children);
        if(rootNodes.size()>1)return  -1;
        if(!validTreeForCycleAndBst(map.get(rootNodes.get(0)), Integer.MAX_VALUE, Integer.MIN_VALUE, new HashSet<>())) return -1;
        if(checkNodeInInput(nodes, list)) return rootNodes.get(0);
        return -1;
    }

    private static boolean checkValidTree(List<List<Integer>> nodes){
        Set<Integer>children = new HashSet<>();
        for(List<Integer> x: nodes){
            if(x.get(1) !=-1 && children.contains(x.get(1)))return false;
            children.add(x.get(1));
            if(x.get(2) !=-1 && children.contains(x.get(2))) return false;
            children.add(x.get(2));
        }
        return true;
    }

    private static boolean checkNodeInInput(List<List<Integer>> nodes, Set<Integer> parentNodes){
        boolean ret= true;
        for (List<Integer> x : nodes) {
            if(ret) {
                boolean isLeftNodeInParent = x.get(1) == -1 || parentNodes.contains(x.get(1)) ? true : false;
                boolean isRightNodeInParent = x.get(2) == -1 || parentNodes.contains(x.get(2)) ? true : false;
                ret = ret && isLeftNodeInParent && isRightNodeInParent;
            }
        }
        return ret;
    }
    private static boolean validTreeForCycleAndBst(Node node, int maxAllowed, int minAllowed, Set<Integer> visited){
        if(node == null) return true;
        if(visited.contains(node.value)) return false;
        if(node.value>maxAllowed || node.value<minAllowed) return false;
        visited.add(node.value);
        if(node.right != null && node.right.value < node.value) return  false;
        if(node.left !=null && node.left.value > node.value) return false;
        boolean isLeftValidBst = validTreeForCycleAndBst(node.left, node.value, minAllowed, visited);
        boolean isRightValidBst = validTreeForCycleAndBst(node.right, maxAllowed, node.value, visited);
        return  isLeftValidBst && isRightValidBst;
    }

    private static List<Integer> getRootNodes(Set<Integer> allElements, Set<Integer> children){
        List<Integer> rootNodes =  new ArrayList<>();
        allElements.forEach(x -> {
            if(!children.contains(x)){
                rootNodes.add(x);
            }
        });

        return  rootNodes;
    }
}

class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}